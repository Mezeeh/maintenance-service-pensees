package accesseur.cache;

public interface PenseeURL {
    String DSN = "jdbc:sqlite:C:/sqlite/bases/inspiration.cache.db";
    String SQL_ENREGISTRER_PENSEE = "insert into pensee(auteur, message, source) values(?,?,?)";
    String SQL_LISTER_PENSEES = "SELECT * FROM pensee";
}