package com.aaa.three.utils;

import java.util.Random;

/**
 * @Param
 * @ClassName FileNameUtils
 * @Description ftp文件名工具类
 * @Author yk
 * @Date 2020/7/13 0013 10:02
 * @Return
 **/
public class FileNameUtils {

    private FileNameUtils(){

    }

    /**
     * @Description :
     文件名的生成
     * @return : java.lang.String
     * @author : yk
     * @date : 2020/07/13 10:02
     */
    public static String getFileName(){
        /*1.获取当前系统时间的毫秒数*/
        long currentTimeMillis = System.currentTimeMillis();
        /*2.创建随机数对象*/
        Random random = new Random();
        /*3.随机  0-999之间随机*/
        int number = random.nextInt(999);
        /*4.生成最终的文件名*/
        /**
         * format():
         *      格式化方法
         *      %：占位符
         *      03：三位，如果不够三位则向前补0
         *      0-999随机----->66------>066
         *      9----->009
         *      d:数字
         */
        return currentTimeMillis + String.format("%03d",number);
    }
}
