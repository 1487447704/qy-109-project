package com.aaa.three.service;

import com.aaa.three.properties.FtpProperties;
import com.aaa.three.utils.FileNameUtils;
import com.aaa.three.utils.FtpUtils;
import org.apache.commons.httpclient.util.DateUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

import static com.aaa.three.staticproperties.RedisProperties.POINT;
import static com.aaa.three.staticproperties.TimeFormatProperties.DATE_FORMAT;

/**
 * @Param
 * @ClassName UploadService
 * @Description TODO
 * @Author yk
 * @Date 2020/7/13 0013 9:44
 * @Return
 **/
@Service
public class UploadService {

    private FtpProperties ftpProperties;

    /**
     * @Description : 文件上传
     * @param file
     * @return : java.lang.Boolean
     * @author : yk
     * @date : 2020/07/13 10:00
     */
    public Boolean upload(MultipartFile file){
        /*1.获取文件的远程名称(为了获取后缀名)*/
        String oldFileName = file.getOriginalFilename();

        /*2.生成新的文件名*/
        String newFileName = FileNameUtils.getFileName();

        /*3.截取后缀名，拼接到新的文件名上*/
        newFileName = newFileName + oldFileName.substring(oldFileName.lastIndexOf(POINT));

        /*4.获取文件的上传路径(2020/07/13)*/
        //TODO 暂时没有完成，目前使用的是apache开源基金会的日期工具类
        String filePath = DateUtil.formatDate(new Date(),DATE_FORMAT);

        /*5.调用文件上传工具类*/
        try {
            return FtpUtils.upload(ftpProperties.getHost(),ftpProperties.getPort(),ftpProperties.getUsername(),
                    ftpProperties.getPassword(),ftpProperties.getBasePath(),filePath,newFileName,file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
