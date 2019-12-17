package cn.itcast.haoke.dubbo.api.controller;

import cn.itcast.haoke.dubbo.api.service.HouseResourcesService;
import cn.itcast.haoke.dubbo.api.vo.TableResult;
import cn.itcast.haoke.dubbo.server.pojo.HouseResources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Young
 * @date 2019/12/16 9:45
 * @description：
 */
@Controller
@RequestMapping("house/resources")
public class HouseResourcesController {

    @Autowired
    private HouseResourcesService houseResourcesService;

    /***
     * 新增房源
     * @param houseResources json数据
     * @return
     */
    @PostMapping
    @ResponseBody
    public ResponseEntity<Void> save(@RequestBody HouseResources houseResources) {
        try {
            boolean bool = houseResourcesService.save(houseResources);
            if (bool) {
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * 查询房源列表
     *
     * @param houseResources
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping
    @ResponseBody
    public ResponseEntity<TableResult> list(HouseResources houseResources,
                                            @RequestParam(name = "currentPage", defaultValue = "1") Integer currentPage,
                                            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return ResponseEntity.ok(this.houseResourcesService.queryList(houseResources, currentPage, pageSize));
    }


}
