package cn.itcast.haoke.dubbo.server.service;

import cn.itcast.haoke.dubbo.server.pojo.Ad;
import cn.itcast.haoke.dubbo.server.vo.PageInfo;

/**
 * @author Young
 * 轮播广告service
 */
public interface AdService {
    /***
     *
     * @param ad 轮播广告实体类
     * @param page 当前页
     * @param pageSize 每页大小
     * @return
     */
    PageInfo<Ad> queryAdList(Ad ad, Integer page, Integer pageSize);
}