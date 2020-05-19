package ru.job4j.io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ArgZip {

    private String[] args;
    private boolean checkDirectory = true;
    private boolean checkExceptions = true;
    private boolean checkOutput = true;
    public String directory;
    public List<String> exceptions = new ArrayList<>();
    public String output;

    public ArgZip(String ... args) {
        this.args = args;
    }

    public static void main(String[] args) {
        ArgZip packer = new ArgZip(args);
        packer.init();
        Zip zip = new Zip();
        System.out.println(packer.directory + " " + packer.exceptions + " " + packer.output);
        zip.pack(zip.seekBy(packer.directory, packer.exceptions), new File(packer.output));
    }

    public void init() {
        if (!args[0].equals("-d") || !args[2].equals("-e") || !args[4].equals("-o")) {
            System.out.println("Incorrect syntax! Please input: d c: \\ project \\ job4j \\ -e * .java -o project.zip\n" +
                    "\n" +
                    "-d - directory to be archived\n" +
                    "-e - files to exclude\n" +
                    "-o - where to archive.");
        }
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            if (arg.matches("-\\w")) {
                if (checkDirectory && "-d".equals(arg)) {
                    this.directory = args[++i];
                    checkDirectory = false;
                } if (checkExceptions && "-e".equals(arg)) {
                    while (++i < args.length && args[i].startsWith("*")) {
                        this.exceptions.add(args[i].substring(1));
                    }
                    i--;
                    checkExceptions = false;
                } if (checkOutput && "-o".equals(arg)) {
                    this.output = args[++i];
                    checkOutput = false;
                }
            }
        }
    }
}
