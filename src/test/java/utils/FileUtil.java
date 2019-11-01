package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {
    private static final String OUTPUT_FILE = "outputFile.name";

    public static void writeToCsv(String[][] messages) {
        File csvFile = new File(PropertyUtil.getProperty(OUTPUT_FILE));
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
}
