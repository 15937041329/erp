package com.zsy.common.template;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
@Data
public class OssTemplate {

    @Value("${aliyun.oss.endpoint}")
    private String endpoint;

    @Value("${aliyun.oss.access-key-id}")
    private String accessKeyId;

    @Value("${aliyun.oss.access-key-secret}")
    private String accessKeySecret;

    @Value("${aliyun.oss.bucket-name}")
    private String bucketName;

    /**
     * 上传文件至OSS
     * @param key img/1.jpg
     * @param inputStream  字节流
     * @return
     */
    public boolean upload(final String key, final InputStream inputStream, ObjectMetadata metadata) {

        return handler(new OssHandler() {
            @Override
            public void handler(OSSClient client) {
                client.putObject(bucketName, key, inputStream, metadata);
            }
        });
    }

    /**
     * 上传文件至OSS
     * @param key img/1.jpg
     * @param inputStream  字节流
     * @return
     */
    public boolean upload(final String key,final InputStream inputStream) {
        return handler(new OssHandler() {
            @Override
            public void handler(OSSClient client) {
                client.putObject(bucketName, key, inputStream);
            }
        });
    }

    /**
     * 删除指定oss资源
     * @param key  例如img/1.jpg
     * @return
     */
    public boolean delete(final String key) {
        return handler(new OssHandler() {
            @Override
            public void handler(OSSClient client) {
                client.deleteObject(bucketName, key);
            }
        });
    }

    private boolean handler(OssHandler ossHandler){
        OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        try {
            ossHandler.handler(client);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if(client!=null){
                client.shutdown();
            }
        }
        return true;
    }

    static interface OssHandler{
        public void handler(OSSClient client);
    }

}
