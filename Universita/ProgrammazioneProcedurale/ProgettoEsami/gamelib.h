typedef enum{
    bosco=0,
    scuola=1,
    laboratorio=2,
    caverna=3,
    strada=4,
    giardino=5,
    supermercato=6,
    centrale_elettrica=7,
    deposito_abbandonato=8,
    stazione_polizia=9
}tipo_zona;
typedef enum{
    nessun_nemico=0,
    democane=1,
    billi=2,
    demotozone=3
} tipo_nemico;
typedef enum{
    nessun_oggetto=0,
    bicicletta=1,
    maglietta_fuocoinferno=2,
    bussola=3,
    schitarrata_metallica=4
}tipo_oggetto;
void imposta_gioco();
void gioca();
void termina_gioco();
void crediti();
<<<<<<< Updated upstream
=======
int scegli();
struct zona_mondoreale{
    tipo_zona tipo_zona_mondoreale;
    tipo_nemico tipo_nemico_mondoreale;
    tipo_oggetto tipo_oggetto_mondoreale;
    struct zona_mondoreale *avanti;
    struct zona_mondoreale *indietro;
    struct zona_soprasotto *link_soprasotto;
};
struct zona_soprasotto{
    struct zona_mondoreale *avanti;
    struct zona_mondoreale *indietro;
    struct zona_soprasotto *link_soprasotto;
};
>>>>>>> Stashed changes
struct giocatore{
    char nome[64];
    enum {reale=0,soprasotto=1} mondo;
    struct zona_mondoreale *pos_mondoreale;
    struct zona_soprasotto *pos_soprasotto;
    short attacco_psichico;
    short difesa_psichica;
    short fortuna;
    int zaino[3];
};
