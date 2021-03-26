package com.socialbuilder.algo;

import java.util.Scanner;


public class TD1 {

	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		exo1();
		exo2();
		exo3();
		exo4();
		exo5();
		exo5bis();
		exo6while();
		exo6for();
		exo7();
		exo8();				
		exo9();
		exo12();

	}

/**
 * Concaténation 2 fois d'une syllabe choisie par l'utilisateur
 */
	public static void exo1() {

		System.out.println("Saisissez une syllabe:");
		String syllabe = scan.nextLine();
		String doubleSyllabe = syllabe + syllabe;
		
		System.out.println("Votre syllabe dédoublée est : " + doubleSyllabe);

	}
	
	/**
	 * Permute les 2 chaines de caractères choisies par l'utilisateur
	 */
	public static void exo2() {

		System.out.println("Saisissez une chaine de caractère:");
		String var1 = scan.nextLine();
		System.out.println("Saisissez une seconde chaine de caractère:");
		String var2 = scan.nextLine();	
		
		
		System.out.println("var1 = "+ var1 + ", var2  =  " + var2);
		
		String permute = var1;
		var1 = var2;
		var2 = permute;
		
		System.out.println("var1 = "+ var1 + ", var2  =  " + var2);

	}
	
	/**
	 * Trouve le maximum de 2 entiers choisis par l'utilisateur
	 */
	public static void exo3() {
		int max;		
		System.out.println("Calculons le maximum de 2 nombres.");
		System.out.println("Saisissez un premier nombre:");
		int a = scan.nextInt();
		System.out.println("Saisissez le second:");
		int b = scan.nextInt();	
		
		if (a ==b) {System.out.println("Les deux nombres sont identiques.");}
		
		max = Max2(a, b);
		System.out.println("Le maximum est : " + max);
	}
	
	/**
	 * Trouve le max de 2 entiers le retourne
	 * @param a un premier entier
	 * @param b un second entier
	 * @return le max des 2 entiers a et b
	 */
	public static int Max2(int a, int b) {
		if (a >=b) {
			return a;
		}  else {
			return b;
		}
	}
	
	 /**
	  * Controle le calcul d'une somme
	  * Demande 2 entiers à l'utilisateur, demande la valeur de leur somme 
	  * et verifie que l'entier donné par l'utilisateur est la valeur correcte
	  */
	public static void exo4() {
		System.out.println("Testons l'addition.");
		System.out.println("Saisissez un premier nombre:");
		int a = scan.nextInt();
		System.out.println("Saisissez le second:");
		int b = scan.nextInt();	
		
		System.out.println("Saississez la valeur de la somme des deux nombres précédents:");
		int r = scan.nextInt();	
		
		if (r == (a+b)) {
			System.out.println("Bravo !");
		} else {
			System.out.println("Retourne en primaire :-(");
		}
		
	}
	
	/**
	 * Trouve le maximum de 3 entiers choisis par l'utilisateur
	 * fait appel à la methode Max2()
	 */
	public static void exo5() {
		int max;		
		System.out.println("Calculons le maximum de 3 nombres.");
		System.out.println("Saisissez un premier nombre:");
		int a = scan.nextInt();
		System.out.println("Saisissez le second:");
		int b = scan.nextInt();	
		System.out.println("Saisissez le troisième:");
		int c = scan.nextInt();	
		
		if (a ==b || b==c|| a==c) {
			System.out.println("Des nombres sont identiques.");
		}
		
		max = Max2(a,b);
		max = Max2(max,c);
		
		System.out.println("Le maximum est : " + max);
	}
	
	/**
	 * Trouve le maximum de 3 entiers choisis par l'utilisateur
	 */
	public static void exo5bis() {
		int max;		
		System.out.println("Calculons le maximum de 3 nombres.");
		System.out.println("Saisissez un premier nombre:");
		int a = scan.nextInt();
		System.out.println("Saisissez le second:");
		int b = scan.nextInt();	
		System.out.println("Saisissez le troisième:");
		int c = scan.nextInt();	
		
		if (a ==b || b==c|| a==c) {
			System.out.println("Des nombres sont identiques.");
		}
		
		if (a >=b || c >=b) {
			if (a>=c) {
				max = a;
			} else {
				max = c;
			}
		}  else {
			max = b;
		}
		
		System.out.println("Le maximum est : " + max);
	}
	
	/**
	 * Répete 20 fois l'instruction; utilise une boucle while
	 */
	public static void exo6while() {
		System.out.println("20 répétitions avec la boucle while");
		String tourne = "ca tourne";
		int rep = 0;
		while(rep<20) {
			System.out.println("n°" + (rep+ 1) + " : " +tourne);
			rep++;
		}
	}

	/**
	 * Répete 20 fois l'instruction; utilise une boucle for
	 */
	public static void exo6for() {
		System.out.println("20 répétitions avec la boucle for");
		String tourne = "ca tourne";

		for(int rep = 0; rep < 20; rep++) {
			System.out.println("n°" + (rep+ 1) + " : " +tourne);
		}
	}
	
	/**
	 * Liste les n premiers entiers, valeur de n choisie par l'utilisateur, du plus petit au plus grand
	 */
	public static void exo7() {
		System.out.println("Listons les n premiers entiers positifs.");
		System.out.println("Choisissez la valeur de n:");
		int n = scan.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println(i);
		}

	}
	
	/**
	 * Liste les n premiers entiers, valeur de n choisie par l'utilisateur, du plus grand au plus petit
	 */	
	public static void exo8() {
		System.out.println("Compte à rebours jusqu'à 1.");
		System.out.println("Quelle est la valeur de départ? (entier positif)");
		int n = scan.nextInt();
		
		while (n>0) {
			System.out.println(n);
			n--;
		}

	}
	
	/**
	 * Calcule la somme de n entiers positifs successifs en partant de 0
	 * n est choisi par l'utilisateur
	 */
	public static void exo9() {
		System.out.println("On cherche a additionner n nombres.");
		System.out.println("Choisissez un entier n positif:");
		int n = scan.nextInt();
		int somme = 0;
		
		for (int i = 1; i<=n; i++) {
			somme = somme + i;
		}
		
		System.out.println("La somme des "+ n + " premiers entiers positifs est : " + somme);
	}
	
	/**
	 * Calcule la somme de n entiers positifs successifs en partant de 0
	 * n est choisi par l'utilisateur
	 * Vérifie que la valeur entrée soit bien positive
	 */
	public static void exo12() {
		System.out.println("On cherche a additionner n nombres.");
		System.out.println("Choisissez un entier n positif:");
		int n = scan.nextInt();
		int somme = 0;

		while (n<=0) {
			System.out.println("Merci de bien donner un entier n positif:");
			n = scan.nextInt();
		}
		
		for (int i = 1; i<=n; i++) {
			somme = somme + i;
		}
		
		System.out.println("La somme des "+ n + " premiers entiers positifs est : " + somme);

	}
	
}
