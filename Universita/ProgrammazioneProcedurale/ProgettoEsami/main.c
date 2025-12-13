#include <stdio.h>
#include "gamelib.h"
int main(){
    int scelta;
    scelta=scegli();
    switch((int)scelta){
        case 1:
            imposta_gioco();
            break;
        case 2:
            gioca();
            break;
        case 3:
            termina_gioco();
            break;
        case 4:
            crediti();
            break;
        default:
            printf("non hai scelto un opzione valida\n");
            main();
            break;
    }
    return 0;
}