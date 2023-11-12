package com.example.Report.Services;

import com.example.Report.Models.Report;

import java.util.List;

public interface ReportService {

    List<Report> getAllReports();

    Report getReportById(Integer id);

    Report createReport(Report report);

    Report updateReport(Report report);

    void deleteReportById(Integer id);
}
