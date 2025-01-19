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
        document.getElementById("listaCitta").innerText="";
        let cercato=document.getElementById("nomeCitta").value;
        let rispostaj = await fetch("http://192.168.1.56:8088/cities?city="+cercato);
        let risposta = await rispostaj.json();
        console.log(risposta);
        if(rispostaj.status==200 && rispostaj.ok==true){
            risposta.forEach((city)=>{
                let opt=document.createElement("option");
                opt.value=city.city+"-"+city.country;
                opt.dataset.cityId=city.id;
                opt.dataset.cityNname=city.city;
                opt.dataset.cityCountry=city.country;
                document.getElementById("listaCitta").appendChild(opt);
                console.log(opt.dataset.cityId);
            });
            seleziona();
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
    let cercato=document.getElementById("nomeCitta").value.trim();
    let nome=document.getElementById("nomeU").value.trim();
    let dataInizio=document.getElementById("dataI").value;
    let dataFine=document.getElementById("dataF").value;
    let ospiti=document.getElementById("numeroO").value;
    document.getElementById("errore").classList.add("hidden");
    if(document.querySelectorAll("datalist option")[0]!=undefined && cercato!="" && nome!="" && dataInizio!="" && dataFine!="" && ospiti!=""){
        let idCitta=document.querySelectorAll("datalist option")[0];
        let prenotazione={
            cityId: idCitta.dataset.cityId,
            from: dataInizio,
            guests: ospiti,
            name: nome,
            to: dataFine
        }
        fetch("http://192.168.1.56:8088/reservations",{
            method:'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body:JSON.stringify(prenotazione)
        });
    }
    else{
        document.getElementById("errore").classList.remove("hidden");
    }
}
async function controlla(){
    let rispostaj = await fetch("http://192.168.1.56:8088/reservations");
    let risposta = await rispostaj.json();
    console.log(risposta);
}
function seleziona(){
    console.log("Entrato");
    let opt=document.querySelectorAll("datalist option");
    console.log("Preso opt "+opt.length +opt);
    let nome=document.getElementById("nomeCitta").value;
    console.log("Preso nome");
    opt.forEach((opz)=>{
        console.log("cerco");
        if(opz.dataset.cityName==nome){
            cittaSelezionata=opz;
            console.log(opz);
        }
    }); 
}