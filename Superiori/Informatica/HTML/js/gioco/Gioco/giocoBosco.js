"use strict";
let timerPersonaggio;
let timerIdle=window.setInterval(fermo,50);
let aggiungtaZombie=window.setInterval(aggiungiZombie,1000);
let camminaZombie=window.setInterval(camminaZ,60);
let adattaSfondo=window.setInterval(adatta,1);
let posSfondo=0;
let inc=[];
let timerSalto;
let timerScesa;
let incrementoPavimento=1;
let fotoCorsa=0;
let fotoFermo=0;
let fotoSalto=0;
function adatta(){
    document.querySelector("body").style.backgroundSize="auto "+window.innerHeight+"px";
}
function fermo(){
    document.getElementById("personaggio").style.backgroundImage="url('immagini/personaggio/Idle"+fotoFermo+".png')";
    fotoFermo++;
    if(fotoFermo==6){
        fotoFermo=0;
    }
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
        let posizioneZom=parseInt(zombies[i].style.left);
        posizioneZom-=inc[i];
        zombies[i].style.left=posizioneZom+"px";
    }
}
let incre=1;
function premi(event){
    let tasto=event.key;
    let personaggio=document.getElementById("personaggio");
    if(tasto==" "||tasto=="ArrowUp"||tasto=="w"){
        incrementoPavimento=1;
        timerSalto=window.setInterval(salto,100);
        posSfondo-=15;
        document.querySelector("body").style.backgroundPositionX=posSfondo+"px";
    }
    if(tasto=="d"|| tasto=="ArrowRight"){  
        document.getElementById("personaggio").style.backgroundImage="url('immagini/personaggio/Run"+fotoCorsa+".png')";
        fotoCorsa++;
        if(fotoCorsa==6){
            fotoCorsa=0;
        }
        for(let i=0;i<inc.length;i++){
            inc[i]=5;
        }
        posSfondo-=15;
        document.querySelector("body").style.backgroundPositionX=posSfondo+"px";
        window.clearInterval(timerIdle);
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
    if(tasto=="d"){
        for(let i=0;i<inc.length;i++){
            inc[i]=1;
        }   
    }
}
function salto(){
    let personaggio=document.getElementById("personaggio");
    let pavimento=parseInt(personaggio.style.bottom);
    document.getElementById("personaggio").style.backgroundImage="url('immagini/personaggio/Jump"+fotoSalto+".png')";
    fotoSalto+=incre;
    if(fotoSalto>=3){
        incre=0;
    }
    window.clearInterval(timerIdle);
    if(pavimento<25){
        pavimento+=incrementoPavimento;
    }
    personaggio.style.bottom=pavimento+"%";
}
function scesa(){
    let personaggio=document.getElementById("personaggio");
    let pavimento=parseInt(personaggio.style.bottom);
    incre=1;
    if(fotoSalto==6){
        incre=0;
    }
    console.log(fotoSalto);
    fotoSalto+=incre;
    document.getElementById("personaggio").style.backgroundImage="url('immagini/personaggio/Jump"+fotoSalto+".png')";
    if(pavimento>7){
        pavimento--;
    }
    else{
        timerIdle=window.setInterval(fermo,50);
        window.clearInterval(timerScesa);
    }
    personaggio.style.bottom=pavimento+"%";
}