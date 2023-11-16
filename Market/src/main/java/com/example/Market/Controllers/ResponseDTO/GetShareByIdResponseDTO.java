package com.example.Market.Controllers.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetShareByIdResponseDTO {
    private int id;
    private String name;
    private double price;
    private int totalNumberOfShares;
    private int numberOfSharesLeft;
}
