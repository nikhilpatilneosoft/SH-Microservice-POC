package com.example.Report.Controllers.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateReportRequestDTO {
    private int id;
    private String date;
    private double totalAmount;
    private int shareId;
    private int orderId;
}
