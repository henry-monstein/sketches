package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileInput {
    public final static String LINE_SPLITER = "[!@#$%^&*/|~ ,.]";

    public String[] readFromFile(String fileName) {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {

            list = br.lines().collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list.toArray(new String[list.size()]);
    }

    public String[] parser(String line, int limit) {
        return line.split(LINE_SPLITER, limit);
    }
}
