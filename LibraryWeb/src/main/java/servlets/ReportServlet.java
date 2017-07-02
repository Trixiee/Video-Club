package servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import managers.ClanManager;
import model.Clan;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
/**
 * Servlet implementation class ReportServlet
 */
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReportServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/pdf");
		ServletOutputStream out = response.getOutputStream();
		JRDataSource dataSource = null; 
		JREmptyDataSource emptyDataSource = new JREmptyDataSource();
		JasperPrint jasperPrint = null;
		JasperReport reporte = null;
		HashMap<String,Object> params = new HashMap();
		try {
			reporte = (JasperReport) JRLoader.loadObjectFromFile("D:\\Video Club\\VideoClub\\LibraryWeb\\src\\main\\resources\\jasper\\clanovi.jasper");
			
			List<Clan> data =new ClanManager().getSviClanovi(); 
			
			if (data.isEmpty()) {
				jasperPrint = JasperFillManager.fillReport(reporte, null, emptyDataSource);
			} else {
				dataSource = new JRBeanCollectionDataSource(data);
				jasperPrint = JasperFillManager.fillReport(reporte, params, dataSource);

				JRExporter exporter = new JRPdfExporter();
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
				exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
				exporter.exportReport();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
