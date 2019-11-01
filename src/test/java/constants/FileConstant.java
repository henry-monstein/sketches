package constants;

import utils.PropertyUtil;

public class FileConstant {
    private static final String OUTPUT_FILE = "outputFile.name";

    public static String getOutputFilePath() {
        return PropertyUtil.getProperty(OUTPUT_FILE);
    }
}
