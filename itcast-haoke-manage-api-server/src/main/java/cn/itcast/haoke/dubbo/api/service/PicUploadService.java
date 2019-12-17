package cn.itcast.haoke.dubbo.api.service;

import cn.itcast.haoke.dubbo.api.config.AliyunConfig;
import cn.itcast.haoke.dubbo.api.vo.PicUploadResult;
import com.aliyun.oss.OSS;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;

/**
 * @author Young
 * @date 2019/12/16 11:57
 * @description：阿里云OSS文件存储
 */
@Service
public class PicUploadService {

    /**
     * @author Young
     * @date 2019/12/16 13:23
     * @param null
     * @description：允许上传的格式
     */
    private static final String[] IMAGE_TYPE = new String[]{".bmp", ".jpg", ".jpeg", ".gif", ".png"};

    @Autowired
    private OSS ossClient;

    @Autowired
    private AliyunConfig aliyunConfig;


    public PicUploadResult upload(MultipartFile uploadFile) {
        PicUploadResult fileUploadResult = new PicUploadResult();

        //文件名
        String fileName = uploadFile.getOriginalFilename();
        // 校验图片格式
        boolean isLegal = false;
        for (String type : IMAGE_TYPE) {
            if (StringUtils.endsWithIgnoreCase(fileName, type)) {
                isLegal = true;
                break;
            }
        }
        // 封装Result对象，并且将文件的byte数组放置到result对象中
        if (!isLegal) {
            fileUploadResult.setStatus("error");
            return fileUploadResult;
        }

        // 文件新路径
        String filePath = getFilePath(fileName);

        // 上传到阿里云
        try {
            //目录结构: images/年/月/日/xxxx.jpg  列子：images/2018/12/20/xxxx.jpg
            ossClient.putObject(aliyunConfig.getBucketName(), filePath, new
                    ByteArrayInputStream(uploadFile.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
            //上传失败
            fileUploadResult.setStatus("error");
            return fileUploadResult;
        }
        fileUploadResult.setStatus("done");
        fileUploadResult.setName(this.aliyunConfig.getUrlPrefix() + filePath);
        fileUploadResult.setUid(String.valueOf(System.currentTimeMillis()));

        return fileUploadResult;
    }

    private String getFilePath(String sourceFileName) {
        DateTime dateTime = new DateTime();
        return "images/" + dateTime.toString("yyyy")
                + "/" + dateTime.toString("MM") + "/"
                + dateTime.toString("dd") + "/" + System.currentTimeMillis() +
                RandomUtils.nextInt(100, 9999) + "." +
                StringUtils.substringAfterLast(sourceFileName, ".");
    }
}
