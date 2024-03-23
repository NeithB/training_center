package Forms;

import dao.NiveauDao;
import jakarta.servlet.http.HttpServletRequest;
import modele.Niveaux;
import modele.User;


public class Form_Inscription {

	private static final String     CHAMPS_SEXE     = "sexe";
    private static final String     CHAMPS_PRENOM   = "prenom";
    private static final String     CHAMPS_NOM      = "nom";
    private static final String     CHAMPS_LOGIN    = "login";
    private static final String     CHAMPS_MDP      = "mdp";
    private static final String     CHAMPS_EMAIL    = "email";
    private static final String     CHAMPS_ROLE     = "role";
    private static final String     CHAMPS_NIVEAU   = "niveau";
    
    
    public User editer( HttpServletRequest request ) throws Exception {
    	
    	NiveauDao niveauDao=new NiveauDao();

        String sexe = request.getParameter( CHAMPS_SEXE );
        String prenom = request.getParameter( CHAMPS_PRENOM );
        String nom = request.getParameter( CHAMPS_NOM );
        String login = request.getParameter( CHAMPS_LOGIN );
        String mdp = request.getParameter( CHAMPS_MDP );
        String email = request.getParameter( CHAMPS_EMAIL );  
         
        int intNiv=Integer.parseInt(request.getParameter( CHAMPS_NIVEAU ) );
        
        Niveaux niveau=niveauDao.getNiveau(intNiv);
        
        
     
      return new User(0, nom, prenom, sexe, login, mdp, email,"participant", niveau);
      
          
       
    }
	
}
