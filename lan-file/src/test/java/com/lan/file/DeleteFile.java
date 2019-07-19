package com.lan.file;

import java.io.File;

/**
 * 删除文件夹内所有指定名称的文件
 * @author Lan
 * @date 2019/6/17 9:44
 */
public class DeleteFile {

    public static void main(String[] args) {
        //填入maven仓库路径
        File file = new File("G:\\Resources\\畅购\\doc\\讲义");
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isDirectory()) search(file1);
        }
    }

    //判断空文件夹/文件夹中有lastUpdated 第一个递归
    private static void search(File file) {
        File[] files = file.listFiles();
        if (files.length == 0) return;
        for (File f : files) {
            if (f.isFile() && f.getName().contains("markdown-1.0.jar")) {
                //清洁模式
                System.out.println("要删除的文件 " + f.getAbsolutePath());
                f.delete();
            } else if (f.isDirectory()) search(f);
        }

    }







}
