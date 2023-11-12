package com.example.Report.Controllers.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateReportRequestDTO {
    private Date date;
    private double totalAmount;
    private String shareName;
    private int orderId;
}
