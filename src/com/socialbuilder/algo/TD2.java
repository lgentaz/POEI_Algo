package com.socialbuilder.algo;

import java.util.Scanner;

public class TD2 {
	
	private final static int solution  = 42;
	
	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//exo1();
		//exo2();
		//exo3();
		//exo4();
		//exo5();
		//exo6();
		//exo7();
		exo7b();
		//exo8();
		//exo8b();
		//exo9();
		//exo10();
		//exo11();

	}
	
	public static void exo1() {
		System.out.println("Jouons à deviner le nombre mystère.");
		System.out.println("Saisissez un nombre entier entre 0 et 100 :");
		
		int reponse = scan.nextInt();
		
		while(reponse != solution) {
			if(reponse > solution) {
				System.out.println("Trop grand. Saisissez à nouveau un nombre : ");
			} else if (reponse < solution) {
				System.out.println("Trop petit. Saisissez à nouveau un nombre : ");
			}
			reponse = scan.nextInt();
		}
		
		System.out.println("Bravo. La réponse est : " + solution);
	}
	
	public static void exo2() {
		System.out.println("On construit un carré de 5 étoiles de coté.");
		String line = "*****";
		for (int i = 0; i<5; i++){
			System.out.println(line);
		}
	}
	
	public static void exo3() {
		System.out.println("On construit une diagonale de n lignes de haut.");
		System.out.println("Choisissez un nombre entre 1 et 10:");
		int n = scan.nextInt();
		System.out.println("De gauche à droite.");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j<i; j++) {
				System.out.print(" ");
			}
			System.out.println("*");
		}
		System.out.println("De droite à gauche.");
		for (int i = n-1; i>=0; i--) {
			for (int j = 0; j<i; j++) {
				System.out.print(" ");
			}
			System.out.println("*");
		}
		
	}
	
	public static void exo4() {
		System.out.println("On construit un triangle rectangle de n lignes de haut.");
		System.out.println("Choisissez un nombre entre 1 et 10:");
		int n = scan.nextInt();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j<=i; j++) {System.out.print("*");}
			System.out.println();
		}
		
	}
	
	public static void exo5() {
		System.out.println("On construit un triangle isocèle de n lignes de haut, pointe en haut.");
		System.out.println("Choisissez un nombre entre 1 et 10:");
		int n = scan.nextInt();
		
		for (int i = 0; i < n; i++) {
			int starNb = i * 2 + 1;
			int spaceNb = n-i-1;
			for (int j = 0; j<spaceNb; j++) {System.out.print(" ");}
			for (int j = 0; j<starNb; j++) {System.out.print("*");}
			System.out.println();
		}
	}
	
	public static void exo6() {
		System.out.println("On construit un triangle rectangle de n lignes de haut, pointe en bas.");
		System.out.println("Choisissez un nombre entre 1 et 10:");
		int n = scan.nextInt();
		
		for (int i = n; i >0; i--) {
			int starNb = i * 2 - 1;
			int spaceNb = n-i;
			for (int j = 0; j<spaceNb; j++) {System.out.print(" ");}
			for (int j = 0; j<starNb; j++) {System.out.print("*");}
			System.out.println();
		}

	}
	
	public static void exo7() {
		System.out.println("Sur combien de lignes voulez-vous voir le résultat? (entier inferieur à 30)");
		int n = scan.nextInt();
		
		for (int i=1;i<=n; i++) {
			if (i%3 ==0) {
				System.out.println("Un noeud-papillon");
			} else if (i%2 ==0) {
				System.out.println("Un sablier");
			} else {
				System.out.println("Une croix");
			}
		}
	}
	
	public static void exo7b() {
		System.out.println("Sur combien de lignes voulez-vous voir le résultat? (entier inferieur à 30)");
		int n = scan.nextInt();
		System.out.println();
		
		System.out.println("Une croix");
		croix(n);
		System.out.println();
		
		System.out.println("Un sablier plein");
		sablier_plein(n);
		System.out.println();
		
		System.out.println("Un sablier vide");
		sablier_vide(n);
		System.out.println();
		
		System.out.println("Un noeud-papillon plein");
		noeudpap_plein(n);
		System.out.println();
		
		System.out.println("Un noeud-papillon vide");
		noeudpap_vide(n);
		System.out.println();
		
	}
	
	public static void croix(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j<n; j++) {
				if (j == i || j == n-i-1) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}
	
	public static void sablier_plein(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j<n; j++) {
				if ((j >= i) && (j <= n-i-1)||(j >= n-i-1) && (j <= i)) {
					System.out.print("* ");
				}
				else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}
	
	public static void sablier_vide(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j<n; j++) {
				if (i ==0 || i==n-1) {System.out.print("* ");}
				else {
					if (j == i || j == n-i-1) {
						System.out.print("* ");
					} else {
						System.out.print("  ");
					}
				}
			}
			System.out.println();
		}
	}
	
	public static void noeudpap_plein(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j<n; j++) {
				if ((j > i) && (j < n-i-1)) {
					System.out.print("  ");
				} else if ((j > n-i-1) && (j < i)) {
					System.out.print("  ");
				}
				else {
					System.out.print("* ");
				}
			}
			System.out.println();
		}
	}
	
	public static void noeudpap_vide(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j<n; j++) {
				if (j ==0 || j==(n-1)) {System.out.print("* ");}
				else {
					if (j == i || j == n-i-1) {
						System.out.print("* ");
					} else {
						System.out.print("  ");
					}
				}
			}
			System.out.println();
		}
		

	}
	
	public static void exo8() {
		
		System.out.println("Jouons nouveau à deviner le nombre mystère.");
		System.out.println("Saisissez un nombre entier entre 0 et 100 :");
		
		int reponse = scan.nextInt();
		int coups = 0;
		
		while(reponse != solution) {
			while (reponse<0 || reponse>100) {
				System.out.println("Merci de bien choisir un entier entre 0 et 100 :");
				reponse = scan.nextInt();
				coups++;
			}
			if(reponse > solution) {
				System.out.println("Trop grand. Saisissez à nouveau un nombre : ");
			} else if (reponse < solution) {
				System.out.println("Trop petit. Saisissez à nouveau un nombre : ");
			}
			if (reponse != solution) {
				reponse = scan.nextInt();
				coups++;
			}
		}
		
		coups++;
		System.out.println("Bravo. La réponse est : " + solution);
		System.out.println("Résultat trouvé en " + coups + " coups.");
		
	}
	
	public static void exo8b() {

		System.out.println("Jouons nouveau à deviner le nombre mystère en moins de 10 coups.");
		System.out.println("Saisissez un nombre entier entre 0 et 100 :");
		
		int reponse = scan.nextInt();
		int coups = 0;
		
		while(reponse != solution && coups<9) {
			while (reponse<0 || reponse>100) {
				System.out.println("Merci de bien choisir un entier entre 0 et 100 :");
				reponse = scan.nextInt();
				coups++;
			}
			if(reponse > solution) {
				System.out.println("Trop grand. Saisissez à nouveau un nombre : ");
			} else if (reponse < solution) {
				System.out.println("Trop petit. Saisissez à nouveau un nombre : ");
			}
			if (reponse != solution) {
				reponse = scan.nextInt();
				coups++;
			}
		}
		if (reponse == solution) {
			coups++;
			System.out.println("Bravo. La réponse est : " + solution);
			System.out.println("Résultat trouvé en " + coups + " coups.");
		} else {
			System.out.println("Raté, vous avez dépassé 10 coups.");
		}
	}
	
	public static void exo9() {		
		System.out.println("Calculons une factorielle.");
		System.out.println("Saisissez l'entier à factoriser:");
		int entier = scan.nextInt();
		int factorielle = 1;
		int variable = entier;
		while(variable>0) {
			factorielle*=variable;
			variable--;
		}
		System.out.println(entier+"! = "+factorielle);
	}
	
	public static void exo10() {
		System.out.println("Calculons une puissance.");
		System.out.println("Saisissez un réel à élever:");
		double a = scan.nextDouble();
		System.out.println("Saisissez un entier pour valeur de la puissance:");
		int b = scan.nextInt();	
		
		double resultat = 1.0;
		for (int i = 0;i<b;i++) {
			resultat *=a;
		}
		
		System.out.println(a + " puissance " + b + " égal "+ resultat);

	}
	
	public static void exo11() {
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
		
		max = TD1.Max2(a, b);
		max = TD1.Max2(max,c);
		
		System.out.println("Le maximum est : " + max);
		
	}

}
