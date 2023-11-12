package com.example.Order.Controller.ResponseDTOs;

import com.example.Order.Models.OrderType;
import com.example.Order.Models.Report;
import com.example.Order.Models.Share;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateMarketOrderResponseDTO {
    private int id;
    private int quantity;
    private Share share;
    private Report report;
    private Date date;
    private OrderType type;
}
