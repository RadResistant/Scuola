"use strict";
async function chiedi() {
    let risposta = await fetch("http://10.1.0.52:9000/saluto.json");
    let esempio = await risposta.json();
    console.log(esempio);
    let saluto = document.getElementById("saluto");
    let nomeDato = document.getElementById("nome");
    nomeDato.value.value = esempio.nome;
    saluto.innerText = esempio.saluto;
}
async function invia() {
    let nomeDato = document.getElementById("nome");
    let saluto = document.getElementById("saluto");
    let lingua = document.getElementById("lingua");
    if (lingua.value != "") {
        let rispostaLingua = await fetch("http://10.1.0.52:9000/salutoLocale/" + lingua.value);
        let esempioLingua = await rispostaLingua.json();
        console.log(esempioLingua);
        if (esempioLingua.saluto == null) {
            lingua.value = "lingua non disponibile";
        }
        else {
            saluto.innerText = esempioLingua.saluto;
        }
    }
    else {
        let rispostaNome = await fetch("http://10.1.0.52:9000/salutoPersonale?nome=" + nomeDato.value);
        let esempioNome = await rispostaNome.json();
        console.log(esempioNome);
        nomeDato.value = esempioNome.nome;
        saluto.innerText = esempioNome.saluto;
    }
}
async function error1() {
    let etichetta = document.getElementById("errore");
    let rispostaErrore1 = await fetch("http://10.1.0.52:9000/salutoErrore");
    if (!rispostaErrore1.ok) {
        console.error("errore " + rispostaErrore1.status);
        etichetta.innerText = "errore" + rispostaErrore1.status;
    }
    else {
        rispostaErrore1 = await rispostaErrore1.json();
    }
}
async function error2() {
    let etichetta = document.getElementById("errore");
    let rispostaErrore2 = await fetch("http://10.1.0.52:9000/salutoErrore2");
    try {
        if (!rispostaErrore2.ok) {
            console.error("errore " + rispostaErrore2.status);
        }
        else {
            rispostaErrore2 = await rispostaErrore2.json();
        }
    }
    catch (e) {
        etichetta.innerText = "errore" + e;
    }
}