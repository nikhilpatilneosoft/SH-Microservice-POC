package com.example.Order.Config.FeignResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateReportResponseDTO {
    private int id;
    private String date;
    private double totalAmount;
    private int shareId;
    private int orderId;
}