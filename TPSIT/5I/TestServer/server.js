const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors'); 
const app = express();
const port = 3000;
app.use(cors());
// Middleware per parsare il corpo della richiesta
app.use(bodyParser.json());

// Endpoint per gestire la richiesta POST e del GET
app.post('/api/data', (req, res) => {
    const data = req.body;
    console.log('Dati ricevuti:', data);
    res.json({ message: 'Dati ricevuti con successo!', receivedData: data });
});
app.get('/api/data', (req, res) => {
    console.log(req._parsedUrl.query);
    const sampleData = { nome: 'Mario', email: 'mario@example.com' };
    console.log('Dati inviati tramite GET:', sampleData);
    res.json({ message: 'Dati inviati con successo tramite GET!', data: sampleData });
});

// Avvia il server
app.listen(port, () => {
    console.log(`Server in ascolto su http://localhost:${port}`);
});
