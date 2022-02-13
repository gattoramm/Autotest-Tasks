package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfProperties {
    protected static FileInputStream fileInputStream;
    protected static Properties PROPERTIES;

    static String str = "src/test/resources/conf.properties";

    static {
        try {
            //указание пути до файла с настройками
            fileInputStream = new FileInputStream(str);
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            //обработка возможного исключения (нет файла и т.п.)
        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
    // метод для возврата строки со значением из файла с настройками
    public static String getPropertyString(String key) {
        return PROPERTIES.getProperty(key);
    }

    // метод для возврата строки со значением из файла с настройками
    public static String[] getPropertyArray(String array) {
        return PROPERTIES.getProperty(array).split(",");
    }
}
