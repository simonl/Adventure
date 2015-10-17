#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void combat(long hpennemi, long hphero)
{
    printf("\nVous avez engagez le combat avec un Ennemi!\n");
    do{
        comptetours++;
    printf("\n--------------------------Tour %ld----------------------------", comptetours);
    printf("\nVos statistiques :\n%ld hp\nUne dague qui frappe de %ld a %ld\n%ld Exp. de Combat\n", hphero, MiN, MaX, ExpCom);
    if(niveauvue > 1)
    {
        printf("\nLes statistiques de l'ennemi :\n%ld hp\nDes sabots qui attaquent de %ld a %ld\nCet ennemi donne %ld Exp. de Combat\n", hpennemi, min, max, exp);
    }
    printf("\nChoisissez:\n 1. Attaquer(Ennemi)\n 2. Vous regenerer(Vous)\n 3. Prendre la fuite\n");
        scanf("%ld", &ChoixCombat);
    if(ChoixCombat == 1)
    {
        srand(time(NULL));
            attaque = (rand() % (MaX - MiN + 1)) + MiN;
            dommages = (rand() % (max - min + 1)) + min;
        printf("\nVous attaquez l'ennemi de %ld hp", attaque);
        printf("\nL'ennemi vous attaque de %ld hp", dommages);
        hpennemi = hpennemi - attaque;
        hphero = hphero - dommages;
        if(hphero < 1)
        {
            printf("\nOh non, vous etes mort!");
            continuer = 2;
            return 0;
        }
    }
    else if(ChoixCombat == 2)
    {
        hphero = hphero + heal;
        srand(time(NULL));
           dommages = (rand() % (max - min + 1)) + min;
        printf("\nVous vous regenerez de %ld hp", heal);
        printf("\nL'ennemi vous attaque de %ld hp", dommages);
        hphero = hphero - dommages;
        if(hphero < 1)
        {
            printf("\nOh non, vous etes mort!");
            continuer = 2;
            return 0;
        }
        }
    else
    {
        printf("\nVous tentez de prendre la fuite mais sans succes.\nL'ennemi vous plaque au sol et vou dechire les entrailles\n");
        hphero = 0;
        printf("\nOh non, vous etes mort!\n");
            continuer = 2;
            return 0;
    }
    }while(hpennemi > 0);
        printf("\nVous avez vaincu l'ennemi! Vous gagnez %ld Exp. de Combat\n", exp);
        comptetours = 0;
        if(niveaucombat == 3)
            {
            hphero = maximumhp;
            }
        ExpCom = ExpCom + exp;


        printf("\nQue voulez-vous faire maintenant :\n 1. Explorer encore\n 2. Quitter la foret\n");
        scanf("%ld", &continuer);



}
