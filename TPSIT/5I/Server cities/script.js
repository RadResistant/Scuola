"use strict";
let cittaSelezionata;
function aggiungiN(){
    let menu=document.getElementById("numeroO");
    for(let i=0; i<15;i++){
        let opt=document.createElement("option");
        opt.value=i+1;
        opt.innerText=opt.value;
        menu.appendChild(opt);
    }
}
async function chiedi(e) {
    let tasto=e.key;
    if(tasto=="Enter"){
        let cercato=document.getElementById("nomeCitta").value;
        let rispostaj = await fetch("http://10.1.0.52:8088/cities?city="+cercato);
        let risposta = await rispostaj.json();
        console.log(risposta);
        if(rispostaj.status==200 && rispostaj.ok==true){
            risposta.forEach((city)=>{
                let opt=document.createElement("option");
                opt.value=city.city;
                document.getElementById("listaCitta").appendChild(opt);
            });
        }
        else{
            console.error("Errore "+ rispostaj.status)
        }
    }
}
function mostraHotel(){
    aggiungiN();
    document.getElementById("prenotazioneHotel").classList.remove("hidden");
    document.getElementById("scelta").classList.add("hidden");
}
function mostraVoli(){
    document.getElementById("prenotazioneVoli").classList.remove("hidden");
    document.getElementById("scelta").classList.add("hidden");
}
async function prenota(){
    let p=document.createElement("p");
    p.innerText="Riempire tutti i campi"
    p.style.color="red";
    p.id="errore";
    let cercato=document.getElementById("nomeCitta").value.trim();
    let nome=document.getElementById("nomeU").value.trim();
    let dataInizio=document.getElementById("dataI").value;
    let dataFine=document.getElementById("dataF").value;
    let ospiti=document.getElementById("numeroO").value;
    if(cercato!="" && nome!="" && dataInizio!="" && dataFine!="" && ospiti!=""){
        let rispostaj = await fetch("http://10.1.0.52:8088/cities?city="+cercato);
        let risposta = await rispostaj.json();
        console.log(risposta);
        let prenotazione={
            cityId: risposta[0].id,
            from: dataInizio,
            guests: ospiti,
            name: nome,
            to: dataFine
        }
        fetch("http://10.1.0.52:8088/reservations",{
            method:'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body:JSON.stringify(prenotazione)
        });
    }
    else{
        document.getElementById("prenotazioneHotel").appendChild(p);
    }
}
async function controlla(){
    let rispostaj = await fetch("http://10.1.0.52:8088/reservations");
    let risposta = await rispostaj.json();
    console.log(risposta);
}