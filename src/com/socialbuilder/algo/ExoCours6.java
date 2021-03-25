package com.socialbuilder.algo;

import java.util.Scanner;

public class ExoCours6 {

	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		//exo6_1();
		//exo6_2();
		//exo6_3();
		//exo6_4();
		exo6_5();
		
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
	
	public static void exo6_3() {
		double[] notes = new double[9];
		
		for(int i = 1; i<=notes.length; i++) {
			System.out.println("Rentrez la note n°"+ i);
			notes[i-1] = scan.nextDouble();
		}
		System.out.println(notes[5]);
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
		int i, k;
		six[0] = 1;
		for(k = 1; k<6; k++) {
			six[k] = six[k-1] + 2;
		}
		for(i = 0; i<6; i++) {
			System.out.println(six[i]);
		}
	}
	
	public static void exo6_6() {

	}
	
	public static void exo6_7() {

	}
	
	public static void exo6_8() {

	}
	
	public static void exo6_9() {

	}
	
	public static void exo6_10() {

	}
	
	
}
