void imposta_gioco();
void gioca();
void termina_gioco();
void crediti();
struct giocatore{
    char nome[64];
    enum {reale=0,sottosopra=1} mondo;
};
