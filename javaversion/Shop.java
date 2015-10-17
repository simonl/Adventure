
public class Shop {

	private static enum Keeper { EASY, MEDIUM, HARD }

	private Keeper keeper = Keeper.EASY;

	private static class Good {
		private final Item item;
		private final int price;

		public Good(final Item item, final int price) {
			this.item = item;
			this.price = price;
		}
	}

	private List<Good> goods = new ArrayList(

	private long sword1Price = 50, armor1Price = 100, heal1Price = 150, dindonPrice = 250;
	private long sword2Price = 500, armor2Price = 1000, heal2Price = 1500, whistlePrice = 2500;
	private long sword3Price = 5000, armor3Price = 10000, heal3Price = 15000, globePrice = 25000;

	private long sword1Bonus = 5, armor1Bonus = 5, heal1Bonus = 5, dindonBonus = 10;
	private long sword2Bonus = 10, armor2Bonus = 10, heal2Bonus = 10, whistleBonus = 5;
	private long sword3Bonus = 50, armor3Bonus = 10000, heal3Bonus = 15000, globeBonus = 25000;

	private boolean sword1Sold = false, armor1Sold = false, heal1Sold = false, dindonSold = false;
	private boolean sword2Sold = false, armor2Sold = false, heal2Sold = false, whistleSold = false;
	private boolean sword3Sold = false, armor3Sold = false, heal3Sold = false, globeSold = false;



	public void sell(final Player player, int price, boolean sold, Thunk action) {
		if(player.gold < price)
			ui.declare(
				"\nVous n'avez pas assez de pieces d'or pour effectuer cet achat!");
		else if(sold)
			ui.declare(
				"\nVous avez deja achete cet article!");
		else {
			player.gold -= price;
			action();
		}
	}


	public void shop(final Player player, final AbstractUI ui) {
		ui.declare(
			"\n+++++++++++++++++++++++++++++ Magasin ++++++++++++++++++++++++++++++++++",
			"\nBienvenue au magasin! Ici, vous pouvez acheter toute sorte d'equipement.");

		do{
			ui.declare(
				"-----------------------------------------",
				"Vous avez presentement " + player.gold + " pieces d'or.");

			int shopChoice;
			int numChoices;
			switch(this.keeper) {
				case EASY : {
					numChoices = 5;
					shopChoice = ui.select(
						"\nVous voulez acheter",
						"Epee Simple (" + sword1Price + ")",
						"Armure Simple (" + armor1Price + ")",
						"Sort Regen (" + heal1Price + ")",
						"Defier le vendeur barbu",
						"Rien finalement");
						break;
				}
				case MEDIUM : {
					numChoices = 9;
					shopChoice = ui.select(
						"\nVous voulez acheter",
						"Epee Simple (" + sword1Price + ")",
						"Armure Simple (" + armor1Price + ")",
						"Sort Regen (" + heal1Price + ")",
						"Epee Magique (" + sword2Price + ")",
						"Armure Magique (" + armor2Price + ")",
						"Sort Curaga (" + heal2Price + ")",
						"Sifflet Magique (" + whistlePrice + ")",
						"Defier le vendeur barbu",
						"Rien finalement");
						break;
				}
				case HARD : {
					numChoices = 13;
					shopChoice = ui.select(
						"\nVous voulez acheter",
						"Epee Simple (" + sword1Price + ")",
						"Armure Simple (" + armor1Price + ")",
						"Sort Regen (" + heal1Price + ")",
						"Epee Magique (" + sword2Price + ")",
						"Armure Magique (" + armor2Price + ")",
						"Sort Curaga (" + heal2Price + ")",
						"Sifflet Magique (" + whistlePrice + ")",
						"Epee Ragnarok (" + sword3Price + ")",
						"Armure Titan (" + armor3Price + ")",
						"Regeneration Gaia (" + heal3Price + ")",
						"Globe Mystifiant (" + globePrice + ")",
						"Defier le vendeur barbu",
						"Rien finalement");
						break;
				}
			}

			if(shopChoice == numChoices - 1)
				break;
			else if(shopChoice == numChoices - 2)
				fightKeeper(player, this.keeper);

			switch(result) {
				case 1 : {
					sell(player, sword1Price, sword1Sold, new Thunk<void>() {
							public void invoke() {
								sword1Sold = false;
								player.damage += sword1Bonus;
								ui.declare(
									"\nVous avez maintenant une epee qui frappe jusqu'a " + player.damage + " de dommages!");
							}
						});
					break;
				}
			}

		} while(true);

		scanf("%ld", &ChoixShop);
			switch(ChoixShop)
			{
				case 1:
						if(GOLD >= swordprice && epee == 0)
						{
							GOLD -= swordprice;
							epee = 1;
							MiN += 4;
							MaX += 5;
							printf("\nVous avez maintenant une epee qui frappe de %ld a %ld de dommages\n", MiN, MaX);
						}
						else if(epee == 1)
						{
							printf("\nVous avez deja achete cette epee.\n");

						}
						else
						{
							printf("\nVous n'avez pas assez de pieces d'or pour effectuer cet achat.\n");
						}
					break;
				case 2:
						if(GOLD >= armorprice && armure == 0)
						{
							GOLD -= armorprice;
							armure = 1;
							defense += 5;
							printf("\nVous avez maintenant une armure qui vous protegera de %ld dommages.\n", defense);
						}
						else if(armure == 1)
						{
							printf("\nVous avez deja achete cette armure.\n");

						}
						else
						{
							printf("\nVous n'avez pas assez de pieces d'or pour effectuer cet achat.\n");
						}
					break;
				case 3:
						if(GOLD >= healprice && HEAL == 0)
						{
							GOLD -= healprice;
							HEAL = 1;
							heal += 5;
							printf("\nVous avez maintenant un nouveau sort qui vous regenerera de %ld hp.\n", heal);
						}
						else if(HEAL == 1)
						{
							printf("\nVous avez deja achete ce sort.\n");

						}
						else
						{
							printf("\nVous n'avez pas assez de pieces d'or pour effectuer cet achat.\n");
						}
					break;
				case 4:
						if(GOLD >= dindonPrice && Dindon == 0)
						{
							GOLD -= dindonPrice;
							pet = 1;
							Dindon = 1;
							petMIN = 5;
							petMAX = 10;
							printf("\nVous avez maintenant un animal qui attaquera de %ld a %ld\n", petMIN, petMAX);
						}
						else if(Dindon == 1)
						{
							printf("\nVous avez deja achete cet animal.\n");

						}
						else
						{
							printf("\nVous n'avez pas assez de pieces d'or pour effectuer cet achat.\n");
						}
					break;
				case 5:
						if(keeper > 0)
						{
							if(GOLD >= epeelprice && epeel == 0)
							{
								GOLD -= epeelprice;
								epeel = 1;
								MiN += 4;
								MaX += 5;
								printf("\nVous avez maintenant une epee qui frappe de %ld a %ld de dommages\n", MiN, MaX);
							}
							else if(epeel == 1)
							{
								printf("\nVous avez deja achete cette epee.\n");
							}
							else
							{
								printf("\nVous n'avez pas assez de pieces d'or pour effectuer cet achat.\n");
							}
						}
						if(keeper == 0)
						{
								BossEncounter(1, niveaucombat);
								combat(-1, &comptecombats);
							if(continuer != 2)
							{
								printf("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
								printf("\n\"Tu m'as vaincu! Je te laisse acheter mes equipements secrets, profites-en!\"\n");
								printf("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
								keeper = 1;
							}
						}
					break;
				case 6:
						if(keeper == 0)
						{
							printf("\nAu revoir!\n");
							ChoixShop = 375;
						}
						if(keeper > 0)
						{
							if(GOLD >= armorlprice && armurel == 0)
							{
								GOLD -= armorlprice;
								armurel = 1;
								defense += 5;
								printf("\nVous avez maintenant une armure qui vous protegera de %ld dommages.\n", defense);
							}
							else if(armurel == 1)
							{
								printf("\nVous avez deja achete cette armure.\n");
							}
							else
							{
								printf("\nVous n'avez pas assez de pieces d'or pour effectuer cet achat.\n");
							}
						}
					break;
				case 7:
						if(keeper > 0)
						{
							if(GOLD >= heallprice && HEALl == 0)
							{
								GOLD -= heallprice;
								HEALl = 1;
								heal += 5;
								printf("\nVous avez maintenant un nouveau sort qui vous regenerera de %ld hp.\n", heal);
							}
							else if(HEALl == 1)
							{
								printf("\nVous avez deja achete ce sort.\n");
							}
							else
							{
								printf("\nVous n'avez pas assez de pieces d'or pour effectuer cet achat.\n");
							}
						}
					break;
				case 8:
						if(keeper > 0)
						{
							if(GOLD >= whistleprice && whistle == 0)
							{
								GOLD -= whistleprice;
								whistle = 1;
								whistleMod = 5;
								printf("\nVous avez maintenant un nouvel objet qui vous permettra \nde familiariser des animaux");
							}
							else if(whistle == 1)
							{
								printf("\nVous avez deja achete cet objet.\n");
							}
							else
							{
								printf("\nVous n'avez pas assez de pieces d'or pour effectuer cet achat.\n");
							}
						}
					break;
				case 9:
						if(keeper > 1)
						{
							if(GOLD >= RagnaPrice && Ragnarok == 0)
							{
								GOLD -= RagnaPrice;
								Ragnarok = 1;
								MiN += 45;
								MaX += 50;
								printf("\nVous avez maintenant une epee qui frappe de %ld a %ld de dommages\n", MiN, MaX);
							}
							else if(Ragnarok == 1)
							{
								printf("\nVous avez deja achete cette arme.\n");
							}
							else
							{
								printf("\nVous n'avez pas assez de pieces d'or pour effectuer cet achat.\n");
							}
						}
						if(keeper == 1)
						{
								BossEncounter(2, niveaucombat);
								combat(-2, &comptecombats);
							if(keeper == 1 && continuer != 2)
							{
								printf("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
								printf("\n\"Je me meurs!\" *Le Marchand Barbu devient Barbu Zombie*\n\"Sous cette forme, jamais tu ne m'auras a nouveau!\n");
								printf("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
									BossEncounter(3, niveaucombat);
									combat(-3, &comptecombats);
								if(continuer != 2)
								{
									printf("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
									printf("\n\"Tu es un adversaire tres courageux! Mais ne crois pas que ma mort te permette \nde ne pas payer! Et surtout ne vas pas dans l'arriere-boutique...\"\n");
									printf("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
									keeper = 2;
								}
							}
						}
						break;
				case 10:
						if(keeper == 1)
						{
							printf("\nAu revoir!\n");
							ChoixShop = 375;
						}
						if(keeper > 1)
						{
							 if(GOLD >= TitanPrice && Titan == 0)
							{
								GOLD -= TitanPrice;
								Titan = 1;
								defense += 100;
								printf("\nVous avez maintenant une armure qui vous protegera de %ld dommages.\n", defense);
							}
							else if(Titan == 1)
							{
								printf("\nVous avez deja achete cette armure.\n");
							}
							else
							{
								printf("\nVous n'avez pas assez de pieces d'or pour effectuer cet achat.\n");
							}
						}
					break;
				case 11:
						if(keeper > 1)
						{
							 if(GOLD >= GaiaPrice && Gaia == 0)
							{
								GOLD -= heallprice;
								Gaia = 1;
								heal += 150;
								printf("\nVous avez maintenant un nouveau sort qui vous regenerera de %ld hp.\n", heal);
							}
							else if(HEALl == 1)
							{
								printf("\nVous avez deja achete ce sort.\n");
							}
							else
							{
								printf("\nVous n'avez pas assez de pieces d'or pour effectuer cet achat.\n");
							}
						}
					break;
				case 12:
						if(keeper > 1)
						{
							 if(GOLD >= MystPrice && Myst == 0)
							{
								GOLD -= MystPrice;
								Myst = 1;
								whistleMod = 2;
								whistle = 1;
								printf("\nVous avez maintenant un nouvel objet qui vous permettra de \nfamiliariser des animaux tres facilement.");
							}
							else if(Myst == 1)
							{
								printf("\nVous avez deja achete cet objet.\n");
							}
							else
							{
								printf("\nVous n'avez pas assez de pieces d'or pour effectuer cet achat.\n");
							}
						}
					break;
				case 13:
						if(keeper == 2)
						{
							printf("\n\"Je ne crois pas que tu ais bien saisi ce que le mot \"Detruire\" signifie...\"\n");
						}
					break;
				case 14:
						if(keeper == 2)
						{
							printf("\nAu revoir!\n");
							ChoixShop = 375;
						}
					break;


				}
			}while(continuer != 2 && ChoixShop != 375);
	}
}