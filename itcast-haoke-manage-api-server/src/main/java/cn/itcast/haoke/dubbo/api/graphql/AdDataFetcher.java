package cn.itcast.haoke.dubbo.api.graphql;

import cn.itcast.haoke.dubbo.api.service.AdService;
import cn.itcast.haoke.dubbo.api.vo.ad.index.IndexAdResult;
import cn.itcast.haoke.dubbo.api.vo.ad.index.IndexAdResultData;
import cn.itcast.haoke.dubbo.server.pojo.Ad;
import cn.itcast.haoke.dubbo.server.vo.PageInfo;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Young
 * @date 2019/12/30 16:20
 * @description：
 */
@Component
public class AdDataFetcher implements MyDataFetcher{

    @Autowired
    private AdService adService;

    @Override
    public String fieldName() {
        return "IndexAdList";
    }

    @Override
    public Object dataFetcher(DataFetchingEnvironment environment) {
        PageInfo<Ad> pageInfo = this.adService.queryAdList(1, 1, 3);
        List<Ad> records = pageInfo.getRecords();
        List<IndexAdResultData> list = new ArrayList<>();
        for (Ad record : records) {
            list.add(new IndexAdResultData(record.getUrl()));
        }
        return new IndexAdResult(list);
    }
}
