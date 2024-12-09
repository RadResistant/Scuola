let timerSfondo=window.setInterval(scorrimentoSfondo,10);
let timerUccello=window.setInterval(vola,1);
let collisio=window.setInterval(collisione,1);
function carica(){
    document.getElementById("personaggio").style.bottom=0;
}
let x=0;
function scorrimentoSfondo(){
    let sfondo=document.querySelector("body");
    x-=5;
    if(x<=-1024){
        x=0
    }
    sfondo.style.backgroundPositionX=x+"px";
}
let posizioneUccello=Number(window.innerWidth);
function vola(){
    let pappagallo=document.getElementById("uccello");
    posizioneUccello--;
    if(posizioneUccello==0-pappagallo.width){
        posizioneUccello=Number(window.innerWidth);
    }
    pappagallo.style.left=posizioneUccello+"px";
}
function premuto(event){
    let personaggio=document.getElementById("personaggio");
    let tasto=event.key;
    if(tasto==' '){
        personaggio.style.bottom=personaggio.height+"px";
    }
} 
function rilasciato(event){
    let personaggio=document.getElementById("personaggio");
    let tasto=event.key;
    if(tasto==" "){
        personaggio.style.bottom=0;
    }
}
function collisione() {
    let coll = true;
    let img1 = document.getElementById("personaggio").getBoundingClientRect();
    let img2 = document.getElementById("uccello").getBoundingClientRect();
    if (img1.y > img2.y + img2.height) {
        coll = false;
    }
    if (img2.x + img2.width < img1.x) {
        coll = false;
    }
    if (img1.x + img1.width < img2.x) {
        coll = false;
    }
    if (img1.y + img1.height < img2.y) {
        coll = false;
    }
    if(coll){
        window.clearInterval(timerSfondo);
        window.clearInterval(timerUccello);
        window.clearInterval(collisio);
    }
}
