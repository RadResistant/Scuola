"use strict";
let cittaSelezionata;
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
async function prenota(){
    let cercato=document.getElementById("nomeCitta").value;
    let rispostaj = await fetch("http://10.1.0.52:8088/cities?city="+cercato);
    let risposta = await rispostaj.json();
    console.log(risposta);
    let prenotazione={
        cityId: risposta[0].id,
        from: "2023-01-01",
        guests: 1,
        name: "Edoardo",
        to: "2023-01-10"
    }
    fetch("http://10.1.0.52:8088/reservations",{
        method:'POST',
        headers:{
            'Content-Type': 'application/json'
        },
        body:JSON.stringify(prenotazione)
    });
}
async function controlla(){
    let rispostaj = await fetch("http://10.1.0.52:8088/reservations");
    let risposta = await rispostaj.json();
    console.log(risposta);
}