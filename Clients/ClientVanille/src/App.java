import accesseur.PenseeDAO;
import modele.Pensee;
import outils.Journal;
import vue.VueInspirationVisuelle;

import java.util.Iterator;
import java.util.List;

public class App {

	public static void main(String[] parametres) {
		//Journal.activer();
		Journal.activerNiveau(0);

		PenseeDAO penseeDAO = new PenseeDAO();
		List<Pensee> listePensees = penseeDAO.listerPensees();

		for(Iterator<Pensee> visiteur = listePensees.iterator(); visiteur.hasNext(); )
		{
			Pensee pensee = visiteur.next();
			Journal.ecrire(5, pensee.getMessage() + "(" + pensee.getAuteur() + ")");
		}

		Pensee pensee = new Pensee("Rossetti","Ce qui est plus triste qu une oeuvre inachevee, c est une oeuvre jamais commencee.");
		penseeDAO.ajouterPensee(pensee);

		VueInspirationVisuelle.launch(VueInspirationVisuelle.class, parametres);
	}
}

