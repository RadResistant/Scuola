"use strict";
let timerSfondo=window.setInterval(scorrimentoSfondo,1);
let timerPersonaggio=window.setInterval(cammina,60);
let aggiungtaZombie=window.setInterval(aggiungiZombie,1000);
let camminaZombie=window.setInterval(camminaZ,60);
let posSfondo=0;
function scorrimentoSfondo(){
    let sfondo=document.querySelector("body");
    posSfondo-=2;
    if(posSfondo<=-1000){
        posSfondo=0
    }
    sfondo.style.backgroundPositionX=posSfondo+"px";
}
let posPersonaggio=0;
function cammina(){
    posPersonaggio-=233;
    if(posPersonaggio<=-932){
        posPersonaggio=233
    }
    let foto=document.querySelectorAll("div")[0];
    foto.style.backgroundPositionX=posPersonaggio+"px";
}
function aggiungiZombie(){
    let zom=document.createElement("div");
    zom.className="zombie";
    zom.style.right="1px";
    document.body.appendChild(zom);
}
function camminaZ(){
    let zombies=document.querySelectorAll(".zombie");
    if(zombies.length>4){
        window.clearInterval(aggiungtaZombie);
    }
    for(let i=0;i<zombies.length;i++){
        let posizioneZom=parseInt(zombies[i].style.right);
        posizioneZom++;
        zombies[i].style.right=posizioneZom+"px";
    }
}