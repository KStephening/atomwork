package com.longer.util;

import com.google.common.base.Predicate;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

/**
 * @program: spring-springmvc
 * @description:
 * @author: PuTao
 * @create: 2018-10-15 17:48
 **/
@Configuration
@EnableWebMvc
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket createDocketA() {
		return buildDocket(
				"default",
				//接口扫描
				RequestHandlerSelectors.basePackage("com.longer.controller"),
				PathSelectors.any()
		);
	}

	private Docket buildDocket(String groupName, Predicate<RequestHandler> selector, Predicate<String> filter) {
		return new Docket(DocumentationType.SWAGGER_2)
				//组名
				.groupName(groupName)
				//关闭默认的响应Code
				.useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET, responseMessageList())
				.globalResponseMessage(RequestMethod.POST, responseMessageList())
				.globalResponseMessage(RequestMethod.PUT, responseMessageList())
				.globalResponseMessage(RequestMethod.DELETE, responseMessageList())
				.enableUrlTemplating(true)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
				.build();
	}

	/**
	 * API信息
	 * @return
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("使用Swagger2构建RESTful APIs")
				.description("这里是接口文档的描述")
				.termsOfServiceUrl("http://localhost:8080")
				.version("1.0")
				.build();
	}

	/**
	 * 通用的response
	 * @return
	 */
	private List<ResponseMessage> responseMessageList() {
		ResponseMessage m500 = new ResponseMessageBuilder()
				.code(500)
				.message("服务器开小差了")
				.build();
		ResponseMessage m400 = new ResponseMessageBuilder()
				.code(400)
				.message("您的请求有误,is bad request!")
				.build();
		ResponseMessage m403 = new ResponseMessageBuilder()
				.code(403)
				.message("您无权限访问")
				.build();
		ResponseMessage m404 = new ResponseMessageBuilder()
				.code(404)
				.message("您请求的资源不存在")
				.build();
		return Arrays.asList(m400, m403, m404, m500);
	}
}
