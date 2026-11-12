package demo.orangehrm.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtil {

    public Properties readPropertiesFile(String filePath) {
    Properties properties = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream(filePath);
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Log.info(this.getClass(), "Test data: \n", properties);
        return  properties;
    }
}