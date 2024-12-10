"use strict";
async function chiedi() {
    let risposta = await fetch("https://kili.aspix.it/edoardo/esempio.json");
    let esempio = await risposta.json();
    let campi=document.querySelectorAll("span");
    console.log(esempio);
    campi[0].innerText=esempio.nome;
    campi[1].innerText=esempio.saluto;
}
async function invia() {
    let risposta = await fetch("http://10.1.0.52:9000/saluto.json");
    let esempio = await risposta.json();
    console.log(esempio);
}