package ru.job4j.io;

import java.io.*;

public class Analizy {

    private boolean check = false;

    public void unavailable(String source, String target) throws IOException {
        BufferedReader read = new BufferedReader(new FileReader(source));
        String line = read.readLine();
        try (FileWriter out = new FileWriter(target, true)) {
            while (line != null) {
                if ((line.startsWith("500") || line.startsWith("400")) && !check) {
                    out.write(line.substring(4) + ";");
                    check = true;
                } else if (check && (line.startsWith("200") || line.startsWith("300"))) {
                    out.write(line.substring(4) + System.getProperty("line.separator"));
                    check = false;
                }
                line = read.readLine();
            }
        }
    }
}
