package com.example.Order.Controller;

import com.example.Order.Config.OrderFeignClient;
import com.example.Order.Controller.RequestDTOs.CreateMarketOrderRequestDTO;
import com.example.Order.Models.MarketOrder;
import com.example.Order.Service.OrderService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final ModelMapper modelMapper;
//    private OrderFeignClient orderFeignClient;
    private final RestTemplate restTemplate;

    @GetMapping("/")
    public List<MarketOrder> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public MarketOrder getOrderById(@PathVariable int id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/")
    @RateLimiter(name = "createOrderRatelimiter", fallbackMethod = "createOrderFallback")
    public MarketOrder createOrder(@RequestBody CreateMarketOrderRequestDTO createMarketOrderRequestDTO) {
        String shareName = createMarketOrderRequestDTO.getShareName();
        MarketOrder marketOrder = modelMapper.map(createMarketOrderRequestDTO, MarketOrder.class);
        return orderService.createOrder(marketOrder, shareName);
    }


    public MarketOrder createOrderFallback(CreateMarketOrderRequestDTO createMarketOrderRequestDTO, Throwable t) {
        MarketOrder order = MarketOrder.builder()
                .id(0)
                .quantity(0)
                .date(new Date())
                .type(createMarketOrderRequestDTO.getType())
                .build();

        return order;
    }

//    @PostMapping("/createOrder")
//    public Mono<MarketOrder> createOrderMethod(@RequestBody CreateMarketOrderRequestDTO createMarketOrderRequestDTO) {
//        return orderService.createOrder(createMarketOrderRequestDTO);
//    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
    }

    @PostMapping("/order_test")
    public String orderTest() {
        restTemplate.exchange("http://localhost:8182/shares/test", HttpMethod.POST, null, String.class);
//        restTemplate.postForObject("http://localhost:8182/shares/test", name, String.class);

//        orderFeignClient.test();
        return "order_test";
    }
}
