package com.example.Market.Controllers.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateShareByOrderRequestDTO {
    private String name;
    private int quantity;
    private String type;
}
