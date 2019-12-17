package cn.itcast.haoke.dubbo.api.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Young
 * @date 2019/12/16 16:07
 * @description：分页信息
*/
@Data
@AllArgsConstructor
public class Pagination {
    /***
     * 当前页
     */
    private Integer current;
    /***
     * 每页大小
     */
    private Integer pageSize;
    /***
     * 总页数
     */
    private Integer total;
}