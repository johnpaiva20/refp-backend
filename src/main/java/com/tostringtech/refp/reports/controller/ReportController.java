package com.tostringtech.refp.reports.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tostringtech.refp.reports.service.ReportService;

import io.swagger.annotations.Api;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

@RestController
@Api(tags = "Reports")
public class ReportController {
	
	@Autowired
	private ReportService reportService;
	
	@GetMapping(value = "/report", produces = "application/pdf")
	public @ResponseBody ResponseEntity<Resource> generateExpenseReport(
		Pageable pageable, Long projetoId
	) throws JRException, IOException {
		Optional<byte[]> report = reportService.generateExpenseReport(projetoId);
		
		return !report.isPresent() ? null
				: ResponseEntity
					.ok()
					.header("Content-Type", "application/pdf")
					.header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Expose-Headers", "X-My-Custom-Header, X-Another-Custom-Header, headerValues")
					.header("Content-Disposition", "attachment; filename=Despesas.pdf")
					.body(new ByteArrayResource(report.get()));
	}
	
	@GetMapping(value = "/totalization", produces = "application/pdf")
	public @ResponseBody ResponseEntity<Resource> generateExpenseTotalizationReport(
		Pageable pageable, Long projetoId
	) throws JRException, IOException {
		Optional<byte[]> report = reportService.generateExpenseTotalizationReport(projetoId);
		
		return !report.isPresent() ? null
				: ResponseEntity
					.ok()
					.header("Content-Type", "application/pdf")
					.header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Expose-Headers", "X-My-Custom-Header, X-Another-Custom-Header, headerValues")
					.header("Content-Disposition", "attachment; filename=TotalizaçãoDespesas.pdf")
					.body(new ByteArrayResource(report.get()));
	}
	
}
