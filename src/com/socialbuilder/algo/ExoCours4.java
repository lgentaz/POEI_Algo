package com.socialbuilder.algo;

import java.util.Scanner;

public class ExoCours4 {

	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		exo4_2();
		exo4_3();
		exo4_4();
		exo4_5();
		exo4_6();
	}
	
	public static void exo4_2() {
		System.out.println("Quelle heure est-il?");
		System.out.println("Rentrez la valeur des heures:");
		int h = scan.nextInt();

		System.out.println("Rentrez la valeur des minutes:");
		int m = scan.nextInt();
		if (m==59) {
			m = -1;

			if (h==23) {
				h = 0;
			}else {	h++;}
		}
		
		System.out.println("Dans une minute, il sera "+h+" heure(s) "+ (m+1)+".");
	}
	
	public static void exo4_3() {
		System.out.println("Quelle heure est-il?");
		System.out.println("Rentrez la valeur des heures:");
		int h = scan.nextInt();

		System.out.println("Rentrez la valeur des minutes:");
		int m = scan.nextInt();

		System.out.println("Rentrez la valeur des secondes:");
		int s = scan.nextInt();
		
		if (s==59) {
			s = -1;
			if (m==59) {
				m = 0;
				if (h==23) {
					h = 0;
				}else {	h++;}
			} else { m++;}
		}
		
		System.out.println("Dans une seconde, il sera "+h+" heure(s) "+ m+"minute(s) et "+ (s+1)+ "seconde(s).");
		
	}
	
	public static void exo4_4() {
		double prixUnit = 0.1;
		
		System.out.println("Combien de photocopies voulez-vous?");
		int copies = scan.nextInt();
		
		double total;
		
		if (copies<=10) {
			total = copies * prixUnit;
		} else if (copies<=20) {
			total = (copies-10)*0.09 + 1;
		} else {
			total = ((copies-20)*0.08) + 0.9 + 1;
		}
		
		System.out.println("Votre facture est de "+ total+" euros.");
		
	}
	
	public static void exo4_5() {
		System.out.println("Calculons le montant de votre impôt à Zorglub");
		System.out.println("=========");
		System.out.println("Dans quel zone habitez-vous?");
		System.out.println("1 - Zorglub Nord");
		System.out.println("2 - Zorglub Ouest");
		System.out.println("3 - Zorglub Plage");
		System.out.println("4 - Centroglub");
		System.out.println("5 - Pringles");
		
		int zone = scan.nextInt();
		
		double impot;
		
		switch(zone) {
		case 1:
			impot = 99.9;
			break;
		case 2:
			impot = 500;
			break;
		case 3:
			impot = 40.5;
			break;
		case 4:
			impot = 236;
			break;
		case 5:
			impot = 1;
			break;
		default:
			System.out.println("Tricheur!!! Imposé à 1 millions de Zorglouros");
			impot = 1000000;
			break;
		}
		
		System.out.println("=========");
		System.out.println("Quel age avez-vous?");
		int age = scan.nextInt();
		if (age<=21 ) {
			impot = 0;
		}else if (age<= 26 || age > 69) {
			impot = impot * 0.5;
		}
		
		System.out.println("=========");
		System.out.println("Quel est votre prénom?");
		String prenom = scan.next();
		System.out.println("=========");
		if(prenom.equals("Simone")) {
			impot = -5067.40;
			System.out.println("Bravo " + prenom + ", on vous rembourse "+ (-impot)+ " Zorgloubos.");
		} else {
			System.out.println("Votre impot a été calculé " + prenom + ".");
		}

		System.out.println("Vous devez " + impot + " Zorgloubos aux impots.");
	}
	
	public static void exo4_6() {
		System.out.println("Résultat des éléctions en Guignolerie Septentrionale");
		System.out.println("Rentrez le nombre de voix du candidat 1");
		int score1 = scan.nextInt();
		System.out.println("Rentrez le nombre de voix du candidat 2");
		int score2 = scan.nextInt();
		System.out.println("Rentrez le nombre de voix du candidat 3");
		int score3 = scan.nextInt();
		System.out.println("Rentrez le nombre de voix du candidat 4");
		int score4 = scan.nextInt();
		
		int suffrage = score1 + score2 + score3 + score4;
		
		if (score1>=(suffrage/2)) {
			System.out.println("Le candidat 1 est élu.");
		} else if (score1<(suffrage/8)) {
			System.out.println("Le candidat 1 est battu.");
		} else {
			if (score1 >score2 && score1 >score3 && score1 >score4) {
				System.out.println("Le candidat 1 est en ballotage favorable.");
			} else {
				System.out.println("Le candidat 1 est en ballotage défavorable.");
			}
		}

	}
	

}
