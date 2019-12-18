package cn.itcast.haoke.dubbo.api.graphql;

import cn.itcast.haoke.dubbo.api.service.HouseResourcesService;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author Young
 * @date 2019/12/17 17:13
 * @description：将GraphQL对象载入到spring容器，并且完成GraphQL对象的初始化的功能
 */
@Component
public class GrapQLProvider {

    private GraphQL graphQL;

    @Autowired
    private HouseResourcesService houseResourcesService;

    /***
     *实现GraphQL对象的初始化
     */
    @PostConstruct
    public void init() throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:haoke.graphql");
        this.graphQL = GraphQL.newGraphQL(buildGraphQLSchema(file)).build();
    }

    private GraphQLSchema buildGraphQLSchema(File file) {
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(file);
        return new SchemaGenerator().makeExecutableSchema(typeRegistry, buildWiring());
    }

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("HaokeQuery", builder ->
                        builder.dataFetcher("HouseResources", dataFetchingEnvironment -> {
                            Long id = dataFetchingEnvironment.getArgument("id");
                            return this.houseResourcesService.queryHouseResourcesById(id);
                        })
                )
                .build();
    }

    @Bean
    public GraphQL graphQL() {
        return this.graphQL;
    }
}
