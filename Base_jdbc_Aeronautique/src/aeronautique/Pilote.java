package aeronautique;

public class Pilote {
	
	private int numpil;
	private String nompil;
	private String adr;
	private int sal;
	/**
	 * @param numpil
	 * @param nompil
	 * @param adr
	 * @param sal
	 */
	public Pilote(int numpil, String nompil, String adr, int sal) {
		super();
		this.numpil = numpil;
		this.nompil = nompil;
		this.adr = adr;
		this.sal = sal;
	}
	/**
	 * @return the numpil
	 */
	public int getNumpil() {
		return numpil;
	}
	/**
	 * @param numpil the numpil to set
	 */
	public void setNumpil(int numpil) {
		this.numpil = numpil;
	}
	/**
	 * @return the nompil
	 */
	public String getNompil() {
		return nompil;
	}
	/**
	 * @param nompil the nompil to set
	 */
	public void setNompil(String nompil) {
		this.nompil = nompil;
	}
	/**
	 * @return the adr
	 */
	public String getAdr() {
		return adr;
	}
	/**
	 * @param adr the adr to set
	 */
	public void setAdr(String adr) {
		this.adr = adr;
	}
	/**
	 * @return the sal
	 */
	public int getSal() {
		return sal;
	}
	/**
	 * @param sal the sal to set
	 */
	public void setSal(int sal) {
		this.sal = sal;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pilote [numpil=" + numpil + ", nompil=" + nompil + ", adr=" + adr + ", sal=" + sal + "]";
	}

	
	
	
}
