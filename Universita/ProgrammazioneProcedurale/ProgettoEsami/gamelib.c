#include <stdio.h>
#include <stdlib.h>
#include "gamelib.h"
static int impostato=0;
void imposta_gioco(){
    printf("imposta gioco\n");
    impostato=1;
}
void gioca(){
    if(impostato){
        printf("gioca\n");
    }
    else{
        printf("prima di poter giocare devi impostare il gioco\n");
    }
}
void termina_gioco(){
    printf("termina gioco\n");
}
void crediti(){
    printf("crediti\n");
}