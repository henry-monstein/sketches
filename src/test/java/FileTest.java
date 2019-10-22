import data.FileTestData;
import org.testng.annotations.Test;

import java.lang.reflect.Field;

import static org.testng.Assert.assertEquals;

public class FileTest {
    public final static String extensionFieldName="extension";
    public final static String fileNameFieldName="fileName";
    public final static String contentFieldName="content";
    public final static String sizeFieldName="size";


    @Test(dataProvider = "get",dataProviderClass = FileTestData.class)
    public void testFile() throws NoSuchFieldException, IllegalAccessException {
        File file = new File("Something.exe", "qwertyu");
        String extension=null;
        try {
            Field extensionField= file.getClass().getDeclaredField(extensionFieldName);
            extensionField.setAccessible(true);
            extension = (String) extensionField.get(file);
        }catch (NoSuchFieldException | IllegalAccessException e){
            e.printStackTrace();
        }

        assertEquals(extension,"exe","Parser don't work");
    }
}
