package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modele.Calendrier;
import modele.Niveaux;
import modele.User;

import java.io.IOException;

import dao.CalendrierDao;
import dao.NiveauDao;
import dao.UserDao;

public class NiveauxController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CalendrierDao calendrierDao = new CalendrierDao();
	NiveauDao niveauDao=new NiveauDao();
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NiveauxController() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String vue = "niveaux.jsp";
		String action=request.getParameter("action");
		String id_niveaux=request.getParameter("id_niveaux");
		
		
		request.setAttribute("listeNiveaux", niveauDao.listesNiveaux());
		request.setAttribute("calendriers", calendrierDao.calendar());
		
		switch(action) {
		case"ajouterNiveau"->vue="niveaux.jsp";
		case"listeNiveau"->vue="listeNiveau.jsp";
		
		case"supprimer"->{
			
			if(id_niveaux!=null) {
				int id=Integer.parseInt(id_niveaux);
				niveauDao.supprimer(id);
				response.sendRedirect("NiveauxController?action=listeNiveau");
				return;
			}
		}
		}
		
		request.getRequestDispatcher(vue).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("add");

		String libelle = request.getParameter("libelle");
		int calendrier = Integer.parseInt(request.getParameter("niveau"));

		System.out.println(calendrier);

		CalendrierDao calDao = new CalendrierDao();
		NiveauDao niveauDao = new NiveauDao();

		HttpSession sessionNiveau = request.getSession();
		
		if (calendrier != 0) {

			Calendrier cal = calDao.getCalendrier(calendrier);
			

			Niveaux niveaux = new Niveaux(0, libelle, cal);

			switch (action) {
			case "Ajouter niveux" -> {
				niveauDao.insert(niveaux);
				response.sendRedirect("Home");
				return;
				
			}

			}
		}
	}

}
