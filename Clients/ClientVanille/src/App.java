import accesseur.cache.PenseeDAO;
import modele.Pensee;
import outils.Journal;
import vue.VueInspirationVisuelle;

public class App {

	public static void main(String[] parametres) {
		//Journal.activer();
		Journal.activerNiveau(0);

		PenseeDAO cachePenseeDAO = new PenseeDAO();
//		cachePenseeDAO.listerPensees();
		Pensee pensee = new Pensee("Joe","20$ is 20$");
		pensee.setSource("www.google.ca");
		cachePenseeDAO.enregistrerPensee(pensee);

		VueInspirationVisuelle.launch(VueInspirationVisuelle.class, parametres);
	}
}

