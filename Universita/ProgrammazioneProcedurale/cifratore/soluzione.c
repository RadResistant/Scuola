#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <ctype.h>
int size=50;
void cleanString(char *dpt){
    char plaintext[25]="";
    int ipt=0;
    for(int i=0;dpt[i]!='\0';i++){
        if((dpt[i]>='a' && dpt[i]<='z') || (dpt[i]>='A' && dpt[i]<='Z') ){
            plaintext[ipt]=dpt[i];
            ipt++;
        }
    }
    strcpy(dpt, plaintext);
}
void cifra(char *pt,char *key,char *ct,char type){
    if(type=='d'){
        for(int i=0;i<strlen(pt);i++){
            pt[i]-=32;
        }
    }
    int ik=0;
    for(int i=0;i<strlen(pt);i++){
        if(ik==strlen(key)){
            ik=0;
        }
        ct[i]=pt[i]^key[ik];
        ik++;
    }
    if(type=='c'){
        for(int i=0;i<strlen(ct);i++){
            ct[i]+=32;
        }
    }
    ct[strlen(ct)]='\0';
}
void cifratore(char *plaintext){
    char *key=(char*)calloc(size,sizeof(char));
    char ciphertext[25]="";
    printf("Scrivi la tua chiave di cifratura: ");
    fgets(key, size, stdin);
    cleanString(plaintext);
    cleanString(key);
    size=25;
    plaintext=realloc(plaintext, size);
    key=realloc(key, size);
    cifra(plaintext,key,ciphertext,'c');
    printf("plaintext: %s\n", plaintext);
    printf("key: %s\n", key);
    printf("ciphertext: \n");
    for(int i=0;i<strlen(ciphertext);i++){
        printf("%d: %d,\n",i,(unsigned char)ciphertext[i]);
    }
    printf("%s\n",ciphertext);
}
void decifratore(char *ciphertext){
    char *key=(char*)calloc(size,sizeof(char));
    char plaintext[25]="";
    printf("Scrivi la tua chiave di cifratura: ");
    fgets(key, size, stdin);
    cleanString(key);
    size=25;
    ciphertext=realloc(ciphertext, size);
    key=realloc(key, size);
    cifra(ciphertext,key,plaintext,'d');
    printf("ciphertext: %s\n", ciphertext); // Problema: non stampa
    printf("key: %s\n", key);
    printf("plaintextt: \n");
    for(int i=0;i<strlen(plaintext);i++){
        printf("%d: %d,\n",i,(unsigned char)plaintext[i]); // Problema: aggiunge il carattere 159 alla fine
    }
    printf("%s\n",plaintext);
}
int main(){
    char *text=(char*)calloc(size,sizeof(char));
    char *choice=(char*)calloc(10,sizeof(char));
    printf(">Cifratore di Vernam<\n");
    printf("Scrivi la tua frase: ");
    fgets(text,size,stdin);
    printf("Cosa vuoi fare? (Cifrare: c, Decifrare: d, Nulla: n):");
    fgets(choice,sizeof(choice),stdin);
    switch(tolower(choice[0])){
        case 'c':
            free(choice);
            cifratore(text);
            break;
        case 'd':
            free(choice);
            decifratore(text);
            break;
        case 'n':
            printf("Non hai scelto nulla e questo è il testo inserito: %s\n",text);
            break;
        default:
            printf("Non hai scelto un opzione valida (Cifrare: c, Decifrare: d, Nulla:n):");
            break;
    }
    return 0;
}
