import 'dart:collection';
import 'package:flutter/material.dart';
void main() {
  runApp(const MyApp());
}
class MyApp extends StatelessWidget {
  const MyApp({super.key});
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        useMaterial3: true,
      ),
      home: const MyHomePage(title: 'Vivaio2'),
    );
  }
}
class Fiori{
  String nome;
  double prezzo;
  Color colore;
  List<int> fioritura;
  bool sempreverde;
  String descrizione;
  int quantita;
  Fiori(this.nome,this.fioritura,this.colore,this.prezzo,this.sempreverde,this.descrizione,this.quantita);
}
class Mese{
  String nome;
  bool fiorito;
  Mese(this.nome, [this.fiorito=false]);
}
class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});
  final String title;
  @override
  State<MyHomePage> createState() => _MyHomePageState();
}
class _MyHomePageState extends State<MyHomePage> {
  TextStyle meseSi = TextStyle(fontSize: 15, color: Colors.green);
  TextStyle meseNo = TextStyle(fontSize: 15, color: Colors.red);
  List<Fiori> fiori=[
    Fiori(
        "Primula",
        [3,4,5],
        Colors.yellow,
        2,
        false,
        "La primula è una pianta erbacea perenne che fiorisce in primavera. "
            "I suoi fiori sono colorati e vivaci, e possono essere gialli, arancioni, rosa, viola o bianchi. "
            "La primula ama i luoghi semi-ombreggiati e il terreno umido.",
        0
    ),
    Fiori(
        "Narciso",
        [4],
        Colors.white,
        2,
        false,
        "Il narciso è una pianta erbacea perenne che fiorisce in primavera."
            " I suoi fiori sono a forma di tromba, e possono essere gialli, bianchi o arancioni."
            " Il narciso ama i luoghi soleggiati e il terreno ben drenato.",
        0
    ),
    Fiori(
        "Viola",
        [3,4,5],
        Colors.purple,
        1,
        false,
        "La viola è una pianta erbacea perenne che fiorisce in primavera."
            "I suoi fiori sono piccoli e delicati, e possono essere di vari colori, tra cui blu, viola, giallo, arancione e bianco."
            "La viola ama i luoghi semi-ombreggiati e il terreno umido.",
        0
    ),
    Fiori(
        "Ranuncolo",
        [4,5],
        Colors.orange,
        3,
        false,
        "Il ranuncolo è una pianta erbacea perenne che fiorisce in primavera. "
            "I suoi fiori sono delicati e profumati, e possono essere di vari colori, tra cui bianco, giallo, rosa, viola e rosso."
            " Il ranuncolo ama i luoghi semi-ombreggiati e il terreno umido.",
        0
    ),
    Fiori(
        "Margherita",
        [6,7,8,9,10],
        Colors.white,
        3,
        false,
        "La margherita è una pianta erbacea perenne che fiorisce in primavera e in estate. "
            "I suoi fiori sono piccoli e delicati, e possono essere di vari colori, tra cui bianco, giallo e rosa. "
            "La margherita ama i luoghi soleggiati e il terreno ben drenato.",
        0
    ),
    Fiori(
        "Rosa",
        [6,7,8,9,10],
        Colors.red,
        12,
        false,
        "La rosa è una pianta erbacea perenne che fiorisce in primavera, in estate e in autunno. "
            "I suoi fiori sono eleganti e profumati, e possono essere di vari colori, tra cui rosso, rosa, bianco, giallo e viola. "
            "La rosa ama i luoghi soleggiati e il terreno ben drenato.",
        0
    ),
    Fiori(
        "Lavanda",
        [6,7,8,9],
        Colors.purple,
        3,
        false,
        "La lavanda è una pianta erbacea perenne che fiorisce in estate. "
            "I suoi fiori sono piccoli e profumati, e sono di colore viola. "
            "La lavanda ama i luoghi soleggiati e il terreno ben drenato.",
        0
    ),
    Fiori(
        "Aster",
        [7,8,9,10],
        Colors.purple,
        2,
        false,
        "L'aster è una pianta erbacea perenne che fiorisce in estate e in autunno. "
            "I suoi fiori sono colorati e vivaci, e possono essere di vari colori, tra cui bianco, giallo, rosa, viola e rosso."
            "L'aster ama i luoghi soleggiati e il terreno ben drenato.",
        0
    ),
    Fiori(
        "Agapanto",
        [7,8,9],
        Colors.blue,
        8,
        false,
        "L'agapanto è una pianta perenne bulbosa che produce grandi fiori a forma di stella in estate. "
            "I fiori sono disponibili in una varietà di colori, tra cui blu, viola, bianco e rosa. "
            "L'agapanto ama i luoghi soleggiati e il terreno ben drenato.",
        0
    ),
    Fiori(
        "Dalia",
        [8,9,10],
        Colors.red,
        7,
        false,
        "La dalia è una pianta erbacea perenne che produce grandi fiori colorati in estate. "
            "I fiori sono disponibili in una varietà di forme e dimensioni, e possono essere di vari colori, tra cui rosso, rosa, giallo, bianco e viola. "
            "Le dalie amano i luoghi soleggiati e il terreno ben drenato.",
        0
    ),
    Fiori(
        "Crisantemo",
        [10],
        Colors.white,
        2,
        false,
        "Il crisantemo è una pianta erbacea perenne che produce fiori colorati in autunno. "
            "I fiori sono disponibili in una varietà di forme e dimensioni, e possono essere di vari colori, tra cui giallo, bianco, rosa, viola e rosso. "
            "I crisantemi amano i luoghi soleggiati e il terreno ben drenato.",
        0
    ),
    Fiori(
        "Pino mugo",
        [],
        Colors.green,
        15,
        true,
        "Il pino mugo è un arbusto sempreverde che produce aghi duri e pungenti. "
            "I rami sono fitti e formano una forma arrotondata. "
            "Il pino mugo ama i luoghi soleggiati e il terreno ben drenato.",
        0
    ),
    Fiori(
        "Ginepro",
        [],
        Colors.green,
        15,
        true,
        "Il ginepro è un arbusto o un albero sempreverde che produce aghi duri e pungenti. "
            "I rami sono spessi e formano una forma piramidale. "
            "Il ginepro ama i luoghi soleggiati e il terreno ben drenato.",
        0
    )
  ];
  List<String> nomiMesi = [
    "errore",
    "Gennaio",
    "Febbraio",
    "Marzo",
    "Aprile",
    "Maggio",
    "Giugno",
    "Luglio",
    "Agosto",
    "Settembre",
    "Ottobre",
    "Novembre",
    "Dicembre"
  ];
  List<Mese> etichetteMesiPerGrafica = [
    Mese("Ma"),Mese("Ap"),
    Mese("Mg"),Mese("Gi"),
    Mese("Lu"),Mese("Ag"),
    Mese("Se"),Mese("Ot"),
  ];
  void ricalcolaTotale(){
    var mesiOccupati = HashSet<String>();
    for(int i=0; i<etichetteMesiPerGrafica.length; i++){
      etichetteMesiPerGrafica[i].fiorito = false;
    }
    for(int i=0; i<fiori.length; i++){
      if( !fiori[i].sempreverde ) {
        // imposto etichette e
        for(int iMese=0; iMese<fiori[i].fioritura.length; iMese++) {
          etichetteMesiPerGrafica[ fiori[i].fioritura[iMese] - 3 ].fiorito = true;
          mesiOccupati.add( nomiMesi[fiori[i].fioritura[iMese]]);
        }
      }
    }
  }
  var fioreSelezionionato=0;
  Widget separe(context,index){
    return Container(height: 5);
  }
  ListTile listaFiori(context,index) {
    return ListTile(
      title: Text(
          "${fiori[index].nome}",
          style: TextStyle(
              color: Colors.black
          )),
      subtitle: Text( fiori[index].sempreverde ?
      "sempre verde" : nomiMesi[fiori[index].fioritura[0]]
      ),
      leading: Image(
          image: AssetImage(
              'images/${fiori[index].nome.toLowerCase()}.jpeg'
          )),
      trailing: Text(
          "${fiori[index].prezzo}€",
          style: TextStyle(
              fontSize: 20,
              fontWeight: FontWeight.w900,
              color: Colors.black
          )),
      tileColor: fiori[index].colore,
      onTap:(){
        fioreSelezionionato=index;
        pagina2();
      },
    );
  }
  void pagina2() {
    Navigator.of(context).push(MaterialPageRoute<void>(builder: (context){
      return Scaffold(appBar:AppBar(backgroundColor: Theme.of(context).colorScheme.inversePrimary,title: Text(fiori[fioreSelezionionato].nome)),
        body:Material(color:Colors.orange[300],child: Center(child:Column(mainAxisAlignment:MainAxisAlignment.spaceAround,children: <Widget>[
          Image(image: AssetImage('images/${fiori[fioreSelezionionato].nome.toLowerCase()}.jpeg'),height: 300),
          Row(
              mainAxisAlignment: MainAxisAlignment.spaceAround,
              children:[
                for(int i=0; i<etichetteMesiPerGrafica.length; i++)
                  Text(etichetteMesiPerGrafica[i].nome, style: etichetteMesiPerGrafica[i].fiorito ? meseSi : meseNo )
              ]),
          Padding(
              padding: EdgeInsets.fromLTRB(10, 0, 10, 0),
              child: Text(
                fiori[fioreSelezionionato].descrizione,
                style: TextStyle(
                  fontSize: 20,
                ),
              )
          ),
          Text(
              "Prezzo ${fiori[fioreSelezionionato].prezzo}€ cad.",
              style: TextStyle(
                  fontSize: 20
              )
          )
        ]))),
      );
    }));
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(appBar: AppBar(backgroundColor: Theme.of(context).colorScheme.inversePrimary, title: Text(widget.title)),
        body: Center(child: Column(children: <Widget>[
          Expanded(
              child:Material(
                  color:Colors.pink[300],
                  child: ListView.separated(
                    separatorBuilder:separe,
                    itemCount:fiori.length,
                    itemBuilder: listaFiori,
                    padding: EdgeInsets.all(5),
                  ))
          )
        ]))
    );
  }
}
