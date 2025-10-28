#include <stdio.h>
#include <X11/Xlib.h>
#include <X11/extensions/XTest.h>
#include <unistd.h>
#include <stdlib.h>
int main(){
    Display *display = XOpenDisplay(NULL);
    if (display == NULL) {
        return 1;
    }
    system("gnome-terminal");
    int num=0;
    int inte=0;
    int press=0;
    printf("inserisci il numero di click\n");
    scanf("%d",&num);
    printf("inserisci il tempo di pressione (in ms,1 per un click istantaneo)\n");
    scanf("%d",&press);
    printf("inserisci il l'intervallo tra i click (in ms)\n");
    scanf("%d",&inte);
    printf("l'autoclicker iniziera in 10 secondi\n");
    sleep(10);
    for(int i=0;i<num;i++){
        XTestFakeButtonEvent(display, 1, True, CurrentTime);
        usleep(press*1000);
        XTestFakeButtonEvent(display, 1, False, CurrentTime);
        usleep(inte*1000);
        XFlush(display);
    }
    XCloseDisplay(display);
    printf("Autoclicker terminato\n");
    return 0;
}