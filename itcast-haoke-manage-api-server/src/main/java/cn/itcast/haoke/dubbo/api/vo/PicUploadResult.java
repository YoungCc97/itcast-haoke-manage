package cn.itcast.haoke.dubbo.api.vo;

import lombok.Data;

/**
 * @author Young
 * @date 2019/12/16 11:59
 * @description：上传文件返回实体类
 */
@Data
public class PicUploadResult {
    /**
     * @author Young
     * @date 2019/12/16 12:00
     * @param uid
     * @description：文件唯一标识
    */
    private String uid;
    /**
     * @author Young
     * @date 2019/12/16 12:00
     * @param name
     * @description：文件名
     */
    private String name;
    /**
     * @author Young
     * @date 2019/12/16 12:00
     * @param status
     * @description：状态有：uploading done error removed
     */
    private String status;
    /**
     * @author Young
     * @date 2019/12/16 12:00
     * @param response
     * @description：服务端响应内容，如：'{"status": "success"}'
     */
    private String response;
}
