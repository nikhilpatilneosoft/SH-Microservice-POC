package com.example.Report.Models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Share {

    private int id;
    private String name;
    private double price;
    private int totalNumberOfShares;
}
