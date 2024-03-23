package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modele.User;

import java.io.IOException;

import Forms.Form_Inscription;
import dao.NiveauDao;
import dao.UserDao;


public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserDao userDao =new UserDao();
	NiveauDao niveauDao=new NiveauDao();
	
	

	public UserController() {
		super();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		
		request.setAttribute("listesNiveaux", niveauDao.listesNiveaux());;
		request.setAttribute("listeUsers", userDao.listeUsers());
		
		
		
		String vue = "index.jsp";
		String action= request.getParameter("action");
		String id_user=request.getParameter("id_user") ;
		
		
		
		

		switch (action) {
		case "inscription" -> vue = "inscription.jsp";
		case "connexion" -> vue = "connexion.jsp";
		case "listeUsers" -> vue = "listeUsers.jsp";
		case "listeUser" -> vue = "listeUser.jsp";
		case "deconnexion" ->{
			session.invalidate() ;
			response.sendRedirect("Home");
			return;
			
			
		}
		case"ajouterUser"->{
			vue="ajouterUser.jsp";		
		}
		case"supprimer"->{
			
			if(id_user!=null) {
				int id=Integer.parseInt(id_user);
				userDao.supprimer(id);
				response.sendRedirect("UserController?action=listeUsers");
				return;
			}
			
		}
		case"modifier"->{	
			if(id_user!=null) {
				int id=Integer.parseInt(id_user);
				request.setAttribute("userModifier", userDao.getUser(id));
			}
			vue="modifierUser.jsp";
		}

		}
		
		request.getRequestDispatcher(vue).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("add");
		
		HttpSession session=request.getSession();
		

		Form_Inscription form_inscription = new Form_Inscription();

		switch (action) {
		case "inscription" -> {
			try {

				User user = form_inscription.editer(request);
				
				
				if(user!=null) {				
					userDao.insert(user);
					response.sendRedirect("UserController?action=connexion");
					return;
				}
				
			} catch (Exception e) {
				System.out.print("dans userController inscription" + e.getMessage());
			}

		}

		case "se connecter" -> {
			String login=request.getParameter("login");
			String mdp=request.getParameter("mdp");
			
			User user=userDao.connecter(login,mdp);
			System.out.println(user);
			 
			if(user!=null) {
				session.setAttribute("user", user);	
				response.sendRedirect("Home?action=acceuil");
				return;
			}else {	
				response.sendRedirect("UserController?action=connexion");
				return;
			}

		}
		case"ajouterUser"->{
			try {

				User user = form_inscription.editer(request);
				
				
				if(user!=null) {				
					userDao.insert(user);
					response.sendRedirect("UserController?action=listeUsers");
					return;
				}
				
			} catch (Exception e) {
				System.out.print("dans userController inscription" + e.getMessage());
			}
			
		}
		case"Modifier"->{
			String id=request.getParameter("id");
			
			try {
				
				User user = form_inscription.editer(request);
				
				System.out.println(user);
				
				if(user!=null) {
					if(id!=null) {
						int id_user=Integer.parseInt(id);
						userDao.modifier(user,id_user);
						response.sendRedirect("UserController?action=listeUsers");
						return;
					}					
				}
				
				
			} catch (Exception e) {
				System.out.println("dans userController modifier "+e.getMessage());
			}
			
		}

		}

	}

}
