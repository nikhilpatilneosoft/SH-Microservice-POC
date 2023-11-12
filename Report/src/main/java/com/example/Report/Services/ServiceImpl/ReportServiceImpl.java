package com.example.Report.Services.ServiceImpl;

import com.example.Report.Models.Report;
import com.example.Report.Repositories.ReportRepository;
import com.example.Report.Services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService
{
    @Autowired
    private ReportRepository reportRepository;

    @Override
    public List<Report> getAllReports()
    {
        return reportRepository.findAll();
    }

    @Override
    public Report getReportById(Integer id)
    {
        return reportRepository.findById(id).orElse(null);
    }

    @Override
    public Report createReport(Report report)
    {
        return reportRepository.save(report);
    }

    @Override
    public Report updateReport(Report report)
    {
        return reportRepository.save(report);
    }

    @Override
    public void deleteReportById(Integer id)
    {
        reportRepository.deleteById(id);
    }
}
