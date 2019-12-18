package cn.itcast.haoke.dubbo.api.controller;

import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

/**
 * @author Young
 * @date 2019/12/17 17:07
 * @description：使用GraphQL根据ID查询房源信息
 */
@RequestMapping("graphql")
@Controller
public class GraphQLController {

    @Autowired
    private GraphQL graphQL;

    /***
     * 实现GraphQL查询
     * @param query
     * @return
     */
    @GetMapping
    @ResponseBody
    public Map<String, Object> graphql(@RequestParam("query") String query) throws IOException {
        return this.graphQL.execute(query).toSpecification();
    }
}
