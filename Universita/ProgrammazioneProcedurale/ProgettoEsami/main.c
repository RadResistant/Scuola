#include <stdio.h>
#include "gamelib.h"
int main(){
    printf("----------------------Menù--------------------------\n");
    int scelta;
    int validInput;
    do{
        printf("1)Imposta gioco\n2)Gioca\n3)Termina gioco\n4)Crediti\nScegli un opzione del menu:");
        validInput=scanf("%d",&scelta);
        if(validInput!=1){
            printf("Non hai scelto un opzione valida\n");
            while(getchar()!='\n');
        }
    }while(validInput!=1);
    printf("----------------------------------------------------\n");
    switch(scelta){
        case 1:
            imposta_gioco();
            break;
        case 2:
            gioca();
            break;
        case 3:
            char sure;
            while(getchar()!='\n');
            printf("Sei sicuro di voler terminare?[y/n]:");
            scanf("%c",&sure);
            if(sure=='y'){
                termina_gioco();
                return 0;
            }
            break;
        case 4:
            crediti();
            break;
        default:
            printf("Non hai scelto un opzione valida\n");
            break;
    }
    main();
}