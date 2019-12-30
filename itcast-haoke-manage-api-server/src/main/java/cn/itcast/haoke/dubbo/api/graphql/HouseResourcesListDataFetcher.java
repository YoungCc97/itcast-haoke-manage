package cn.itcast.haoke.dubbo.api.graphql;

import cn.itcast.haoke.dubbo.api.service.HouseResourcesService;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Young
 * @date 2019/12/19 16:49
 * @description：
 */
@Component
public class HouseResourcesListDataFetcher implements MyDataFetcher {

    @Autowired
    private HouseResourcesService houseResourcesService;

    @Override
    public String fieldName() {
        return "HouseResourcesList";
    }

    @Override
    public Object dataFetcher(DataFetchingEnvironment environment) {
        Integer page = environment.getArgument("page");
        if (null == page){
            page = 1;
        }
        Integer pageSize = environment.getArgument("pageSize");
        if (null == pageSize){
            pageSize = 5;
        }
        return this.houseResourcesService.queryList(null,page,pageSize);
    }
}
