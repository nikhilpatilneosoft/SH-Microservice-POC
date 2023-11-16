package com.example.Order.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.beans.Transient;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Share {

    private int id;
    private String name;
    private double price;
    private int totalNumberOfShares;
//    private int numberOfSharesLeft;

//    public Share(String name, double price, int totalNumberOfShares) {
//        this.name = name;
//        this.price = price;
//        this.totalNumberOfShares = totalNumberOfShares;
//    }
}
