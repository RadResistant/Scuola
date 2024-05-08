"use strict";
document.querySelector("body").style.backgroundImage="url('sfondoBase.jpg')";
let timerSfondo=window.setInterval(scorrimentoSfondo,1);
let x=0;
function scorrimentoSfondo(){
    let sfondo=document.querySelector("body");
    x-=0.5;
    if(x<=-626){
        x=0
    }
    sfondo.style.backgroundPositionX=x+"px";
}