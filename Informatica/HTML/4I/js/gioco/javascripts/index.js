"use strict";
function centra(){
    let corpo=document.querySelector("body");
    let immagine=document.querySelectorAll("img");
    let div=document.querySelectorAll("div");
    corpo.style.width=window.innerWidth;
    corpo.style.height=window.innerHeight;
    for(let i=0;i<immagine.length;i++){
        immagine[i].style.position="fixed";
        immagine[i].style.top=window.innerHeight/2-immagine[i].height/2+"px";
        immagine[i].style.left=(div[i].width-immagine[i].width)/2+"px";
    }
}