package com.strell.web.controllers;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/game")
public class GameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/Game.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Integer respuesta = Integer.parseInt(request.getParameter("number"));
		String output = null;
		
		Random rand = new Random();
		
		if(session.getAttribute("num") == null) {
			session.setAttribute("num", rand.nextInt(100)+1);
		}
		Integer numero = (Integer) session.getAttribute("num");
		System.out.println("Respuesta: "+respuesta);
		System.out.println("Random: "+numero);
		
		if (respuesta.equals(numero)) {
			output = "<div class='container bg-success w-50 text-center p-4 border rounded'><p class='text-light display-4'>Correcto, era el numero " + numero + "</p><a href='/GreatNumber/home'><button class='btn btn-outline-danger btn-lg'>Volver a Jugar</button></a></div>";
			session.setAttribute("num", rand.nextInt(100)+1);
		} else if (respuesta < numero) {
			output = "<div class='container bg-danger w-50 text-center p-4 border rounded'><p class='text-light display-4'>¡Muy Bajo!</p></div><hr>" + 
					"<form action='/GreatNumber/game' method='POST'>" + 
					"<div class='text-center'><input type='text' name='number'></div>" + 
					"<hr>" + 
					"<div class='text-center'><button class='btn btn-outline-danger btn-lg'>Adivinar</button></div>" + 
					"</form>";
		} else if (respuesta > numero) {
			output = "<div class='container bg-danger w-50 text-center p-4 border rounded'><p class='text-light display-4'>¡Muy Alto!</p></div><hr>" + 
					"<form action='/GreatNumber/game' method='POST'>" + 
					"<div class='text-center'><input type='text' name='number'></div>" + 
					"<hr>" + 
					"<div class='text-center'><button class='btn btn-outline-danger btn-lg'>Adivinar</button></div>" + 
					"</form>";
		} else {
			output = "<form action='/GreatNumber/game' method='POST'>" + 
					"<div class='text-center'><input type='text' name='number'></div>" + 
					"<hr>" + 
					"<div class='text-center'><button class='btn btn-outline-danger btn-lg'>Adivinar</button></div>" + 
					"</form>";
		}
		System.out.println("Salida: "+output);
		session.setAttribute("salida", output);
	    doGet(request, response);
	}

}
