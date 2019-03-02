package controleur;

import accesseur.PenseeDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import modele.Pensee;
import vue.VueInspirationVisuelle;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ControleurInspirationVisuelle implements Initializable {
    protected static ControleurInspirationVisuelle instance = null;
    protected PenseeDAO penseeDAO = new PenseeDAO();

    public ControleurInspirationVisuelle() {
        ControleurInspirationVisuelle.instance = this;
    }

    public static ControleurInspirationVisuelle getInstance() {
        return ControleurInspirationVisuelle.instance;
    }

    @FXML
    protected void trouverInspiration(ActionEvent evenement) {

        System.out.println("trouverInspiration( )");

        // Singleton obligatoire car le framework de JavaFX cache l'instance
        //VueInspirationVisuelle.getInstance().ecrireUnMessage("allo");
    }

    public void initialiser() {
        List<Pensee> listePensees = penseeDAO.listerPensees();

        //for(Iterator<Pensee> visiteur = listePensees.iterator(); visiteur.hasNext(); )
        //{
        //	Pensee pensee = visiteur.next();
        //	Journal.ecrire(5, pensee.getMessage() + "(" + pensee.getAuteur() + ")");
        //}
        VueInspirationVisuelle.getInstance().afficherListePensees(listePensees);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
}
