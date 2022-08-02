package com.sxliusir;

import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.LoadBalancerBuilder;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.reactive.LoadBalancerCommand;
import com.netflix.loadbalancer.reactive.ServerOperation;
import lombok.SneakyThrows;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import rx.Observable;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class RibbonApplicationTests {

    @Test
    void contextLoads() {
        List<Server> serverList = Lists.newArrayList(new Server("localhost", 10001), new Server("localhost", 10002));

        // 构建负载实例
        BaseLoadBalancer loadBalancer = LoadBalancerBuilder.newBuilder().buildFixedServerListLoadBalancer(serverList);
        loadBalancer.setRule(new RoundRobinRule());
        //loadBalancer.setRule(new RandomRule());
        // 调用5次来测试效果
        for (int i = 0; i < 5; i++) {
            String result = LoadBalancerCommand.<String>builder().withLoadBalancer(loadBalancer).build()
                    .submit(new ServerOperation<String>() {
                        public Observable<String> call(Server server) {
                            try {
                                String addr = "http://" + server.getHost() + ":" + server.getPort() + "/hello";
                                System.out.println("调用地址：" + addr);
                                URL url = new URL(addr);
                                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                                conn.setRequestMethod("GET");
                                conn.connect();
                                InputStream in = conn.getInputStream();
                                byte[] data = new byte[in.available()];
                                in.read(data);
                                return Observable.just(new String(data));
                            } catch (Exception e) {
                                return Observable.error(e);
                            }
                        }
                    }).toBlocking().first();
            System.out.println("调用结果：" + result);
        }
    }

}
