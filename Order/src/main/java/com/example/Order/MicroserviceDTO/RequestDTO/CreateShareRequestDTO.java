package com.example.Market.Controllers.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateShareRequestDTO {
    private String name;
    private double price;
    private int totalNumberOfShares;
    private int numberOfSharesLeft;
}
