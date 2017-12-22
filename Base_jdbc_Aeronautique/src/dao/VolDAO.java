package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.GregorianCalendar;

import aeronautique.Pilote;
import aeronautique.Vol;

/**
 * étape 2 : le patron de conception DAO, le lien vers notre table PILOTE
 * On étend la classe DAO avec un Pilote
 * @author abi 
 *
 */
public class VolDAO extends DAO<Vol> {
	
	private static final String TABLE = "Vol";
	private static final String CLE_PRIMAIRE = "NUMVOL";
	
	@Override
	public boolean create(Vol obj) {
	boolean succes=true;
	try
	// TODO Le prepared Statement prépare notre requete.
				// On peut utiliser les méthodes setInt, setTimestamp, setString...
				// Puis on utilise executeUpdate

				// Ensuite, il faut remettre à jour l'identifiant de l'objet java,
				// généré automatiquement par la base de données	
	{
		String req ="INSERT INTO "+ TABLE +" (numpil,numav,vill_dep,ville_arr,h_dep,h_arr) values(?,?,?,?,?,?:);";
		PreparedStatement pst = Connexion.getInstance().prepareStatement(req);
		pst.setInt(1, obj.getNumvol());
		pst.setInt(2, obj.getNumvol());
		pst.setString(3, obj.getVilleDep());
		pst.setString(4, obj.getVilleArr());
		pst.setTimestamp(5, obj.gethDep());
		pst.setTimestamp(6, obj.gethArr());
		pst.executeUpdate();	

		// TODO récupérer id généré

		int id = Connexion.getMaxId(CLE_PRIMAIRE,TABLE);
		obj.setNumvol(id);//recupere id generé et on affecte
	}   
	catch (SQLException e) {
		succes=false;
		e.printStackTrace();
	}

	return succes;
}	

	/* !!! DATES : pour les bases de données, on passera par java.sql.Timestamp 
	 * Pour le find :
	 * GregorianCalendar hArr = new GregorianCalendar();
	 * hArr.setTimeInMillis (rs.getTimestamp("harr").getTime());
	 * Pour le create :
	 * Timestamp ts = new Timestamp (vol.gethDep().getTimeInMillis());
	 * pst.setTimestamp(3,ts);
	 * 
	 * NB : les mois dans le constructeur de Gregorian Calendar vont de 0 à 11.
	 * 
	 * En utilisant SimpleDateFormat, on peut avoir un affichage avec des termes français.
	 * SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM yyyy zzzz G", Locale.FRENCH);
	 * 
	 */

	
	/**
	 * On donne un vol en entrée qu'on va écrire dans la base de données
	 * La requête à utiliser est un INSERT INTO
	 * On utilise encore TimeStamp
	 */

	

	/**
	 * On donne un vol en entrée qu'on va supprimer de la base de données
	 * La requête à utiliser est un DELETE FROM
	 * 
	 */
	@Override
	public boolean delete(Vol obj) {
		boolean succes=true;
		
		try {
			int id = obj.getNumvol();
			String req ="DELETE FROM "+ TABLE + " WHERE "+CLE_PRIMAIRE+" = ? ;";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(req);
			pst.setInt(1,id);
			pst.executeUpdate();
			
		} catch (SQLException e) {
			succes = false;
			e.printStackTrace();
		} 
		return succes;		
	}

	/**
	 * On donne un vol en entrée qu'on va mettre à jour dans la base de données
	 * La requête à utiliser est un UPDATE SET
	 * 
	 */
	@Override
	public boolean update(Vol obj) {
		boolean succes=true;
		int id = obj.getNumvol();
		int numpil  =obj.getNumvol();
		int numav =obj.getNumav();
		String ville_dep =obj.getVilleDep();
        String ville_arr = obj.getVilleArr();
        Timestamp h_dep= obj.gethDep();
        Timestamp h_arr= obj.gethArr();
        
		try {
			String req = " UPDATE " + TABLE + " SET " + "numPil" +" = ? "+" numav "+ " = ? "+"ville_dep" +" = ? " + " ville_arr "+ " = ? " + "ville_dep " + " = ? " + " h_dep " + " = ? "+ " h_arr " + " = ? " + " WHERE " +CLE_PRIMAIRE+ " = ? ; ";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(req);
			id = obj.getNumvol();	
			pst.executeUpdate();
			// TODO requete, preparedStatement, setInt, setString, setTimeStamp etc. puis executeUpdate
		} catch (SQLException e) {
			succes = false;
			e.printStackTrace();
		} 
		return succes;	
	}

	/**
	 * On donne un identifiant entier en entrée qu'on cherche dans la base de données
	 * La requête à utiliser est un SELECT FROM WHERE avec la clé primaire
	 * 
	 */
	@Override
	public Vol find(int id) {
		Vol vol = null;
	
		try {
	    String req = " SELECT 	*  FROM  " + TABLE + " WHERE " +CLE_PRIMAIRE+" = "+id+" ;";
		PreparedStatement pst = Connexion.getInstance().prepareStatement(req);
		ResultSet rs= Connexion.executeQuery(req);
		rs.next();
        int numpil =rs.getInt(2);
        int numav =rs.getInt(3);
        String ville_dep = rs.getString(4);
        String ville_arr = rs.getString(5);
        Timestamp h_dep = rs.getTimestamp(6);
        Timestamp h_arr = rs.getTimestamp(7);
        
        
        
        vol=new Vol(id, numpil, numav, ville_dep, ville_arr, h_arr, h_dep);
		pst.executeUpdate();	
	} 
		
		 catch (SQLException e) {
			e.printStackTrace();
		}
		return vol;
	}

}


