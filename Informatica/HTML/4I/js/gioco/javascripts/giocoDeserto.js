"use strict";
let timerSfondo=window.setInterval(scorrimentoSfondo,1);
let timerPersonaggio=window.setInterval(cammina,1);
let posSfondo=0;
function scorrimentoSfondo(){
    let sfondo=document.querySelector("body");
    posSfondo-=0.5;
    if(posSfondo<=-1365){
        posSfondo=0
    }
    sfondo.style.backgroundPositionX=posSfondo+"px";
}
let posPersonaggio=0;
function cammina(){
    posPersonaggio-=233;
    if(posPersonaggio<=-1366){
        posPersonaggio=233
    }
    let foto=document.querySelector("div");
    foto.style.backgroundPositionX=posPersonaggio+"px";
}