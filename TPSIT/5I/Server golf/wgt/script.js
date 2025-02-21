let server="http://localhost:8180"
function avvia(){
    cercaCampi();
    cercaGiocatori();
    cercaTornei();
}
async function cercaCampi(){
    let posto=document.getElementById("ricercaCampi");
    posto.innerHTML=``;
    let campi=await fetch(`${server}/golf/campi`)
    if(campi.ok && campi.status==200){
        campi=await campi.json();
        campi.forEach((campo) => {
            let div=document.createElement("div");
            let p=document.createElement("p");
            p.innerText=campo.nome;
            p.dataset.idCampo=campo.id;
            let clickG=true;
            p.addEventListener("click",async (m)=>{
                if(clickG){
                    let tornei= await fetch(`${server}/golf/tornei`);
                    if(tornei.ok){
                        tornei=await tornei.json();
                        tornei.filter(torneo=>torneo.campo.id==m.target.dataset.idCampo).forEach((torneo)=>{
                            for(let i=0;i<torneo.campo.foto.length;i++){
                                let img=document.createElement("img");
                                img.alt="Foto del campo";
                                img.src=torneo.campo.foto[i];
                                div.appendChild(img);
                            }
                            div.innerHTML+=`
                            <p>Latitudine:${torneo.campo.latitudine}</p> 
                            <p>Longitudine:${torneo.campo.longitudine}</p> 
                            <p>Numero buche:${torneo.campo.numeroBuche}</p>
                            <p>Tiri massimi:${torneo.campo.par}</p>
                            <h3>Tornei svolti nel campo</h3>
                            `
                        })
                        tornei=tornei.filter(torneo=>torneo.campo.id==m.target.dataset.idCampo).forEach(torneo=>{
                            let p=document.createElement("p");
                            p.innerText=torneo.nome+" svolto in data: "+torneo.data;
                            div.appendChild(p);
                        });
                    }
                    clickG=!clickG;
                }
                else{
                    let nome=m.target.innerText.split('\n');
                    m.target.innerHTML=nome[0];
                    clickG=!clickG;
                }
            });
            div.appendChild(p);
            posto.appendChild(div);
        });
    }
}
// let click=true;
// async function cercaDatiCampo(m){
//     if(click){
//         let campo=await fetch(`${server}/golf/campi/${m.target.dataset.idCampo}`);
//         let tornei= await fetch(`${server}/golf/tornei`);
//         if(campo.ok && tornei.ok){
//             campo=await campo.json();
//             tornei=await tornei.json();
//             m.target.innerText=campo.nome;
//             for(let i=0;i<campo.foto.length;i++){
//                 let img=document.createElement("img");
//                 img.alt="Foto del campo";
//                 img.src=campo.foto[i];
//                 m.target.appendChild(img);
//             }
//             m.target.innerHTML+=`
//             <p>Latitudine:${campo.latitudine}</p> 
//             <p>Longitudine:${campo.longitudine}</p> 
//             <p>Numero buche:${campo.numeroBuche}</p>
//             <p>Tiri massimi:${campo.par}</p>
//             <h3>Tornei svolti nel campo</h3>
//             `
//             tornei=tornei.filter(torneo=>torneo.campo.id==m.target.dataset.idCampo).forEach(torneo=>{
//                 let p=document.createElement("p");
//                 p.innerText=torneo.nome+" svolto in data: "+torneo.data;
//                 m.target.appendChild(p);
//             });
//         }
//         click=!click;
//     }
//     else{
//         let nome=m.target.innerText.split('\n');
//         m.target.innerHTML=nome[0];
//         click=!click;
//     }
// }
async function cercaGiocatori() {
    let posto=document.getElementsByClassName("ricercaGiocatori");
    posto.innerHTML=``;
    let giocatori=await fetch(`${server}/golf/giocatori`)
    if(giocatori.ok && giocatori.status==200){
        giocatori=await giocatori.json();
        giocatori.forEach((giocatore)=>{
            let div=document.createElement("div");
            let p=document.createElement("p");
            p.innerText=giocatore.nome+", Handicap: "+giocatore.handicap;
            p.dataset.idGiocatore=giocatore.id;
            p.addEventListener("click",()=>{
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
            opt.dataset.idGiocatore=giocatore.id;
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
    let tornei=await fetch(`${server}/golf/tornei`);
    let posto=document.getElementsByClassName("ricercaTornei");
    posto.innerHTML=``;
    if(tornei.status==200 && tornei.ok){
        tornei= await tornei.json();
        tornei.forEach((torneo)=>{
            let div=document.createElement("div");
            let p=document.createElement("p");
            let pCampo=document.createElement("p");
            p.innerText=torneo.nome+", in data: "+torneo.data;
            p.dataset.idTorneo=torneo.id;
            pCampo.innerText="Svolto nel campo: "+torneo.campo.nome;
            let clickT=true;
            p.addEventListener("click",()=>{
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
            opt.dataset.idTorneo=torneo.id;
            // opt.addEventListener("click",elencaPrestazioni);
            posto[1].appendChild(opt);
        });
    }
}
function assegnaG(e){
    if(e.target.dataset.idGiocatore) {
        document.getElementById("nomeGP").dataset.idGiocatore=e.target.dataset.idGiocatore;
    }
    else{
        document.getElementById("torneoP").dataset.idTorneo=e.target.dataset.idTorneo;
    }
}
async function inserisciPrestazione() {
    let idGiocatore=document.getElementById("nomeGP").dataset.idGiocatore;
    let idTorneo=document.getElementById("torneoP").dataset.idTorneo;
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