package utils;

import constants.FileConstant;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtil {
    private static final String SPLITER = ",";

    public static void writeToCsv(String[][] messages) {
        File csvFile = new File(FileConstant.getOutputFilePath());
        csvFile.getParentFile().mkdirs();
        try (FileWriter csvWriter = new FileWriter(csvFile)) {
            for (String[] messageLine : messages) {
                csvWriter.append(String.join(",", messageLine));
                csvWriter.append("\n");
            }
            csvWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[][] readFromCsv() {
        List<String> list;
        ArrayList<String[]> table = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(FileConstant.getOutputFilePath()))) {
            list = br.lines().collect(Collectors.toList());
            for (String line : list) {
                table.add(line.split(SPLITER));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return table.toArray(new String[table.size()][]);
    }

}
