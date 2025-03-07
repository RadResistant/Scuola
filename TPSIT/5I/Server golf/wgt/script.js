let server="http://localhost:8180";
let coordinate=[0,0];
const bounds=[[85,-180],[-85,180]];
let map= L.map('map',{
    maxBounds: bounds,
    maxBoundsViscosity: 2.0
}).setView(coordinate, 5);
window.navigator.geolocation.getCurrentPosition(posTrovata);
function posTrovata(posizione){
    coordinate=[posizione.coords.latitude,posizione.coords.longitude];
    map.setView(coordinate,5);
    L.marker(coordinate).bindPopup("Posizione attuale").openPopup().addTo(map);
}
function avvia(){
    cercaCampi();
    cercaGiocatori();
    cercaTornei();
    mostraMappa();
}
async function mostraMappa(){
    L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
        maxZoom: 19,
        minZoom:2,
        noWrap:true,
        attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
    }).addTo(map);
}
async function cercaCampi(){
    let posto=document.getElementsByClassName("ricercaCampi");
    let imgCaricamento=document.createElement("img");
    imgCaricamento.src="images/loading.gif";
    imgCaricamento.alt="caricamento";
    imgCaricamento.classList.add("caricamento");
    posto[0].insertBefore(imgCaricamento,document.getElementById("map"));
    let campi=await fetch(`${server}/golf/campi`);
    if(campi.ok && campi.status==200){
        campi=await campi.json();
        posto[0].removeChild(imgCaricamento);
        campi.forEach((campo) => {
            let div=document.createElement("div");
            let p=document.createElement("p");
            div.classList.add("sottosezione");
            p.innerText=campo.nome;
            p.dataset.idCampo=campo.id;
            p.addEventListener("click",async(m)=>{
                let campoCercato= await fetch(`${server}/golf/campi/${m.target.dataset.idCampo}`);
                if(campoCercato.ok){
                    campoCercato=await campoCercato.json();
                    let marker = L.marker([campoCercato.latitudine,campoCercato.longitudine]).addTo(map);
                    marker.bindPopup(campoCercato.nome).openPopup();
                    for(let i=0;i<campoCercato.foto.length;i++){
                        let img=document.createElement("img");
                        img.alt="Foto del campo";
                        img.src=campoCercato.foto[i];
                        div.appendChild(img);
                    }
                    div.innerHTML+=`
                    <p>Latitudine:${campoCercato.latitudine}</p> 
                    <p>Longitudine:${campoCercato.longitudine}</p> 
                    <p>Numero buche:${campoCercato.numeroBuche}</p>
                    <p>Tiri massimi:${campoCercato.par}</p>
                    <h3>Tornei svolti nel campo</h3>
                    `;
                    let tornei=campoCercato.tornei;
                    tornei.sort((a,b) => new Date(b.data.split("T")[0]) - new Date(a.data.split("T")[0])).forEach(torneo=>{
                        let p=document.createElement("p");
                        p.innerText=torneo.nome;
                        p.addEventListener("click",()=>{
                            p.innerText=torneo.nome+"\n-svolto in data: "+torneo.data.split("T")[0]+"\n-iniziato alle ore: "+torneo.data.split("T")[1].split("+")[0].split(".")[0];
                        });
                        div.appendChild(p);
                    });
                }
            });
            div.appendChild(p);
            posto[0].insertBefore(div,document.getElementById("map"));
        });
        campi.forEach((campo)=>{
            let opt=document.createElement("option");
            opt.innerText=campo.nome+", numero buche: "+campo.numeroBuche+", par: "+campo.par;
            opt.value=campo.id;
            posto[1].appendChild(opt);
        })
    }
}
async function cercaGiocatori() {
    let posto=document.getElementsByClassName("ricercaGiocatori");
    posto.innerHTML=``;
    let imgCaricamento=document.createElement("img");
    imgCaricamento.src="images/loading.gif";
    imgCaricamento.alt="caricamento";
    imgCaricamento.classList.add("caricamento");
    posto[0].appendChild(imgCaricamento);
    let giocatori=await fetch(`${server}/golf/giocatori`)
    if(giocatori.ok && giocatori.status==200){
        giocatori=await giocatori.json();
        posto[0].removeChild(imgCaricamento);
        giocatori.sort((a,b)=>b.handicap - a.handicap).forEach((giocatore,index)=>{
            let div=document.createElement("div");
            let p=document.createElement("p");
            div.classList.add("sottosezione");
            p.innerText=index+1+"° "+giocatore.nome+", Handicap: "+giocatore.handicap;
            p.dataset.idGiocatore=giocatore.id;
            p.addEventListener("click",()=>{
                div.innerHTML="";
                div.appendChild(p);
                giocatore.prestazioni.forEach((prestazione)=>{
                    let pp=document.createElement("p");
                    pp.innerText=prestazione.torneo.nome+", svolto in data: "+prestazione.torneo.data.split("T")[0]+" sul campo: "+prestazione.torneo.campo.nome;
                    pp.dataset.idPrestazione=prestazione.id;
                    div.appendChild(pp);
                });
            });
            div.appendChild(p);
            posto[0].appendChild(div);
        });
        giocatori.forEach((giocatore)=>{
            let opt=document.createElement("option");
            opt.innerText=giocatore.nome+", Handicap: "+giocatore.handicap;
            opt.value=giocatore.id;
            posto[1].appendChild(opt);
        });
    }
}
async function inserisciGiocatore() {
    let name=document.getElementById("nomeGiocatore").value;
    let handicapp=document.getElementById("handicapGiocatore").value;
    if(name!="" && handicapp!=""){
        let corpo={
            nome:name,
            handicap:handicapp
        };
        let risposta=await fetch(`${server}/golf/giocatori`,{
            method:'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body:JSON.stringify(corpo)
        });
        if(risposta.ok){
            document.getElementById("giocatoreSI").innerText="Giocatore inserito con successo";
            document.getElementById("giocatoreSI").classList.add("successo");
            for(let i=0; i<2; i++){
                if(document.getElementById("giocatoreSI").classList[i]=="insuccesso"){
                    document.getElementById("giocatoreSI").classList.remove("insuccesso");
                }
            }
        }
        else{
            if(risposta.status==400){
                document.getElementById("giocatoreSI").innerText="Riempi tutti i campi";
                document.getElementById("giocatoreSI").classList.add("insuccesso");
                for(let i=0; i<2; i++){
                    if(document.getElementById("giocatoreSI").classList[i]=="successo"){
                        document.getElementById("giocatoreSI").classList.remove("successo");
                    }
                }
            }
            if(risposta.status==500){
                document.getElementById("giocatoreSI").innerText="Errore del server";
                document.getElementById("giocatoreSI").classList.add("insuccesso");
                for(let i=0; i<2; i++){
                    if(document.getElementById("giocatoreSI").classList[i]=="successo"){
                        document.getElementById("giocatoreSI").classList.remove("successo");
                    }
                }
            }
        }
    }
    else{
        document.getElementById("giocatoreSI").innerText="Riempire tutti i campi";
        document.getElementById("giocatoreSI").classList.add("insuccesso");
        for(let i=0; i<2; i++){
            if(document.getElementById("giocatoreSI").classList[i]=="successo"){
                document.getElementById("giocatoreSI").classList.remove("successo");
            }
        }
    }
}
async function cercaTornei(){
    let posto=document.getElementsByClassName("ricercaTornei");
    posto.innerHTML=``;
    let imgCaricamento=document.createElement("img");
    imgCaricamento.src="images/loading.gif";
    imgCaricamento.alt="caricamento";
    imgCaricamento.classList.add("caricamento");
    posto[0].appendChild(imgCaricamento);
    let tornei=await fetch(`${server}/golf/tornei`);
    if(tornei.status==200 && tornei.ok){
        tornei= await tornei.json();
        tornei.sort((a,b) => new Date(ordinaData(b.data)) - new Date(ordinaData(a.data)));
        posto[0].removeChild(imgCaricamento);
        tornei.forEach((torneo)=>{
            let div=document.createElement("div");
            let p=document.createElement("p");
            div.classList.add("sottosezione");
            let pCampo=document.createElement("p");
            p.innerText=torneo.nome+", in data: "+torneo.data;
            p.dataset.idTorneo=torneo.id;
            pCampo.innerText="Svolto nel campo: "+torneo.campo.nome;
            let clickT=true;
            p.addEventListener("click",async(e)=>{
                if(clickT){
                    div.innerHTML='';
                    div.appendChild(p);
                    div.appendChild(pCampo);
                    for(let i=0;i<torneo.campo.foto.length;i++){
                        let img=document.createElement("img");
                        img.alt="Foto del campo";
                        img.src=torneo.campo.foto[i];
                        div.appendChild(img);
                    }
                    div.innerHTML+="<h3>Giocatori Partecipanti</h3>";
                    let prestazioniTorneo=await fetch(`${server}/golf/tornei/${e.target.dataset.idTorneo}`);
                    prestazioniTorneo= await prestazioniTorneo.json();
                    prestazioniTorneo.prestazioni
                    .sort((a,b) => (a.colpi-a.giocatore.handicap) - (b.colpi-b.giocatore.handicap))
                    .forEach((prestazione,index)=>{
                        let giocatore=document.createElement("p");
                        giocatore.innerText=(index+1)+"° "+prestazione.giocatore.nome+" e ha terminato con "+prestazione.colpi+" colpi";
                        div.appendChild(giocatore);
                    });
                    clickT=!clickT;
                }
                else{
                    div.innerHTML="";
                    div.appendChild(p)
                    clickT=!clickT;
                }
            });
            div.appendChild(p);
            posto[0].appendChild(div);
        });
        tornei.forEach(torneo=>{
            let opt=document.createElement("option");
            opt.innerText=torneo.nome+", svolto in data: "+torneo.data;
            opt.value=torneo.id;
            posto[1].appendChild(opt);
        });
        tornei.forEach(torneo=>{
            let opt=document.createElement("option");
            opt.innerText=torneo.nome+", svolto in data: "+torneo.data;
            opt.value=torneo.id;
            posto[2].appendChild(opt);
        });
    }
}
function ordinaData(data){
    let [anno,giorno,mese]=data.split("-");
    return anno+"-"+mese+"-"+giorno;
}
async function inserisciPrestazione() {
    let idGiocatore=document.getElementById("nomeGP").value;
    let idTorneo=document.getElementById("torneoP").value;
    let nColpi=document.getElementById("numeroColpi").value;
    if(idGiocatore!=undefined && idTorneo!="undefined" && nColpi!=""){
        let oggetto={
            colpi:nColpi,
            giocatore: {
                id:idGiocatore
            },
            torneo:{
                id:idTorneo
            }
        }
        let risposta= await fetch(`${server}/golf/prestazioni`,{
            method:'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body:JSON.stringify(oggetto)
        });
        if(risposta.ok){
            document.getElementById("prestazioneSI").innerText="Prestazione inserita con successo";
            document.getElementById("prestazioneSI").classList.add("successo");
            for(let i=0; i<2; i++){
                if(document.getElementById("prestazioneSI").classList[i]=="insuccesso"){
                    document.getElementById("prestazioneSI").classList.remove("insuccesso");
                }
            }
        }
        else{
            if(risposta.status==400){
                document.getElementById("prestazioneSI").innerText="Riempi tutti i campi";
                document.getElementById("prestazioneSI").classList.add("insuccesso");
                for(let i=0; i<2; i++){
                    if(document.getElementById("prestazioneSI").classList[i]=="successo"){
                        document.getElementById("prestazioneSI").classList.remove("successo");
                    }
                }
            }
            if(risposta.status==500){
                document.getElementById("prestazioneSI").innerText="Errore del server";
                document.getElementById("prestazioneSI").classList.add("insuccesso");
                for(let i=0; i<2; i++){
                    if(document.getElementById("prestazioneSI").classList[i]=="successo"){
                        document.getElementById("prestazioneSI").classList.remove("successo");
                    }
                }
            }
        }
    }
    else{
        document.getElementById("prestazioneSI").innerText="Riempire tutti i campi";
        document.getElementById("prestazioneSI").classList.add("insuccesso");
        for(let i=0; i<2; i++){
            if(document.getElementById("prestazioneSI").classList[i]=="successo"){
                document.getElementById("prestazioneSI").classList.remove("successo");
            }
        }
    }
}
async function inserisciTorneo(){
    let idCampo=document.getElementById("campoT").value;
    let nomeT=document.getElementById("nomeTorneo").value;
    let dataT=document.getElementById("dataTorneo").value;
    if(idCampo!=undefined && idCampo!="undefined" && nomeT!="" && dataT!=""){
        let oggetto={
            nome:nomeT,
            data:dataT,
            campo:{
                id:idCampo
            }
        };
        let risposta= await fetch(`${server}/golf/tornei`,{
            method:'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body:JSON.stringify(oggetto)
        });
        if(risposta.ok){
            document.getElementById("torneoSI").innerText="Torneo inserito con successo";
            document.getElementById("torneoSI").classList.add("successo");
            for(let i=0; i<2; i++){
                if(document.getElementById("torneoSI").classList[i]=="insuccesso"){
                    document.getElementById("torneoSI").classList.remove("insuccesso");
                }
            }
        }
        else{
            if(risposta.status==400){
                document.getElementById("torneoSI").innerText="Riempi tutti i campi";
                document.getElementById("torneoSI").classList.add("insuccesso");
                for(let i=0; i<2; i++){
                    if(document.getElementById("torneoSI").classList[i]=="successo"){
                        document.getElementById("torneoSI").classList.remove("successo");
                    }
                }
            }
            if(risposta.status==500){
                document.getElementById("torneoSI").innerText="Errore del server";
                document.getElementById("torneoSI").classList.add("insuccesso");
                for(let i=0; i<2; i++){
                    if(document.getElementById("torneoSI").classList[i]=="successo"){
                        document.getElementById("torneoSI").classList.remove("successo");
                    }
                }
            }
        }
    }
    else{
        document.getElementById("torneoSI").innerText="Riempire tutti i campi";
        document.getElementById("torneoSI").classList.add("insuccesso");
        for(let i=0; i<2; i++){
            if(document.getElementById("torneoSI").classList[i]=="successo"){
                document.getElementById("torneoSI").classList.remove("successo");
            }
        }
    }
}
async function cercaGiocatoriPartecipanti(e){
    let torneo= await fetch(`${server}/golf/tornei/${e.target.value}`);
    if(torneo.ok){
        torneo=await torneo.json();
        console.log(torneo);
        torneo.prestazioni.forEach((prestazione)=>{
            let opt=document.createElement("option");
            opt.value=prestazione.id;
            opt.innerText=prestazione.giocatore.nome;
            document.getElementById("nomeGPM").appendChild(opt);
        });
    }
}
async function modificaPrestazione(){
    let idPrestazione=document.getElementById("nomeGPM").value;
    let nColpi=document.getElementById("numeroColpiModifica").value;
    if(idPrestazione!="" && nColpi!=""){
        let oggetto={
            colpi:nColpi
        };
        let risposta= await fetch(`${server}/golf/prestazioni/${idPrestazione}`,{
            method:'PUT',
            headers:{
                'Content-Type': 'application/json'
            },
            body:JSON.stringify(oggetto)
        });
        if(risposta.ok){
            document.getElementById("modificaSI").innerText="Prestazione modificata con successo";
            document.getElementById("modificaSI").classList.add("successo");
            for(let i=0; i<2; i++){
                if(document.getElementById("modificaSI").classList[i]=="insuccesso"){
                    document.getElementById("modificaSI").classList.remove("insuccesso");
                }
            }
        }
        else{
            if(risposta.status==400){
                document.getElementById("modificaSI").innerText="Riempi tutti i campi";
                document.getElementById("modificaSI").classList.add("insuccesso");
                for(let i=0; i<2; i++){
                    if(document.getElementById("modificaSI").classList[i]=="successo"){
                        document.getElementById("modificaSI").classList.remove("successo");
                    }
                }
            }
            if(risposta.status==500){
                document.getElementById("modificaSI").innerText="Errore del server";
                document.getElementById("modificaSI").classList.add("insuccesso");
                for(let i=0; i<2; i++){
                    if(document.getElementById("modificaSI").classList[i]=="successo"){
                        document.getElementById("modificaSI").classList.remove("successo");
                    }
                }
            }
        }
    }
    else{
        document.getElementById("modificaSI").innerText="Riempire tutti i campi";
        document.getElementById("modificaSI").classList.add("insuccesso");
        for(let i=0; i<2; i++){
            if(document.getElementById("modificaSI").classList[i]=="successo"){
                document.getElementById("modificaSI").classList.remove("successo");
            }
        }
    }
}
async function calcolaHandicap(){
    let giocatori= await fetch(`${server}/golf/giocatori`);
    if(giocatori.ok){
        giocatori=await giocatori.json();
        giocatori.forEach((giocatore)=>{
            let prestazioniOrdinate= giocatore.prestazioni.sort((a,b) => new Date(ordinaData(b.torneo.data)) - new Date(ordinaData(a.torneo.data)));
            let ultimeSeiP;
            for(let i=0;i<6;i++){
                ultimeSeiP.push(prestazioniOrdinate[i]);
            }
            ultimeSeiP=ultimeSeiP.sort((a,b)=>{b.colpi-a.colpi});
            let totale;
            for(let i=0;i<3;i++){
                totale+=ultimeSeiP[i];
            }
            return totale/3;
        });
    }
}