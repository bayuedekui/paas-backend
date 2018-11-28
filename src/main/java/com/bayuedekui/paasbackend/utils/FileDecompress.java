package com.bayuedekui.paasbackend.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FileDecompress {
    private static Logger logger = LoggerFactory.getLogger(FileDecompress.class);

    public static void unzip(String zipDir, String destDir) {
        try {
            ZipInputStream zis = new ZipInputStream(new FileInputStream(zipDir));
            BufferedInputStream bis = new BufferedInputStream(zis);
            String parent = destDir;
            File outFile;
            ZipEntry entry = null;

            while ((entry = zis.getNextEntry()) != null && !entry.isDirectory()) {
                outFile = new File(destDir, entry.getName());
                if (!outFile.exists()) {
                    //如果传入的输出路径不存在就创建
                    new File(outFile.getParent()).mkdirs();
                }

                FileOutputStream fos = new FileOutputStream(outFile);
                BufferedOutputStream bos = new BufferedOutputStream(fos);

                int b;
                while ((b = bis.read()) != -1) {
                    bos.write(b);
                }
                bos.close();
                fos.close();
                logger.info("解压成功");
            }
            bis.close();
            zis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        unzip("E:\\1.zip", "E:\\2");
    }

}
