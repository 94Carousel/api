package com.eolane.ywy.api.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {

    private static Logger log = LoggerFactory.getLogger(FileUtil.class);

    /**
     * 删除目录
     *
     * @author fengshuonan
     * @Date 2017/10/30 下午4:15
     */
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }

    /**
     * 复制文件夹
     *
     * @param sourcePath
     * @param newPath
     * @throws IOException
     */
    public static void copyDir(String sourcePath, String newPath) throws IOException {
        File file = new File(sourcePath);
        String[] filePath = file.list();

        if (!(new File(newPath)).exists()) {
            (new File(newPath)).mkdirs();
        }

        for (int i = 0; i < filePath.length; i++) {
            if ((new File(sourcePath + file.separator + filePath[i])).isDirectory()) {
                copyDir(sourcePath + file.separator + filePath[i], newPath + file.separator + filePath[i]);
            }

            if (new File(sourcePath + file.separator + filePath[i]).isFile()) {
                copyFile(sourcePath + file.separator + filePath[i], newPath + file.separator + filePath[i]);
            }

        }
    }

    /**
     * 移动文件夹
     *
     * @param sourcePath
     * @param newPath
     * @throws IOException
     */
    public static void moveDir(String sourcePath, String newPath) throws IOException {
        File file = new File(sourcePath);
        String[] filePath = file.list();

        if (!(new File(newPath)).exists()) {
            (new File(newPath)).mkdir();
        }

        for (int i = 0; i < filePath.length; i++) {
            if ((new File(sourcePath + file.separator + filePath[i])).isDirectory()) {
                moveDir(sourcePath + file.separator + filePath[i], newPath + file.separator + filePath[i]);
            }

            if (new File(sourcePath + file.separator + filePath[i]).isFile()) {
                moveFile(sourcePath + file.separator + filePath[i], newPath + file.separator + filePath[i], true);
            }

        }
    }

    /**
     * @param oldPath
     * @param newPath
     * @param cover
     */
    private static void moveFile(String oldPath, String newPath, boolean cover) {
        if (!oldPath.equals(newPath)) {
            File oldFile = new File(oldPath);
            File newFile = new File(newPath);
            if (newFile.exists()) {//若在待转移目录下，已经存在待转移文件
                if (cover)//覆盖
                    oldFile.renameTo(newFile);
                else
                    System.out.println("在新目录下已经存在：");
            } else {
                boolean b = oldFile.renameTo(newFile);
                System.out.println(b);
            }
        }
    }

    /**
     * 复制文件
     *
     * @param oldPath
     * @param newPath
     * @throws IOException
     */
    public static void copyFile(String oldPath, String newPath) throws IOException {
        File oldFile = new File(oldPath);
        File file = new File(newPath);
        FileInputStream in = new FileInputStream(oldFile);
        FileOutputStream out = new FileOutputStream(file);

        byte[] buffer = new byte[2097152];
        int readByte = 0;
        while ((readByte = in.read(buffer)) != -1) {
            out.write(buffer, 0, readByte);
        }

        in.close();
        out.close();
    }

    /**
     * 移动文件
     *
     * @param oldFile
     * @param newFile
     * @param cover
     */
    public static void moveFile(File oldFile, File newFile, boolean cover) {
        if (!newFile.equals(oldFile)) {
            if (newFile.exists()) {//若在待转移目录下，已经存在待转移文件
                if (cover)//覆盖
                    oldFile.renameTo(newFile);
                else
                    System.out.println("在新目录下已经存在：");
            } else {
                oldFile.renameTo(newFile);
            }
        }
    }

    /**
     * 移动文件或目录
     *
     * @param oldPath
     * @param newPath
     * @param cover
     */
    public static void moveFileOrDir(String oldPath, String newPath, boolean cover) {
        if (!oldPath.equals(newPath)) {
            File oldFile = new File(oldPath);
            File newFile = new File(newPath);
            if (newFile.exists()) {//若在待转移目录下，已经存在待转移文件
                if (cover)//覆盖
                {
                    deleteDir(newFile);
                    oldFile.renameTo(newFile);
                }else {
                    deleteDir(oldFile);
                }
            } else {
                 new File(newFile.getParent()).mkdirs();
                 oldFile.renameTo(newFile);
            }
        }
    }
}