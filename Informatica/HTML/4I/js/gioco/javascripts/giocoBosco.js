"use strict";
let timerSfondo=window.setInterval(scorrimentoSfondo,1);
let timerPersonaggio=window.setInterval(cammina,60);
let aggiungtaZombie=window.setInterval(aggiungiZombie,1000);
let camminaZombie=window.setInterval(camminaZ,60);
let adattaSfondo=window.setInterval(adatta,1);
let posSfondo=0;
function adatta(){
        document.querySelector("body").style.backgroundSize="auto "+window.innerHeight+"px";
}
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
    let foto=document.getElementById("personaggio");
    foto.style.backgroundPositionX=posPersonaggio+"px";
}
function aggiungiZombie(){
    let zom=document.createElement("div");
    zom.className="zombie";
    zom.style.left=window.innerWidth-233+"px";
    document.body.appendChild(zom);
}
function camminaZ(){
    let zombies=document.querySelectorAll(".zombie");
    let inc=[1,1,1,1,1];
    if(zombies.length>4){
        window.clearInterval(aggiungtaZombie);
    }
    for(let i=0;i<zombies.length;i++){
        if(parseInt(zombies[i].style.left)<=0){
            inc[i]=0;
        }
        let posizioneZom=parseInt(zombies[i].style.left);
        posizioneZom-=inc[i];
        zombies[i].style.left=posizioneZom+"px";
    }
}