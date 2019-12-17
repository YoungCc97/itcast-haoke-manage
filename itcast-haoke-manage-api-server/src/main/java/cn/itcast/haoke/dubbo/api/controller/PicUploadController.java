package cn.itcast.haoke.dubbo.api.controller;

import cn.itcast.haoke.dubbo.api.service.PicUploadFileSystemService;
import cn.itcast.haoke.dubbo.api.service.PicUploadService;
import cn.itcast.haoke.dubbo.api.vo.PicUploadResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Young
 * @date 2019/12/16 11:54
 * @description：图片上传
 */
@RequestMapping("pic/upload")
@Controller
public class PicUploadController {

    @Autowired
    private PicUploadService picUploadService;

//    @Autowired
//    private PicUploadFileSystemService picUploadService;

    @PostMapping
    @ResponseBody
    public PicUploadResult upload(@RequestParam("file") MultipartFile multipartFile){
        PicUploadResult picUploadResult = this.picUploadService.upload(multipartFile);
        return picUploadResult;
    }
}
