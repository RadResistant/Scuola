import 'dart:collection';
import 'package:flutter/material.dart';
void main() {
  runApp(HelloWorld());
}
class HelloWorld extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: ThemeData(
        primarySwatch: Colors.orange,
      ),
      home: SchermataPrincipale(),
    );
  }
}
class SchermataPrincipale extends StatefulWidget {
  @override
  State<SchermataPrincipale> createState() {
    return _SchermataPrincipaleState();
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
class MeseDescrizione{
  String nome;
  bool fiorito;
  MeseDescrizione(this.nome, [this.fiorito=true]);
}
class _SchermataPrincipaleState extends State<SchermataPrincipale> {
  TextStyle testoGrande = TextStyle(fontSize: 25);
  TextStyle meseSi = TextStyle(fontSize: 15, color: Colors.green);
  TextStyle meseNo = TextStyle(fontSize: 15, color: Colors.red);
  String descrizionePianta = "";
  double spesaTotale = 0;
  bool bilanciata = false;
  int fioreSelezionionato=0;
  List<Fiori> listaSelezionate = [];
  List<Fiori> listaDisponibili=[
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
        10
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
        10
    )
  ];
  List<String> nomiMesi = ["errore","Gennaio","Febbraio",
    "Marzo","Aprile","Maggio","Giugno",
    "Luglio","Agosto","Settembre","Ottobre",
    "Novembre","Dicembre"];
  List<MeseDescrizione> etichetteMesiPerGraficaDescrizone = [
    MeseDescrizione("Ma"),MeseDescrizione("Ap"),
    MeseDescrizione("Mg"),MeseDescrizione("Gi"),
    MeseDescrizione("Lu"),MeseDescrizione("Ag"),
    MeseDescrizione("Se"),MeseDescrizione("Ot"),
  ];
  List<Mese> etichetteMesiPerGrafica = [
    Mese("Ma"),Mese("Ap"),
    Mese("Mg"),Mese("Gi"),
    Mese("Lu"),Mese("Ag"),
    Mese("Se"),Mese("Ot"),
  ];
  void ricalcolaTotale(){
    var mesiOccupati = HashSet<String>();
    spesaTotale = 0;
    bool clienteSceltoSempreverde=false;
    for(int i=0; i<etichetteMesiPerGrafica.length; i++){
      etichetteMesiPerGrafica[i].fiorito = false;
    }
    for(int i=0; i<listaSelezionate.length; i++){
      spesaTotale += listaSelezionate[i].prezzo *
          listaSelezionate[i].quantita;
      if( !listaSelezionate[i].sempreverde ) {
        // imposto etichette e
        for(int iMese=0; iMese<listaSelezionate[i].fioritura.length; iMese++) {
          etichetteMesiPerGrafica[ listaSelezionate[i].fioritura[iMese] - 3 ].fiorito = true;
          mesiOccupati.add( nomiMesi[listaSelezionate[i].fioritura[iMese]]);
        }
      }
      if( listaSelezionate[i].sempreverde ){
        clienteSceltoSempreverde = true;
      }
    }
    bilanciata = clienteSceltoSempreverde && mesiOccupati.length>=6;
  }
  Widget generaListaDisponibili(BuildContext context, int index) {
    String mesiFioritura = "";
    for(int i=0; i<listaDisponibili[index].fioritura.length; i++){
      mesiFioritura += " "+nomiMesi[listaDisponibili[index].fioritura[i]];
    }
    return ListTile(
      tileColor: (listaDisponibili[index].colore),
      title: Text(listaDisponibili[index].nome),
      subtitle: Text( listaDisponibili[index].sempreverde ?
      "sempre verde" : mesiFioritura
      ),
      leading: Image(image: AssetImage('images/${listaDisponibili[index].nome.toLowerCase()}.jpeg')),
      trailing: Text("${listaDisponibili[index].prezzo}€", style: testoGrande,),
      onTap: (){
        setState(() {
          fioreSelezionionato=index;
          pagina2();
        });
      },
      onLongPress: (){
        setState(() {
          if( !listaSelezionate.contains(listaDisponibili[index]) ) {
            listaSelezionate.add(listaDisponibili[index]);
            listaSelezionate[index].quantita++;
          }else{
            listaDisponibili[index].quantita++;
          }
          ricalcolaTotale();
        });
      },
    );
  }
  ListTile generaListaSelezionati(BuildContext context, int index) {
    return ListTile(
      tileColor: (listaSelezionate[index].colore),
      title: Text(listaSelezionate[index].nome),
      trailing: Text(
        listaSelezionate[index].quantita.toString(),
        style: testoGrande,
      ),
      onTap: (){
        setState(() {
          listaSelezionate[index].quantita += 1;
          ricalcolaTotale();
        });
      },
      onLongPress: (){
        setState(() {
          listaSelezionate[index].quantita = 0;
          listaSelezionate.remove(listaSelezionate[index]);
          ricalcolaTotale();
        });
      },
    );
  }
  Widget separe(context,index){
    return Container(height: 5);
  }
  void pagina2() {
    var mesiOccupatiDescrizione = HashSet<String>();
    for(int i=0; i<etichetteMesiPerGraficaDescrizone.length; i++){
      etichetteMesiPerGraficaDescrizone[i].fiorito = false;
    }
    for(int i=0; i<listaSelezionate.length; i++) {
      if (!listaSelezionate[i].sempreverde) {
        for (int iMese = 0; iMese < listaSelezionate[i].fioritura.length; iMese++) {
          etichetteMesiPerGrafica[ listaSelezionate[i].fioritura[iMese] - 3 ].fiorito = true;
          mesiOccupatiDescrizione.add(nomiMesi[listaSelezionate[i].fioritura[iMese]]);
        }
      }
    }
    Navigator.of(context).push(MaterialPageRoute<void>(builder: (context){
      return Scaffold(appBar:AppBar(backgroundColor: Theme.of(context).colorScheme.inversePrimary,title: Text(listaDisponibili[fioreSelezionionato].nome)),
        body:Material(color:Colors.orange[300],child: Center(child:Column(mainAxisAlignment:MainAxisAlignment.spaceAround,children: <Widget>[
          Image(image: AssetImage('images/${listaDisponibili[fioreSelezionionato].nome.toLowerCase()}.jpeg'),height: 300),
          Row(
              mainAxisAlignment: MainAxisAlignment.spaceAround,
              children:[
                for(int i = 0; i < etichetteMesiPerGraficaDescrizone.length; i++)
                  for (int iMese = 0; iMese < listaSelezionate[i].fioritura.length; iMese++)
                    Text(etichetteMesiPerGraficaDescrizone[i].nome, style: etichetteMesiPerGraficaDescrizone[iMese].fiorito ? meseSi : meseNo)
              ]),
          Padding(
              padding: EdgeInsets.fromLTRB(10, 0, 10, 0),
              child: Text(
                listaDisponibili[fioreSelezionionato].descrizione,
                style: TextStyle(
                  fontSize: 20,
                ),
              )


          ),
          Text(
              "Prezzo ${listaDisponibili[fioreSelezionionato].prezzo}€ cad.",
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
    return Scaffold(appBar: AppBar(backgroundColor: Theme.of(context).colorScheme.inversePrimary,title: const Text("Vivaio"),),body: Material(color:Colors.orange[300],child:Container(child: Column(children: <Widget>[
      Row(
        mainAxisAlignment: MainAxisAlignment.spaceAround,
        children: [
          if(bilanciata) Icon(Icons.balance),
          Text(spesaTotale.toString(), style: testoGrande),
        ],
      ),
      Row(
        mainAxisAlignment: MainAxisAlignment.spaceAround,
        children: [
          for(int i=0; i<etichetteMesiPerGrafica.length; i++)
            Text(etichetteMesiPerGrafica[i].nome, style: etichetteMesiPerGrafica[i].fiorito ? meseSi : meseNo ),
        ],
      ),
      Expanded(
        child: Material(
          color: Colors.orange[300],
          child: ListView.separated(
            itemCount: listaSelezionate.length,
            itemBuilder: generaListaSelezionati,
            separatorBuilder:separe,
            padding: EdgeInsets.all(5),
          ),
        ),
      ),
      Expanded(
          child: Material(
            color:Colors.orange[300],
            child: ListView.separated(
              itemCount: listaDisponibili.length,
              itemBuilder: generaListaDisponibili,
              separatorBuilder:separe,
              padding: EdgeInsets.all(5),
            ),
          )
      ),
      Text(descrizionePianta),
    ]))));
  }
}

