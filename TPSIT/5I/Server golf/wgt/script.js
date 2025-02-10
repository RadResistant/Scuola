let server="http://localhost:8180"
async function cercaCampi(){
    let posto=document.getElementById("ricercaCampi");
    posto.innerHTML=`<button onclick="cercaCampi()">Cerca campi</button>`;
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
async function cercaDatiCampo(e){
    let campo=await fetch(`${server}/golf/campo/${e.target.dataset.idCampo}`);
    if(campo.ok && campo.status==200){
        campo=await campo.json();
        console.log(campo);
        let img=document.createElement("img");
        img.alt="Foto del campo";
        img.src=campo.foto[0];
        e.target.appendChild(img);
        e.target.innerHTML+=`<p>Latitudine:${campo.latitudine}</p>`
    }
}