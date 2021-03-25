package com.socialbuilder.algo;

import java.util.Scanner;

public class ExoCours1 {
	
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		exo1_1();
		exo1_2();
		exo1_3();
		exo1_4();
		exo1_5();
		exo1_6();
		exo1_7();
		exo1_8();
		exo1_9();
	}

	public static void exo1_1() {
		int a, b;
		System.out.println("exo1_1");
		a = 1;
		b = a + 3;
		a = 3;
		System.out.println("a :"+a + " b :"+b);
	}

	public static void exo1_2() {
		int a, b, c;
		System.out.println("exo1_2");
		a = 5;
		b = 3;
		c = a+ b;
		System.out.println("a :"+a + " b :"+b + " c :"+c);
		a = 2;
		c = b-a;	
		System.out.println("a :"+a + " b :"+b + " c :"+c);
	}

	public static void exo1_3() {
		int a, b;
		System.out.println("exo1_3");
		a = 5;
		b = a+ 4;
		System.out.println("a :"+a + " b :"+b);
		a = a + 1;
		b = a - 4;
		System.out.println("a :"+a + " b :"+b);
	}

	public static void exo1_4() {
		int a, b, c;
		System.out.println("exo1_4");
		a = 3;
		b = 10;
		c = a + b;
		System.out.println("a :"+a + " b :"+b + " c :"+c);
		b = a + b;
		a = c;
		System.out.println("a :"+a + " b :"+b + " c :"+c);
	}

	public static void exo1_5() {
		int a, b;
		System.out.println("exo1_5");
		a = 5;
		b = 2;
		a = b;
		b = a;
		System.out.println("a :"+a + " b :"+b);
		a = 5;
		b = 2;
		b = a;
		a = b;
		System.out.println("a :"+a + " b :"+b);
	}

	public static void exo1_6() {
		int a, b, c;
		System.out.println("exo1_6");
		a = 5;
		b = 2;
		System.out.println("a :"+a + " b :"+b);
		c = b;
		b = a;
		a = c;
		System.out.println("a :"+a + " b :"+b);
	}

	public static void exo1_7() {
		int a, b, c, d;
		System.out.println("exo1_7");
		a = 5;
		b = 2;
		c = 8;
		System.out.println("a :"+a + " b :"+b+ " c :"+c);
		d = c;
		c = b;
		b = a;
		a = d;
		System.out.println("a :"+a + " b :"+b+ " c :"+c);
	}

	public static void exo1_8() {
		int a, b, c;
		System.out.println("exo1_8");
		a = 432;
		b = 12;
		c = a + b;
		System.out.println("a :"+a + " b :"+b+ " c :"+c);
	}

	public static void exo1_9() {
		String a, b, c;
		System.out.println("exo1_9");
		a = "432";
		b = "12";
		c = a + b;
		System.out.println("a :"+a + " b :"+b+ " c :"+c);
	}


}
