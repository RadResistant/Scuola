#include <stdio.h>
#include "gamelib.h"
int main(){
    int scelta;
    int validInput;
    do{
        printf("Menù\n1)imposta gioco\n2)gioca\n3)termina gioco\n4)crediti\nScegli un opzione del menu:");
        validInput=scanf("%d",&scelta);
        if(validInput!=1){
            printf("non hai scelto un opzione valida\n");
            while(getchar()!='\n');
        }
    }while(validInput!=1);
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
            printf("non hai scelto un opzione valida\n");
            break;
    }
    main();
}