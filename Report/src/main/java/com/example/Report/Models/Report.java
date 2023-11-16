package com.example.Report.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Report
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reportId;

    private String date;

    private double totalAmount;

    private String shareName;

//    @Transient
//    private Share share;
//
//    @Transient
//    private Order order;
}