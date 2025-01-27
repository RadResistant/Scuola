"use strict";
let nome;
function mostra(e){
    document.getElementById("erroreNome").classList.add("hidden");
    if(document.getElementById("nomeU").value!=""){
        nome=document.getElementById("nomeU").value;
        if(e.target.id=="pulsanteHotel"){
            aggiungiN();
            document.getElementById("prenotazioneHotel").classList.remove("hidden");
        }
        if(e.target.id=="pulsanteVoli"){
            document.getElementById("prenotazioneVoli").classList.remove("hidden");
        }
        if(e.target.id=="pulsanteRicerca"){
            ricercaPrenotazioni();
            document.getElementById("ricerca").classList.remove("hidden");
        }
        document.getElementById("scelta").classList.add("hidden");
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
        document.getElementById("listaCitta").innerText="";
        let cercato=document.getElementById("nomeCitta").value;
        let rispostaj = await fetch("http://localhost:8088/cities?city="+cercato);
        let risposta = await rispostaj.json();
        if(rispostaj.status==200 && rispostaj.ok==true){
            risposta.forEach((city)=>{
                let opt=document.createElement("option");
                opt.value=city.city+"-"+city.country;
                document.getElementById("listaCitta").appendChild(opt);
            });
        }
        else{
            console.error("Errore "+ rispostaj.status)
        }
    }
}
async function prenotaHotel(){
    let cercato=document.getElementById("nomeCitta").value.trim().split("-");
    let dataInizio=document.getElementById("dataI").value;
    let dataFine=document.getElementById("dataF").value;
    let ospiti=document.getElementById("numeroO").value;
    document.getElementById("erroreHotel").classList.add("hidden");
    if(cercato[0]!="" && nome!="" && dataInizio!="" && dataFine!="" && ospiti!=""){
        let cittaCercata = await fetch("http://localhost:8088/cities?city="+cercato[0]+"&country="+cercato[1]);
        if(cittaCercata.status==200 && cittaCercata.ok==true){
            cittaCercata = await cittaCercata.json();
            if(cittaCercata.length>=0){
                let prenotazione={
                    cityId: cittaCercata[0].id,
                    from: dataInizio,
                    guests: ospiti,
                    name: nome,
                    to: dataFine
                };
                fetch("http://localhost:8088/reservations",{
                    method:'POST',
                    headers:{
                        'Content-Type': 'application/json'
                    },
                    body:JSON.stringify(prenotazione)
                });
            }
        }
    }
    else{
        document.getElementById("erroreHotel").classList.remove("hidden");
    }
}
async function controllaH(){
    let rispostaj = await fetch("http://localhost:8088/reservations");
    let risposta = await rispostaj.json();
    console.log(risposta);
}
async function cercaCittaVolo(e) {
    if(e.key=="Enter"){
        if(e.target.id=="nomeCittaPartenza"){
            document.getElementById("listaCittaPartenza").innerText="";
            let cercato=document.getElementById("nomeCittaPartenza").value;
            let rispostaj = await fetch("http://localhost:8088/cities?city="+cercato);
            let risposta = await rispostaj.json();
            if(rispostaj.status==200 && rispostaj.ok==true){
                risposta.forEach((city)=>{
                    let opt=document.createElement("option");
                    opt.value=city.city+"-"+city.country;
                    document.getElementById("listaCittaPartenza").appendChild(opt);
                });
            }
            else{
                console.error("Errore "+ rispostaj.status)
            }
        }
        if(e.target.id=="nomeCittaArrivo"){
            document.getElementById("listaCittaArrivo").innerText="";
            let cercato=document.getElementById("nomeCittaArrivo").value;
            let rispostaj = await fetch("http://localhost:8088/cities?city="+cercato);
            let risposta = await rispostaj.json();
            if(rispostaj.status==200 && rispostaj.ok==true){
                risposta.forEach((city)=>{
                    let opt=document.createElement("option");
                    opt.value=city.city+"-"+city.country;
                    document.getElementById("listaCittaArrivo").appendChild(opt);
                });
            }
            else{
                console.error("Errore "+ rispostaj.status)
            }
        }
    }
}
async function cercaVolo() {
    document.getElementById("listaVoli").innerText="";
    let partenza=document.getElementById("nomeCittaPartenza").value.split("-");
    let arrivo=document.getElementById("nomeCittaArrivo").value.split("-");
    let rispostaPartenza = await fetch("http://localhost:8088/cities?city="+partenza[0]+"&country="+partenza[1]);
    let rispostaArrivo;
    if(arrivo!=""){
        rispostaArrivo = await fetch("http://localhost:8088/cities?city="+arrivo[0]+"&country="+arrivo[1]);
    }
    if(rispostaPartenza.status==200 && rispostaPartenza.ok==true){
        rispostaPartenza = await rispostaPartenza.json();
        let rispostav;
        if(arrivo!=""){ 
            rispostaArrivo = await rispostaArrivo.json();
            rispostav = await fetch("http://localhost:8088/flights?from="+rispostaPartenza[0].id+"&to="+rispostaArrivo[0].id);
        }
        else{
            rispostav = await fetch("http://localhost:8088/flights?from="+rispostaPartenza[0].id);
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
        fetch("http://localhost:8088/tickets",{
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
    let rispostaj = await fetch("http://localhost:8088/tickets");
    let risposta = await rispostaj.json();
    console.log(risposta);
}
async function ricercaPrenotazioni() {
    let hotel = await fetch("http://localhost:8088/reservations?name="+nome);
    if(hotel.ok==true){
        hotel = await hotel.json();
        hotel.forEach(async (reservation)=>{
            let citta= await fetch("http://localhost:8088/cities/"+reservation.cityId);
            citta=await citta.json();
            document.getElementById("ricerca").innerHTML+=
            `<span>
                <h1>Hotel ${citta.city}</h1>
                <p>Check in:${reservation.from}</p>
                <p>Check out:${reservation.to}</p>
                <p>Paese:${citta.country}</p>
            </span>`;
        });
    }
    let voli = await fetch("http://localhost:8088/tickets?name="+nome);
    if(voli.ok==true){
        voli= await voli.json();
        voli.forEach(async (ticket)=>{
            let volo= await fetch("http://localhost:8088/flights/"+ticket.flightId);
            volo=await volo.json();
            document.getElementById("ricerca").innerHTML+=
            `<span>
            <h1>Volo ${ticket.flightId}</h1>
                <p>Data di partenza:${ticket.date}</p>
                <p>Data di arrivo:${ticket.date}</p>
                <p>Paese di partenza:${volo.from.city}</p>
                <p>Paese di arrivo:${volo.to.city}</p>
            </span>`;
        });
    }
}