package cn.itcast.haoke.dubbo.api.vo;

import lombok.*;

import java.util.List;

/**
 * @author Young
 * @date 2019/12/16 16:08
 * @description：分页对象
*/
@Data
@AllArgsConstructor
public class TableResult<T> {
    /***
     * 数据信息
     */
    private List<T> list;
    private Pagination pagination;
}