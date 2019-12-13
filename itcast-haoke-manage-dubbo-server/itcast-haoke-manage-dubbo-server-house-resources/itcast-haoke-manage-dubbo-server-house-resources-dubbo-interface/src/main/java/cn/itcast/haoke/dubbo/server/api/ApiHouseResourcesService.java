package cn.itcast.haoke.dubbo.server.api;

import cn.itcast.haoke.dubbo.server.pojo.HouseResources;

/**
 * @author Young
 * @date 2019/12/13 17:31
 * @description：房源接口
 */
public interface ApiHouseResourcesService {
    /***
     * 新增房源接口
     * @param houseResources
     * @return-1:输入的参数不符合要求，0：数据插入数据库失败，1：成功
     */
    int saveHouseResources(HouseResources houseResources);
}
