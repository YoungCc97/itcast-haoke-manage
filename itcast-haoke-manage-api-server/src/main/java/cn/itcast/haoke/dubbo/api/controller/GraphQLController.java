package cn.itcast.haoke.dubbo.api.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Young
 * @date 2019/12/17 17:07
 * @description：使用GraphQL根据ID查询房源信息
 */
@RequestMapping("graphql")
@Controller
@CrossOrigin
public class GraphQLController {

    @Autowired
    private GraphQL graphQL;

    private static final ObjectMapper MAPPER = new ObjectMapper();

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

    @PostMapping
    @ResponseBody
    public Map<String, Object> postQraphql(@RequestBody String json) throws IOException {
        JsonNode jsonNode = MAPPER.readTree(json);
        if (jsonNode.has("query")) {
            String query = jsonNode.get("query").textValue();
            return this.graphQL.execute(query).toSpecification();
        }
        Map<String,Object> error = new HashMap<>();
        error.put("status",500);
        error.put("msg","查询出错");
        return error;
    }
}
