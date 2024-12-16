"use strict";
async function chiedi() {
    let nCitta=document.getElementById("nomeCitta").value;
    let rispostaj = await fetch("http://localHost:8088/cities?city="+nCitta);
    let risposta = await rispostaj.json();
    console.log(risposta);
    if(rispostaj.status==200 && rispostaj.ok==true){
        document.getElementById("listaCitta").removeChild;
        risposta.forEach(city => {
            let p=document.createElement("p");
            p.innerText=city.city;
            document.getElementById("listaCitta").appendChild(p);
        });
    }
    else{
        console.error("Errore "+ rispostaj.status)
    }
}