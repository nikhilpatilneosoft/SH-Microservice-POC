package com.example.Order.Service;

import com.example.Order.Models.MarketOrder;
import reactor.core.publisher.Mono;

import java.util.List;

public interface OrderService {

    List<MarketOrder> getAllOrders();

    MarketOrder getOrderById(int id);

    MarketOrder createOrder(MarketOrder marketOrder, String sharename);

    void deleteOrder(int id);


}
