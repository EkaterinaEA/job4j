package ru.job4j;

import org.junit.Rule;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SearchFilesTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    private static File file1;
    private static File file2;
    private static File file3;
    private static File file4;
    private static File file5;
    private static Path outputFile;
    private static File folder1;

    @Before
    public void setUp() throws IOException {
        folder1 = folder.newFolder("folder1");
        file1 = folder.newFile("file1.txt");
        file2 = new File(folder1.getAbsolutePath(), "file1.txt");
        file2.createNewFile();
        file3 = new File(folder1.getAbsolutePath(), "file2.txt");
        file3.createNewFile();
        file4 = new File(folder1.getAbsolutePath(), "file3.csv");
        file4.createNewFile();
        File folder2 = new File(folder1.getAbsolutePath(), "folder2");
        folder2.mkdir();
        file5 = new File(folder2.getAbsolutePath(), "file4.pdf");
        file5.createNewFile();
        outputFile = Path.of(folder1.toString(), "log.txt");
    }

    @Test
    public void searchFilesByMask() throws IOException {
        List<String> expected = Arrays.asList("file1.txt", "file2.txt");
        SearchFiles searchFiles = new SearchFiles();
        searchFiles.writeToFile(("-d " + folder1.toString() + " -n *.txt -m sd -o " + outputFile).split(" "));
        assertThat(Files.readAllLines(outputFile, Charset.forName("UTF-8")), is(expected));
    }

    @Test
    public void searchFilesByFullName() throws IOException {
        List<String> expected = Collections.singletonList("file4.pdf");
        SearchFiles searchFiles = new SearchFiles();
        searchFiles.writeToFile(("-d " + folder1.toString() + " -n file4.pdf -f sd -o " + outputFile).split(" "));
        assertThat(Files.readAllLines(outputFile, Charset.forName("UTF-8")), is(expected));
    }

    @Test
    public void searchFilesByRegex() throws IOException {
        List<String> expected = Collections.singletonList("file3.csv");
        SearchFiles searchFiles = new SearchFiles();
        searchFiles.writeToFile(("-d " + folder1.toString() + " -n .+csv -r sd -o " + outputFile).split(" "));
        assertThat(Files.readAllLines(outputFile, Charset.forName("UTF-8")), is(expected));
    }

    @Test
    public void searchFilesByMaskIsEmpty() throws IOException {
        List<String> expected = new ArrayList<>();
        SearchFiles searchFiles = new SearchFiles();
        searchFiles.writeToFile(("-d " + folder1.toString() + " -n *.doc -m sd -o " + outputFile).split(" "));
        assertThat(Files.readAllLines(outputFile, Charset.forName("UTF-8")), is(expected));
    }

    @Test
    public void searchFilesByFullNameIsEmpty() throws IOException {
        List<String> expected = new ArrayList<>();
        SearchFiles searchFiles = new SearchFiles();
        searchFiles.writeToFile(("-d " + folder1.toString() + " -n file6.txt -f sd -o " + outputFile).split(" "));
        assertThat(Files.readAllLines(outputFile, Charset.forName("UTF-8")), is(expected));
    }

    @Test
    public void searchFilesByRegexIsEmpty() throws IOException {
        List<String> expected = new ArrayList<>();
        SearchFiles searchFiles = new SearchFiles();
        searchFiles.writeToFile(("-d " + folder1.toString() + " -n .+doc -r sd -o " + outputFile).split(" "));
        assertThat(Files.readAllLines(outputFile, Charset.forName("UTF-8")), is(expected));
    }

    @Test
    public void testIncorrectSyntax() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);
        SearchFiles searchFiles = new SearchFiles();
        searchFiles.writeToFile(("-p " + folder1.toString() + " -n *.txt -m sd -o " + outputFile).split(" "));
        assertThat(byteArrayOutputStream.toString(), containsString("Unrecognized option: -p"));
        System.setOut(System.out);
    }

}
