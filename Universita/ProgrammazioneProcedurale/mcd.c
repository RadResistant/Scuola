#include <stdio.h>
int main(){
    int a,b;
    printf("Primo numero positivo:");
    scanf("%d",&a);
    printf("Secondo numero positivo:");
    scanf("%d",&b);
    while(b!=0){
        if(a>b)
            a-=b;
        else
            b-=a;
    }
    printf("MCD=%d\n", a);
    return 0;
}