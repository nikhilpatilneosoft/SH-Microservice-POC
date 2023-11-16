package com.example.Report.Controllers;

import com.example.Report.Controllers.RequestDTO.CreateReportRequestDTO;
import com.example.Report.Controllers.RequestDTO.UpdateReportRequestDTO;
import com.example.Report.Controllers.ResponseDTO.CreateReportResponseDTO;
import com.example.Report.Controllers.ResponseDTO.GetReportResponseDTO;
import com.example.Report.Controllers.ResponseDTO.UpdateReportResponseDTO;
import com.example.Report.Models.Report;
import com.example.Report.Services.ReportService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<GetReportResponseDTO>> getAllReports() {
        List<Report> reports = reportService.getAllReports();
        List<GetReportResponseDTO> getReportResponseDTOS = reports.stream().map(report -> modelMapper.map(report, GetReportResponseDTO.class)).collect(Collectors.toList());
        return ResponseEntity.ok(getReportResponseDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetReportResponseDTO> getReportById(@PathVariable int id) {
        GetReportResponseDTO getReportResponseDTO = modelMapper.map(reportService.getReportById(id), GetReportResponseDTO.class);
        return ResponseEntity.ok(getReportResponseDTO);
    }

    @PostMapping("/")
    public ResponseEntity<CreateReportResponseDTO> createReport(@RequestBody CreateReportRequestDTO createReportRequestDTO) {
        Report report = modelMapper.map(createReportRequestDTO, Report.class);
        Report savedReport = reportService.createReport(report);
        CreateReportResponseDTO createReportResponseDTO = modelMapper.map(savedReport, CreateReportResponseDTO.class);
        return ResponseEntity.ok(createReportResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateReportResponseDTO> updateReport(@PathVariable int id, @RequestBody UpdateReportRequestDTO updateReportRequestDTO) {
        Report existingReport = reportService.getReportById(id);

        if(existingReport == null)
            return ResponseEntity.notFound().build();

        Report report = modelMapper.map(existingReport, Report.class);

        UpdateReportResponseDTO updateReportResponseDTO = modelMapper.map(reportService.updateReport(report), UpdateReportResponseDTO.class);
        return ResponseEntity.ok(updateReportResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReportById(@PathVariable int id) {
        reportService.deleteReportById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/report_test")
    public String reportTest() {
        System.out.println("report_test");
        return null;
    }
}
