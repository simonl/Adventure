import java.util.Scanner;

public class Game {

	private static final Scanner keyboard = new Scanner(System.in);

	public static void main(final String[] args) {

		System.out.println("\n Bienvenue dans mon jeu!");
		System.out.println("\n Vous etes dans une foret, arme de votre fidele poignard.");
		System.out.println(" Devant vous, vous voyez des chevreuils en train de broutter de l'herbe.");
		System.out.println(" A votre gauche, vous apercevez une buche qui vous semble particuliere.");

		boolean quitter = false;
		Joueur joueur = new Joueur();

		do {

			System.out.println("\n *******************************");
			System.out.println("\n Que voulez-vous faire?");
			System.out.println("	1. Attaquer un chevreuil");
			System.out.println("	2. Examiner la buche");
			System.out.println("	3. Voir tes statistiques");
			System.out.println("	4. Aller au magasin");
			System.out.println("	5. Quitter le jeu");

			System.out.print("\n > ");
			final int choixForet = keyboard.nextInt();

			switch(choixForet) {

				case 1: {
					combat(joueur);

				} break;
				case 2: {
					inspection(joueur);
				} break;
				case 3: {
					statistiques(joueur);
				} break;
				case 4: {
					magasin(joueur);
				} break;
				case 5: {
					System.out.println("\n Etes-vous sure de vouloir quitter?");
					System.out.println("	1. Oui");
					System.out.println("	2. Non");

					System.out.print("\n > ");
					final int choixQuitter = keyboard.nextInt();

					quitter = choixQuitter == 1;
				} break;
			}

		} while(joueur.vie > 0);

		System.out.println("\n Merci d'avoir joue!\n");
	}


	public static void combat(final Joueur p) {

		final long niveau = p.compteCombats;
		p.compteCombats++;

		final long totalVie = (long) (Math.random() * niveau) + 20;
		long vie = totalVie;

		final long minAttaque = niveau;
		final long maxAttaque = (long) (Math.random() * niveau) + 5;

		for(int tours = 1; vie > 0 && p.vie > 0; tours++) {
			System.out.println("\n ----------------------------- Tour " + tours + " -------------------------------");

			System.out.println("\n - Vous avez " + p.vie + "/" + p.maxVie + " hp");
			System.out.println(" - Une arme qui frappe de " + p.minAttaque + " a " + p.maxAttaque);
			System.out.println(" - Une regeneration de " + p.regen + " hp");
			System.out.println(" - Une armure qui vous protege de " + p.armure);
			System.out.println(" - Un animal qui attaque de " + p.minAnimal + " a " + p.maxAnimal);


			System.out.println("\n Les statistiques de l'ennemi:");

			if(p.niveauVue > 0) {

				System.out.println("	- " + vie + "/" + totalVie + " hp");

				if(p.niveauVue > 1) {

					System.out.println("	- Des sabots qui attaquent de " + minAttaque + " a " + maxAttaque);

					if(p.niveauVue > 2) {

						System.out.println("	- Cet ennemi donne " + niveau * 15 + " experience de combat");

					}
				}
			} else {

				System.out.println("	- ???");

			}


			System.out.println("\n Choisissez:");
			System.out.println("	1. Attaquer (Ennemi)");
			System.out.println("	2. Regenerer (Vous)");
			System.out.println("	3. Prendre la fuite");

			System.out.print("\n > ");
			final int choixCombat = keyboard.nextInt();

			switch(choixCombat) {
				case 1: {

					final long pAttaque = (long) (Math.random() * (p.maxAttaque - p.minAttaque)) + p.minAttaque;
					vie -= pAttaque;

					System.out.println("\n Vous attaquez l'ennemi de " + pAttaque + " hp");

				} break;
				case 2: {
					p.vie += p.regen;

					if(p.vie > p.maxVie) p.vie = p.maxVie;

					System.out.println("\n Vous vous regenerez de " + p.regen + " hp");

				} break;
				case 3: {

					p.vie = 0;

					System.out.println(" \n Vous tentez de prendre la fuite mais sans success.");
					System.out.println(" L'ennemi vous planque au sol et vous dechire les entrailles");

				} continue;
				default: continue;
			}

			if(p.aUnAnimal) {
				final long aAttaque = (long) (Math.random() * (p.maxAnimal - p.minAnimal)) + p.minAnimal;
				vie -= aAttaque;

				System.out.println(" Votre animal attaque de " + aAttaque + " hp");
			}

			if(vie > 0) {
				final long eAttaque = (long) (Math.random() * (maxAttaque - minAttaque)) + minAttaque;
				p.vie -= eAttaque;

				if(p.aUneArmure)
					p.vie += p.armure;

				System.out.println(" L'ennemi vous attaque de " + eAttaque + " hp");
			}
		}

		if(p.vie > 0) {
			final long or = 5 * niveau + 15;
			final long exp = 5 * niveau + 15;

			p.or += or;
			p.expCombat += exp;

			System.out.println("\n Vous avez vaincu l'ennemi!");
			System.out.println(" Vous gagnez " + exp + " experience de combat et " + or + " pieces d'or!");

			niveauCombat(p);
		}
	}

	public static void niveauCombat(final Joueur p) {
		if(p.expCombat >= (p.niveauCombat * p.niveauCombat * 15) && p.niveauCombat < 100) {

			p.niveauCombat ++;
			p.regen += 2;
			p.armure ++;
			p.minAttaque ++;
			p.maxAttaque += 2;
			p.maxVie += 5;

			System.out.println("\n Bravo! Vous etes maintenant un guerrier de niveau " + p.niveauCombat + "!");
			System.out.println(" Vos habiletes ont ete ameliores.");

		}
	}

	public static void niveauVue(final Joueur p) {
		switch((int) p.niveauVue) {

			case 0: if(p.expVue >= 50) {
				p.niveauVue++;

				System.out.println("\n Bravo! vous etes maintenant un observateur de niveau " + p.niveauVue + ".");
				System.out.println(" Vous pouvez maintenant voir les hp de vos ennemis.");

			} break;
			case 1: if(p.expVue >= 125) {
				p.niveauVue++;

				System.out.println("\n Bravo! vous etes maintenant un observateur de niveau " + p.niveauVue + ".");
				System.out.println(" Vous pouvez maintenant voir la puissance de vos ennemis.");

			} break;
			case 2: if(p.expVue >= 300) {
				p.niveauVue++;

				System.out.println("\n Bravo! vous etes maintenant un observateur de niveau " + p.niveauVue + ".");
				System.out.println(" Vous pouvez maintenant voir l'experience que vos ennemis vous donneront.");

			}
		}
	}

	public static void inspection(final Joueur p) {

		final long niveau = p.compteBuches;
		p.compteBuches ++;

		System.out.println("\n Comme vous vous en doutiez tout a l'heure,");
		System.out.println(" le tronc est bel et bien sculpte en forme de chevreuil!");

		p.expVue += 5 * niveau + 15;
		niveauVue(p);

		final double combat = Math.random();

		if(combat < 0.5) {

			System.out.println("\n Un chevreuil ne semble pas etre d'accord avec ce que vous faites.");
			System.out.println(" Il vous charge dans le dos et vous enleve 5 hp!");

			p.vie -= 5;
			combat(p);
		}
	}

	public static void statistiques(final Joueur p) {
		System.out.println("\n -------------------------- Vos Statistiques --------------------------\n");

		System.out.println(" - Vous avez " + p.vie + "/" + p.maxVie + " hp");
		System.out.println(" - Une arme qui frappe de " + p.minAttaque + " a " + p.maxAttaque);
		System.out.println(" - Une regeneration de " + p.regen + " hp");

		if(p.aUneArmure)
			System.out.println(" - Une armure qui vous protege de " + p.armure);

		if(p.aUnAnimal)
			System.out.println(" - Un animal qui attaque de " + p.minAnimal + " a " + p.maxAnimal);

		System.out.println(" - Une reseve de " + p.or + " pieces d'or");

		System.out.println("\n Vous etes un guerrier de niveau " + p.niveauCombat + " pour un total de " + p.expCombat + " experience de combat");
		System.out.println(" Vous etes un observateur de niveau " + p.niveauVue + " pour un total de " + p.expVue + " experience de vision");
		System.out.println(" Vous avez combattu " + p.compteCombats + " ennemis");
		System.out.println(" Vous avez examine " + p.compteBuches + " objects");
	}




	private static boolean venduEpeeSimple = false;
	private static final long prixEpeeSimple = 50;

	private static boolean venduArmureSimple = false;
	private static final long prixArmureSimple = 100;

	private static boolean venduSortRegen = false;
	private static final long prixSortRegen = 150;

	private static boolean venduDindon = false;
	private static final long prixDindon = 250;

	public static void magasin(final Joueur p) {

		System.out.println("\n +++++++++++++++++++++++++++++++++ Magasin +++++++++++++++++++++++++++++++++++");
		System.out.println("\n Bienvenue au magasin! Ici, vous pouvez acheter toute sorte d'equipement.");

		System.out.println(" ------------------ Vous avex presentement " + p.or + " pieces d'or.");

		System.out.println("\n Vous voulez acheter:");
		System.out.println("	1. Epee simple : " + prixEpeeSimple);
		System.out.println("	2. Armure simple : " + prixArmureSimple);
		System.out.println("	3. Sort Regen : " + prixSortRegen);
		System.out.println("	4. Dindon Domestique : " + prixDindon);

	}


	private static class Joueur {


		public long vie = 30, maxVie = 30;
		public long minAttaque = 1, maxAttaque = 5;
		public long regen = 7;

		public boolean aUneArmure = false;
		public long armure = 0;

		public long or = 0;

		public long niveauCombat = 0, expCombat = 0;
		public long niveauVue = 0, expVue = 0;

		public long compteCombats = 0, compteBuches = 0;

		public boolean aUnAnimal = false;
		public long minAnimal = 0, maxAnimal = 0;

	}

}