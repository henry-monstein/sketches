package data;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import util.FileInput;

import java.util.ArrayList;

public class FileTestData {
    @DataProvider(name = "get")
//    @Parameters(value = {"fileName", "limit"})
    public Object[][] get(/*String fileName, int limit*/) {
        FileInput fi = new FileInput();
        String[] lines = fi.readFromFile("");
        ArrayList<String[]> data = new ArrayList<>();
        for(String line:lines){
            data.add(fi.parser(line,3));
        }
        return data.toArray(new String[lines.length][3]);
    }
}
