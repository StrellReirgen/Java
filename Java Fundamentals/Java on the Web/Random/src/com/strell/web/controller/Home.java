package com.strell.web.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Random rand = new Random();
		String contador = (String) session.getAttribute("count");
		Integer numero;
		
		String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		String palabra = "";
		for(int i=1; i<=10; i++) {
			palabra += caracteres.charAt(rand.nextInt(caracteres.length()));
		}
		session.setAttribute("palabra", palabra);
		Date today = new Date();
		session.setAttribute("fecha", today);
		
		if (contador == null) {
        	session.setAttribute("count", "0");
        } else {
        	numero = Integer.parseInt(contador);
        	numero ++;
        	contador = numero.toString();
        	session.setAttribute("count", contador);
        }
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/Random.jsp");
        view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
