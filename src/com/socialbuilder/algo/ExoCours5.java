package com.socialbuilder.algo;

import java.util.Scanner;

public class ExoCours5 {

	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		exo5_1();
		exo5_2();
		exo5_3();
		exo5_4();
		exo5_5();
		exo5_6();
		exo5_7();
		exo5_8();
		exo5_9();
		exo5_10();
	}

	public static void exo5_1() {
		System.out.println("Entrez un nombre réel compris entre 1 et 3 inclus");
		double n = scan.nextDouble();
		
		while (n>3 || n<1) {
			System.out.println("Merci de bien choisir un réel entre 1 et 3 inclus");
			n = scan.nextDouble();
		}
		
		System.out.println(n+" est bien un réel compris entre 1 et 3.");

	}
	
	public static void exo5_2() {
		System.out.println("Entrez un nombre réel compris entre 10 et 20 inclus");
		double n = scan.nextDouble();
		
		while (n>20 || n<10) {
			if(n<10) {
				System.out.println("Trop petit!");
			} else {
				System.out.println("Trop grand!");
			}
			System.out.println("Merci de bien choisir un nombre entre 10 et 20");
			n = scan.nextDouble();
		}
		
		System.out.println(n+" est bien un réel compris entre 10 et 20.");

	}
	
	public static void exo5_3() {
		System.out.println("On affiche les 10 nombres suivants.");
		System.out.println("Choisissez un nombre entier de départ");
		int n = scan.nextInt();
		
		for (int i = 0; i<10; i++) {
			n++;
			System.out.println(n);
		}
	}
	
	public static void exo5_4() {
		System.out.println("On affiche la table de multiplication.");
		System.out.println("Choisissez un nombre entier de départ");
		int n = scan.nextInt();
		int produit;
		
		for (int i = 1; i<=10; i++) {
			produit = i*n;
			System.out.println(n+" x "+i+" = "+produit);
		}
	}
	
	public static void exo5_5() {
		TD1.exo9();
	}
	
	public static void exo5_6() {
		TD2.exo9();
	}
	
	public static void exo5_7() {
		int n;
		int max = 0;
		int posMax = 0;
		for(int i = 1; i<=20;i++) {
			System.out.println("Entrez le nombre entier n°" + i + " : ");
			n = scan.nextInt();
			if(n>max) {
				max = n;
				posMax = i;
			}
		}
		System.out.println("Le plus grand de ces nombres est " + max );
		System.out.println("C'était le nombre numéro " + posMax );
	}

	
	public static void exo5_8() {
		System.out.println("On cherche le maximum d'une liste d'entier");
		System.out.println("Le programme s'arrête lorque vous entrez 0.");
		int n;
		int max = 0;
		int posMax = 0;
		int i = 1;
		System.out.println("Entrez le nombre entier n°" + i + " : ");
		n = scan.nextInt();
		while(n!=0) {
			if(n>max) {
				max = n;
				posMax = i;
			}
			i++;
			System.out.println("Entrez le nombre entier n°" + i + " : ");
			n = scan.nextInt();
		}
		System.out.println("Le plus grand de ces nombres est " + max );
		System.out.println("C'était le nombre numéro " + posMax );
	}
	
	public static void exo5_9() {
		System.out.println("Passons les achats en caisse (les prix sont des entiers)");
		System.out.println("Pour signaler qu'il n'y a plus d'article à passer, entrez 0.");
		int n;
		int total = 0;
		int paye = 0;
		int monnaie;
		System.out.println("Prix du premier article: ");
		n = scan.nextInt();
		while(n!=0) {
			total += n;
			System.out.println("Sous-total "+ total + " €.  ");
			System.out.println("Prix de l'article suivant: ");
			n = scan.nextInt();
		}
		System.out.println("Le montant total est de " + total + " €.");
		System.out.println("======== ");
		System.out.println("Quel montant donnez-vous?");
		paye = scan.nextInt();
		while (paye<total) {
			System.out.println("Montant insuffisant. Il manque "+ (total - paye) +"€. Combien ajoutez-vous?" );
			paye += scan.nextInt();
		}
		System.out.println("======== ");
		monnaie = paye - total;
		System.out.println("Merci. Nous vous rendons vos "+ monnaie +" € de monnaie.");
		System.out.println("...");
		
		int especes = monnaie / 50;
		monnaie -= especes*50;
		for (int i = 0;i<especes;i++) {System.out.println("50€");}
		especes = (monnaie) / 20;
		monnaie -= especes*20;
		for (int i = 0;i<especes;i++) {System.out.println("20€");}
		especes = (monnaie) / 10;
		monnaie -= especes*10;
		for (int i = 0;i<especes;i++)  {System.out.println("10€");}
		especes = (monnaie) / 5;
		monnaie -= especes*5;
		for (int i = 0;i<especes;i++) {System.out.println("5€");}
		especes = (monnaie) / 2;
		monnaie -= especes*2;
		for (int i = 0;i<especes;i++)  {System.out.println("2€");}
		especes = (monnaie) / 1;
		monnaie -= especes*1;
		for (int i = 0;i<especes;i++)  {System.out.println("1€");}
		
	}
	
	public static void exo5_10() {
		System.out.println("Les courses, c'est ma grande passion. - O.S.");
		System.out.println("Combien de chevaux au départ de la course?");
		int partants = scan.nextInt();
		System.out.println("Combien de chevaux joués?");
		int joues = scan.nextInt();
		int ordre = calculX(partants,joues);
		int desordre = calculY(partants,joues);
		
		System.out.println("Dans l'ordre: une chance sur "+ ordre +" de gagner");
		System.out.println("Dans le désordre: une chance sur "+ desordre +" de gagner");
	}
	
	/**
	 * 
	 * @param i
	 * @return fact
	 */
	
	public static int fact(int i) {
		int fact = 1;
		while(i>0) {
			fact*=i;
			i--;
		}
		return fact;
	}
	
	/**
	 * 
	 * @param i
	 * @param j
	 * @return x
	 */
	
	public static int calculX(int i, int j) {
		int x = fact(i) / fact(i-j);
		return x;
	}
	
	/**
	 * 
	 * @param i
	 * @param j
	 * @return y
	 */
	public static int calculY(int i, int j) {
		int y = calculX(i,j)/fact(j);
		return y;
	}
	
}
