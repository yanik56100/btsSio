package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import aeronautique.Pilote;

public class PiloteDAO extends DAO<Pilote> {

	private static final String TABLE = "Pilote";
	private static final String CLE_PRIMAIRE = "numPIL";

	@Override
	public boolean create(Pilote obj) {
		boolean succes=true;
		try
		{
			String req ="INSERT INTO "+ TABLE +" (nompil,adr,sal) values(?,?,?);";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(req);
			pst.setString(1, obj.getNompil());
			pst.setString(2, obj.getAdr());
			pst.setInt(3, obj.getSal());
			pst.executeUpdate();	

			// TODO récupérer id généré

			int id = Connexion.getMaxId(CLE_PRIMAIRE,TABLE);
			obj.setNumpil(id);//recupere id generé et on affecte
		}   
		catch (SQLException e) {
			succes=false;
			e.printStackTrace();
		}

		return succes;
	}	

	@Override
	public boolean delete(Pilote obj) {
		boolean succes=true;
		
		try
		{ 
			int id = obj.getNumpil();
			String req ="DELETE  FROM "+ TABLE + " WHERE "+CLE_PRIMAIRE+" = ? ;";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(req);
			
			pst.setInt(1,id);
			pst.executeUpdate();

		} 
		catch (SQLException e) {
			succes = false;
			e.printStackTrace();
		} 
		return succes;		
	}

	@Override
	public boolean update(Pilote obj) {
		boolean succes=true;
		int id = obj.getNumpil();
		String nompil =obj.getNompil();
		String adresse =obj.getAdr();
		int salaire =obj.getSal();
		
		try
		{ 
			String req = " UPDATE " + TABLE + " SET " + "nomPil" +" = ? "+" adr "+ " = ? "+"sal" +" = ? " + " WHERE " +CLE_PRIMAIRE+" = ? ;"; 
			PreparedStatement pst = Connexion.getInstance().prepareStatement(req);
			pst.setString(1, obj.getNompil());
			pst.setString(2, obj.getAdr());
			pst.setInt(3, obj.getSal());
			id = obj.getNumpil();	
			pst.executeUpdate();
		
	} 
	    catch (SQLException e) {
		     succes = false;
		e.printStackTrace();
	
	}
		return succes;
	}
	@Override
	public Pilote find(int id) {
		Pilote pilote = null;
	
		try {
			
		String req = " SELECT * FROM  " + TABLE + " WHERE " +CLE_PRIMAIRE+ " = "+id+" ;";
		ResultSet rs= Connexion.executeQuery(req);
		rs.next();
        String nompil =rs.getString(2);
        String adresse =rs.getString(3);
        int salaire = rs.getInt(4);
        pilote=new Pilote(id, nompil, adresse, salaire);
	} 
		catch (SQLException e) {
			e.printStackTrace();
		}
			return pilote;
		}
	
	}
