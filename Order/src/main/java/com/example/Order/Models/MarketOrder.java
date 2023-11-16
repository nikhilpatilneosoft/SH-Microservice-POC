package com.example.Order.Models;

import jdk.javadoc.doclet.Reporter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MarketOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int quantity;

    @Transient
    private Share share;

    @Transient
    private Report report;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private String type;
}

