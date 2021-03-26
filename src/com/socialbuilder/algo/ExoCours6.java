package com.socialbuilder.algo;

import java.util.Scanner;

public class ExoCours6 {

	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		//exo6_1();
		//exo6_2();
		//exo6_3();
		//exo6_4();
		//exo6_5();
		//exo6_6();
		//exo6_7();
		exo6_8();
		exo6_9();
		exo6_10();
		//tableauDimensions();
		
	}
	
	public static void exo6_1() {
		int[] septInit = new int[7];
		int[] septZero = {0,0,0,0,0,0,0};
		
		System.out.println(septInit[3]);
		System.out.println(septZero[3]);
	}
	
	public static void exo6_2() {
		char[] voyelles = {'a','e','i','o','u','y'};
		
		System.out.println(voyelles);
		System.out.println(voyelles[2]);
	}
	
	public static double[] exo6_3() {
		double[] notes = new double[9];
		
		for(int i = 1; i<=notes.length; i++) {
			System.out.println("Rentrez la note n°"+ i);
			notes[i-1] = scan.nextDouble();
		}
		return notes;
	}
	
	public static void exo6_4() {
		int[] cinq = new int[5];
		int i;
		for(i = 0; i<5; i++) {
			cinq[i] = i*i;
		}
		for(i = 0; i<5; i++) {
			System.out.println(cinq[i]);
		}
	}
	
	public static void exo6_5() {
		int[] six = new int[6];
		int k;
		six[0] = 1;
		for(k = 1; k<six.length; k++) {
			six[k] = six[k-1] + 2;
		}
		for(int s: six) {
			System.out.println(s);
		}
	}
	
	public static void exo6_6() {
		int[] suite = new int[7];
		int i;
		suite[0] = 1;
		suite[1] = 1;
		for(i = 2; i<suite.length; i++) {
			suite[i] = suite[i-1] + suite[i-2];
		}
		for(i = 0; i<suite.length; i++) {
			System.out.println(suite[i]);
		}
	}
	
	public static void exo6_7() {
		double[] notes = exo6_3();
		double sum =  exo6_9(notes);
		double moy = sum/notes.length;
		System.out.println(moy);
	}
	
	public static void exo6_8() {
		System.out.println("Combien de valeurs souhaitez-vous ajouter au tableau (entier entre 1 et 10)?");
		int n = scan.nextInt();
		int[] monTableau = new int[n];
		System.out.println("Rentrez "+n+" entiers positifs ou négatifs dans le tableau.");
		for(int i = 0; i<monTableau.length; i++) {
			System.out.println("Rentrez la valeur n°"+ (i+1));
			monTableau[i] = scan.nextInt();
		}
		int neg = 0;
		int pos =0;
		
		for(int i = 0; i<monTableau.length; i++) {
			if (monTableau[i]>0) {
				pos++;
			} else if (monTableau[i]<0) {
				neg++;
			}
		}
		System.out.println("Il y a "+ pos+ " valeurs positives et "+ neg+ " valeurs négatives.");
	}
	
	public static double exo6_9(double[] tab) {
		double sum = 0;
		for (double t : tab) {
			sum += t;
		}
		System.out.println(sum);
		return sum;
	}
	
	public static void exo6_10() {

	}
	
	public static void tableauDimensions() {
		int[][] tab = new int[5][5];
		for (int i = 0; i<tab.length; i++) {
			for (int j = 0; j<tab[i].length; j++) {
				tab[i][j] = i*j;
				System.out.print(tab[i][j]+ " | ");
			}
			System.out.println();
		}
	}
	
	
}
