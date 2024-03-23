package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modele.Calendrier;
import modele.Lecon;
import modele.Niveaux;
import modele.User;

import java.io.IOException;

import dao.CalendrierDao;
import dao.CoursDao;
import dao.NiveauDao;

/**
 * Servlet implementation class Cours
 */
public class Cours extends HttpServlet {
	private static final long serialVersionUID = 1L;

	NiveauDao niveauDao = new NiveauDao();
	CalendrierDao calDao=new CalendrierDao();
	CoursDao coursDao=new CoursDao();

	public Cours() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		request.setAttribute("listesNiveaux", niveauDao.listesNiveaux());
		request.setAttribute("listeCours", coursDao.listeCours());
		request.setAttribute("listeCalendars", calDao.calendar());
		
		
		String vue = "index.jsp";
		String action=request.getParameter("action");
		String id_cours=request.getParameter("id_cours");
		
		switch(action) {
		case"listeCours"-> vue="listeCours.jsp";
		case"ajouterCours"->vue="cours.jsp";
		case"planifier"->vue="planifier.jsp";
		case"supprimer"->{
			if(id_cours!=null) {
				int id=Integer.parseInt(id_cours);
				coursDao.supprimer(id);
				response.sendRedirect("Cours?action=listeCours");
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
		String titre = request.getParameter("titre");
		int intNiv = Integer.parseInt(request.getParameter("niveau"));
		String action = request.getParameter("add");
		
		
		
		System.out.println(intNiv);

		CoursDao coursDao = new CoursDao();
		NiveauDao niveauDao = new NiveauDao();
		

		HttpSession sessionCours = request.getSession();

		User user = (User) sessionCours.getAttribute("user");
		Niveaux niveau = niveauDao.getNiveau(intNiv);
		
		

		Lecon lecon = new Lecon(0, titre, user, niveau);

		if (action != null) {
			
			switch (action) {
			case "ajouter cours" -> {
				coursDao.insert(lecon);
				response.sendRedirect("Cours?action=listeCours");
				return;
			}
			
			}

		}

	}

}
