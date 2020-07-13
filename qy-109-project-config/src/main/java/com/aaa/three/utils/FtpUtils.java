package com.aaa.three.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Param
 * @ClassName FtpUtils
 * @Description ftp的工具类
 * @Author yk
 * @Date 2020/7/10 0010 16:58
 * @Return
 **/
public class FtpUtils {

    private FtpUtils(){

    }
    /**
     * @Description : ftp文件上传方法工具
     * @param host ftp服务器的ip地址
     * @param port ftp服务器的端口号
     * @param username ftp服务器的用户名
     * @param password ftp服务器的密码
     * @param basePath 用户上传文件的根路径
     * @param filePath 用户上传当天的日期路径
     * @param fileName 修改之后的文件名
     * @param inputStream 使用io上传
     * @return : java.lang.Boolean
     * @author : yk
     * @date : 2020/07/10 17:00
     */
    public static Boolean upload(String host, Integer port, String username, String password, String basePath,
                                 String filePath, String fileName, InputStream inputStream){
        /*
        * 最终按照每天日期的文件夹来进行上传
        * */
        /*1.创建一个临时的路径变量，可能需要循环来进行创建当天日期的文件夹*/
        String tempPath = "";

        /*2.创建FTPClient对象，这个对象由commons-http包所提供，其实FTPClient就是最终ftp给java所提供的上传和下载功能
        * 也可以称之为ftp为java所提供的上传api*/
        FTPClient ftp = new FTPClient();

        try {
            /*3.定义一个返回状态码（是否连接成功，是否登录成功...）*/
            int reply;

            /*4.连接ftp服务器
            * 是否连接成功是没有返回值的，所以抛出了异常*/
            ftp.connect(host,port);

            /*5.登录ftp*/
            ftp.login(username, password);

            /*6.判断用户是否登录成功ftp服务器（接收服务器所返回的状态码）
            * 如果登录成功，则返回状态码230，如果登录失败，则返回的状态码为503*/
            reply = ftp.getReplyCode();

            /*7.判断是否登录成功（具体判断）
            * 返回的结果是true/false，如果是true代表连接成功，如果是false代表连接失败*/
            if (!FTPReply.isPositiveCompletion(reply)){
                /*说明登录失败，必须要断开ftp的连接*/
                ftp.disconnect();
                return false;
            }
            /*8.说明登录服务器成功
            * filepath：2020/07/13--------->先创建2020，再创建07，最后创建13
            * 检测文件上传的路径是否存在，如果不存在则创建
            * 返回的是Boolean类型，如果是true则说明存在，如果是false则说明不存在需要创建
            * */
            if (!ftp.changeWorkingDirectory(basePath+filePath)){
                /*说明上传的目录不存在需要自己手动创建
                * filepath:2020/07/13---->需要先创建2020，再创建07，再创建13*/
                /*9. 截取用户上传的目录
                * ["2020","07","13"]*/
                String[] filePathArray = filePath.split("/");

                /*目前临时路径就变成了/home/ftp*/
                tempPath = basePath;

                /*10.循环filePathArray(唯一的目的就是创建当前日期的目录)*/
                for (String dir: filePathArray
                     ) {
                    /*第一次循环：2020
                    * 11. 严谨判断：获取当前循环出来的String类型的文件夹地址(2020)*/
                    if (StringUtils.isEmpty(dir) || null == dir){
                        /*
                        没有数据
                        在这不能直接return，因为循环还没有结束，continue是跳过当前循环，进入下一次循环*/
                        continue;
                    }

                    /*12.把2020拼到临时路径中，组成新的路径/home/ftp/2020*/
                    tempPath += "/" + dir;

                    /*13.再次判断/home/ftp/2020是否存在*/
                    if (!ftp.changeWorkingDirectory(tempPath)){
                        /*说明路径不存在，则需要创建该路径*/

                        /*14.创建目录*/
                        if (!ftp.makeDirectory(tempPath)){
                            /*说明创建路径失败*/
                            return false;
                        }else {
                            /*说明路径创建成功
                            * 15.再次进行判断该路径是否存在(double check)*/
                            ftp.changeWorkingDirectory(tempPath);

                        }
                    }
                }
                /*16.开启以二进制流的形式来进行上传(因为二进制流的形式是计算机原有的语言，不需要进行编译可以直接运行，
                所以比普通的IO流上传速度会快)*/
                ftp.setFileType(FTP.BINARY_FILE_TYPE);

                /*17.真正的上传（这么多代码只有这一步进行上传操作）*/
                if (!ftp.storeFile(fileName,inputStream)){
                    /*说明上传失败*/
                    return false;
                }

                /*说明上传成功
                *
                * 18.关闭输入流*/
                inputStream.close();

                /*19.退出ftp用户*/
                ftp.logout();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            /*20.判断当前ftp是否处于正在连接状态*/
            if (ftp.isConnected()){
                /*说明当前服务器正在处于连接状态*/
                try {
                    ftp.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}
