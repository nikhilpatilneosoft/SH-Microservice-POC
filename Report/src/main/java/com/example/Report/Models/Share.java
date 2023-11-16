package com.example.Report.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Share {

    private int id;
    private String name;
    private double price;
    private int totalNumberOfShares;
}
