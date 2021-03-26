package com.socialbuilder.algo;

import java.util.Scanner;
import java.util.HashMap;

public class JoyeusePaques {
	
	private static final Scanner scan = new Scanner(System.in);
	
	/**
	 * Map associant à chaque valeur numérique d'un mois sa forme écrite
	 */
	private static final HashMap<Integer,String> nomMois = new HashMap<Integer,String>(){
		private static final long serialVersionUID = 1L; //added automatically by eclipse
	{
	    put(1, "janvier");
	    put(2, "fevrier");
	    put(3, "mars");
	    put(4, "avril");
	    put(5, "mai");
	    put(6, "juin");
	    put(7, "juillet");
	    put(8, "aout");
	    put(9, "septembre");
	    put(10, "octobre");
	    put(11, "novembre");
	    put(12, "decembre");
	}};
	
	/**
	 * Map associant à chacune des "distances" en jour avec Paques (clé) le nom de la fête mobile (valeur)
	 */
	private static final HashMap<Integer,String> fetesMobiles = new HashMap<Integer,String>(){
		private static final long serialVersionUID = 1L; //added automatically by eclipse
	{
	    put((-70), "Triodion");
	    put((-63), "Septuagésime");
	    put((-57), "Samedi des âmes");
	    put((-56), "Sexagésime");
	    put((-49), "Quinquagésime");
	    put((-48), "Lundi Gras");
	    put((-47), "Mardi Gras");
	    put((-46), "Mercredi des Cendres");
	    put((-42), "Dimanche de l'Orthodoxie");
	    put((-41), "People's Sunday");
	    put((-21), "Mothering Sunday");
	    put((-14), "Dimanche de la Passion");
	    put((-8), "Samedi de Lazare");
	    put((-7), "Dimanche des Rameaux");
	    put((-3), "Jeudi saint");
	    put((-2), "Vendredi saint");
	    put((-1), "Samedi saint");
	    put(0, "Pâques");
	    put(3, "Fête de saint Grégoire");
	    put(7, "Quasimodo");
	    put(8, "Radonitsa");
	    put(39, "Ascension");
	    put(49, "Pentecôte");
	    put(50, "Lundi de Pentecôte");
	    put(59, "Fête de la Sainte Trinité / Toussaint");
	    put(60, "Fête-Dieu");
	}};
	
	/**
	 * Tableau listant le nombre de jour pour chaque mois d'une année non bissextile
	 */
	private static final int[] mensuelNB  = {31,28,31,30,31,30,31,31,30,31,30,31};
	
	/**
	 * Tableau listant le nombre de jour pour chaque mois d'une année bissextile
	 */
	private static final int[] mensuelB  = {31,29,31,30,31,30,31,31,30,31,30,31};
	
	public static void main(String[] args) {
		System.out.println("Travaillons sur le calendrier.");
		boolean poursuit = true;
		do //cette boucle do while permet de relancer la selection tant que l'utilisateur ne change pas la valeur de "poursuit"
		{	int choix = menu();
			System.out.println();
			selectionMenu(choix);
			System.out.println();
			poursuit = selectionPoursuite();
			System.out.println();
		} while (poursuit);
	}
	
	/**
	 * Affiche la liste des options de traitement des différentes méthodes et renvoie la selection de l'utilisateur
	 * @return la valeur selectionnée par l'utilisateur
	 */
	public static int menu() {
		System.out.println("Choisissez une option:");
		System.out.println("1 - Determiner si l'année est bissextile.");
		System.out.println("2 - Connaitre le nombre de jour dans un mois.");
		System.out.println("3 - Determiner la date de Pâques pour une année spécifique par la méthode de Gauss.");
		System.out.println("4 - Determiner la date de Pâques pour une année spécifique par la méthode de Meuss.");
		System.out.println("5 - Determiner la date de Pâques pour une année spécifique par la méthode de Conway.");
		System.out.println("6 - Determiner le calendrier des fêtes mobiles pour une année spécifique (méthode de Gauss).");
		System.out.println("7 - Determiner la date de Pâques pour la décennie suivant une année spécifique.");
		return scan.nextInt();
	}
	
	/**
	 * Répartie les fonctionnalitées à appeler en fonction de la selection du menu
	 * @param i valeur correspondant à l'option du menu selectionnée par l'utilisateur
	 */
	public static void selectionMenu(int i) {
		int annee;
		int[] datePaques = new int[2];
		int jourPaques;
		switch(i) {
		case 1:
			annee = choixAnnee();
			System.out.println();
			boolean isBissextile = anneeBissextile(annee);
			if (isBissextile) {
				System.out.println("L'année "+ annee+ " est bissextile.");
			} else {System.out.println("L'année "+ annee+ " n'est pas bissextile.");}
			break;
		case 2:
			int mois = choixMois();
			System.out.println();
			annee = choixAnnee();
			System.out.println();
			int jours = nombreDeJoursAnnee(mois, annee);
			System.out.println("En "+ nomMois.get(mois) +" "+ annee +", on compte "+jours+" jours.");
			break;
		case 3:
			annee = choixAnnee();
			System.out.println();
			while (annee < 325) {
				System.out.println("Le calcul est impossible avec l’algorithme de Gauss.");
				System.out.println("Pâques n'existait pas avant l'an 325. Merci de choisir une date ultérieure");
				annee = choixAnnee();
			}
			datePaques = gaussAlgo(annee);
			jourPaques = jourAnnee(datePaques, annee);
			System.out.println("Selon la méthode gaussienne, Paques tombe le " + datePaques[0] +" "+ nomMois.get(datePaques[1]) +" " + annee);
			System.out.println("Soit le " + jourPaques +"ème jour de l'année.");
			break;
		case 4:
			annee = choixAnnee();
			System.out.println();
			while (annee < 326) {
				System.out.println("Le calcul est impossible avec l’algorithme de Meeus.");
				System.out.println("Merci de choisir une date après 326.");
				annee = choixAnnee();
				System.out.println();
			}
			datePaques = meeusAlgo(annee);
			jourPaques = jourAnnee(datePaques, annee);
			System.out.println("Selon la méthode de Meeus, Paques tombe le " + datePaques[0] +" "+ nomMois.get(datePaques[1]) +" " + annee);
			System.out.println("Soit le " + jourPaques +"ème jour de l'année.");
			break;
		case 5:
			annee = choixAnnee();
			System.out.println();
			while (annee < 1583) {
				System.out.println("Le calcul est impossible avec l’algorithme de Conway.");
				System.out.println("Merci de choisir une date après 1583.");
				annee = choixAnnee();
				System.out.println();
			}
			datePaques = conwayAlgo(annee);
			jourPaques = jourAnnee(datePaques, annee);
			System.out.println("Selon la méthode de Conway, Paques tombe le " + datePaques[0] +" "+ nomMois.get(datePaques[1]) +" " + annee);
			System.out.println("Soit le " + jourPaques +"ème jour de l'année.");
			break;
		case 6:
			annee = choixAnnee();
			System.out.println();
			while (annee < 325) {
				System.out.println("Pâques n'existait pas avant l'an 325. Merci de choisir une date ultérieure");
				annee = choixAnnee();
				System.out.println();
			}
			jourPaques = jourAnnee(gaussAlgo(annee), annee);
			System.out.println("En "+annee);		
			for (int s : fetesMobiles.keySet()) {
				int[] myBigDay = dateFete(jourPaques+s,annee);
				System.out.println(fetesMobiles.get(s) + " est le " + myBigDay[0]+" " + nomMois.get(myBigDay[1]));
			}			
			break;
		case 7:
			annee = choixAnnee();
			System.out.println();
			while (annee < 325) {
				System.out.println("Pâques n'existait pas avant l'an 325. Merci de choisir une date ultérieure");
				annee = choixAnnee();
				System.out.println();
			}
			System.out.println("Pour la décennie suivant cette date, on célèbre Paques");
			for (int j = 0;j<10;j++) {
				datePaques = gaussAlgo(annee+j);
				System.out.println("le " + datePaques[0] +" "+ nomMois.get(datePaques[1]) +" " + (annee+j));
			}
			break;
		default:
			System.out.println("Merci de choisir une option existante.");
			System.out.println();
			break;
		}
	}
	
	/**
	 * Affiche l'option de terminer le programme ou relancer le menu, puis récupère la selection de l'utilisateur
	 * @return un booléen indiquant si l'execution se poursuit
	 */
	public static boolean selectionPoursuite() {
		System.out.println("Choisissez une option:");
		System.out.println("1 - Continuer et choisir une autre option");
		System.out.println("2 - Terminer");
		int select = scan.nextInt();
		if (select == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Demande à l'utilisateur de selectionner une année
	 * @return l'année selectionnée par l'utilisateur
	 */
	public static int choixAnnee() {
		System.out.println("Choisissez une année :");
		return scan.nextInt();
	}
	
	/**
	 * Vérifie si une année est bissextile
	 * @param annee
	 * @return une valeur booleenne indiquant si l'année est bissextile
	 */
	public static boolean anneeBissextile(int annee) {
		boolean estBissextile = false;
		
		if (annee % 400 == 0) {
			estBissextile = true;
		} else if (annee % 4 ==0 && annee % 100 !=0) {
			estBissextile = true;
		} 
		return estBissextile;
	}
	
	/**
	 * Demande à l'utilisateur de selectionner un mois
	 * @return La valeur du mois selectionné par l'utilisateur
	 */
	public static int choixMois() {
		System.out.println("Choisissez un mois (numero du mois):");
		int mois = scan.nextInt();
		while (mois<1||mois>12) {
			System.out.println("La valeur du mois n'est pas valide");
			System.out.println("Choisissez un mois (numero du mois):");
			mois = scan.nextInt();
		}
		return mois;
	}

	/**
	 * Récupère le nombre de jour dans un mois 
	 * @param mois
	 * @param annee
	 * @return jours le nombre de jours pour le mois et l'année donnés
	 */
	public static int nombreDeJoursAnnee(int mois, int annee) {
		int jours = 0;
		boolean isBissextile = anneeBissextile(annee);
		if (isBissextile) {
			jours = mensuelB[mois-1];
		}else {
			jours = mensuelNB[mois-1];
		}
		return jours;
	}


	/**
	 * Calcule la date de Paques par l'algorythme de Gauss
	 * @param annee
	 * @return un tableau contenant la valeur du jour et du mois de Paques
	 */
	public static int[] gaussAlgo(int annee) {
		int a = annee % 19;
		int b = annee % 4;
		int c = annee % 7;
		int M = 15;
		int N = 6;
		
		if (annee >=1583) {
			int k  = annee / 100;
			int p = (13 + 8*k) / 25;
			int q = k/4;
			M = (15 - p + k - q) % 30;
			N = (4 + k - q) % 7;
		}
		
		int d = (19*a + M) % 30;
		int e = (2*b + 4*c+ 6*d + N ) % 7;
		int H = 22 + d + e;
		
		int[] jourMois = {31,3};
		
		
		if (d == 29 && e == 6) {
			jourMois[0] = 19;
			jourMois[1] = 4;
		} else if (d == 28 && e == 6 && ((12* M)%30)<19) {
			jourMois[0] = 18;
			jourMois[1] = 4;			
		} else if (H > 31) {
			jourMois[0] = d + e - 9;
			jourMois[1] = 4;
		} else {
			jourMois[0] = 22+d+e;
		}
		return jourMois;
	}
	
	/**
	 * Calcule la date de Paques par l'algorythme de Meeus
	 * @param annee
	 * @return un tableau contenant la valeur du jour et du mois de Paques
	 */
	public static int[] meeusAlgo(int annee) {
		int a = annee % 19;
		int b = annee % 4;
		int c = annee % 7;
		int M = 15;
		int d = (19*a + M) % 30;
		int e = (2*b + 4*c - d + 34 ) % 7;
		int f = (d + e + 114) / 31;
		int g = (d + e + 114)% 31;
		
		if (annee >=1583) {
			c = annee / 100;
			int u = annee % 100;
			int s = c / 4;
			int t = c % 4;
			int p = (c + 8) / 25;
			int q = (c+p+1)/3;
			e = (19*a + c - s - q + 15) % 30;
			b = u / 4;
			d = u % 4;
			int L = (2*t + 2*b - e - d + 32) % 7;
			int h = (a + 11*e + 22*L)/451;
			f = (e + L - 7*h + 114) / 31;
			g = (e + L - 7*h + 114) % 31;
		}
		int[] jourMois = {(g + 1),f};
		return jourMois;
	}
	
	/**
	 * Calcule la date de Paques par l'algorythme de Conway
	 * @param annee
	 * @return un tableau contenant la valeur du jour et du mois de Paques
	 */
	public static int[] conwayAlgo(int annee) {
		int s = annee/100;
		int t= annee%100;
		int a = t/4;
		int b = s/4;
		int p = s%4;
		int jps = (9-2*p)/7;
		int jp = (jps+t+a)/7;
		int g = annee%19;
		int G = g+1;
		int r = 8*(s+11)/25;
		int C = r+b-s;
		int d = (11*G +C)%30;
		d = (d+30)%30;
		int h = (551 - 19*d +G)/544;
		int e = (50 - d - h)%7;
		int f = (e +jp)%7;
		int R = 57 - d - f - h;
		
		int[] jourMois = {31,3};
		if (R<=31) {			
			jourMois[0] = R;
		} else {
			jourMois[0] = R-31;
			jourMois[1] = 4;
		}
		return jourMois;
	}
	
	/**
	 * Converti les valeurs de la date de Paques pour le jour et le mois en une seule valeur
	 * le nombre de jours écoulés depuis le début de l'année
	 * @param jourMois tableau contenant 2 valeurs le jour et le mois de Paques
	 * @param annee
	 * @return nombre de jours écoulés avant Pâques pour l'année donnée
	 */
	public static int jourAnnee(int[] jourMois, int annee) {
		int jourPaques = 0;
		if(anneeBissextile(annee)){
			if(jourMois[1]==4) {jourPaques +=31;}
			jourPaques += 31 + 29 + jourMois[0];
		} else {
			if(jourMois[1]==4) {jourPaques +=31;}
			jourPaques += 31 + 28 + jourMois[0];
		}
		return jourPaques;
	}
	
	/**
	 * Converti le nombre de jours écoulés depuis le début de l'année 
	 * en valeurs de jour et mois calendaire pour l'année selectionnée
	 * @param jour
	 * @param annee
	 * @return jourMois un tableau contenant 2 valeurs: le jour et le mois associé au nombre entré
	 */
	public static int[] dateFete(int jour, int annee) {
		int[] jourMois = {1,1};
		int i = 0;
		int[] calendrier = new int[12];
		if (anneeBissextile(annee)){
			calendrier = mensuelB;
		}else {
			calendrier = mensuelNB;
		}
		
		while(jour>0) {
			if (jour> calendrier[i]) {
				jour = jour - calendrier[i];
				jourMois[1]++;
				i++;
			}else {
				jourMois[0] = jour;
				jour = 0;
			}
		}

		return jourMois ;
	}
}
