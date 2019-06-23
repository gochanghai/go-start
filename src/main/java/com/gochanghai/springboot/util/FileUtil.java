package com.gochanghai.springboot.util;

import java.text.DecimalFormat;
import java.util.UUID;

public class FileUtil {

    public static String getNewFileName(String suffix){
        return UUID.randomUUID().toString() + suffix;
    }

    /**
        * 获取文件名称
        * @param headerStr
        * @return
        */
    public static String getfilename(String headerStr){
        return headerStr.substring(headerStr.lastIndexOf("/")+1,headerStr.lastIndexOf("."));
    }
    /**
        * 获取文件后缀
        */
    public static String getSuffix(String fileName){
        return fileName.substring(fileName.lastIndexOf("."),fileName.length());
    }

    /**
     * 获取文件大小
     * @param size
     * @return
     */
    public static String getFileSize(Long size){
        //获取到的size为：1705230
        long KB = 1024;
        long MB = KB * 1024;
        long GB = MB * 1024;
        //格式化小数
        DecimalFormat df = new DecimalFormat("0.00");
        String resultSize = "";
        if (size / GB >= 1) {
            //如果当前Byte的值大于等于1GB
            resultSize = df.format(size / (float) GB) + "GB";
        } else if (size / MB >= 1) {
            //如果当前Byte的值大于等于1MB
            resultSize = df.format(size / (float) MB) + "MB";
        } else if (size / KB >= 1) {
            //如果当前Byte的值大于等于1KB
            resultSize = df.format(size / (float) KB) + "KB";
        } else {
            resultSize = size + "B";
        }
        return resultSize;
    }

    /**
     * 分局文件后缀名获取文件归类 目前分三类 word/image/excel/ppt/pdf/other
     * @param fileSux 文件后缀名
     * @return
     */
    public static String getFileClassify(String fileSux){
        if(fileSux.contains(".")){
            fileSux = fileSux.substring(fileSux.lastIndexOf(".") + 1);
        }
        System.out.println("文件后缀名: " + fileSux);
        if (fileSux.equals("doc")|| fileSux.equals("docx") ){
            return "word" ;
        }
        if (fileSux.equals("xls") || fileSux.equals("xlsx")){
            return "excel" ;
        }
        if (fileSux.equals("ppt") || fileSux.equals("pptx")){
            return "ppt" ;
        }
        if (fileSux.equals("pdf")){
            return "pdf" ;
        }
        if (fileSux.equals("jpg") || fileSux.equals("png") || fileSux.equals("jpeg") || fileSux.equals("gif")){
            return "image";
        }
        return "other";
    }
}
