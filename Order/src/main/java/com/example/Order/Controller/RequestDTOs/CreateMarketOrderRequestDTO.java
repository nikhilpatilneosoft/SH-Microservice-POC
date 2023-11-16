package com.example.Order.Controller.RequestDTOs;

import com.example.Order.Models.OrderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateMarketOrderRequestDTO {
    private int quantity;
    private String shareName;
    private String type;
}
