package cn.itcast.order.config;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.cloud.loadbalancer.core.ReactorServiceInstanceLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@LoadBalancerClients(defaultConfiguration = {MyLoadBalancerConfig.class})
public class MyLoadBalancerConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    // 参数 serviceInstanceListSupplierProvider 会自动注入
//    @Bean
//    public ReactorServiceInstanceLoadBalancer customLoadBalancer(ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierProvider) {
//        return new CustomRandomLoadBalancerClient(serviceInstanceListSupplierProvider);
//    }
}