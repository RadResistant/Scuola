"use strict";
async function chiedi() {
    let nCitta=document.getElementById("nomeCitta").value;
    let risposta = await fetch("http://10.1.0.52:8088/cities?city="+nCitta);
    risposta = await risposta.json();
    console.log(risposta);
    risposta.forEach(city => {
        let p=document.createElement("p");
        p.innerText=city.city;
        document.getElementById("listaCitta").appendChild(p);
    });
}