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
    private int id;

    @Column(unique = true)
    private String date;

    private double totalAmount;

    @Transient
    private Share share;

    @Transient
    private Order order;

    @Override
    public String toString()
    {
        return "Report{" +
                        "id=" + id +
                        ", date='" + date + '\'' +
                        ", totalAmount=" + totalAmount +
                        ", share=" + share +
                        ", order=" + order +
                        '}';
    }
}