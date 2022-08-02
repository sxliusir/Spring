package com.sxliusir;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;

import java.net.URI;
import java.util.Collections;
import java.util.Map;

@SpringBootTest
class RestTemplateApplicationTests {

    @Bean
    // 开启负载均衡
    @LoadBalanced
    RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        //拦截器
        restTemplate.getInterceptors().add(new LoggingClientHttpRequestInterceptor());
        return restTemplate;
    }

    @Test
    void contextLoads() {
        String url = "http://localhost:12000/Hi";
        String forObject = restTemplate().getForObject(url, String.class);
        System.out.println(forObject);
    }
    @Test
    //返回map
    void test1() {
        String url = "http://localhost:12000/getMap";
        ResponseEntity<Map> forEntity = restTemplate().getForEntity(url, Map.class);
        System.out.println("respStr：" +  forEntity.getBody());
    }

    @Test
    //返回对象
    void test2() {
        String url = "http://localhost:12000/getObj";
        ResponseEntity<Person> forEntity = restTemplate().getForEntity(url, Person.class);
        System.out.println("respStr：" + ToStringBuilder.reflectionToString(forEntity.getBody()));
    }

    @Test
    //传参调用
    void test3(){
        String url = "http://localhost:12000/getObjParam?name={1}";
        ResponseEntity<Person> forEntity = restTemplate().getForEntity(url, Person.class,"Jack");
        System.out.println("respStr：" + ToStringBuilder.reflectionToString(forEntity.getBody()));
    }

    @Test
    //post请求处理
    void test4(){
        String url = "http://localhost:12000/postParam";
        Map<String, String> map = Collections.singletonMap("name", "Tom");
        ResponseEntity<Person> forEntity = restTemplate().postForEntity(url, map, Person.class);
        System.out.println("respStr：" + ToStringBuilder.reflectionToString(forEntity.getBody()));
    }

    @Test
    void test5()
    {
        URI uri = restTemplate().postForLocation("https://www.baidu.com/s?wd=tom", "");
        String forObject = restTemplate().getForObject(uri, String.class);
        System.out.println(forObject);
    }
}
