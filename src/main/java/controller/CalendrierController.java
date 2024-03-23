package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modele.Calendrier;
import modele.User;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import dao.CalendrierDao;
import dao.UserDao;


public class CalendrierController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	CalendrierDao calDao = new CalendrierDao();
	
    public CalendrierController() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String vue="index.jsp";	
		String action=request.getParameter("action");		
		
		if(action!=null) {
			switch(action) {
			case"ajouterCalendrier"->vue="AjouterCalendrier.jsp";
			case"listeCalendrier" -> vue="listeCalendrier.jsp";		
			}
		}
		
		
		request.getRequestDispatcher(vue).forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date date= Date.valueOf(request.getParameter("dateCal"));
		String heure=request.getParameter("heure");	
		
		
		
		HttpSession httpSession=request.getSession();
		
		
		
		Calendrier calendrier=new Calendrier(0, date, heure);
		
		String action= request.getParameter("add");
		
		if(action!=null) {
			
			switch(action) {	
			case "ajouter calendrier"->{			
				calDao.insert(calendrier);		
				
			}	
			}
		}
		
		
		
		
	}

}
