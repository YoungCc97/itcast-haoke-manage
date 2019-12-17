package cn.itcast.haoke.dubbo.server.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @author Young
 * @date 2019/12/16 15:44
 * @description：分页对象
 */
@Data
@AllArgsConstructor
public class PageInfo<T> implements Serializable {

    private static final long serialVersionUID = 5054784078567109974L;
    /**
     * 总条数
     */
    private Integer total;
    /**
     * 当前页
     */
    private Integer pageNum;
    /**
     * 一页显示的大小
     */
    private Integer pageSize;
    /**
     * 数据列表
     */
    private List<T> records = Collections.emptyList();
}
