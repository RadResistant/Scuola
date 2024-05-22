"use strict";
let timerSfondo=window.setInterval(scorrimentoSfondo,1);
let timerPersonaggio=window.setInterval(cammina,50);
let aggiungtaZombie=window.setInterval(aggiungiZombie,1000);
let camminaZombie=window.setInterval(camminaZ,60);
let adattaSfondo=window.setInterval(adatta,1);
let posSfondo=0;
let inc=[];
function adatta(){
    document.querySelector("body").style.backgroundSize="auto "+window.innerHeight+"px";
}
function scorrimentoSfondo(){
    posSfondo-=2;
    document.querySelector("body").style.backgroundPositionX=posSfondo+"px";
}
let posPersonaggio=0;
function cammina(){
    posPersonaggio-=355;
    if(posPersonaggio<=-750){
        posPersonaggio=145;
    }
    let foto=document.getElementById("personaggio");
    foto.style.backgroundPositionX=posPersonaggio+"px";
}
function aggiungiZombie(){
    let zom=document.createElement("div");
    zom.className="zombie";
    zom.style.left=window.innerWidth-233+"px";
    inc.push(1);
    document.body.appendChild(zom);
}
function camminaZ(){
    let zombies=document.querySelectorAll(".zombie");
    if(zombies.length>1){
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
let timerSalto;
let timerScesa;
let incrementoPavimento=1;
function premi(event){
    let tasto=event.key;
    let personaggio=document.getElementById("personaggio");
    if(tasto==" "||tasto=="ArrowUp"||tasto=="w"){
        console.log(incrementoPavimento);
        incrementoPavimento=1;
        timerSalto=window.setInterval(salto,100);
    }
}
function rilascia(event){
    let tasto=event.key;
    let personaggio=document.getElementById("personaggio");
    if(tasto==" "||tasto=="ArrowUp"||tasto=="w"){
        incrementoPavimento=0;
        window.clearInterval(timerSalto);
        timerScesa=window.setInterval(scesa,1);
    }
}
function salto(){
    let personaggio=document.getElementById("personaggio");
    let pavimento=parseInt(personaggio.style.bottom);
    if(pavimento<25){
        pavimento+=incrementoPavimento;
    }
    personaggio.style.bottom=pavimento+"%";
}
function scesa(){
    let personaggio=document.getElementById("personaggio");
    let pavimento=parseInt(personaggio.style.bottom);
    if(pavimento>10){
        pavimento--;
    }
    else{
        window.clearInterval(timerScesa);
    }
    personaggio.style.bottom=pavimento+"%";
}