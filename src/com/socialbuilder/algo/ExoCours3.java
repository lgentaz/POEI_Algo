package com.socialbuilder.algo;

import java.util.Scanner;

public class ExoCours3 {
	
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		exo3_1();
		exo3_2();	
		exo3_3();		
		exo3_4();
		exo3_5();
		exo3_6();
		loiMorgan();
	}

	public static void exo3_1() {
		System.out.println("Entrez un nombre réel:");
		double reel = scan.nextDouble();
		if (reel>=0) {
			System.out.println("Le nombre est positif.");
		}else {
			System.out.println("Le nombre est négatif.");
		}
	}

	public static void exo3_2() {
		System.out.println("Entrez un premier nombre réel:");
		double reel1 = scan.nextDouble();
		System.out.println("Entrez un second nombre réel:");
		double reel2 = scan.nextDouble();

		if (reel1>=0 && reel2>=0) {
			System.out.println("Le produit de ses nombres est positif.");
		} else if (reel1<0 && reel2<0) {
			System.out.println("Le produit de ses nombres est positif.");
		} else {
			System.out.println("Le produit de ses nombres est négatif.");
		}

	}

	public static void exo3_3() {
		System.out.println("Entrez un premier nom:");
		String nom1 = scan.next();
		System.out.println("Entrez un second nom:");
		String nom2 = scan.next();
		System.out.println("Entrez un troisième nom:");
		String nom3 = scan.next();

		if (nom2.compareTo(nom1)>=0 && nom3.compareTo(nom2)>=0) {
			System.out.println("Les noms sont bien dans l'ordre alphabétique.");
		} else {
			System.out.println("Les noms ne sont pas dans l'ordre alphabétique.");
		}

	}

	public static void exo3_4() {
		System.out.println("Entrez un nombre réel:");
		double reel = scan.nextDouble();
		if (reel>0) {
			System.out.println("Le nombre est positif.");
		}else if (reel ==0){
			System.out.println("Le nombre est nul.");
		} else
			System.out.println("Le nombre est négatif.");
	}


	public static void exo3_5() {
		System.out.println("Entrez un premier nombre réel:");
		double reel1 = scan.nextDouble();
		System.out.println("Entrez un second nombre réel:");
		double reel2 = scan.nextDouble();
	
		if (reel1>0 && reel2>0) {
			System.out.println("Le produit de ses nombres est positif.");
		} else if (reel1<0 && reel2<0) {
			System.out.println("Le produit de ses nombres est positif.");
		} else if (reel1==0 || reel2==0) {
			System.out.println("Le produit est nul.");
		} else {
			System.out.println("Le produit de ses nombres est négatif.");
		}
	}

	public static void exo3_6() {
		System.out.println("Entrez l'age de votre enfant:");
		int age = scan.nextInt();
	
		switch(age) {
			case 6:
			case 7:
				System.out.println("Poussin");
				break;
			case 8:
			case 9:
				System.out.println("Pupille");
				break;
			case 10:
			case 11:
				System.out.println("Minime");
				break;
			default:
				if (age<6) {
					System.out.println("Désolé, trop jeune");
				} else if (age>=18){
					System.out.println("Réservé aux enfants");
				} else {
					System.out.println("Cadet");
				}
				break;
		}
	}


	public static void loiMorgan() {
		String chaine1 = "oui";
		String chaine2 = "vrai";
	
		System.out.println("oui ou non?");
		String entree1 =scan.next();
		System.out.println("vrai ou faux?");
		String entree2 = scan.next();
	
		System.out.println("_ _ _ _ _");
	
		System.out.println("A et B");
		if (chaine1.equals(entree1) && chaine2.equals(entree2)) {
			System.out.println("Quel optimisme!");
		} else {
			System.out.println("Pas cool.");
		}
	
		System.out.println("non A ou non B");
		if (!(chaine1.equals(entree1)) || !(chaine2.equals(entree2))) {
			System.out.println("Pas cool.");
		} else {
			System.out.println("Quel optimisme!");
		}
	}


}
