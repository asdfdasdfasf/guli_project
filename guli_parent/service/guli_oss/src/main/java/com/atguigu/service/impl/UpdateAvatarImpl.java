package com.atguigu.service.impl;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.atguigu.service.UpdateAvatar;
import com.atguigu.util.UpdateUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author KyrieStudy
 * @version 1.0
 * @date 2022/6/7 22:09
 */
@Service
public class UpdateAvatarImpl implements UpdateAvatar {
    @Override
    public String updateAvatarFile(MultipartFile file) {
        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
        String endpoint = UpdateUtils.ENDPOINT;
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = UpdateUtils.KEYID;
        String accessKeySecret = UpdateUtils.KEYSECRET;
        // 填写Bucket名称，例如examplebucket。
        String bucketName = UpdateUtils.BUCKETNAME;
        //获取文件名称
        String filePath = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        filePath=uuid+filePath;
        System.out.println("FilePath="+filePath);
        //获取当前时间
        String dateTime = new DateTime().toString("yyyy/MM/dd");
        //拼接路径
        filePath=dateTime+"/"+filePath;
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        String result="";
        try {
            InputStream inputStream = file.getInputStream();
            // 创建PutObject请求。
            ossClient.putObject(bucketName, filePath, inputStream);
            result="https://"+bucketName+"."+endpoint+"/"+filePath;
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return result;
    }
}
