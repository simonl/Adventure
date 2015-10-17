
import java.util.Scanner;

public class DeerGame {

	private static AbstractUI ui = new CommandLineUI("$ ");

	public static void main(String[] args) {

		Player player = new Player();
		boolean continuer = true;

		ui.declare(	"Bienvenue dans mon jeu!\n",
					"Vous etes dans une foret, arme de votre fidele poignard.",
					"Devant vous, vous voyez des chevreuils en train de broutter de l'herbe.",
					"A votre gauche, vous apercevez une buche qui vous semble particuliere.");

		while(continuer) {
		    switch (chooseMain()) {
		    	case ATTACK:
		    		break;
		    	case EXAMINE:
		    		break;
		    	case STATS :
		    		break;
		    	case SHOP :
		    		break;
		     	case QUIT :
		     		continuer = makeSure();
		        	break;
		    	}
		    }

		ui.declare("Merci d'avoir joue!\n");
	}

	private void battle(Fighter f1, Fighter f2) {
		while(true) {
			if(f1.isDead()) {
				f2.loot(f1.reward());
				return;
			}

			f2.getHit(f1.attack());

			if(f2.isDead()) {
				f1.loot(f2.reward());
				return;
			}

			f1.getHit(f2.attack());
		}
	}

	private void shop(Customer customer, Shop shop) {
		while(true) {

			// Initialise shopping behaviour
            customer.startShopping(shop.getGreeting());

            // Make the customer see the products
            for(Good good : shop.getGoods())
                customer.inspect(good);

            //Get his choice
            int choice = customer.makeChoice();
            if(choice == -1) return;

            customer.receive(shop.choose(choice));
		}
	}

	private enum MainChoices {
		ATTACK, EXAMINE, STATS, SHOP, QUIT;

		public static MainChoices fromInt(final int i) {
			switch(i) {
				case 0 : return ATTACK;
				case 1 : return EXAMINE;
				case 2 : return STATS;
				case 3 : return SHOP;
				default: return QUIT;
			}
		}
	}

	private static MainChoices chooseMain() {
		return MainChoices.fromInt(
				ui.select(	"Que voulez-vous faire?",
						 	"Attaquer un chevreuil",
						 	"Examiner la buche",
						 	"Voir tes statistiques",
						 	"Aller au magasin",
						 	"Quitter le jeu") );

	}

	private static boolean makeSure() {
		return !ui.query("Etes-vous sure de vouloir quitter?");
	}

}

