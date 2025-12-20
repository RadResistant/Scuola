#include <stdio.h>
#include <stdlib.h>
#include "gamelib.h"
static int impostato=0;
static struct giocatore giocatori[4];
static struct zona_mondoreale mappa_mondoreale[15];
static struct zona_soprasotto mappa_soprasotto[15];
static void inserisci_giocatore(){
    // Registrazione giocatore
}
static void rimuovi_giocatore(){
    // Rimozione giocatore
}
static void genera_mappa(){
    // Crazione della mappa
}
static void inserisci_zona(){
    // Inseriento di una nuova zona al posto scelto dal'utente
}
static void cancella_zona(){
    // Cancellazione di una zona scelta dal giocatore e ricollegamento della zona precedente e la successiva
}
static void stampa_mappa(){
    // Stampa della mappa scelta dallutente(mondo reale o soprasotto)
}
static void stampa_zona(){
    // Stampa della zona scelta dallutente
}
void imposta_gioco(){
    printf("----------------------Menù-mappa--------------------\n");
    register_giocatore();
    int scelta;
    int validInput;
    do{
        printf("1)Inserisci giocatore\n2)Rimuovi giocatore\n3)Genera mappa\n4)Inserisci zona\n5)Cancella zona\n6)Stampa mappa\n7)Stampa zona\n8)Chiudi mappa\nScegli un opzione del menu:");
        validInput=scanf("%d",&scelta);
        if(validInput!=1){
            printf("Non hai scelto un opzione valida\n");
            while(getchar()!='\n');
        }
    }while(validInput!=1);
    printf("----------------------------------------------------\n");
    switch(scelta){
        case 1:
            inserisci_giocatore();
            break;
        case 2:
            rimuovi_giocatore();
            break;
        case 3:
            genera_mappa();
            break;
        case 4:
            inserisci_zona();
            break;
        case 5:
            cancella_zona();
            break;
        case 6:
            stampa_mappa();
            break;
        case 7:
            stampa_zona();
            break;
        case 8:
            impostato=1;
            return;
            break;
        default:
            printf("Non hai scelto un opzione valida\n");
            break;
    }
    imposta_gioco();
}
void gioca(){
    if(impostato){
        printf("Gioca\n");
    }
    else{
        printf("Prima di poter giocare devi impostare il gioco\n");
    }
}
void termina_gioco(){
    printf("Termina gioco\n");
}
void crediti(){
    printf("Crediti\n");
}