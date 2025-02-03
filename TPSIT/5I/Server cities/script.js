"use strict";
let nome;
let map;
function mostra(e){      
    document.getElementById("erroreNome").classList.add("hidden");
    if(document.getElementById("nomeU").value!=""){
        nome=document.getElementById("nomeU").value;
        if(e.target.id=="pulsanteHotel"){
            aggiungiN();
            mostraMappa("Hotel");
            document.getElementById("prenotazioneHotel").classList.remove("hidden");
            document.getElementById("scelta").classList.add("hidden");
            document.getElementById("pulsanteHome").classList.remove("hidden");
        }
        if(e.target.id=="pulsanteVoli"){
            mostraMappa("Flights");
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
function mostraMappa(type){
    if(type=="Hotel"){
        const bounds=[[85,-180],[-85,180]];
        map = L.map('mapHotel',{
            maxBounds: bounds,
            maxBoundsViscosity: 2.0
        }).setView([0,0], 5);
        L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
            maxZoom: 19,
            minZoom:2,
            noWrap:true,
            attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
        }).addTo(map);
    }
    if(type=="Flights"){
        const bounds=[[85,-180],[-85,180]];
        map = L.map('mapFlights',{
            maxBounds: bounds,
            maxBoundsViscosity: 2.0
        }).setView([0,0], 5);
        L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
            maxZoom: 19,
            minZoom:2,
            noWrap:true,
            attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
        }).addTo(map);
    }
    setTimeout(function() {
        map.invalidateSize();
    }, 100); 
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
        document.getElementsByClassName("leaflet-marker-pane")[0].innerHTML="";
        document.getElementsByClassName("leaflet-shadow-pane")[0].innerHTML="";
        document.getElementsByClassName("leaflet-popup-pane")[0].innerHTML="";
        cercato=cercato.split("-");
        let citta;
        if(cercato.length>1){
            citta = await fetch("http://192.168.1.56:8088/cities?city="+cercato[0]+"&country="+cercato[1]);
        }
        else if(cercato.length==1){
            citta = await fetch("http://192.168.1.56:8088/cities?city="+cercato[0]);
        }
        if(citta.status==200 && citta.ok==true){
            citta = await citta.json();
            citta.forEach((city)=>{
                let opt=document.createElement("option");
                opt.innerText=city.city+"-"+city.country;
                opt.dataset.idCitta=city.id;
                lista.appendChild(opt);
                if(lista.id=="listaCitta"){
                    let marker = L.marker([city.coordinates.lat,city.coordinates.lng]).addTo(map);
                    marker.bindPopup(city.city+"-"+city.country).openPopup();
                    marker.idCitta=city.id;
                    marker.addEventListener("click",()=>{
                        lista.value=marker._popup._content;
                        lista.dataset.idCitta=marker.idCitta;
                    });
                }
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
        fetch("http://192.168.1.56:8088/reservations",{
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
    let rispostaj = await fetch("http://192.168.1.56:8088/reservations");
    let risposta = await rispostaj.json();
    console.log(risposta);
}
async function cercaVolo() {
    let partenza=document.getElementById("nomeCittaPartenza").value.split("-");
    let arrivo=document.getElementById("nomeCittaArrivo").value.split("-");
    let rispostaPartenza = await fetch("http://192.168.1.56:8088/cities?city="+partenza[0]+"&country="+partenza[1]);
    let lista=document.getElementById("listaVoli");
    let rispostaArrivo;
    lista.innerHTML="";
    document.getElementsByClassName("leaflet-marker-pane")[0].innerHTML="";
    document.getElementsByClassName("leaflet-shadow-pane")[0].innerHTML="";
    document.getElementsByClassName("leaflet-popup-pane")[0].innerHTML="";
    // document.getElementsByClassName("leaflet-zoom-animated")[0].innerText=""; 
    if(arrivo!=""){
        rispostaArrivo = await fetch("http://192.168.1.56:8088/cities?city="+arrivo[0]+"&country="+arrivo[1]);
    }
    if(rispostaPartenza.status==200 && rispostaPartenza.ok==true){
        rispostaPartenza = await rispostaPartenza.json();
        let rispostav;
        if(arrivo!=""){ 
            rispostaArrivo = await rispostaArrivo.json();
            rispostav = await fetch("http://192.168.1.56:8088/flights?from="+rispostaPartenza[0].id+"&to="+rispostaArrivo[0].id);
        }
        else{
            rispostav = await fetch("http://192.168.1.56:8088/flights?from="+rispostaPartenza[0].id);
        }
        if(rispostav.ok==true && rispostav.status==200){
            rispostav = await rispostav.json();
            rispostav.forEach((flight)=>{
                let opt=document.createElement("option");
                opt.innerText=flight.from.city+"-"+flight.to.city;
                opt.dataset.idVolo=flight.id;
                lista.appendChild(opt);
                let markerFrom = L.marker([flight.from.coordinates.lat,flight.from.coordinates.lng]).addTo(map);
                markerFrom.bindPopup(flight.from.city+"-"+flight.from.country).openPopup();
                markerFrom.idVolo=flight.id;
                markerFrom.addEventListener("click",()=>{
                    lista.value=markerFrom._popup._content;
                    lista.dataset.idVolo=markerFrom.idVolo;
                });
                let markerTo = L.marker([flight.to.coordinates.lat,flight.to.coordinates.lng]).addTo(map);
                markerTo.bindPopup(flight.to.city+"-"+flight.to.country).openPopup();
                markerTo.idVolo=flight.id;
                markerTo.addEventListener("click",()=>{
                    lista.value=markerTo._popup._content;
                    lista.dataset.idVolo=markerTo.idVolo;
                });
                //Da fixare
                let curve = L.curve([
                        'M',[flight.from.coordinates.lat,flight.from.coordinates.lng],
                        'Q',[(flight.from.coordinates.lat*1.5),(flight.to.coordinates.lng)],
                        [flight.to.coordinates.lat,flight.to.coordinates.lng]
                ],{color:'red',weight:2}).addTo(map);
                curve.bindPopup("From "+flight.from.city+"-"+flight.from.country+" to "+flight.to.city+"-"+flight.to.country);
                curve.idVolo=flight.id;
                curve.addEventListener("click",()=>{
                    lista.value=curve._popup._content;
                    lista.dataset.idVolo=curve.idVolo;
                });
                // let polyline=L.polyline([
                //     [flight.from.coordinates.lat,flight.from.coordinates.lng],
                //     [flight.to.coordinates.lat,flight.to.coordinates.lng]
                // ],{color:"red"}).addTo(map);
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
        fetch("http://192.168.1.56:8088/tickets",{
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
    let rispostaj = await fetch("http://192.168.1.56:8088/tickets");
    let risposta = await rispostaj.json();
    console.log(risposta);
}
async function ricercaPrenotazioni() {
    document.getElementById("ricerca").innerHTML="";
    let hotel = await fetch("http://192.168.1.56:8088/reservations?name="+nome);
    if(hotel.ok==true){
        hotel = await hotel.json();
        hotel.forEach(async (reservation)=>{
            let citta= await fetch("http://192.168.1.56:8088/cities/"+reservation.cityId);
            citta=await citta.json();
            document.getElementById("ricerca").innerHTML+=
            `<section class="biglietto">
                <h1>Hotel ${citta.city}</h1>
                <p>Ospiti:${reservation.guests}</p>
                <p>Check in:${reservation.from}</p>
                <p>Check out:${reservation.to}</p>
                <p>Paese:${citta.country}</p>
            </section>`;
        });
    }
    let voli=await fetch("http://192.168.1.56:8088/tickets?name="+nome);
    if(voli.ok==true){
        voli=await voli.json();
        voli.forEach(async (ticket)=>{
            let volo= await fetch("http://192.168.1.56:8088/flights/"+ticket.flightId);
            volo=await volo.json();
            document.getElementById("ricerca").innerHTML+=
            `<section class="biglietto">
                <h1>Volo ${ticket.flightId}</h1>
                <p>Data di partenza:${ticket.date}</p>
                <p>Data di arrivo:${ticket.date}</p>
                <p>Paese di partenza:${volo.from.city}</p>
                <p>Paese di arrivo:${volo.to.city}</p>
            </section>`;
        });
    }
}