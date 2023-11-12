package com.example.Order.Config;

import com.example.Market.Controllers.RequestDTO.UpdateShareByOrderRequestDTO;
import com.example.Market.Controllers.RequestDTO.UpdateShareRequestDTO;
import com.example.Market.Controllers.ResponseDTO.UpdateShareByOrderResponseDTO;
import com.example.Market.Controllers.ResponseDTO.UpdateShareResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "MARKET-SERVICE", path = "http://localhost:8182/shares")
public interface OrderFeignClient {

    @PutMapping("/{id}")
    public ResponseEntity<UpdateShareResponseDTO> updateShare(@PathVariable int id, @RequestBody UpdateShareRequestDTO updateShareRequestDTO);

    @PutMapping()
    public ResponseEntity<UpdateShareByOrderResponseDTO> updateShareByOrder(@RequestBody UpdateShareByOrderRequestDTO updateShareByOrderRequestDTO);

    @PostMapping("/test")
    public void test();
}
