package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class FileUtil {
    public static void writeDataToFile(Object[] data, String fileName) {
        if (FileUtil.isNullOrEmpty(fileName) || FileUtil.isNullOrEmpty(data)) {
            return;
        }
        try   {
            ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(fileName));
            obj.writeObject(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isNullOrEmpty(Object obj) {
        return obj == null;
    }

    public static boolean isNullOrEmptyArray(Object[] obj) {
        return obj == null && obj.length == 0;
    }
}
