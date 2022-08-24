package cn.itcast.order.web;

import cn.itcast.order.pojo.Order;
import cn.itcast.order.service.OrderService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author zhi
 */
@RefreshScope
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;
//    @Autowired
//    private PatternProperties properties;

//    @GetMapping("/prop")
//    public PatternProperties prop() {
//        return properties;
//    }


//    @GetMapping("/now")
//    public String now() {
//        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(properties.getDateformat()
//        ));
//    }

    @GetMapping("{orderId}")
    public Order queryOrderByUserId(@PathVariable("orderId") Long orderId) {
        // 根据id查询订单并返回
        return orderService.queryOrderById(orderId);
    }
}
