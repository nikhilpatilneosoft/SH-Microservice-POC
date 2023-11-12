package com.example.Order.Repositories;

import com.example.Order.Models.MarketOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<MarketOrder, Integer> {
}
