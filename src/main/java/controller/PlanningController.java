package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modele.Calendrier;
import modele.Lecon;
import modele.Planning;

import java.io.IOException;

import dao.CalendrierDao;
import dao.CoursDao;
import dao.PlanningDao;

/**
 * Servlet implementation class PlanningController
 */
public class PlanningController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CalendrierDao calDao=new CalendrierDao();
	CoursDao coursDao=new CoursDao();
	PlanningDao planDao=new PlanningDao();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlanningController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("listeCours", coursDao.listeCours());
		request.setAttribute("listeCalendars", calDao.calendar());
		request.setAttribute("listePlanings",planDao.listePlaning());
		
			
		String vue="index.jsp";
		
		String id_lecon=request.getParameter("id_lecon");
		String id_cal=request.getParameter("id_calendar");
		
		String idS=request.getParameter("id");
		
		if(idS!=null) {
			
			int id=Integer.parseInt(idS);
			request.setAttribute("id", id);
		}
		
		
		String action=request.getParameter("action");
		switch(action) {
		case"planifier"->vue="planifier.jsp";
		case"coursPlanifier"->vue="coursPlanifier.jsp";
		case"monCalendrier"->vue="monCalendrier.jsp";
		case"supprimer"->{
			if(id_lecon!=null && id_cal!=null) {
				int idL=Integer.parseInt(id_lecon);
				int idC=Integer.parseInt(id_cal);
				planDao.supprimer(idL,idC);
				response.sendRedirect("PlanningController?action=coursPlanifier");
				return;
				
			}
		}
		}
		request.getRequestDispatcher(vue).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("add");
		
		int titre=Integer.parseInt(request.getParameter("cours"));
		int cal=Integer.parseInt(request.getParameter("calendrier"));
		
		PlanningDao planDao=new PlanningDao();
		CalendrierDao calDao=new CalendrierDao();
		CoursDao coursDao=new CoursDao();
		
		Calendrier calendrier=calDao.getCalendrier(cal); 
		Lecon cours=coursDao.getLecon(titre);
		
		
		
		Planning plan=new Planning(calendrier, cours);
		
		
		
		if(action!=null) {
			switch(action) {
			case"planifier cours"->{
				planDao.insert(plan);
				response.sendRedirect("PlanningController?action=coursPlanifier");
				return;
				
			}
			}
		}
	}

}
