package modele;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import outils.Journal;
import outils.JournalDesactivable;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.List;

public class DecodeurPenseesXML {

    public List<Pensee> decoderListe(String xml) {
        JournalDesactivable.ecrire("decoderListe()");
        List<Pensee> listePensees = new ArrayList<Pensee>();

        try {
            DocumentBuilder parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            StringBufferInputStream test = new StringBufferInputStream(xml);
            @SuppressWarnings("deprecation")
            Document document = parseur.parse(test);
            String racine = document.getDocumentElement().getNodeName();
            Journal.ecrire(3, "Racine=" + racine);

            NodeList listeNoeudsPensees = document.getElementsByTagName("pensee");
            for (int position = 0; position < listeNoeudsPensees.getLength(); position++)// TODO : veille sur s'il devient iterable
            {
                //Node noeudPensee = listePensees.item(position);
                Element noeudPensee = (Element) listeNoeudsPensees.item(position);
                String id = noeudPensee.getElementsByTagName("id").item(0).getTextContent();
                String auteur = noeudPensee.getElementsByTagName("auteur").item(0).getTextContent();
                String message = noeudPensee.getElementsByTagName("message").item(0).getTextContent();
                String annee = noeudPensee.getElementsByTagName("annee").item(0).getTextContent();
                String source = noeudPensee.getElementsByTagName("source").item(0).getTextContent();

                Journal.ecrire(3, "Id : " + id);
                Journal.ecrire(3, "Auteur : " + auteur);
                Journal.ecrire(3, "Message : " + message);
                Journal.ecrire(3, "Annee : " + annee);
                Journal.ecrire(3, "Source : " + source);

                Pensee pensee = new Pensee(auteur, message);
                //pensee.setAnnee(Integer.parseInt(annee));
                pensee.setId(Integer.parseInt(id));
                pensee.setSource(source);
                listePensees.add(pensee);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listePensees;
    }

    public Pensee decoderPensee(String xml) {
        JournalDesactivable.ecrire("decoderPensee()");
        try {
            DocumentBuilder parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            @SuppressWarnings("deprecation")
            Document document = parseur.parse(new StringBufferInputStream(xml));
            String racine = document.getDocumentElement().getNodeName();
            Journal.ecrire(3, "Racine=" + racine);

            //Node noeudPensee = listePensees.item(position);
            Element noeudPensee = document.getDocumentElement();
            String id = noeudPensee.getElementsByTagName("id").item(0).getTextContent();
            String auteur = noeudPensee.getElementsByTagName("auteur").item(0).getTextContent();
            String message = noeudPensee.getElementsByTagName("message").item(0).getTextContent();
            String annee = noeudPensee.getElementsByTagName("annee").item(0).getTextContent();
            String source = noeudPensee.getElementsByTagName("source").item(0).getTextContent();

            Journal.ecrire(3, "Id : " + id);
            Journal.ecrire(3, "Auteur : " + auteur);
            Journal.ecrire(3, "Message : " + message);
            Journal.ecrire(3, "Annee : " + annee);
            Journal.ecrire(3, "Source : " + source);

            Pensee pensee = new Pensee(auteur, message);
            //pensee.setAnnee(Integer.parseInt(annee));
            pensee.setId(Integer.parseInt(id));
            pensee.setSource(source);

            return pensee;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean decoderReponseAction(String xml) {
        Journal.ecrire(3, "xml" + xml); // prouve que le script a bien recu les donnees en POST

        return true;
    }

}
