package com.socialbuilder.algo;

import java.util.Scanner;

public class ExoCours2 {
	
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		exo2_1();
		exo2_2();
		exo2_3();
		exo2_4();
	}
	public static void exo2_1() {
		int val, dbl;
		val = 231;
		dbl = val * 2;
		System.out.println("val : "+val );
		System.out.println("double numérique : "+dbl );

	}

	public static void exo2_2() {
		System.out.println("Choississez un nombre quelconque:");
		double myNb = scan.nextDouble();
		double mySqr = Math.pow(myNb, 2);
		System.out.println("Voici son carré : "+mySqr);
	}

	public static void exo2_3() {
		System.out.println("Entrez le prix de l'article HT:");
		double prixHT = scan.nextDouble();
		System.out.println("Entrez le nombre d'article:");
		int nbArticle = scan.nextInt();
		System.out.println("Entrez la valeur de la TVA en %:");
		double tva = scan.nextDouble()/100;

		double prixTTC = prixHT + prixHT * tva;
		System.out.println("Article seul TTC: " + prixTTC);
		double totalTTC = prixTTC * nbArticle;
		System.out.println("Total TTC: " + totalTTC);

	}

	public static void exo2_4() {
		String st1 = " belle Marquise";
		String st2 = " vos beaux yeux";
		String st2b = " vos yeux beaux";
		String st3 = " me font";
		String st4 = " mourir";
		String st5 = " d’amour";
		String virgule = ",";
		String point = ".";

		String v1 = st1 + virgule + st2 +  st3 + st4 + st5 + point;
		String v2 = st5 + st4 + st3 + virgule + st1 + virgule + st2 + point;
		String v3 = st2b + st5 + st3 + virgule + st1 + virgule + st4 + point;
		String v4 = st4 + st2 + virgule + st1 + virgule + st5 + st3 + point;
		String v5 = st3 + st2b + st4 + virgule + st1 + virgule + st5 + point;

		v1 = v1.substring(1,2).toUpperCase() + v1.substring(2);
		v2 = v2.substring(1,2).toUpperCase() + v2.substring(2);
		v3 = v3.substring(1,2).toUpperCase() + v3.substring(2);
		v4 = v4.substring(1,2).toUpperCase() + v4.substring(2);
		v5 = v5.substring(1,2).toUpperCase() + v5.substring(2);

		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		System.out.println(v4);
		System.out.println(v5);

	}


}
