> SpringBoot只是一个配置工具，整合工具，辅助工具
> SpringMVC是框架，项目中实际运行的代码



### Spring MVC的功能

Spring MVC提供了一种轻度解耦的方式来开发web应用
spring MVC是Spring的一个模块，是一个框架。通过Dispatcher Servlet,ModeAndView和View Resolver，开发web应用变得容易。
解决的问题领域是网站应用程序或者服务开发，URL路由、Session、模板引擎、静态Web资源等

### SpringBoot的功能

SpringBoot实现了自动配置，降低了项目搭建的复杂度。说到底是一个工具，整合了大量的第三方库配置.
Spring Boot是一个”引擎“
Spring MVC是基于Spring的一个MVC框架
**Spring Boot是基于Spring4条件注册的一套快速开发软件包**

### SpringBoot启动原理

@SpringBootApplication注解：
包含了三个主要的注解，1. @Configuration 2. @EnableAutoConfiguration 3.@ComponentScan
@Configuration:将启动类定义成一个Ioc容器的配置类。（SpringBoot推荐使用JavaConfig的配置形式 ）
@EnableAutoConfiguration:借助@Import的帮助，将所有符合自动装配条件的bean定义加载到IOC容器。
@ComponentScan:自动扫描并加载符合条件的组件（比如@Component和@Respository）或者bean的定义，最终将这些加载到Ioc容器中。