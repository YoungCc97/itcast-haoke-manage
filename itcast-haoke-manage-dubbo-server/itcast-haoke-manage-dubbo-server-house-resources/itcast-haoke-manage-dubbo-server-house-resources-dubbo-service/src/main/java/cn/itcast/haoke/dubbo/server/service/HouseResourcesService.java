package cn.itcast.haoke.dubbo.server.service;

import cn.itcast.haoke.dubbo.server.pojo.HouseResources;
import cn.itcast.haoke.dubbo.server.vo.PageInfo;

/**
 * @author Young
 */
public interface HouseResourcesService {
    /**
     * @param houseResources
     * @return -1:输入的参数不符合要求，0：数据插入数据库失败，1：成功
     */
    int saveHouseResources(HouseResources houseResources);

    /***
     *
     * @param page 当前页
     * @param pageSize 每页大小
     * @param queryCondition 实体类
     * @return pageinfo实体类
     */
    PageInfo<HouseResources> queryHouseResourcesList(int page, int pageSize, HouseResources queryCondition);
}