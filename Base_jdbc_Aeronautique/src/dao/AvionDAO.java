package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import aeronautique.Avion;
import aeronautique.Pilote;

public class AvionDAO extends DAO<Avion> {

	private static final String TABLE = "avion";
	private static final String CLE_PRIMAIRE = "NUMAV";
	

	@Override
	public boolean create(Avion obj) {
		boolean succes=true;
		try
		{
			String req ="INSERT INTO "+ TABLE +" (nomav,capacite,loc) values(?,?,?);";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(req);
			pst.setString(1, obj.getNomav());
			pst.setInt(2, obj.getCapacité());
			pst.setString(3, obj.getNomav());
			pst.executeUpdate();
		
		int id = Connexion.getMaxId(CLE_PRIMAIRE,TABLE);
		obj.setNumvol(id);//recupere id generé et on affecte
	}   
	catch (SQLException e) {
		succes=false;
		e.printStackTrace();
	}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Avion obj) {
		boolean succes=true;
		int id = obj.getNumvol();
		try
		{ 
			String req ="DELETE FROM "+ TABLE + " WHERE "+CLE_PRIMAIRE+" = ? ;";
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
	public boolean update(Avion obj) {
		boolean succes=true;
		int id = obj.getNumav();
		String nomav =obj.getNomav();
		int capacite =obj.getCapacité();
		String loc =obj.getLoc();
		
		try
		{ 
			String req = " UPDATE " + TABLE + " SET " + "nomPil" +" = ? "+" adr "+ " = ? "+"sal" +" = ? " + " WHERE " +CLE_PRIMAIRE+" = ? ;"; 
			PreparedStatement pst = Connexion.getInstance().prepareStatement(req);
			pst.setInt(1, obj.getNumav());
			pst.setString(2, obj.getNomav());
			pst.setInt(3, obj.getNumvol());
			id = obj.getNumav();	
			pst.executeUpdate();
		
	} 
	    catch (SQLException e) {
		     succes = false;
		e.printStackTrace();
	
	}
		return succes;
	}

	@Override
	public Avion find(int id) {
		Avion avion = null;
		
		try {
		String req = " SELECT "	+ ",nomav" + " FROM  " + TABLE + " WHERE " +CLE_PRIMAIRE+" = "+id+";";
		ResultSet rs= Connexion.executeQuery(req);
		rs.next();
		//int  nomav = rs.getInt(2);
		String nomav =rs.getString(3);
		int capacite =rs.getInt(4);
		String loc =rs.getString(4);
		avion = new Avion(capacite, loc, capacite, loc);
	    
	} 
		catch (SQLException e) {
			e.printStackTrace();
		}
			return avion;
	}

}
