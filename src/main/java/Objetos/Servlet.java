package Objetos;

import java.io.IOException;
import java.sql.Connection;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	      Connection conn;
	        String vret = null;
	        Titles title;

			try {
				// Inicializa Conexion
				conn = DBconnection.initializeDatabase();
				
				// Utiliza el select del Crud
				switch(request.getParameter("operation")) {
				case "select":
					title = DTOTitles.select(conn,new Titles(request.getParameter("title_no")));
					vret = title.getTitle_no() + ";" + title.getTitle();
					break;
				case "insert":
					if(DTOTitles.insert(conn,new Titles(request.getParameter("title_no"),request.getParameter("title")
							))) {
						vret = "Exito";
					};
					break;
				case "update":
					if(DTOTitles.update(conn,new Titles(request.getParameter("title_no"),request.getParameter("title")))) {
						vret = "Exito";
					};
					break;
				case "delete":
					if(DTOTitles.delete(conn,new Titles(request.getParameter("title_no")))) {
						vret = "Exito";
					};
					break;					
			};
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			vret = e.toString();
		}
		
		response.getWriter().append(vret);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
