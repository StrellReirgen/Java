package com.strell.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = "Desconocido";
		String lastName = "Desconocido";
		String favorite = "Desconocido";
		String town = "Desconocido";
		if (request.getParameter("firstname") != null) {
			firstName = request.getParameter("firstname");
		}
		if (request.getParameter("lastname") != null) {
			lastName = request.getParameter("lastname");
		}
		if (request.getParameter("favorite") != null) {
			favorite = request.getParameter("favorite");
		}
		if (request.getParameter("town") != null) {
			town = request.getParameter("town");
		}
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.write("<h1>Bienvenido, " + firstName + " " + lastName +"</h1>");
        out.write("<h2>Tu lenguaje Favorito: " + favorite + "</h2>");
        out.write("<h2>Tu pueblo Natal: " + town + "</h2>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
