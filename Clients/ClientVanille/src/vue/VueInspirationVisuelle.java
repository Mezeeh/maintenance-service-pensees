package vue;

import controleur.ControleurInspirationVisuelle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import modele.Pensee;
import outils.Journal;

import java.util.Iterator;
import java.util.List;

public class VueInspirationVisuelle extends Application {
    public VueInspirationVisuelle()
    {
        System.out.println("new VueInspiration()");
        VueInspirationVisuelle.instance = this;
    }
    protected static VueInspirationVisuelle instance = null;
    public static VueInspirationVisuelle getInstance() {return VueInspirationVisuelle.instance;};

    protected Scene scene = null;
    @Override
    public void start(Stage stade) throws Exception {
        Parent racine = FXMLLoader.load(getClass().getResource("inspiration-visuelle.fxml"));
        //Pane racine = new StackPane();
        scene = new Scene(racine, 800, 600);
        stade.setScene(scene);
        stade.show();
        ControleurInspirationVisuelle.getInstance().initialiser();

        // stade.setOnShowing(new EventHandler<WindowEvent>() {public void handle(WindowEvent event) {  } });
    }

    public void afficherPensee(Pensee pensee)
    {
        System.out.println("afficherPensee()");
        TextArea champsMessage = (TextArea) scene.lookup("#listePensees");

        champsMessage.setText(pensee.getMessage() + " - " + pensee.getAuteur() + " (" + pensee.getSource() + ")");
        Journal.ecrire(5, pensee.getMessage() + " - " + pensee.getAuteur());
    }
}
