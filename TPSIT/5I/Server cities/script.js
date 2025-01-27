"use strict";
let nome;
function mostra(e){      
    document.getElementById("erroreNome").classList.add("hidden");
    if(document.getElementById("nomeU").value!=""){
        nome=document.getElementById("nomeU").value;
        if(e.target.id=="pulsanteHotel"){
            aggiungiN();
            document.getElementById("prenotazioneHotel").classList.remove("hidden");
            document.getElementById("scelta").classList.add("hidden");
            document.getElementById("pulsanteHome").classList.remove("hidden");
        }
        if(e.target.id=="pulsanteVoli"){
            document.getElementById("prenotazioneVoli").classList.remove("hidden");
            document.getElementById("scelta").classList.add("hidden");
            document.getElementById("pulsanteHome").classList.remove("hidden");
        }
        if(e.target.id=="pulsanteRicerca"){
            ricercaPrenotazioni();
            document.getElementById("ricerca").classList.remove("hidden");
            document.getElementById("scelta").classList.add("hidden");
            document.getElementById("pulsanteHome").classList.remove("hidden");
        }
        if(e.target.id=="pulsanteHome"){
            document.getElementById("ricerca").classList.add("hidden");
            document.getElementById("prenotazioneVoli").classList.add("hidden");
            document.getElementById("prenotazioneHotel").classList.add("hidden");
            document.getElementById("pulsanteHome").classList.add("hidden");
            document.getElementById("scelta").classList.remove("hidden");
        }
    }
    else{
        document.getElementById("erroreNome").classList.remove("hidden");
    }
}
function aggiungiN(){
    let menu=document.getElementById("numeroO");
    for(let i=0; i<15;i++){
        let opt=document.createElement("option");
        opt.value=i+1;
        opt.innerText=opt.value;
        menu.appendChild(opt);
    }
}
async function cercaCitta(e) {
    if(e.key=="Enter"){
        let cercato;
        let lista;
        if(e.target.id=="nomeCitta"){
            lista=document.getElementById("listaCitta");
            cercato=document.getElementById("nomeCitta").value;
        }
        if(e.target.id=="nomeCittaPartenza"){
            lista=document.getElementById("listaCittaPartenza");
            cercato=document.getElementById("nomeCittaPartenza").value;
        }
        if(e.target.id=="nomeCittaArrivo"){
            lista=document.getElementById("listaCittaArrivo");
            cercato=document.getElementById("nomeCittaArrivo").value;
        }
        lista.innerHTML="";
        let rispostaj = await fetch("http://10.1.0.52:8088/cities?city="+cercato);
        let risposta = await rispostaj.json();
        if(rispostaj.status==200 && rispostaj.ok==true){
            risposta.forEach((city)=>{
                let opt=document.createElement("option");
                opt.innerText=city.city+"-"+city.country;
                opt.dataset.idCitta=city.id;
                lista.appendChild(opt);
            });
        }
        else{
            console.error("Errore "+ rispostaj.status)
        }
    }
}
async function prenotaHotel(){
    let idCitta=document.getElementById("listaCitta").dataset.idCitta;
    let dataInizio=document.getElementById("dataI").value;
    let dataFine=document.getElementById("dataF").value;
    let ospiti=document.getElementById("numeroO").value;
    document.getElementById("erroreHotel").classList.add("hidden");
    if(idCitta!="" && nome!="" && dataInizio!="" && dataFine!="" && ospiti!=""){
        let prenotazione={
            cityId: idCitta,
            from: dataInizio,
            guests: ospiti,
            name: nome,
            to: dataFine
        };
        fetch("http://10.1.0.52:8088/reservations",{
            method:'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body:JSON.stringify(prenotazione)
        });
    }
    else{
        document.getElementById("erroreHotel").classList.remove("hidden");
    }
}
function assegnaH(e){
    let idCitta=e.target.dataset.idCitta;
    document.getElementById("listaCitta").dataset.idCitta=idCitta;
}
async function controllaH(){
    let rispostaj = await fetch("http://10.1.0.52:8088/reservations");
    let risposta = await rispostaj.json();
    console.log(risposta);
}
async function cercaVolo() {
    document.getElementById("listaVoli").innerText="";
    let partenza=document.getElementById("nomeCittaPartenza").value.split("-");
    let arrivo=document.getElementById("nomeCittaArrivo").value.split("-");
    let rispostaPartenza = await fetch("http://10.1.0.52:8088/cities?city="+partenza[0]+"&country="+partenza[1]);
    let rispostaArrivo;
    if(arrivo!=""){
        rispostaArrivo = await fetch("http://10.1.0.52:8088/cities?city="+arrivo[0]+"&country="+arrivo[1]);
    }
    if(rispostaPartenza.status==200 && rispostaPartenza.ok==true){
        rispostaPartenza = await rispostaPartenza.json();
        let rispostav;
        if(arrivo!=""){ 
            rispostaArrivo = await rispostaArrivo.json();
            rispostav = await fetch("http://10.1.0.52:8088/flights?from="+rispostaPartenza[0].id+"&to="+rispostaArrivo[0].id);
        }
        else{
            rispostav = await fetch("http://10.1.0.52:8088/flights?from="+rispostaPartenza[0].id);
        }
        if(rispostav.ok==true && rispostav.status==200){
            rispostav = await rispostav.json();
            console.log(rispostav);
            rispostav.forEach((flight)=>{
                let opt=document.createElement("option");
                opt.innerText=flight.from.city+"-"+flight.to.city;
                opt.dataset.idVolo=flight.id;
                document.getElementById("listaVoli").appendChild(opt);
            });
        }
        else{
            console.error("Errore "+ rispostav.status);
        }
    }
    else{
        console.error("Errore "+ risposta.status);
    }
}
function prenotaVolo(e){
    document.getElementById("erroreVoli").classList.add("hidden");
    let idVolo=document.getElementById("listaVoli").dataset.idVolo;
    let dataPartenza=document.getElementById("dataP").value;
    if(idVolo!="" && dataPartenza!=""){
        let ticket={
            name:nome,
            flightId:idVolo,
            date:dataPartenza
        };
        console.log(ticket);
        fetch("http://10.1.0.52:8088/tickets",{
            method:'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body:JSON.stringify(ticket)
        });
    }
    else{
        document.getElementById("erroreVoli").classList.remove("hidden");
    }
}
function assegnaV(e){
    let idVolo=e.target.dataset.idVolo;
    document.getElementById("listaVoli").dataset.idVolo=idVolo;
}
async function controllaV(){
    let rispostaj = await fetch("http://10.1.0.52:8088/tickets");
    let risposta = await rispostaj.json();
    console.log(risposta);
}
async function ricercaPrenotazioni() {
    document.getElementById("ricerca").innerHTML="";
    let hotel = await fetch("http://10.1.0.52:8088/reservations?name="+nome);
    if(hotel.ok==true){
        hotel = await hotel.json();
        hotel.forEach(async (reservation)=>{
            let citta= await fetch("http://10.1.0.52:8088/cities/"+reservation.cityId);
            citta=await citta.json();
            document.getElementById("ricerca").innerHTML+=
            `<section>
                <h1>Hotel ${citta.city}</h1>
                <p>Ospiti:${reservation.guests}</p>
                <p>Check in:${reservation.from}</p>
                <p>Check out:${reservation.to}</p>
                <p>Paese:${citta.country}</p>
            </section>`;
        });
    }
    let voli=await fetch("http://10.1.0.52:8088/tickets?name="+nome);
    if(voli.ok==true){
        voli=await voli.json();
        voli.forEach(async (ticket)=>{
            let volo= await fetch("http://10.1.0.52:8088/flights/"+ticket.flightId);
            volo=await volo.json();
            document.getElementById("ricerca").innerHTML+=
            `<section>
                <h1>Volo ${ticket.flightId}</h1>
                <p>Data di partenza:${ticket.date}</p>
                <p>Data di arrivo:${ticket.date}</p>
                <p>Paese di partenza:${volo.from.city}</p>
                <p>Paese di arrivo:${volo.to.city}</p>
            </section>`;
        });
    }
}