package utils;

import java.io.File;

public class Common {
    public static boolean clearDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    file.delete();
                }
            }
        }
        return directory.delete();
    }
}
