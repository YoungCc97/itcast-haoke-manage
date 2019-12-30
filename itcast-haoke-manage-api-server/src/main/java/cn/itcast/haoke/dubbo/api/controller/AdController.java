package cn.itcast.haoke.dubbo.api.controller;

import cn.itcast.haoke.dubbo.api.service.AdService;
import cn.itcast.haoke.dubbo.api.vo.WebResult;
import cn.itcast.haoke.dubbo.server.pojo.Ad;
import cn.itcast.haoke.dubbo.server.vo.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Young
 * @date 2019/12/30 15:32
 * @description：轮播广告restful接口
 */
@RequestMapping("ad")
@RestController
@CrossOrigin
public class AdController {

    @Autowired
    private AdService adService;

    @GetMapping
    public WebResult queryAdList(){
        PageInfo<Ad> adPageInfo = this.adService.queryAdList(1, 1, 3);
        List<Ad> records = adPageInfo.getRecords();
        List<Object> result = new ArrayList<>();
        for (Ad record : records) {
            Map<String,Object> map = new HashMap<>();
            map.put("original",record.getUrl());
            result.add(map);
        }
        return WebResult.ok(result);
    }
}
