package aeronautique;

import org.omg.CORBA.PRIVATE_MEMBER;

import controleur.Controleur;
import dao.Connexion;
import dao.PiloteDAO;


/**
 * - Il faut commencer par faire le métier, puis regarder la classe Connexion,
 * puis le Design Pattern DAO sur la table VOL
 * - Ensuite on étend aux autres tables AVION et PILOTE
 * - faire quelques vérifications de base sur la table vol :
 * lors du create, est-ce que les clés étrangères sont dans la table.
 * Il faut lever une exception précise dans le cas contraire.
 * - Essayer des requêtes plus complexes et les proposer dès le menu.
 * - Algorithmique : soigner l'affichage des réponses pour avoir un titre
 * aux colonnes et qu'elles soient de largeur fixe.
 * 
 * Si vous utilisez le type Money sous SQL Server Express, il faut utiliser
 * DECIMAL	avec JDBC et java.math.BigDecimal pour java.
 * 
 * @author abi
 *
 */
public class Principale {

	private static final String array = null;

	public static void main(String[] args) {

		//		new Controleur();		

		//Connexion.getInstance();
		//initialisation();
		//testSelect();
		//testgetMax();
		//testSelectUn();
		testPiloteDao();
	}

	private static void testPiloteDao() {
		Pilote p = (new PiloteDAO()).find(3);
		System.out.println(p);
		Connexion.fermer();
	}

	private static void testgetMax() {
		System.out.println(Connexion.getMaxId("numPil", "PILOTE"));
		Connexion.fermer();
	}

	/*private static void testSelect() {
		Connexion.afficheSelectEtoile("VOL", "VILLE_ARR='Paris'");
		Connexion.fermer();
	}*/


	private static void testSelectUn() {
		PiloteDAO pDao = new PiloteDAO();
		Pilote pilote=new Pilote(1, "Martin", "Paris", 10000);
		/*System.out.println("avant create"+pilote);
		pDao.create(pilote);*/
		System.out.println("après create et avant delete"+pilote);

		for (int i = 6; i < 22; i++) {
			pilote.setNumpil(i);
			pDao.delete(pilote);			
		}
		//System.out.println("après create et avant delete"+pilote);
		Connexion.fermer();
	}
	


	/*private static void testSelect() {
		Connexion.afficheSelectEtoile("AVION", "Cap>350");
		Connexion.fermer();

	}*/

	public static void initialisation() {
		Connexion.executeUpdate("drop table Vol");
		Connexion.executeUpdate("drop table Pilote");
		Connexion.executeUpdate("drop table Avion");

		Connexion.executeUpdate("create table Pilote ("+
				"NUMPIL       int identity(1,1) primary key not null,"+
				"NOMPIL       VARCHAR(32)       not null,"+
				"ADR          VARCHAR (50)      not null,"+
				"SAL          Int               not null);");

		Connexion.executeUpdate(" INSERT INTO PILOTE (NOMPIL,ADR,SAL) " + 
				" VALUES ('Martin','Paris',10000), " + 
				"        ('Dupont','Nice',12000), " + 
				"		('Andros','Lorient',15000);");

		Connexion.executeUpdate("create table Avion ("+
				" NUMAV        int identity(1,1) primary key not null,"+
				"NOMAV        VARCHAR(50)       not null,"+
				"CAPACITE     int               not null,"+
				"LOC          VARCHAR(50)       not null);");
		Connexion.executeUpdate("INSERT   INTO AVION (NOMAV,CAPACITE,LOC)"+
				" VALUES   ('Airbus',800,'Paris'),"+
				"          ('Bombardier',400,'Nice'),"+
				"	       ('Boeing',500,'Paris');");

		Connexion.executeUpdate("create table Vol("+
				"NUMVOL       int identity(1,1) primary key not null,"+
				"NUMPIL       INT FOREIGN KEY REFERENCES PILOTE(numPil)      not null,"+
				"NUMAV        INT FOREIGN KEY REFERENCES AVION(numAv)   not null,"+
				"VILLE_DEP    VARCHAR(50)       not null,"+
				"VILLE_ARR    VARCHAR(50)       not null,"+
				"H_DEP        DATE              not null,"+
				"H_ARR        DATE              not null);");
		Connexion.executeUpdate("INSERT INTO VOL (NUMPIL,NUMAV,VILLE_DEP,VILLE_ARR,H_DEP,H_ARR)"+
				"VALUES   (1,1,'Nice','Paris','27-11-2017 15:15:24','27-11-17 16:15:32'),"+
				"          (2,1,'Lorient','Nice','28-11-2017 13:30:54','28-11-2017 16:30:30'),"+
				"	      (3,3,'Lorient','Paris','19-12-2017 13:30','19-12-2017 15:30:30');");

		Connexion.fermer();
	}

}
