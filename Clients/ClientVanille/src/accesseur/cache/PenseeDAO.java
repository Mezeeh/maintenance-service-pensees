package accesseur.cache;

import accesseur.PenseeURL;
import modele.DecodeurPenseesXML;
import modele.Pensee;
import outils.JournalDesactivable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static accesseur.cache.PenseeURL.DSN;
import static accesseur.cache.PenseeURL.SQL_LISTER_PENSEES;

public class PenseeDAO implements PenseeURL {

    protected DecodeurPenseesXML decodeur = new DecodeurPenseesXML();

    public List<Pensee> listerPensees() {
        List<Pensee> listePensees = new ArrayList<Pensee>();
        JournalDesactivable.ecrire("listerPensees()");
        Connection basededonnees = null;
        ResultSet curseurListePensees;
        try {
            basededonnees = DriverManager.getConnection(DSN);
            Statement requeteListePensees = basededonnees.createStatement();
            curseurListePensees = requeteListePensees.executeQuery(SQL_LISTER_PENSEES);
            if (curseurListePensees == null) return listePensees; //return null;
            while (curseurListePensees.next()) {
                String auteur = curseurListePensees.getString("auteur");
                String message = curseurListePensees.getString("message");
                //System.out.println(auteur + " - " + message);
                listePensees.add(new Pensee(auteur, message));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listePensees;
    }

}