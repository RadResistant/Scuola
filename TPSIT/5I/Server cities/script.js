"use strict";
async function chiedi() {
    let nCitta=document.getElementById("nomeCitta").value;
    let rispostaj = await fetch("http://10.1.0.52:8088/cities?city="+nCitta);
    let risposta = await rispostaj.json();
    console.log(risposta);
    if(rispostaj.status==200 && rispostaj.ok==true){
        document.getElementById("listaCitta").removeChild;
        risposta.forEach(city => {
            let opt=document.createElement("option");
            opt.value=city.city;
            document.getElementById("listaCitta").appendChild(opt);
        });
    }
    else{
        console.error("Errore "+ rispostaj.status)
    }
}
async function chiediR() {
    let rispostaj = await fetch("http://localHost:8088/reservetions");
    let risposta = await rispostaj.json();
    console.log(rispostaj);
    console.log(risposta);
}
