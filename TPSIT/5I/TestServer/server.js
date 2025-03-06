const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors'); 
const app = express();
const port = 3000;
app.use(cors());
app.use(bodyParser.json());
const persone=[
    {
        id:0,
        nome:"Valentino",
        congome:"Rossi",
        email:"123@23.21"
    },
    {
        id:1,
        nome:"Mario",
        congome:"Gialli",
        email:"12334@23.21"
    },
    {
        id:2,
        nome:"Maria",
        congome:"Verdi",
        email:"2354@23.21"
    },
    {
        id:3,
        nome:"Marco",
        congome:"Bianchi",
        email:"5647@2453.21"
    }
];
app.post('/api/data', (req, res) => {
    const data = req.body;
    console.log('Dati ricevuti:', data);
    res.json({ message: 'Dati ricevuti con successo!', receivedData: data });
});
app.get('/api/data', (req, res) => {
    console.log(req.query);
    let query=req.query;
    Object.keys(query).forEach(key => {
        console.log(query[key]);
    });
    // let query=req._parsedUrl.query.split("&");
    // let criterio=query[0].split("=");
    // let datiDaInviare=persone.filter((persona)=>persona.id==criterio[1]);
    // console.log('Dati inviati tramite GET:', datiDaInviare);
    // res.json({/*message: 'Dati inviati con successo tramite GET!',*/ pers:datiDaInviare});
});

// Avvia il server
app.listen(port, () => {
    console.log(`Server in ascolto su http://localhost:${port}`);
});
