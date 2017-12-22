package aeronautique;

public class Avion {

	private int numvol;
	private String nomav;
	private int capacité;
	private String loc;
	/**
	 * @param numvol
	 * @param nomav
	 * @param capacité
	 * @param loc
	 */
	public Avion(int numvol, String nomav, int capacité, String loc) {
		super();
		this.numvol = numvol;
		this.nomav = nomav;
		this.capacité = capacité;
		this.loc = loc;
	}
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
	 * @return the nomav
	 */
	public String getNomav() {
		return nomav;
	}
	/**
	 * @param nomav the nomav to set
	 */
	public void setNomav(String nomav) {
		this.nomav = nomav;
	}
	/**
	 * @return the capacité
	 */
	public int getCapacité() {
		return capacité;
	}
	/**
	 * @param capacité the capacité to set
	 */
	public void setCapacité(int capacité) {
		this.capacité = capacité;
	}
	/**
	 * @return the loc
	 */
	public String getLoc() {
		return loc;
	}
	/**
	 * @param loc the loc to set
	 */
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public int getNumav() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
