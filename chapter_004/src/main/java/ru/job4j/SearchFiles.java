package ru.job4j;

import org.apache.commons.cli.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.StringJoiner;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class SearchFiles {

    public static void main(String[] args) throws IOException {
        SearchFiles searchFiles = new SearchFiles();
        searchFiles.writeToFile(args);
    }

    public void writeToFile(String[] args) throws IOException {
        Options posixOption = initOption();
        CommandLine commandLine = getCommandLine(args, posixOption);
        if (commandLine != null) {
            String fileAttachments = getFilesByFilters(commandLine);
            String fileNameOut = commandLine.getOptionValue("o");
            Files.write(Paths.get(fileNameOut), fileAttachments.getBytes(Charset.forName("UTF-8")), StandardOpenOption.CREATE);
        }
    }

    private String getFilesByFilters(CommandLine commandLine) throws IOException {
        StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());
        String startDirectory = commandLine.getOptionValue("d");
        Pattern pattern = getPattern(commandLine);

        Stream<Path> pathStream = Files.walk(Paths.get(startDirectory));
        pathStream.filter(path -> pattern.matcher(path.getFileName().toString()).find())
                .map(path -> path.getFileName().toString())
                .forEach(stringJoiner::add);

        return stringJoiner.toString();
    }

    private Pattern getPattern(CommandLine commandLine) {
        String searchFromCmd = commandLine.getOptionValue("n");
        Pattern pattern = null;
        if (commandLine.hasOption("m")) {
            pattern = Pattern.compile(getRegularExpressionFromMask(searchFromCmd));
        } else if (commandLine.hasOption("f")) {
            pattern = Pattern.compile("^" + Pattern.quote(searchFromCmd) + "$");
        } else if (commandLine.hasOption("r")) {
            pattern = Pattern.compile(searchFromCmd);
        }
        return pattern;
    }

    private String getRegularExpressionFromMask(String mask) {
        StringBuilder regex = new StringBuilder(mask.length());
        regex.append('^');
        for (int i = 0; i < mask.length(); i++) {
            char character = mask.charAt(i);
            switch (character) {
                case '\\':
                case '|':
                case ')':
                case '(':
                case '{':
                case '}':
                case '[':
                case ']':
                case '.':
                case '$':
                    regex.append("\\");
                    regex.append(character);
                    break;
                case '^':
                    regex.append("\\");
                    break;
                case '?':
                    regex.append(".");
                    break;
                case '*':
                    regex.append(".*");
                    break;
                default:
                    regex.append(character);
                    break;
            }
        }
        return regex.append('$').toString();
    }

    private Options initOption() {

        Option startDirectory = new Option("d", "dir", true, "directory where the search begins");
        Option fileName = new Option("n", "fileName", true, "file name, mask, or regular expression");
        Option fileOut = new Option("o", "resultFile", true, "file to write the result to");

        startDirectory.setRequired(true);
        fileName.setRequired(true);
        fileOut.setRequired(true);

        OptionGroup searchGroup = new OptionGroup();
        searchGroup.addOption(new Option("m", "searchByMask", true, "find file by mask"));
        searchGroup.addOption(new Option("f", "fullNameMatch", true, "find file by full name match"));
        searchGroup.addOption(new Option("r", "regularExpression", true, "find file by regular expression"));
        searchGroup.setRequired(true);

        Options options = new Options().addOption(startDirectory).addOption(fileName).addOptionGroup(searchGroup).addOption(fileOut);
        return options;
    }

    private CommandLine getCommandLine(String[] ars, Options posixOptions) {
        CommandLineParser cmdLinePosixParser = new PosixParser();
        CommandLine commandLine = null;
        try {
            commandLine = cmdLinePosixParser.parse(posixOptions, ars);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            printHelp(posixOptions);
        }
        return commandLine;
    }

    private void printHelp(Options posixOptions) {
        final HelpFormatter helpFormatter = new HelpFormatter();
        final String syntax = "The syntax of this command is:\n";
        final String header = "\njava -jar SearchFiles.jar [-d] [-n] [-m | -f | -r] [-o]";
        final String footer = "SyntaxError: invalid syntax";
        helpFormatter.printHelp(syntax, header, posixOptions, footer, true);
    }

}
