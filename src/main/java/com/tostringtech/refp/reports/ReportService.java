package com.tostringtech.refp.reports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.data.domain.Pageable;

import com.tostringtech.refp.application.models.Despesa;
import com.tostringtech.refp.expense.api.repository.ExpenseRepository;
import com.tostringtech.refp.expense.api.service.ExpenseService;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    private ExpenseService service;
    
    @Autowired
    private ExpenseRepository repo;
	
	public String exportReport(String reportFormat, Pageable pageable) throws FileNotFoundException, JRException {
		List<Despesa> desp = service.findAll(pageable);
		File file = ResourceUtils.getFile("C:\\Users\\alber\\Documents\\TCC\\refp-backend\\src\\main\\resources\\expenses.jrxml");
		JasperReport jasper = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(desp);
		Map<String, Object> map = new HashMap<>();
		map.put("createBy", "Refp");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasper, map, dataSource);
		if(reportFormat.equalsIgnoreCase("html")) {
			JasperExportManager.exportReportToHtmlFile(jasperPrint, "C:\\Users\\alber\\Downloads" + "\\expenses.html");
		}
		if(reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\alber\\Downloads" + "\\expenses.pdf");
		}
		return "Criado!";
	}

}
