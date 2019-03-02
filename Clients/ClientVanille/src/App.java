import accesseur.PenseeDAO;
import outils.Journal;
import vue.VueInspirationVisuelle;

public class App {

	public static void main(String[] parametres) {
		//Journal.activer();
		Journal.activerNiveau(0);

		PenseeDAO cachePenseeDAO = new PenseeDAO();
		cachePenseeDAO.listerPensees();

		VueInspirationVisuelle.launch(VueInspirationVisuelle.class, parametres);
	}
}

