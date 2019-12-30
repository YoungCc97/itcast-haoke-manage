package cn.itcast.haoke.dubbo.server.service;

import cn.itcast.haoke.dubbo.server.mapper.HouseResourcesMapper;
import cn.itcast.haoke.dubbo.server.pojo.HouseResources;
import cn.itcast.haoke.dubbo.server.service.HouseResourcesService;
import cn.itcast.haoke.dubbo.server.vo.PageInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HouseResourcesServiceImplTest {

    @Autowired
    private HouseResourcesMapper houseResourcesMapper;

    @Test
    public void queryHouseResourcesList() {
        Page<HouseResources> page = new Page<>(1, 1);
        IPage<HouseResources> houseResourcesIPage = houseResourcesMapper.selectPage(page, null);
        System.out.println(houseResourcesIPage.getTotal());
    }
}
