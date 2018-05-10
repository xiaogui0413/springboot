package com.example.springboot.util;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created with IDEA
 * Author: GuiqiHu
 * Created in: 2018/5/2 15:18
 */
public class FileUtil {

    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }
}
