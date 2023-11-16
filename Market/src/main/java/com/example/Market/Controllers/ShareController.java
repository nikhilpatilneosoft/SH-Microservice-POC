package com.example.Market.Controllers;

import com.example.Market.Controllers.RequestDTO.CreateShareRequestDTO;
import com.example.Market.Controllers.RequestDTO.UpdateShareByOrderRequestDTO;
import com.example.Market.Controllers.RequestDTO.UpdateShareRequestDTO;
import com.example.Market.Controllers.ResponseDTO.*;
import com.example.Market.Models.Share;
import com.example.Market.Services.ShareService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/shares")
public class ShareController {

    @Autowired
    private ShareService shareService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<GetShareResponseDTO>> getAllShares() {
        List<Share> shares = shareService.getAllShares();
        List<GetShareResponseDTO> responseDTOs = shares.stream().map(share -> modelMapper.map(share, GetShareResponseDTO.class)).collect(Collectors.toList());
        return ResponseEntity.ok(responseDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetShareByIdResponseDTO> getShareById(@PathVariable int id) {
        Share share = shareService.getShareById(id);

        if (share == null) {
            return ResponseEntity.notFound().build();
        }

        GetShareByIdResponseDTO responseDTO = GetShareByIdResponseDTO.builder()
                .id(share.getId())
                .name(share.getName())
                .price(share.getPrice())
                .totalNumberOfShares(share.getTotalNumberOfShares())
                .numberOfSharesLeft(share.getNumberOfSharesLeft())
                .build();

        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping
    public ResponseEntity<CreateShareResponseDTO> createShare(@RequestBody CreateShareRequestDTO createShareRequestDTO) {
        Share share = modelMapper.map(createShareRequestDTO, Share.class);
        return ResponseEntity.ok(modelMapper.map(shareService.createShare(share), CreateShareResponseDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateShareResponseDTO> updateShare(@PathVariable int id, @RequestBody UpdateShareRequestDTO updateShareRequestDTO) {
        Share existingShare = shareService.getShareById(id);
        if (existingShare == null)
            throw new NotFoundException("Share with ID " + id + " does not exist");

        Share updatedShare = modelMapper.map(existingShare, Share.class);

//        existingShare.setName(updateShareRequestDTO.getName());
//        existingShare.setPrice(updateShareRequestDTO.getPrice());
//        existingShare.setTotalNumberOfShares(updateShareRequestDTO.getTotalNumberOfShares());
//        existingShare.setNumberOfSharesLeft(updateShareRequestDTO.getNumberOfSharesLeft());

        return ResponseEntity.ok(modelMapper.map(shareService.updateShare(updatedShare), UpdateShareResponseDTO.class));
    }

    @PutMapping()
    public ResponseEntity<UpdateShareByOrderResponseDTO> updateShareByOrder(@RequestBody UpdateShareByOrderRequestDTO updateShareByOrderRequestDTO) {
        Share updatedShare = shareService.updateAfterPlacingOrder(updateShareByOrderRequestDTO.getName(), updateShareByOrderRequestDTO.getQuantity(), updateShareByOrderRequestDTO.getType());

        UpdateShareByOrderResponseDTO updateShareByOrderResponseDTO = modelMapper.map(updatedShare, UpdateShareByOrderResponseDTO.class);
        updateShareByOrderResponseDTO.setStatus("success");
        return ResponseEntity.ok().body(updateShareByOrderResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteShare(@PathVariable int id) {
        shareService.deleteShare(id);
        return ResponseEntity.ok("Share with ID " + id + " deleted");
    }

    @PostMapping("/test")
    public String test() {
        System.out.println("test");
        return null;
    }
}
