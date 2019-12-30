package cn.itcast.haoke.dubbo.server.service.impl;

import cn.itcast.haoke.dubbo.server.pojo.HouseResources;
import cn.itcast.haoke.dubbo.server.service.BaseServiceImpl;
import cn.itcast.haoke.dubbo.server.service.HouseResourcesService;
import cn.itcast.haoke.dubbo.server.vo.PageInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
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
public class HouseResourcesServiceImpl extends BaseServiceImpl<HouseResources> implements HouseResourcesService {

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

    /**
     * 分页查询房源列表
     *
     * @param page           当前页
     * @param pageSize       页面大小
     * @param queryCondition 查询条件
     * @return
     */
    @Override
    public PageInfo<HouseResources> queryHouseResourcesList(int page, int pageSize, HouseResources queryCondition) {

        QueryWrapper<HouseResources> queryWrapper = new QueryWrapper<HouseResources>(queryCondition);
        //根据数据的时间进行排序
        queryWrapper.orderByDesc("updated");
        IPage<HouseResources> iPage = super.queryPageList(queryWrapper, page, pageSize);

        PageInfo<HouseResources> pageInfo = new PageInfo<HouseResources>(Long.valueOf(iPage.getTotal()).intValue(),page,pageSize,iPage.getRecords());

        return pageInfo;
    }

    /**
     * 根据id查找房源数据
     *
     * @param id
     * @return
     */
    @Override
    public HouseResources queryHouseResourcesById(Long id) {
        return super.queryById(id);
    }
}
