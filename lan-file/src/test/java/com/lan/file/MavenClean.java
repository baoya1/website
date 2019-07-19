package com.lan.file;

import java.io.File;

/**
 * 清理maven仓库,删除lastUpdated同时删除所在文件夹及空文件夹
 * 深度模式删除所在文件夹,清洁模式不删除
 *
 * @author Lan
 * @date 2018/11/8 6:18
 */
public class MavenClean {
    public static void main(String[] args) {
        //填入maven仓库路径
        File file = new File("C:\\java\\apache-maven-3.3.9\\repository");
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isDirectory()) search(file1);
        }
    }

    //判断空文件夹/文件夹中有lastUpdated 第一个递归
    private static void search(File file) {
        File[] files = file.listFiles();
        if (files.length == 0) {
            delEmpty(file);
        }
        for (File f : files) {
            if (f.isFile() && f.getName().contains("lastUpdated")) {
                //深度模式
                /*delAll(file);
                break;*/

                //清洁模式
                System.out.println("要删除的文件 " + f.getAbsolutePath());
                f.delete();
                delEmpty(file);
            } else if (f.isDirectory()) search(f);
        }

    }


    //删除文件夹下所有文件后再删除文件夹
    private static void delAll(File file) {
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            System.out.println("要删除的文件 " + files[i].getAbsolutePath());
            files[i].delete();
        }
        delEmpty(file);
    }

    //删除空文件夹的同时判断父文件夹是否为空 第二个递归
    private static void delEmpty(File file) {
        File parentFile = file.getParentFile();
        System.out.println("空文件夹 " + file.getAbsolutePath());
        file.delete();
        if (parentFile.listFiles().length == 0) {
            delEmpty(parentFile);
        }
    }


}
