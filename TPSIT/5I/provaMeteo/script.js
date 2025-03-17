const APIkey="3b8dba71694014a2c2cc25b295059f80";
const months=["January","February","March","April","May","June","July","August","September","October","November","December"];
const days=["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"];
window.navigator.geolocation.getCurrentPosition(trovaMeteo,errore);
function errore(){
    console.error("Posizione non trovata");
}
async function trovaMeteo(posizione) {
    let rispostaMeteoOra=await fetch(`https://api.openweathermap.org/data/2.5/weather?lat=${posizione.coords.latitude}&lon=${posizione.coords.longitude}&appid=${APIkey}&units=metric&lang=it`);
    if(rispostaMeteoOra.ok){
        let meteo=await rispostaMeteoOra.json();
        document.getElementById("body").innerHTML="";
        document.getElementById("body").innerHTML=`
        <h1>Meteo per ${meteo.name}</h1>
        <img src=https://openweathermap.org/img/wn/${meteo.weather[0].icon}@2x.png alt="iconaMeteo">
        <p>Temperatura attuale: ${Math.floor(meteo.main.temp)}</p>
        <p>Situazione attuale: ${meteo.weather[0].description}</p>
        `;
    }
    else{
        console.log(meteo.response);
    }
    let rispostaMeteoPrevisioni=await fetch(`https://api.openweathermap.org/data/2.5/forecast?lat=${posizione.coords.latitude}&lon=${posizione.coords.longitude}&appid=${APIkey}&units=metric&lang=it`);
    if(rispostaMeteoPrevisioni){
        let meteo=await rispostaMeteoPrevisioni.json();
        console.log(meteo);
        document.getElementById("body").innerHTML+=`
            <h1>Previsioni mete per ${meteo.city.name}</h1>
        `;
        meteo.list.forEach((previsione)=> {
            let data=new Date(previsione.dt_txt);
            document.getElementById("body").innerHTML+=`
            <div>
                <p>${days[data.getDay()]} ${months[data.getMonth()]} ${data.getDate()}/${data.getMonth()+1}/${data.getFullYear()} ${data.getHours()}:${data.getMinutes()}</p>
                <ul>
                    <li>Temperatura prevista:</li>
                    <ul>   
                        <li>Massima:${previsione.main.temp_max}</li>
                        <li>Minima:${previsione.main.temp_min}</li>
                    </ul>
                </ul>
            </div>
            `;
        });
    }
}