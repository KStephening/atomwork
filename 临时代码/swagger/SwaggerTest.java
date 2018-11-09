package com.xxxx.xx.xxx.web.test;


import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


/**
 * <p>
 *
 * </p>
 *
 * @author xiachaoyang 2018年05月31日 10:21
 * @version V1.0
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人} 2018年05月31日
 * @modify by reason:{方法名}:{原因}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:*-swt.xml"})
public class SwaggerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    /**
     * 初始化 MOCK
     */
    @Before
    public void init() {
        mockMvc = webAppContextSetup(wac).build();
    }

    /**
     * 生成 swagger.json
     *
     * @throws Exception
     */
    @Test
    public void getSwaggerJson() throws Exception {
        //获取插件中配置的swagger文件输出地址
        String outputDir = System.getProperty("io.springfox.staticdocs.outputDir");
        //获取插件中配置的swagger.json的访问地址,有几个接口分组就有几个访问地址，地址必须是swagger2controller中原生的，如果是在web.xml自定义的则无法访问，因为mock的服务不会解析web.xml
        String uris = System.getProperty("io.swagger.json.uris");
        //获取插件中配置的每个json文件的名称，名称可配置多个，有几个接口分组就有几个名称， 名称的格式必须是：组件标识-接口分组标识-接口版本号，例如：xxx-api-v1
        String swaggerOutName = System.getProperty("io.swagger.json.output.name");
        String[] uriArray = uris.trim().split(",");
        String[] swaggerOutNameArray = swaggerOutName.trim().split(",");
        //清空文件夹
        //FileUtils.deleteDirectory(Paths.get(outputDir).toFile());
        for (int i = 0; i < uriArray.length; i++) {
            MvcResult mvcResult = mockMvc
                    .perform((get(uriArray[i]))
                            .accept(MediaType.APPLICATION_JSON_UTF8))
                    .andExpect(status().isOk())
                    .andReturn();
            MockHttpServletResponse response = mvcResult.getResponse();
            String swaggerJson = response.getContentAsString();
            Files.createDirectories(Paths.get(outputDir));
            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputDir, swaggerOutNameArray[i]), StandardCharsets.UTF_8)) {
                writer.write(swaggerJson);
            }
        }
    }

}
