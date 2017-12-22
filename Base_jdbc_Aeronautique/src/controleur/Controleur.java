package controleur;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import dao.Connexion;
import ihm.Menu;

public class Controleur {

	// TODO Vous pouvez compl�ter ces enchainements de menu avec les deux autres tables.
	// Liste des constantes priv�es permettant d'enchainer les menus.
	// Menu principal
	private static final int MENU_AJOUT_VOL=0;
	private static final int MENU_SUPPR_VOL=3;
	private static final int MENU_PRINCIPAL=6;
	private static final int MENU_AJOUT_VRAIMENT_VOL = 7;
	private static final int MENU_AFFICHER_VOL = 8;
	private static final int MENU_SUPPR_VRAIMENT_VOL = 13;

	public Controleur() {
		this.sgbdJava();
	}

	private int getChoix(int menuAAfficher){
		int rep;
		switch (menuAAfficher) {
		case MENU_PRINCIPAL:
			rep = gererMenuPpl(); 			
			break;
		case MENU_AJOUT_VOL:
			rep = gererAjoutVol(); 			
			break;
		case MENU_SUPPR_VOL:
			rep = gererSupprVol(); 			
			break;
		default:
			rep=-1;
			break;
		} 
		return rep;
	}

	/**
	 * Cette m�thode g�re les enchainements des menus.
	 * 
	 */
	public void sgbdJava(){
		boolean fini=false;
		int choix = this.getChoix(Controleur.MENU_PRINCIPAL);
		int menuPrecedent=choix;
		while (!fini) {
			switch (choix) {
			case -1 :
				fini = true;
				break;
				// Les cas de base ou on appelle simplement le menu demand�
			case Controleur.MENU_PRINCIPAL :
			case Controleur.MENU_AJOUT_VOL :
			case Controleur.MENU_SUPPR_VOL :
				menuPrecedent=choix;
				choix = this.getChoix(choix);
				break;

				// Les cas o� on ne change rien, on ne fait que de l'affichage
			case Controleur.MENU_AFFICHER_VOL :
				Connexion.afficheSelectEtoile("Vol", null);
				choix = menuPrecedent;
				break;

				// Les cas o� on demande des informations pour l'ajout
			case Controleur.MENU_AJOUT_VRAIMENT_VOL :
				this.effectuerAjoutVol();
				choix = menuPrecedent;
				break;
				
				// Les cas o� on demande une cl� pour suppression
			case Controleur.MENU_SUPPR_VRAIMENT_VOL :
				this.effectuerSupprVol();
				choix = menuPrecedent;
				break;
			default:
				// Code inaccessible selon nos v�rifications
				Menu.afficheMsg(" ## R�-essayez");
				break;
			}
		}
		Menu.afficheMsg("Au revoir");
	}


	private void effectuerSupprVol() {
		Connexion.afficheSelectEtoile("Vol", null);
		Menu.afficheMsg("Quel num�ro de vol supprimer ?");
		// TODO Cr�er une instance de Vol et utiliser delete sur VolDAO.
	}

	/** Cette m�thode permet de lire une date
	 * 
	 * @param msg, un petit message permettant de savoir quelle date on entre
	 * @return une date au format Gregorian Calendar
	 */
	private GregorianCalendar lireDate(String msg){
		Menu.afficheMsg("date heure "+msg);		
		String dateActuelle=""; 
		Menu.afficheMsg("quelle ann�e "+msg+" : "+dateActuelle);
		int annee = Menu.lireInt();
		dateActuelle+=annee+"/";
		Menu.afficheMsg("quelle mois "+msg+" : "+dateActuelle);
		int mois = Menu.lireInt();
		dateActuelle+=mois+"/";
		Menu.afficheMsg("quelle jour "+msg+" : "+dateActuelle);
		int jour = Menu.lireInt();
		dateActuelle+=jour+" ";
		Menu.afficheMsg("quelle heure "+msg+" : "+dateActuelle);
		int heure = Menu.lireInt();
		dateActuelle+=heure+":";
		Menu.afficheMsg("quelle minute "+msg+" : "+dateActuelle);
		int minute = Menu.lireInt();
		dateActuelle+=minute+":";
		Menu.afficheMsg("quelle seconde "+msg+" : "+dateActuelle);
		int seconde = Menu.lireInt();
		dateActuelle+=seconde;
		Menu.afficheMsg("date heure "+msg+" "+dateActuelle);		
		return new GregorianCalendar(annee, mois-1, jour, heure, minute, seconde);
	}

	/**
	 * M�thode d'interaction pour saisir les donn�es au clavier, cr�ation d'un Vol
	 * puis utilisation de create dans VolDAO pour �criture dans la table 
	 */
	private void effectuerAjoutVol() {
		// TODO
	}

	private int gererSupprVol() {
		int rep;
		ArrayList<String> leMenu = new ArrayList<String>(4);
		leMenu.add("Supprimer un Vol");
		leMenu.add("Menu Principal");
		leMenu.add("Voir la table Vol");
		switch (Menu.getChoix(leMenu)) {
		case 0:
			rep=MENU_SUPPR_VRAIMENT_VOL;
			break;
		case 1:
			rep=MENU_PRINCIPAL;
			break;
		case 2:
			rep=MENU_AFFICHER_VOL;
			break;
		default:
			rep=-1;
			break;
		}
		return rep;
	}

	
	private int gererAjoutVol() {
		int rep;
		ArrayList<String> leMenu = new ArrayList<String>(4);
		leMenu.add("Ajouter un Vol");
		leMenu.add("Menu Principal");
		leMenu.add("Voir la table Vol");
		switch (Menu.getChoix(leMenu)) {
		case 0:
			rep=MENU_AJOUT_VRAIMENT_VOL;
			break;
		case 1:
			rep=MENU_PRINCIPAL;
			break;
		case 2:
			rep=MENU_AFFICHER_VOL;
			break;
		default:
			rep=-1;
			break;
		}
		return rep;
	}

	private int gererMenuPpl() {
		int rep;
		ArrayList<String> leMenu = new ArrayList<String>(4);
		leMenu.add("Ajout Vol");
		leMenu.add("Supprimer Vol");
		switch (Menu.getChoix(leMenu)) {
		case 0:
			rep=MENU_AJOUT_VOL;
			break;
		case 2:
			rep=MENU_SUPPR_VOL;
			break;
		default:
			rep=-1;
			break;
		}
		return rep;
	}

}
