package com.strell.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/home")
public class ClickerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        String contador = (String) session.getAttribute("count");
        Integer numero;
        
        if (contador == null) {
        	session.setAttribute("count", "0");
        } else {
        	numero = Integer.parseInt(contador);
        	numero ++;
        	contador = numero.toString();
        	session.setAttribute("count", contador);
        }
        
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/Clicker.jsp");
        view.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
