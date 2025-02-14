let server="http://localhost:8180"
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
async function cercaDatiCampo(m){
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
}