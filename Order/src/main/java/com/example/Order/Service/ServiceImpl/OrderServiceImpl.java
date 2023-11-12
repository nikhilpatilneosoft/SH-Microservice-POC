package com.example.Order.Service.ServiceImpl;

import com.example.Market.Controllers.RequestDTO.UpdateShareByOrderRequestDTO;
import com.example.Market.Controllers.RequestDTO.UpdateShareRequestDTO;
import com.example.Market.Controllers.ResponseDTO.UpdateShareByOrderResponseDTO;
import com.example.Order.Config.FeignRequestDTO.CreateReportRequestDTO;
import com.example.Order.Config.FeignResponseDTO.CreateReportResponseDTO;
import com.example.Order.Config.OrderFeignClient;
import com.example.Order.Controller.RequestDTOs.CreateMarketOrderRequestDTO;
import com.example.Order.Models.MarketOrder;
import com.example.Order.Models.Report;
import com.example.Order.Models.Share;
import com.example.Order.Repositories.OrderRepository;
import com.example.Order.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderFeignClient orderFeignClient;
    private final ModelMapper modelMapper;
    private final RestTemplate restTemplate;

    public List<MarketOrder> getAllOrders() {
        return orderRepository.findAll();
    }

    public MarketOrder getOrderById(int id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public MarketOrder createOrder(MarketOrder marketOrder, String shareName) {
        MarketOrder savedMarketOrder = orderRepository.save(marketOrder);
        UpdateShareByOrderRequestDTO updateShareByOrderRequestDTO = UpdateShareByOrderRequestDTO.builder()
                .name(shareName)
                .quantity(marketOrder.getQuantity())
                .type(marketOrder.getType())
                .build();

        HttpEntity<UpdateShareByOrderRequestDTO> requestEntity = new HttpEntity<>(updateShareByOrderRequestDTO);

        ResponseEntity<UpdateShareByOrderResponseDTO> response = restTemplate.exchange(
                "http://localhost:8182/shares",
                HttpMethod.PUT,
                requestEntity,
                UpdateShareByOrderResponseDTO.class
        );

//        ResponseEntity<UpdateShareByOrderResponseDTO> response = orderFeignClient.updateShareByOrder(updateShareByOrderRequestDTO);

        UpdateShareByOrderResponseDTO updateShareByOrderResponseDTO = response.getBody();

        // Map the response to a Share object
        Share share = modelMapper.map(updateShareByOrderResponseDTO, Share.class);

        // Set the share in the saved market order
        savedMarketOrder.setShare(share);






        CreateReportRequestDTO createReportRequestDTO = CreateReportRequestDTO.builder()
                .date(savedMarketOrder.getDate())
                .shareName(share.getName())
                .orderId(savedMarketOrder.getId())
                .totalAmount(share.getPrice() * savedMarketOrder.getQuantity())
                .build();

        // Make the HTTP request to create the report
        HttpEntity<CreateReportRequestDTO> reportRequestEntity = new HttpEntity<>(createReportRequestDTO);
        ResponseEntity<CreateReportResponseDTO> reportResponseEntity = restTemplate.postForEntity(
                "http://localhost:8182/reports/",
                reportRequestEntity,
                CreateReportResponseDTO.class
        );
//
//        // Map the response to a Report object
        CreateReportResponseDTO createReportResponseDTO = reportResponseEntity.getBody();
        Report report = modelMapper.map(createReportResponseDTO, Report.class);
//
//        // Set the report in the saved market order
        savedMarketOrder.setReport(report);

        return savedMarketOrder;
    }

    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }
}
