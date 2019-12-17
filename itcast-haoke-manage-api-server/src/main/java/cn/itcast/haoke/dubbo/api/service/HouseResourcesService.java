package cn.itcast.haoke.dubbo.api.service;

import cn.itcast.haoke.dubbo.api.vo.Pagination;
import cn.itcast.haoke.dubbo.api.vo.TableResult;
import cn.itcast.haoke.dubbo.server.api.ApiHouseResourcesService;
import cn.itcast.haoke.dubbo.server.pojo.HouseResources;
import cn.itcast.haoke.dubbo.server.vo.PageInfo;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @author Young
 * @date 2019/12/16 9:43
 * @description：房源接口
*/
@Service
public class HouseResourcesService {

    @Reference(version = "1.0.0")
    private ApiHouseResourcesService apiHouseResourcesService;

    public boolean save(HouseResources houseResources) {
        int result = this.apiHouseResourcesService.saveHouseResources(houseResources);
        return result == 1;
    }

    public TableResult<HouseResources> queryList(HouseResources houseResources, Integer currentPage, Integer pageSize) {
        PageInfo<HouseResources> pageInfo = this.apiHouseResourcesService.queryHouseResourcesList(currentPage, pageSize, houseResources);
        TableResult<HouseResources> tableResult = new TableResult<HouseResources>(pageInfo.getRecords(),
                new Pagination(pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getTotal()));
        return tableResult;
    }
}