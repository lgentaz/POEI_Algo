package com.socialbuilder.algo;

import java.util.Scanner;

public class JoyeusePaques {
	
	private static final Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Selectionnons une date.");
		int annee = choixAnnee();
		anneeBissextile(annee);

		int mois = choixMois();
		nombreDeJoursAnnee(mois, annee);
		
		System.out.println("Passons au calcul des fêtes mobiles associées à Paques.");
		annee = possiblePaques(annee);
		
		choixMethode(annee);
		
		/*
		 * Dans le programme principal, proposez une interface qui permet de
		 * tester les méthodes précédemment écrites.
		 * Ensuite affichez les dates de pâques pour la décennie à laquelle appartient 
		 * la date saisie parl’utilisateur.
		 */

	}
	
	/**
	 * 
	 * @return La valeur de l'année selectionnée par l'utilisateur
	 */
	
	public static int choixAnnee() {
		System.out.println("Pour quelle année ?"); 
		return scan.nextInt();
	}
	
	/**
	 * 
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
	 * 
	 * @return La valeur du mois selectionné par l'utilisateur
	 */
	public static int choixMois() {
		System.out.println("Pour quel mois ?"); 
		return scan.nextInt();
	}

	/**
	 * 
	 * @param mois
	 * @return Le nombre de jours dans le mois selectionné
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
			System.out.println("La valeur du mois n'est pas valide"); 
			
		}
		return jours;
	}
	
	/**
	 * 
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
		System.out.println("Le mois n°"+ mois + " de l'année "+ annee +" comporte "+jours+" jours.");
		return jours;
	}
	
	/**
	 * 
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
	 * 
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
	 * 
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
		int Q = H - 31;
		
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
	 * 
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
	

	public static void conwayAlgo(int annee) {
		
	}
	
	
	public static void conwayAlgo2() {
		/*
		 * Écrire une version 2 de votre méthode utilisant l’algorithme de Conway qui 
		 * affiche toutes les fêtes mobiles pour une année donnée.
		 */
	}
	
	public static void methode1(int annee) {
		int[] gauss = gaussAlgo(annee);
		int[] meeus = meeusAlgo(annee);
		System.out.println("Selon la méthode gaussienne, Paques tombe le " + gauss[0] +"/"+ gauss[1] +"/" + annee);
		System.out.println("Selon la méthode de Meeus, Paques tombe le " + meeus[0] +"/"+ meeus[1] +"/" + annee);
//		conwayAlgo(annee);
	}
	
	public static void methode2(int annee) {
		System.out.println("Le calcul est impossible avec l’algorithme de Conway.");
		int[] gauss = gaussAlgo(annee);
		int[] meeus = meeusAlgo(annee);
		System.out.println("Selon la méthode gaussienne, Paques tombe le " + gauss[0] +"/"+ gauss[1] +"/" + annee);
		System.out.println("Selon la méthode de Meeus, Paques tombe le " + meeus[0] +"/"+ meeus[1] +"/" + annee);

	}
	
	public static void methode3(int annee) {
		System.out.println("Le calcul est impossible avec l’algorithme de Conway.");
		System.out.println("Le calcul est impossible avec l’algorithme de Meeus.");
		int[] gauss = gaussAlgo(annee);
		System.out.println("Selon la méthode gaussienne, Paques tombe le " + gauss[0] +"/"+ gauss[1] +"/" + annee);

	}
	
	public static void methode4() {
		System.out.println("Le calcul est impossible avec l’algorithme de Conway.");
		System.out.println("Le calcul est impossible avec l’algorithme de Meeus.");
		System.out.println("Le calcul est impossible avec l’algorithme de Gauss.");
	}

}
