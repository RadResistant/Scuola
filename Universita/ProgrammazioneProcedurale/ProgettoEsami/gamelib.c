#include <stdio.h>
#include <stdlib.h>
#include "gamelib.h"
int scegli(){
    int scelta;
    int validInput;
    do {
        printf("Menù\n1)imposta gioco\n2)gioca\n3)termina gioco\n4)crediti\nScegli un opzione del menu:");
        validInput=scanf("%d",&scelta);
        if(validInput!=1){
            printf("non hai scelto un opzione valida\n");
            while(getchar()!='\n');
        }
    } while (validInput != 1);
    return scelta;
}
void imposta_gioco(){
    printf("imposta gioco\n");
}
void gioca(){
    printf("gioca\n");
}
void termina_gioco(){
    printf("termina gioco\n");
}
void crediti(){
    printf("crediti\n");
}