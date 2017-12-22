package aeronautique;

import java.sql.Timestamp;

/**
 * étape 0 : les classes métier : le vol
 * on regarde les types de la table VOL
 * @author abi
 *
 */

public class Vol {

	
	private int numvol;
	private int numav;
	/**
	 * @return the numav
	 */
	public int getNumav() {
		return numav;
	}







	/**
	 * @param numav the numav to set
	 */
	public void setNumav(int numav) {
		this.numav = numav;
	}







	/**
	 * @param pilote the pilote to set
	 */
	public void setPilote(int pilote) {
		this.pilote = pilote;
	}







	private int pilote;
	private Avion avion;	
	/**
	 * @return the numvol
	 */
	public int getNumvol() {
		return numvol;
	}







	/**
	 * @param numvol the numvol to set
	 */
	public void setNumvol(int numvol) {
		this.numvol = numvol;
	}







	/**
	 * @return the pilote
	 */
	public Pilote getPilote() {
		return pilote;
	}







	/**
	 * @param pilote the pilote to set
	 */
	public void setPilote(Pilote pilote) {
		this.pilote = pilote;
	}







	/**
	 * @return the avion
	 */
	public Avion getAvion() {
		return avion;
	}







	/**
	 * @param avion the avion to set
	 */
	public void setAvion(Avion avion) {
		this.avion = avion;
	}







	/**
	 * @return the villeDep
	 */
	public String getVilleDep() {
		return villeDep;
	}







	/**
	 * @param villeDep the villeDep to set
	 */
	public void setVilleDep(String villeDep) {
		this.villeDep = villeDep;
	}







	/**
	 * @return the villeArr
	 */
	public String getVilleArr() {
		return villeArr;
	}







	/**
	 * @param villeArr the villeArr to set
	 */
	public void setVilleArr(String villeArr) {
		this.villeArr = villeArr;
	}







	/**
	 * @return the hArr
	 */
	public Timestamp gethArr() {
		return hArr;
	}







	/**
	 * @param hArr the hArr to set
	 */
	public void sethArr(Timestamp hArr) {
		this.hArr = hArr;
	}







	/**
	 * @return the hDep
	 */
	public Timestamp gethDep() {
		return hDep;
	}







	/**
	 * @param hDep the hDep to set
	 */
	public void sethDep(Timestamp hDep) {
		this.hDep = hDep;
	}







	private String villeDep;
	private String villeArr;
	private Timestamp hArr;
	private Timestamp hDep;

	
	
	// Constructeur sur les champs.
	
	/**
	 * @param numvol
	 * @param numpil
	 * @param numav
	 * @param villeDep
	 * @param villeArr
	 * @param hArr
	 * @param hDep
	 */
	public Vol(int numvol, int numpil, int numav, String villeDep, String villeArr, Timestamp hArr,
			Timestamp hDep) {
		super();
		this.numvol = numvol;
		this.pilote = numpil;
		this.avion = numav;
		this.villeDep = villeDep;
		this.villeArr = villeArr;
		this.hArr = hArr;
		this.hDep = hDep;
	}



	

	
	
	/**
	 * éventuellement utiliser java.sql.Timestamp et getTimeInMillis pour afficher les dates 
	 */
	@Override
	public String toString() {
		// TODO TimeStamp de java.sql se rapproche du dateTime de sql Server
		return null;
	}
	

}
