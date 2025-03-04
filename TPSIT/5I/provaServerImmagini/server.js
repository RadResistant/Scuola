// // server.js
// const WebSocket = require('ws');
// const fs = require('fs');
// const path = require('path');

// // Crea un server WebSocket
// const wss = new WebSocket.Server({ port: 8080 });

// wss.on('connection', (ws) => {
//   console.log('Client connected');
  
//   // Leggi l'immagine
//   const imagePath = path.join(__dirname, 'image.webp'); // Percorso dell'immagine
//   const imageBuffer = fs.readFileSync(imagePath); // Leggi l'immagine in buffer

//   // Invia l'immagine come buffer al client
//   ws.send(imageBuffer);
  
//   ws.on('message', (message) => {
//     console.log('Received from client: ' + message);
//   });

//   ws.on('close', () => {
//     console.log('Client disconnected');
//   });
// });

// console.log('WebSocket server is running on ws://localhost:8080');
// server.js
const WebSocket = require('ws');
const fs = require('fs');
const path = require('path');

// Crea un server WebSocket
const wss = new WebSocket.Server({ port: 8080 });

wss.on('connection', (ws) => {
  console.log('Client connesso');

  // Quando il server riceve un messaggio (immagine dal client)
  ws.on('message', (message) => {
    // console.log('Immagine ricevuta dal client');

    // // Salva l'immagine nel filesystem
    // const imageBuffer = Buffer.from(message);
    // const savePath = path.join(__dirname, 'uploads', `image-${Date.now()}.jpg`); // Salva con un nome unico

    // // Scrivi il buffer come immagine sul server
    // fs.writeFile(savePath, imageBuffer, (err) => {
    //   if (err) {
    //     console.error('Errore nel salvataggio dell\'immagine:', err);
    //     ws.send('Errore nel salvataggio dell\'immagine');
    //   } else {
    //     console.log('Immagine salvata correttamente');
    //     ws.send('Immagine salvata con successo');
    //   }
    // });
    // let testo=new TextDecoder().decode(message);
    
    // let testoJ=JSON.parse(message);
    // console.log(testoJ);
    // const savePath = path.join(__dirname, 'uploads', testoJ.name);
    // fs.writeFile(savePath, testoJ.file, (err) => {
    //   if (err) {
    //     console.error('Errore nel salvataggio dell\'immagine:', err);
    //     ws.send('Errore nel salvataggio dell\'immagine');
    //   } else {
    //     console.log('Immagine salvata correttamente');
    //     ws.send('Immagine salvata con successo');
    //   }
    // });
  });

  ws.on('close', () => {
    console.log('Client disconnesso');
  });
});

console.log('Server WebSocket in esecuzione su ws://localhost:8080');
