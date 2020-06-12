package com.tostringtech.refp.reports.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.tostringtech.refp.application.domain.CategoriaContabil;
import com.tostringtech.refp.application.models.Despesa;
import com.tostringtech.refp.application.models.Projeto;
import com.tostringtech.refp.application.models.reports.TotalizacaoDespesas;
import com.tostringtech.refp.expense.api.service.ExpenseService;
import com.tostringtech.refp.project.api.service.ProjectService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportService {
	@Autowired
	private ExpenseService service;
	
	@Autowired
	private ProjectService projService;
	
	public Optional<byte[]> generateExpenseReport(Long projetoId)
		throws JRException, FileNotFoundException {
		Optional<Projeto> proj = projService.findById(projetoId);
		if (!proj.isPresent()) {
			return Optional.empty();
		}
		Projeto projeto = proj.get();
		List<Despesa> desp = service.findAllByProject(projeto);
		
		List<Despesa> despesas = new ArrayList<Despesa>();
		Arrays.asList(CategoriaContabil.values())
			.forEach(categoria -> {
				despesas.addAll(
					getExpenseByType(desp, categoria)
				);
			});
		
		return Optional.of(
			generateReportExpense(
				"reportsTemplates/expenses.jasper",
				getIdentificacaoRelatorio(projeto),
				despesas
			)
		);
	}
	
	public Optional<byte[]> generateExpenseTotalizationReport(Long projetoId)
		throws JRException {
		Optional<Projeto> proj = projService.findById(projetoId);
		if (!proj.isPresent()) {
			return Optional.empty();
		}
		Projeto projeto = proj.get();
		List<Despesa> despesas = service.findAllByProject(projeto);
		Map<Long, List<Despesa>> depesasPorAno = despesas
			.stream()
			.collect(
				Collectors
					.groupingBy(this::getExpesesYear)
			);
		List<TotalizacaoDespesas> totalizacaoDespesas = new ArrayList<TotalizacaoDespesas>();
		
		depesasPorAno.keySet()
			.stream()
			.sorted(Comparator.naturalOrder())
			.collect(Collectors.toList())
			.forEach(year -> {
				Arrays.asList(Month.values())
					.forEach(mes -> {
						List<Despesa> despesasDoMes = depesasPorAno.get(year)
							.stream()
							.filter(despesa -> isExpesesMonth(despesa, mes))
							.collect(Collectors.toList());
						totalizacaoDespesas.add(
							getTotalizacaoDespesas(year, getMonthName(mes), despesasDoMes)
						);
					});
			});
		
		return Optional.of(
			generateReport(
				"reportsTemplates/expenses_totalization.jasper",
				getIdentificacaoRelatorio(projeto),
				totalizacaoDespesas
			)
		);
	}
	
	private InputStream getResourceAsStream(String path) {
		return this.getClass()
			.getClassLoader()
			.getResourceAsStream(path);
	}
	
	private List<Despesa> getExpenseByType(List<Despesa> depesas, CategoriaContabil categoria) {
		return depesas
			.stream()
			.filter(
				despesa -> despesa.getTipoRubrica()
					.equalsIgnoreCase(categoria.getCod())
			)
			.collect(Collectors.toList());
	}
	
	private double getTotalDespesas(List<Despesa> despesas, CategoriaContabil categoria) {
		return despesas
			.stream()
			.filter(
				despesa -> despesa.getTipoRubrica()
					.equalsIgnoreCase(categoria.getCod())
			)
			.mapToDouble(Despesa::getValor)
			.sum();
	}
	
	private Map<String, Object> getIdentificacaoRelatorio(Projeto projeto) {
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("logoAneel", getResourceAsStream("aneel.png"));
		params.put("logoIati", getResourceAsStream("IATI.png"));
		params.put("logoAneelCopy", getResourceAsStream("aneel.png"));
		params.put("logoIatiCopy", getResourceAsStream("IATI.png"));
		params.put("codigoProjeto", projeto.getCodigoAneel());
		params.put("nomeProjeto", projeto.getTitulo());
		return params;
	}
	
	private Long getExpesesYear(Despesa depesa) {
		LocalDate date = parseDateToLocalDate(depesa.getData());
		return Long.valueOf(date.getYear());
	}
	
	private boolean isExpesesMonth(Despesa depesa, Month mes) {
		LocalDate date = parseDateToLocalDate(depesa.getData());
		return date.getMonth().equals(mes);
	}
	
	private LocalDate parseDateToLocalDate(Date date) {
		LocalDate parseDate = date
			.toInstant()
			.atZone(ZoneId.of("America/Sao_Paulo"))
			.toLocalDate();
		return parseDate;
	}
	
	private String getMonthName(Month mes) {
		return mes.getDisplayName(TextStyle.FULL, new Locale("pt"));
	}
	
	private TotalizacaoDespesas getTotalizacaoDespesas(Long ano, String mes, List<Despesa> despesas) {
		TotalizacaoDespesas totalizacaoDespesas = new TotalizacaoDespesas();
		totalizacaoDespesas.setAno(ano);
		totalizacaoDespesas.setMes(mes);
		totalizacaoDespesas
			.setValorRubricaRh(
				getTotalDespesas(
					despesas,
					CategoriaContabil.RECURSOS_HUMANOS
				)
			);
		totalizacaoDespesas
			.setValorRubricaMc(
				getTotalDespesas(
					despesas,
					CategoriaContabil.MATERIAIS_CONSUMO
				)
			);
		totalizacaoDespesas
			.setValorRubricaMp(
				getTotalDespesas(
					despesas,
					CategoriaContabil.MATERIAIS_PERMANENTES_EQUIPAMENTOS
				)
			);
		totalizacaoDespesas
			.setValorRubricaSt(
				getTotalDespesas(
					despesas,
					CategoriaContabil.SERVICOS_TERCEIROS
				)
			);
		totalizacaoDespesas
			.setValorRubricaVd(
				getTotalDespesas(
					despesas,
					CategoriaContabil.VIAGENS_DIARIAS
				)
			);
		totalizacaoDespesas
			.setValorRubricaOu(
				getTotalDespesas(
					despesas,
					CategoriaContabil.OUTROS
				)
			);
		return totalizacaoDespesas;
	}
	
	private byte[] generateReport(
		String reportPath,
		Map<String, Object> params,
		List<?> listDetails
	) throws JRException {
		InputStream jasperStream = getResourceAsStream(reportPath);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(
			listDetails
		);
		JasperPrint jasperPrint = JasperFillManager.fillReport(
			jasperStream,
			params,
			ds
		);
		JasperExportManager.exportReportToPdfStream(jasperPrint, out);
		return out.toByteArray();
	}
	
	private byte[] generateReportExpense(
			String reportPath,
			Map<String, Object> params,
			List<?> listDetails
		) throws JRException, FileNotFoundException {
			InputStream jasperStream = getResourceAsStream(reportPath);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(
				listDetails
			);
			File file = ResourceUtils.getFile("classpath:reportsTemplates/expenses.jrxml");
			JasperReport jr = JasperCompileManager.compileReport(file.getAbsolutePath());
			JasperPrint jasperPrint = JasperFillManager.fillReport(
				jr,
				params,
				ds
			);
			JasperExportManager.exportReportToPdfStream(jasperPrint, out);
			return out.toByteArray();
		}
}