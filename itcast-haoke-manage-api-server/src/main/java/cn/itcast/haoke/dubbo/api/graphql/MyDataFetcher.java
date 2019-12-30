package cn.itcast.haoke.dubbo.api.graphql;

import graphql.schema.DataFetchingEnvironment;

/**
 * @author Young
 * @date 2019/12/19 16:39
 * @description：
 */
public interface MyDataFetcher {

    /***
     * GrapQL中查询的名称
     * @return
     */
    String fieldName();

    /***
     * 数据的查询
     * @param environment
     * @return
     */
    Object dataFetcher(DataFetchingEnvironment environment);
}
