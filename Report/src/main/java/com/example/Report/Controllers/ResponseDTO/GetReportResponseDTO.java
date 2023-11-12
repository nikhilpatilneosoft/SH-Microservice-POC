package com.example.Report.Controllers.ResponseDTO;

import com.example.Report.Models.Order;
import com.example.Report.Models.Share;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetReportResponseDTO {
    private int id;
    private String date;
    private double totalAmount;
    private Share share;
    private Order order;
}
