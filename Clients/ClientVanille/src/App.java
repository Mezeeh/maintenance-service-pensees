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
		cachePenseeDAO.enregistrerPensee(new Pensee("Joe","20$ is 20$"));

		VueInspirationVisuelle.launch(VueInspirationVisuelle.class, parametres);
	}
}

