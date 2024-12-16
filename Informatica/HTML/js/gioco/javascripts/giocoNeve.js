"use strict";
let timerSfondo=window.setInterval(scorrimentoSfondo,1);
let timerPersonaggio=window.setInterval(cammina,1);
let posSfondo=0;
function scorrimentoSfondo(){
    let sfondo=document.querySelector("body");
    sfondo.style.backgroundSize="auto "+window.innerHeight+"px";
    let dimensioneSfondo=sfondo.style.backgroundSize;
    let xSfondo=dimensioneSfondo.split("");
    posSfondo-=0.5;
    if(posSfondo<=-80){
        posSfondo=0
    }
    sfondo.style.backgroundPositionX=posSfondo+"px";
}
let posPersonaggio=0;
function cammina(){
    posPersonaggio-=233;
    if(posPersonaggio<=-1365){
        posPersonaggio=233
    }
    let foto=document.querySelector("div");
    foto.style.backgroundPositionX=posPersonaggio+"px";
}