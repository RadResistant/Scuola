#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
#include "gamelib.h"
static int impostato=0;
static int inseriti=0;
static struct giocatore *giocatori[4];
// static struct zona_mondoreale *mappa_mondoreale[15];
// static struct zona_soprasotto *mappa_soprasotto[15];
static void pulisciBuffer(int validInput){
    while(getchar()!='\n');
    if(validInput!=1){
        printf("Non hai scelto un opzione valida\n");
    }
}
static void inserisci_giocatore(){
    int quantita;
    int validInput;
    int undiciEsiste=0;
    printf("----------------Inserisci-giocatori-----------------\n");
    do{
        printf("Inserisci la quantita di giocatori che vuoi inserire: ");
        validInput=scanf("%d",&quantita);
        pulisciBuffer(validInput);
    }while(validInput!=1);
    printf("----------------------------------------------------\n\n");
    for(int i=0;i<quantita;i++){
        printf("--------------------Giocatore-%d--------------------\n",i+1);
        giocatori[i]=malloc(sizeof(struct giocatore));
        printf("Inserisci il nome (max 62 caratteri): ");
        scanf("%62s",giocatori[i]->nome);
        giocatori[i]->attacco_psichico=1+rand()%20;
        giocatori[i]->difesa_psichica=1+rand()%20;
        giocatori[i]->fortuna=1+rand()%20;
        printf("Il suo attacco psichico vale: %d\n",giocatori[i]->attacco_psichico);
        printf("La sua difesa psichica vale: %d\n",giocatori[i]->difesa_psichica);
        printf("La sua fortuna vale: %d\n",giocatori[i]->fortuna);
        giocatori[i]->mondo=0;
        pulisciBuffer(1);
        if(!undiciEsiste){
            char vuole[5];
            printf("Vuoi diventare UndiciVirgolaCinque?[y/n]:");
            scanf("%s",vuole);
            if(vuole[0]=='y'){
                strcpy(giocatori[i]->nome,"UndiciVirgolaCinque");
                giocatori[i]->attacco_psichico+=4;
                giocatori[i]->difesa_psichica+=4;
                giocatori[i]->fortuna-=7;
                undiciEsiste=1;
                printf("Ora il suo attacco psichico vale: %d\n",giocatori[i]->attacco_psichico);
                printf("Ora la sua difesa psichica vale: %d\n",giocatori[i]->difesa_psichica);
                printf("Ora la sua fortuna vale: %d\n",giocatori[i]->fortuna);
            }
        }
        printf("----------------------------------------------------\n\n");
    }
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
    if(!inseriti){
        inserisci_giocatore();
    }
    inseriti=1;
    int scelta;
    int validInput;
    do{
        printf("----------------------Menù-mappa--------------------\n");
        printf("1)Genera mappa\n2)Inserisci zona\n3)Cancella zona\n4)Stampa mappa\n5)Stampa zona\n6)Chiudi mappa\nScegli un opzione del menu:");
        validInput=scanf("%d",&scelta);
        pulisciBuffer(validInput);
    }while(validInput!=1);
    printf("----------------------------------------------------\n\n");
    switch(scelta){
        case 1:
            genera_mappa();
            break;
        case 2:
            inserisci_zona();
            break;
        case 3:
            cancella_zona();
            break;
        case 4:
            stampa_mappa();
            break;
        case 5:
            stampa_zona();
            break;
        case 6:
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