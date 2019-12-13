package cn.itcast.haoke.dubbo.server.service.impl;

import cn.itcast.haoke.dubbo.server.pojo.HouseResources;
import cn.itcast.haoke.dubbo.server.service.HouseResourcesService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Young
 * @date 2019/12/13 17:52
 * @description：房源实现类
 */
@Transactional //开启事务
@Service //这是一个Spring的服务
public class HouseResourcesServiceImpl extends BaseServiceImpl implements HouseResourcesService {

    /**
     * @param houseResources
     * @return -1:输入的参数不符合要求，0：数据插入数据库失败，1：成功
     */
    @Override
    public int saveHouseResources(HouseResources houseResources) {
        //添加校验 或者是其他的逻辑
        if (StringUtils.isBlank(houseResources.getTitle())) {
            //不符合要求
            return -1;
        }
        return super.save(houseResources);
    }
}
