#include <stdlib.h>
#include <stdio.h>
#include <string.h>
    char *scelta;
    int size=50;
    char *plaintext;
    char *key;
    char ciphertext[25]="";
void cleanString(char *dpt){
    char plaintext[25]="";
    int ipt=0;
    for(int i=0;dpt[i]!='\0';i++){
        if((dpt[i]>='a' && dpt[i]<='z') || (dpt[i]>='A' && dpt[i]<='Z') ){
            plaintext[ipt] = dpt[i];
            ipt++;
        }
    }
    strcpy(dpt, plaintext);
}
void cifra(char *pt,char *key,char *ct){
    for(int i=0,ik=0;i<strlen(pt);i++,ik++){
        if(ik==strlen(key)){
            ik=0;
        }
        ct[i]=pt[i]^key[ik];
    }
    ct[strlen(ct)]='\0';
}
void cifratore(){
    printf("Scrivi la tua chiave di cifratura: ");
    fgets(key, size, stdin);
    cleanString(plaintext);
    cleanString(key);
    size=25;
    plaintext = realloc(plaintext, size);
    key = realloc(key, size);
    cifra(plaintext,key,ciphertext);
    printf("plaintext: %s\n", plaintext);
    printf("key: %s\n", key);
    printf("ciphertext: \n");
    for(int i=0;i<strlen(ciphertext);i++){
        printf("%d: %d,\n",i,(unsigned char)ciphertext[i]);
    }
    printf("%s\n",ciphertext);
}
int main(){
    scelta=malloc(10);
    plaintext=malloc(size);
    key=malloc(size);
    printf(">Cifratore di Vernam<\n");
    printf("Scrivi la tua frase: ");
    fgets(plaintext,size,stdin);
    printf("Cazzo voi? ");
    fgets(scelta,sizeof(scelta),stdin);
    switch(scelta[0]){
    case 'c':
        free(scelta);
        cifratore();
        break;
    default:
        printf("Non hai scelto nulla e questo è il testo inserito: %s\n",plaintext);
        break;
    }
    return 0;
}