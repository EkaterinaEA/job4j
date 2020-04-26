package ru.job4j.io;

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

    public void init() {
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            if (arg.matches("-\\w")) {
                if (checkDirectory && "-d".equals(arg)) {
                    this.directory = args[++i];
                    checkDirectory = false;
                } else if (checkExceptions && "-e".equals(arg)) {
                    while (++i < args.length && args[i].startsWith("*")) {
                        this.exceptions.add(args[i].substring(1));
                    }
                    i--;
                    checkExceptions = false;
                } else if (checkOutput && "-o".equals(arg)) {
                    this.output = args[++i];
                    checkOutput = false;
                }
            }
        }
    }
}
