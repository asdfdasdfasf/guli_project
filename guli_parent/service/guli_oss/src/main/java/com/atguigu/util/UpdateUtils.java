package com.atguigu.util;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author KyrieStudy
 * @version 1.0
 * @date 2022/6/7 21:42
 */
@Component
public class UpdateUtils implements InitializingBean {
    @Value("${aliyun.oss.file.endpoint}")
    private String endPoint;

    @Value("${aliyun.oss.file.keyid}")
    private String keyId;

    @Value("${aliyun.oss.file.keysecret}")
    private String keySecret;

    @Value("${aliyun.oss.file.bucketname}")
    private String bucketName;

    public static String ENDPOINT;

    public static String KEYID;

    public static String KEYSECRET;

    public static String BUCKETNAME;

    @Override
    public void afterPropertiesSet() throws Exception {
        ENDPOINT=this.endPoint;
        KEYID=this.keyId;
        KEYSECRET=this.keySecret;
        BUCKETNAME=this.bucketName;
    }
}
