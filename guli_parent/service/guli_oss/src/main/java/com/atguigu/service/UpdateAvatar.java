package com.atguigu.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Kyrie
 */
public interface UpdateAvatar {
    /**
     * 上传讲师头像，返回存储在OSS的文件路径地址
     * @param file
     * @return
     */
    String updateAvatarFile(MultipartFile file);
}
