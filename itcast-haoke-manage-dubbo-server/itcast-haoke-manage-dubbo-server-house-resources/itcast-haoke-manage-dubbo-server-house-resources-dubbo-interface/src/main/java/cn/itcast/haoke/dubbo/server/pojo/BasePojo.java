package cn.itcast.haoke.dubbo.server.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Young
 * @date 2019/12/13 16:18
 * @description：
 */
@Data
public abstract class BasePojo implements Serializable {
    private Date created;
    private Date updated;
}
