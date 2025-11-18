#include <stdlib.h>
#include <stdio.h>
#include <string.h>
void cleanString(char *dpt){
    char plaintext[25]="";
    for(int i=0,ipt=0;dpt[i]!='\0' || ipt<(strlen(dpt)-1);i++){
        if((dpt[i]>='a' && dpt[i]<='z') || (dpt[i]>='A' && dpt[i]<='Z') ){
            plaintext[ipt++] = dpt[i];
        }
    }
    plaintext[sizeof(plaintext)-1] = '\0';
    strcpy(dpt, plaintext);
}
int main(){
    int size=50;
    char *plaintext = malloc(size);
    char *key= malloc(size);
    printf(">Cifratore di Vernam<\n");
    printf("Scrivi la tua frase: ");
    fgets(plaintext, size, stdin);
    cleanString(plaintext);
    printf("output: %s\n", plaintext);
    printf("Scrivi la tua chiave di cifratura: ");
    fgets(key, size, stdin);
    cleanString(key);
    size=24;
    plaintext = realloc(plaintext, size);
    printf("output: %s\n", plaintext);
    printf("key: %s\n", key);
}