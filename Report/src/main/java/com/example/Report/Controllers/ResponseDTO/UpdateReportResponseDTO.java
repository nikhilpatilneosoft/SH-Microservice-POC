package com.example.Report.Controllers.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateReportResponseDTO {
    private int id;
    private String date;
    private double totalAmount;
    private int shareId;
    private int orderId;
}
