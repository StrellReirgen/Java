package com.strell.web.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.strell.web.models.Team;

@WebServlet("/delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<Team> equipos = (ArrayList<Team>) session.getAttribute("equipos");
		int id = Integer.parseInt(request.getParameter("id"));
		if (request.getParameter("tipo").equals("team")) {
			equipos.remove(id);
			session.setAttribute("equipos", equipos);
			response.sendRedirect("/Roster/home");
		}
		else if (request.getParameter("tipo").equals("player")) {
			int team = Integer.parseInt(request.getParameter("team"));
			equipos.get(team).getPlayers().remove(id);
			session.setAttribute("equipos", equipos);
			response.sendRedirect("/Roster/teams?id="+team);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
