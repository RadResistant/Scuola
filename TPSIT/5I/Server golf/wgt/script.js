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
            p.addEventListener("click",cercaDatiCampo);
            div.appendChild(p);
            posto.appendChild(div);
        });
    }
}
let click=true;
async function cercaDatiCampo(m){
    if(click){
        let campo=await fetch(`${server}/golf/campi/${m.target.dataset.idCampo}`);
        if(campo.ok && campo.status==200){
            campo=await campo.json();
            m.target.innerText=campo.nome;
            for(let i=0;i<campo.foto.length;i++){
                let img=document.createElement("img");
                img.alt="Foto del campo";
                img.src=campo.foto[i];
                m.target.appendChild(img);
            }
            m.target.innerHTML+=`
            <p>Latitudine:${campo.latitudine}</p> 
            <p>Longitudine:${campo.longitudine}</p> 
            <p>Numero buche:${campo.numeroBuche}</p>
            <p>Tiri massimi:${campo.par}</p>
            `
        }
        click=!click;
    }
    else{
        let nome=m.target.innerText.split('\n');
        m.target.innerHTML=nome[0];
        click=!click;
    }
}
async function cercaGiocatori() {
    let posto=document.getElementById("ricercaGiocatori");
    posto.innerHTML=``;
    let giocatori=await fetch(`${server}/golf/giocatori`)
    if(giocatori.ok && giocatori.status==200){
        giocatori=await giocatori.json();
        giocatori.forEach((giocatore)=>{
            let div=document.createElement("div");
            let p=document.createElement("p");
            p.innerText=giocatore.nome+", Handicap: "+giocatore.handicap;
            p.dataset.idGiocatore=giocatore.id;
            // p.addEventListener("click",elencaPrestazioni);
            div.appendChild(p);
            posto.appendChild(div);
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
        fetch(`${server}/golf/giocatori`,{
            method:'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body:JSON.stringify(corpo)
        });
    }
}
async function cercaTornei(){
    let tornei=await fetch(`${server}/golf/tornei`);
    let posto=document.getElementById("ricercaTornei");
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
            let click=true;
            p.addEventListener("click",()=>{
                if(click){
                    div.innerHTML='';
                    div.appendChild(p);
                    div.appendChild(pCampo);
                    for(let i=0;i<torneo.campo.foto.length;i++){
                        let img=document.createElement("img");
                        img.alt="Foto del campo";
                        img.src=torneo.campo.foto[i];
                        div.appendChild(img);
                    }
                    click=!click;
                }
                else{
                    div.innerHTML="";
                    div.appendChild(p)
                    click=!click;
                }
            });
            div.appendChild(p);
            posto.appendChild(div);
        });
    }
}