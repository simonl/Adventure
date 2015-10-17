#include <stdio.h>
#include <stdlib.h>
#include <time.h>


long ChoixForet = 0, ChoixCombat = 0, ChoixShop = 0 ,continuer = 1;
long comptecombats = 0, compteinspection = 0, comptetours = 1;
long hphero = 30, attaque = 0, MaX = 5, MiN = 1, heal = 7, maximumhp = 30;
long niveaucombat = 1, niveauvue = 1, ExpCom = 0, ExpVue = 0, keeper = 0;
long hpennemi = 0, dommages = 0, hpmax = 0, hpmin = 0, max = 0, min = 0, hptotal = 0;
long exp = 15, EXP = 15, Surprise = 0, epee = 0;
long gold = 15, armure = 0, defense = 0, arme = 0, Dindon = 0, GOLD = 0, HEAL = 0, whistle = 0, whistleMod = 1, armurel = 0, epeel = 0, HEALl = 0, Ragnarok = 0, Gaia = 0, Titan = 0, Myst = 0;
long swordprice = 50, armorprice = 100, healprice = 150, dindonPrice = 250, whistleprice = 2500, epeelprice = 500, armorlprice = 1000, heallprice = 1500, RagnaPrice = 5000, GaiaPrice = 15000, TitanPrice = 10000, MystPrice = 25000;
long *shopGOLD = NULL, *shoplevel = NULL, *compteC = NULL, *compteV = NULL, i = 0;
long pet = 0, petMIN = 0, petMAX = 0, petdommages = 0;

void combat(long NiveauEnnemi, long *compteC);
void Examine(long hphero);
void lvlcombat(long curcomlvl, long curcomexp);
void lvlvue(long curvulvl, long curvuexp);
void shop(long *shopGOLD, long *shoplevel);
void Statistiques();
void Inspection(long *compteV, long *exp);
long TestMort(long HP);
void BossEncounter(long Bossid, long Level);


int main(int argc, char *argv[])
{

    long Hack = 0;

    printf("Hackzorz?? 1.Yay  2. Nay\n");
    scanf("%ld", &Hack);
    printf("\n");

    if(Hack == 1)
    {
        GOLD = 999999;
        niveaucombat = 100;
        niveauvue = 4;
        defense = 1420;
        MaX = 17293;
        MiN = 3429;
        comptecombats = 1000;
        maximumhp = 100000;
        hphero = 50000;
        heal = 234763;
    }



    printf("Bienvenue dans mon jeu!\n");
    printf("\nVous etes dans une foret, arme de votre fidele poignard.\nDevant vous, vous voyez des chevreuils en train de broutter de l'herbe.\nA votre gauche, vous apercevez une buche qui vous semble particuliere.\n");
    do
    {
        printf("\n************************************\n");
        printf("\nQue voulez-vous faire?\n 1. Attaquer un chevreuil\n 2. Examiner la buche\n 3. Voir tes statistiques\n 4. Aller au magasin\n 5. Quitter le jeu\n");
            scanf("%ld", &ChoixForet);
    switch (ChoixForet)
    {
    case 1:
            if(niveaucombat == 100)
            {
                BossEncounter(4, niveaucombat);
                combat(-4, &comptecombats);
            }
            else
            {
                combat(comptecombats, &comptecombats);
            }
        break;
    case 2:
            Inspection(&compteinspection, &ExpVue);
        break;
    case 3 :
            Statistiques();
        break;
    case 4 :
            shop(&GOLD, &niveaucombat);
        break;
     case 5 :
            printf("\nEtes-vous sure de vouloir quitter?\n 1. Non\n 2. Oui\n");
            scanf("%ld", &continuer);
        break;
    }
    }while(continuer == 1);

printf("\nMerci d'avoir joue!\n\n\n");
    return 0;
}

void combat(long NiveauEnnemi, long *compteC)
{
    long MAX, MIN;

            if(NiveauEnnemi == -1)
            {
                MAX = 450;
                MIN = 425;
                min = 50;
                max = 75;
            }
            else if(NiveauEnnemi == -2)
            {
                MAX = 1600;
                MIN = 1560;
                min = 175;
                max = 210;
            }
            else if(NiveauEnnemi == -3)
            {
                MAX = 2500;
                MIN = 2400;
                min = 310;
                max = 380;
            }
            else if(NiveauEnnemi == -4)
            {
                MAX = 7200;
                MIN = 7050;
                min = 570;
                max = 620;
            }
            else
            {
                MAX = 22 + NiveauEnnemi;
                MIN = 18 + NiveauEnnemi;
                min = 0 + NiveauEnnemi;
                max = 3 + NiveauEnnemi;
            }


    printf("\n\nVous avez engagez le combat avec un Ennemi!\n");
    srand(time(NULL));
        hptotal = (rand() % (MAX - MIN + 1)) + MIN;
        hpennemi = hptotal;

    while(hpennemi > 0 && continuer != 2)
    {

    printf("\n--------------------------Tour %ld----------------------------", comptetours);
    printf("\nVos statistiques :\n %ld/%ld hp\n Une attaque de %ld a %ld\n Une protection de %ld\n Une regen de %ld\n", hphero, maximumhp, MiN, MaX, defense, heal);

    if(pet == 1)
    {
        printf("\nLes Statistiques de votre animal:\n Une attaque de %ld a %ld\n", petMIN, petMAX);
    }

    if(niveauvue > 0)
    {
        if(niveauvue == 1)
        {
            printf("\nLes statistiques de l'ennemi :\n???\n");
        }
        if(niveauvue > 1)
        {
            printf("\nLes statistiques de l'ennemi :\n %ld/%ld hp \n", hpennemi, hptotal);

            if(niveauvue > 2)
            {
                printf(" Des sabots qui attaquent de %ld a %ld\n", min, max);

                if(niveauvue > 3)
                {
                    printf(" Cet ennemi donne %ld Exp. de Combat\n", exp);
                }
            }
        }
    }



    printf("\nChoisissez:\n 1. Attaquer(Ennemi)\n 2. Regenerer(Vous)\n 3. Prendre la fuite\n");
    if(whistle == 1)
    {
        printf(" 4. Convertir l'ennemi\n");
    }

        scanf("%ld", &ChoixCombat);
    switch (ChoixCombat)
    {
    case 1 :
        comptetours++;

            attaque = (rand() % (MaX - MiN + 1)) + MiN;
            hpennemi -= attaque;
            printf("\nVous attaquez l'ennemi de %ld hp", attaque);

            if(pet == 1)
            {
                petdommages = (rand() % (petMAX - petMIN + 1)) + petMIN;
                hpennemi -= petdommages;
                printf("\nVotre animal attaque de %ld hp", petdommages);
            }


            if(hpennemi > 0)
            {
                dommages = ((rand() % (max - min + 1)) + min) - defense;
                hphero -= dommages;
                printf("\nL'ennemi vous attaque de %ld hp\n", dommages);
            }

            continuer = TestMort(hphero);
        break;
    case 2 :
        comptetours++;

            hphero += heal;
            if(hphero > maximumhp)
            {
                hphero = maximumhp;
            }
            printf("\nVous vous regenerez de %ld hp", heal);

            if(pet == 1)
            {
                petdommages = (rand() % (petMAX - petMIN + 1)) + petMIN;
                hpennemi -= petdommages;
                printf("\nVotre animal attaque de %ld hp", petdommages);
            }


            if(hpennemi > 0)
            {
                dommages = ((rand() % (max - min + 1)) + min) - defense;
                hphero -= dommages;
                printf("\nL'ennemi vous attaque de %ld hp\n", dommages);
            }

            continuer = TestMort(hphero);
        break;
    case 3 :
        printf("\nVous tentez de prendre la fuite mais sans succes.\nL'ennemi vous plaque au sol et vous dechire les entrailles\n");
        hphero = 0;
            continuer = TestMort(hphero);
        break;
    case 4 :
        if(whistle == 1)
        {
            printf("\nVous tentez de maitriser l'ennemi...");
            if(hpennemi <= hptotal/whistleMod)
            {
                pet = 1;
                petMAX = max;
                petMIN = min;
                printf("Vous avez reussi!\nVotre animal attaquera de %ld a %ld\n", petMIN, petMAX);
                hpennemi = 0;
            }
            else
            {
                printf("Vous avez echoue!\n");
                comptetours++;

                if(pet == 1)
                {
                    petdommages = (rand() % (petMAX - petMIN + 1)) + petMIN;
                    hpennemi -= petdommages;
                    printf("\nVotre animal attaque de %ld hp", petdommages);
                }

                if(hpennemi > 0)
                {
                    dommages = ((rand() % (max - min + 1)) + min) - defense;
                    hphero -= dommages;
                    printf("\nL'ennemi vous attaque de %ld hp\n", dommages);
                }

                continuer = TestMort(hphero);
            }
        }
        break;
    }

    }
        if(continuer != 2)
        {
            if(NiveauEnnemi == -5)
            {
                exp = 1000;
                gold = 500;
            }
            else if(NiveauEnnemi == -4)
            {
                exp = 2000;
                gold = 5000;
            }
            else if(NiveauEnnemi == -3)
            {
                exp = 5000;
                gold = 5000;
            }
            else
            {
                exp = (5*NiveauEnnemi) + 15;
                gold = (5*NiveauEnnemi) + 15;
            }

            printf("\n\nVous avez vaincu l'ennemi! Vous gagnez %ld Exp. de Combat et %ld pieces d'or.\n", exp, gold);
            ExpCom += exp;
            GOLD += gold;
            *compteC += 1;
            comptetours = 1;
                lvlcombat(niveaucombat, ExpCom);
        }
}

void shop(long *shopGOLD, long *shoplevel)
{
    printf("\n+++++++++++++++++++++++++++++ Magasin ++++++++++++++++++++++++++++++++++\n");
    printf("\nBienvenue au magasin! Ici, vous pouvez acheter toute sorte d'equipement.\n");

    do{
    printf("-----------------------------------------\nVous avez presentement %ld pieces d'or.\n\n Vous voulez acheter :\n", GOLD);

    if(keeper >= 0)
    {
        printf("\n 1. Epee Simple (%ld GOLD)\n 2. Armure Simple (%ld GOLD)\n 3. Sort Regen (%ld GOLD)\n 4. Dindon Domestique (%ld GOLD)", swordprice, armorprice, healprice, dindonPrice);
    }
    if(keeper > 0)
    {
        printf("\n\n 5. Epee Magique (%ld GOLD)\n 6. Armure Magique (%ld GOLD)\n 7. Sort Curaga (%ld GOLD)\n 8. Sifflet Magique (%ld GOLD)", epeelprice, armorlprice, heallprice, whistleprice);
    }
    if(keeper > 1)
    {
        printf("\n\n 9. Epee Ragnarok (%ld GOLD)\n 10. Armure Titan (%ld GOLD)\n 11. Regeneration Gaia (%ld GOLD)\n 12. Globe Mystifiant (%ld GOLD)", whistleprice, RagnaPrice, TitanPrice, MystPrice);
    }
    printf("\n\n %ld. Defier le vendeur barbu\n %ld. Rien finalement\n", (4*keeper)+5, (4*keeper)+6);


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

void lvlcombat(long curlvl, long curexp)
{
    if(curexp >= (curlvl*curlvl*15) && curlvl <= 99)
    {
        niveaucombat ++;
        heal += 2;
        defense ++;
        MiN ++;
        MaX += 2;
        maximumhp += 5;
        printf("\nBravo! Vous etes maintenant un guerrier de niveau %ld.\nVos habiletes ont ete ameliores.\n", niveaucombat);
    }

    if(niveaucombat >= 10)
    {
        printf("\nVotre hp se regenere automatiquement apres le combat.\n");
        hphero = maximumhp;
    }
}

void lvlvue(long curvulvl, long curvuexp)
{
    if(curvuexp >= 30 && curvulvl < 2)
    {
        niveauvue ++;
        printf("\nBravo! Vous etes maintenant un observateur de niveau %ld.\nVous pouvez maintenant voir les hp de vos ennemis.\n", niveauvue);
    }
    if(curvuexp >= 75 && curvulvl < 3)
    {
        niveauvue ++;
        printf("\nBravo! Vous etes maintenant un observateur de niveau %ld.\nVous pouvez maintenant voir la puissance de vos ennemis.\n", niveauvue);
    }
    if(curvuexp >= 160 && curvulvl < 4)
    {
        niveauvue ++;
        printf("\nBravo! Vous etes maintenant un observateur de niveau %ld.\nVous pouvez maintenant voir l'experience que vos ennemis vous donneront.\n", niveauvue);
    }
}

void Statistiques()
{
     printf("\n-----------------------------Vos statistiques------------------------------\n");
        printf("\n%ld/%ld hp\nUne arme qui frappe de %ld a %ld\nUne regeneration de %ld hp\n", hphero, maximumhp, MiN, MaX, heal);
            if(!(armure == 0))
                {
                    printf("Une armure qui vous protege de %ld\n", defense);
                }
            if(pet == 1)
                {
                    printf("Un animal qui attaque de %ld a %ld\n", petMIN, petMAX);
                }
        printf("Une reserve de %ld pieces d'or\n\nVous etes un guerrier de niveau %ld pour un total de %ld Experience de Combat", GOLD, niveaucombat, ExpCom);
        printf("\nVous etes un observateur de niveau %ld pour un total de %ld Experience de vision\n",  niveauvue, ExpVue);
        printf("\nVous avez combattu %ld ennemis\nVous avez examine %ld objets\n\n", comptecombats, compteinspection);
}

void Inspection(long *compteV, long *exp)
{
    *compteV ++;
            printf("\nComme vous vous doutiez tout a l'heure, \nle tronc est bel et bien sculpte en forme de chevreuil!\n");
            printf("\nVous gagnez %ld Exp. de Vision\n", EXP);
            *exp += EXP;
                lvlvue(niveauvue, ExpVue);
            EXP += 5;
            srand(time(NULL));
                Surprise = (rand() % (1 - 0 + 1)) + 0;
            switch(Surprise)
            {
                case 1:
                    printf("\nUn chevreuil ne semble pas etre d'accord avec ce que vous faites.\nIl vous charge dans le dos et vous enleve 5 hp!\n");
                    hphero -= 5;
                    continuer = TestMort(hphero);
                    combat(comptecombats, &comptecombats);
                    break;
                default:
                    printf("\nQue voulez-vous faire maintenant?\n 1. Explorer encore\n 2. Quitter la foret\n");
                    scanf("%ld", &continuer);
                }
}

long TestMort(long HP)
{
    long Mort;

    if(HP <= 0)
        {
            printf("\nOh non, vous etes mort!\n");
            Mort = 2;
        }
    else
        {
            Mort = 1;
        }

    return Mort;
}

void BossEncounter(long Bossid, long Level)
{
    if(Bossid == 1)
    {
        printf("\n********************************************************************************");
        printf("\n**************                --ATTENTION--                       **************");
        printf("\n**************          --MARCHAND BARBU APPROCHE--               **************");
        printf("\n********************************************************************************\n");
         printf("           \"Tu n'es que niveau %ld! Tu n'as aucune chance!\"\n", Level);
    }

    else if(Bossid == 2)
    {
        printf("\n********************************************************************************");
        printf("\n**************                 --ATTENTION--                      **************");
        printf("\n**************          --BARBU DANGEREUX APPROCHE--              **************");
        printf("\n********************************************************************************\n");
         printf("  \"Tu es peut-etre niveau %ld cette fois, mais je me suis pret, et a la mort!\"\n", Level);
    }

    else if(Bossid == 3)
    {
        printf("\n********************************************************************************");
        printf("\n**************                 --ATTENTION--                      **************");
        printf("\n**************           --BARBU ZOMBIE APPROCHE--                **************");
        printf("\n********************************************************************************\n");
         printf("    \"Je suis deja mort! Ce n'est pas un niveau %ld qui me detruira!\"\n", Level);
    }

    else if(Bossid == 4)
    {
        printf("\n********************************************************************************");
        printf("\n**************                 --ATTENTION--                      **************");
        printf("\n**************          --OMEGA CHEVREUIL APPROCHE--              **************");
        printf("\n********************************************************************************\n");
         printf("                    \"BRRRRRRRRRRR %ld BLLRGG BRRRRRRRRR!\"\n", Level);
    }

}



