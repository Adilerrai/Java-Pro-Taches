package com.example.invoice.service;

import com.example.invoice.model.EnteteFact;
import com.example.invoice.repository.EnteteRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReportService {
    private final EnteteRepository enteteRepository;

    public ReportService(EnteteRepository enteteRepository) {
        this.enteteRepository = enteteRepository;
    }

    public String generateReport(Long id) {
        try {
            // Fetch data
            List<EnteteFact> enteteList = new ArrayList<>();

            EnteteFact entete = enteteRepository.findById(id).get();
            enteteList.add(entete);

            String outputDirectory = "src/main/resources/reports/";
            String outputFileName = "Invoice.pdf";

            // Compile main report
            String mainReportPath = "src/main/resources/reports/Invoice.jrxml";
            JasperReport mainJasperReport = JasperCompileManager.compileReport(mainReportPath);

            // Compile subreport
            String subReportPath = "src/main/resources/reports/detFacturesSubReport.jrxml";
            String compiledSubReportPath = "src/main/resources/reports/detFacturesSubReport.jasper";
            JasperCompileManager.compileReportToFile(subReportPath, compiledSubReportPath);

            System.out.println("entete: " + entete);

            JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(enteteList);
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("createdBy", "test");

            // Add compiled subreport to parameters
            parameters.put("DetFacturesSubreport", compiledSubReportPath);

            JasperPrint jasperPrint = JasperFillManager.fillReport(mainJasperReport, parameters, jrBeanCollectionDataSource);

            JasperExportManager.exportReportToPdfFile(jasperPrint, outputDirectory + outputFileName);
            return "Report successfully generated";
        } catch (JRException e) {
            e.printStackTrace();
            return "Error occurred while generating report";
        }
    }
}
