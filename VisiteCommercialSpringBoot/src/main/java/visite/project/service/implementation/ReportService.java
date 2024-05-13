package visite.project.service.implementation;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import visite.project.dto.VisiteDTO;
import visite.project.service.VisiteService;

import java.util.*;

@Service
public class ReportService {
    private final VisiteService visiteService;

    public ReportService(VisiteService visiteService) {
        this.visiteService = visiteService;
    }

    public String generateReport(Long id) {
        try {
            // Fetch data
            List<VisiteDTO> visiteList = new ArrayList<>();

            VisiteDTO visite = visiteService.findById(id);
            visiteList.add(visite);

            String outputDirectory = "src/main/resources/reports/";
            String outputFileName = "reports.pdf";

            String reportPath = "src/main/resources/reports/reportVisite.jrxml";
            JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);


            System.out.println("list: " + visite);

            JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(visiteList);
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("createdBy", "test");


            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrBeanCollectionDataSource);


            //JasperPrintManager.printReport(jasperPrint, false);
            JasperExportManager.exportReportToPdfFile(jasperPrint, outputDirectory + outputFileName);
            return "Report successfully generated";
        } catch (JRException e) {
            e.printStackTrace();
            return "Error occurred while generating report";
        }
    }
}
