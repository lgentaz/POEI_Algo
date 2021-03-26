package com.socialbuilder.algo;

import java.util.Scanner;
import java.util.HashMap;

public class JoyeusePaques {
	
	private static final Scanner scan = new Scanner(System.in);
	
	private static final HashMap<Integer,String> nomMois = new HashMap<Integer,String>(){{
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
	
	private static final HashMap<Integer,String> fetesMobiles = new HashMap<Integer,String>(){{
	    put(-70, "Triodion");
	    put(-63, "Septuagésime");
	    put(-57, "Samedi des âmes");
	    put(-56, "Sexagésime");
	    put(-49, "Quinquagésime");
	    put(-48, "Lunid Gras");
	    put(-47, "Mardi Gras");
	    put(-46, "Mercredi des Cendres");
	    put(-42, "Dimanche de l'Orthodoxie");
	    put(-41, "People's Sunday");
	    put(-21, "Mothering Sunday");
	    put(-14, "Dimanche de la Passion");
	    put(-8, "Samedi de Lazare");
	    put(-7, "Dimanche des Rameaux");
	    put(-3, "Jeudi saint");
	    put(-2, "Vendredi saint");
	    put(-1, "Samedi saint");
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
	
	private static final int[] mensuelNB  = {31,28,31,30,31,30,31,31,30,31,30,31};
	private static final int[] mensuelB  = {31,29,31,30,31,30,31,31,30,31,30,31};
	
	public static void main(String[] args) {
		System.out.println("Travaillons sur le calendrier.");
		int annee = choixAnnee();
		anneeBissextile(annee);

		int mois = choixMois();
		nombreDeJoursAnnee(mois, annee);
		
		System.out.println("Passons au calcul des fêtes mobiles associées à Paques.");
		annee = possiblePaques(annee);
		
		choixMethode(annee);
		
		/*
		
		int[] jourMois = gaussAlgo(annee);
		
		int myDay = jourAnnee(jourMois, annee);
		
		System.out.println("Paques tombe le jour n° "+ myDay);
		
		int[] myBigDay = dateFete(myDay,annee);
		
		System.out.println("Soit"+ myBigDay[0] + "/" + myBigDay[1]);*/
		
		//decenniesPaques(annee);
		
		/*
		 * Ensuite affichez les dates de pâques pour la décennie à laquelle appartient 
		 * la date saisie par l’utilisateur.
		 */

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
	 * Verifie si Paques existe pour l'année donnée
	 * @param annee
	 * 			valeur selectionnée par l'utilisateur
	 * @return La valeur de l'année séléctionnée par l'utilisateur si elle est sup à 33
	 */
	public static int possiblePaques(int annee) {
		while(annee < 33) {
			System.out.println("Veuillez entrer une année après l'an 33 :");
			annee = scan.nextInt();
		}
		return annee;
	}
	
	/**
	 * Demande à l'utilisateur de selectionner un mois
	 * @return La valeur du mois selectionné par l'utilisateur
	 */
	public static int choixMois() {
		System.out.println("Choisissez un mois (numero du mois):");
		return scan.nextInt();
	}

	/**
	 * Determine le nombre de jours dans un mois donné 
	 * en cas particulier (février) demande l'année (verifie si bissextile)
	 * @param mois
	 * @param annee
	 * @return Le nombre de jours dans le mois selectionné en fonction de l'année
	 */
	public static int nombreDeJours(int mois) {
		int jours = 0;
		
		switch(mois) {
		case 1 :
		case 3 : 
		case 5 : 
		case 7 : 
		case 8 : 
		case 10 : 
		case 12 : 
				jours = 31;
				break;
		case 2:
			int annee = choixAnnee();
			if (anneeBissextile(annee)) {
				jours = 29;
			} else {
				jours = 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			jours = 30;
			break;
		default:
			System.out.println("La valeur du mois n'est pas valide. Veuillez entrer un nombre entre 1 et 12"); 
			
		}
		return jours;
	}
	
	/**
	 * Determine le nombre de jours dans un mois donné pour une année spécifique
	 * @param mois
	 * @param annee
	 * @return Le nombre de jours dans le mois selectionné en fonction de l'année
	 */
	public static int nombreDeJoursAnnee(int mois, int annee) {
		int jours = 0;
		switch(mois) {
		case 1 :
		case 3 : 
		case 5 : 
		case 7 : 
		case 8 : 
		case 10 : 
		case 12 : 
			jours = 31;
			break;
		case 2:
			if (anneeBissextile(annee)) {
				jours = 29;
			} else {
				jours = 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			jours = 30;
			break;
		default:
			System.out.println("La valeur du mois n'est pas valide"); 
			
		}
		System.out.println("En "+ nomMois.get(mois) +" "+ annee +", on compte "+jours+" jours.");
		return jours;
	}
	
	/**
	 * Choisis la méthode à appliquer pour le calcule de la date de Paques
	 * @param annee
	 */
	public static void choixMethode(int annee) {
		if (annee >= 1583) {
			methode1(annee);
		} else if (annee >= 326){
			methode2(annee);
		} else if (annee == 325) {
			methode3(annee);
		} else {
			methode4();
		}
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
			System.out.println("L'année "+ annee+ " est bissextile.");
		} else if (annee % 4 ==0 && annee % 100 !=0) {
			estBissextile = true;
			System.out.println("L'année "+ annee+ " est bissextile.");
		} else {
			System.out.println("L'année "+ annee+ " n'est pas bissextile.");
		}
		
		return estBissextile;
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
	
	
	public static void methode1(int annee) {
		int[] gauss = gaussAlgo(annee);
		int[] meeus = meeusAlgo(annee);
		int[] conway = conwayAlgo(annee);
		System.out.println("Selon la méthode gaussienne, Paques tombe le " + gauss[0] +" "+ nomMois.get(gauss[1]) +" " + annee);
		System.out.println("Selon la méthode de Meeus, Paques tombe le " + meeus[0] +" "+ nomMois.get(meeus[1]) +" " + annee);
		System.out.println("Selon la méthode de Conway, Paques tombe le " + conway[0] +" "+ nomMois.get(conway[1]) +" " + annee);
	}
	
	public static void methode2(int annee) {
		System.out.println("Le calcul est impossible avec l’algorithme de Conway.");
		int[] gauss = gaussAlgo(annee);
		int[] meeus = meeusAlgo(annee);
		System.out.println("Selon la méthode gaussienne, Paques tombe le " + gauss[0] +" "+ nomMois.get(gauss[1]) +" " + annee);
		System.out.println("Selon la méthode de Meeus, Paques tombe le " + meeus[0] +" "+ nomMois.get(meeus[1]) +" " + annee);

	}
	
	public static void methode3(int annee) {
		System.out.println("Le calcul est impossible avec l’algorithme de Conway.");
		System.out.println("Le calcul est impossible avec l’algorithme de Meeus.");
		int[] gauss = gaussAlgo(annee);
		System.out.println("Selon la méthode gaussienne, Paques tombe le " + gauss[0] +" "+ nomMois.get(gauss[1]) +" " + annee);

	}
	
	public static void methode4() {
		System.out.println("Désolé, Paques n'existait pas.");
	}

	public static int jourAnnee(int[] jourMois, int annee) {
		int jourPaques = 1;
		if(anneeBissextile(annee)){
			if(jourMois[1]==4) {jourPaques +=31;}
			jourPaques += 31 + 29 + jourMois[0];
		} else {
			if(jourMois[1]==4) {jourPaques +=31;}
			jourPaques += 31 + 28 + jourMois[0];
		}
		return jourPaques;
	}
	
	public static int[] dateFete(int jour, int annee) {
		int[] jourMois = {0,1};
		int i = 0;
		
		if (anneeBissextile(annee)){
			while(jour>0) {
				if (jour> mensuelNB[i]) {
					jour = jour - mensuelNB[i];
					jourMois[1] ++;
					i++;
				} else {
					jourMois[0] = jour;
					jour = 0;
				}
			}
		}else {
			while(jour>0) {
				if (jour> mensuelB[i]) {
					jour = jour - mensuelB[i];
					jourMois[1] ++;
					i++;
				} else {
					jourMois[0] = jour;
					jour = 0;
				}
			}
		}
		return jourMois ;
	}
}
