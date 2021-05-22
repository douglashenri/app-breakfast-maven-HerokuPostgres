package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.DAO;
import model.JavaBeans;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete", "/report" })
public class Controller extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The dao. */
	DAO dao = new DAO();
	
	/** The coffeelist. */
	JavaBeans coffeelist = new JavaBeans();

	/**
	 * Instantiates a new controller.
	 */
	public Controller() {
		super();
	}

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			list(request, response);
		} else if (action.equals("/insert")) {
			addList(request, response);
		} else if (action.equals("/select")) {
			listCoffee(request, response);
		} else if (action.equals("/update")) {
			editList(request, response);
		} else if (action.equals("/delete")) {
			removeList(request, response);
		} else if (action.equals("/report")) {
			generateReport(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	/**
	 * List.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<JavaBeans> list = dao.toListCoffeelist();
		request.setAttribute("coffeelist", list);
		RequestDispatcher rd = request.getRequestDispatcher("breakfast.jsp");
		rd.forward(request, response);
	}

	/**
	 * Adds the list.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void addList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		coffeelist.setPersonsName(request.getParameter("personsName"));
		coffeelist.setCpf(request.getParameter("cpf"));
		coffeelist.setFood(request.getParameter("food"));
		dao.toInsertCoffeelist(coffeelist);
		response.sendRedirect("main");
	}

	/**
	 * List coffee.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void listCoffee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		coffeelist.setIdlist(Integer.parseInt(request.getParameter("idlist")));
		dao.toSelectList(coffeelist);
		request.setAttribute("idlist", coffeelist.getIdlist());
		request.setAttribute("personsName", coffeelist.getPersonsName());
		request.setAttribute("cpf", coffeelist.getCpf());
		request.setAttribute("food", coffeelist.getFood());
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);

	}

	/**
	 * Edits the list.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void editList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		coffeelist.setIdlist(Integer.parseInt(request.getParameter("idlist")));
		coffeelist.setPersonsName(request.getParameter("personsName"));
		coffeelist.setCpf(request.getParameter("cpf"));
		coffeelist.setFood(request.getParameter("food"));
		dao.changeList(coffeelist);
		response.sendRedirect("main");
	}

	/**
	 * Removes the list.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void removeList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		coffeelist.setIdlist(Integer.parseInt(request.getParameter("idlist")));
		dao.deleteList(coffeelist);
		response.sendRedirect("main");
	}

	/**
	 * Generate report.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void generateReport(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Document documento = new Document();
		try {
			response.setContentType("apllication/pdf");
			response.addHeader("Content-Disposition", "inline; filename=" + "breakfast.pdf");
			PdfWriter.getInstance(documento, response.getOutputStream());
			documento.open();
			documento.add(new Paragraph("Lista Café da Manhã"));
			documento.add(new Paragraph(" "));
			PdfPTable tabela = new PdfPTable(3);
			PdfPCell col1 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell col2 = new PdfPCell(new Paragraph("CPF"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Contribuição"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			ArrayList<JavaBeans> list = dao.toListCoffeelist();
			for (int i = 0; i < list.size(); i++) {
				tabela.addCell(list.get(i).getPersonsName());
				tabela.addCell(list.get(i).getCpf());
				tabela.addCell(list.get(i).getFood());
			}
			documento.add(tabela);
			documento.close();
		} catch (Exception e) {
			System.out.println(e);
			documento.close();
		}

	}
}
