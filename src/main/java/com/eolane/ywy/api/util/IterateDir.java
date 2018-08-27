package com.eolane.ywy.api.util;

import com.eolane.ywy.api.dto.DirBean;
import com.eolane.ywy.api.dto.FileBean;
import com.eolane.ywy.api.properties.FileExploreProperties;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;


public class IterateDir {
    @Autowired
    private static FileExploreProperties fileExploreProperties;

    /*
     * 通过递归得到某一路径下所有的目录及其文件
     */
    public static DirBean getFiles(String dirPath) throws Exception {
        File root = new File(dirPath);
        DirBean dirBean = null;
        if (root.exists()) {
            dirBean = new DirBean();
            String dirSize = "";
            int dirCount = 0;
            List<FileBean> fileList = new LinkedList<>();
            if (root.isDirectory()) {
                File[] files = root.listFiles();
                for (File file : files) {
                    FileBean fileBean = new FileBean();
                    String realPath = file.getAbsolutePath();
                    fileBean.setFilePath(realPath.replace("C:\\upload", "Document"));
                    fileBean.setFileName(getFileName(realPath));
                    if (file.isDirectory()) {
                        fileBean.setFileType("DIR");
                        //fileBean.setFileSize(FormetFileSize(getFileSize(file)));
                        fileBean.setFileSize("");
                    } else {
                        fileBean.setFileType(getFileType(getFileName(realPath)));
                        fileBean.setFileSize(FormatFileSize(getFileSizes(file)));
                        fileBean.setFileUrl("todo fileUrl");
                    }
                    fileList.add(fileBean);
                }
            } else {
                dirSize = FormatFileSize(getFileSizes(root));
            }
            dirBean.setDirCount(dirCount);
            dirBean.setDirSize(dirSize);
            dirBean.setDirPath(dirPath.replace("C:\\upload", "Document"));
            dirBean.setFiles(fileList);
        } else {
            System.out.println("文件或文件目录不存在");
        }
        return dirBean;
    }

    private static String getFileType(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1).toUpperCase();
    }

    //获取文件名
    static String getFileName(String filePath) {
        String[] fileItems = filePath.split("\\\\");
        return fileItems[fileItems.length - 1];
    }

    //取得文件大小
    private static long getFileSizes(File f) throws Exception {
        long s = 0;
        if (f.exists()) {
            FileInputStream fis = null;
            fis = new FileInputStream(f);
            s = fis.available();
            fis.close();
        } else {
            System.out.println("文件不存在");
        }
        return s;
    }

    //取得文件夹大小
    private static long getFileSize(File f) throws Exception {
        long size = 0;
        File flist[] = f.listFiles();
        for (int i = 0; i < flist.length; i++) {
            if (flist[i].isDirectory()) {
                size = size + getFileSize(flist[i]);
            } else {
                size = size + flist[i].length();
            }
        }
        return size;
    }

    private static String FormatFileSize(long fileS) {//转换文件大小
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString = "";
        if (fileS < 1024) {
            fileSizeString = df.format((double) fileS) + "B";
        } else if (fileS < 1048576) {
            fileSizeString = df.format((double) fileS / 1024) + "KB";
        } else if (fileS < 1073741824) {
            fileSizeString = df.format((double) fileS / 1048576) + "M";
        } else {
            fileSizeString = df.format((double) fileS / 1073741824) + "G";
        }
        return fileSizeString;
    }

    private static long getList(File f) {//递归求取目录文件个数
        long size = 0;
        File flist[] = f.listFiles();
        size = flist.length;
        for (int i = 0; i < flist.length; i++) {
            if (flist[i].isDirectory()) {
                size = size + getList(flist[i]);
                size--;
            }
        }
        return size;
    }
}
