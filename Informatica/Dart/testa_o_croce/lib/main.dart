import 'dart:math';
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
      home: const MyHomePage(title: 'Testa o Croce'),
    );
  }
}
class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});
  final String title;
  @override
  State<MyHomePage> createState() => _MyHomePageState();
}
class _MyHomePageState extends State<MyHomePage> {
  var big =TextStyle(fontSize: 50);
  String ris="";
  bool testa=true;
  String moneta='images/bianco.jpg';
  double dimensione=0;
  int vinti=0;
  void _testa() {
    testa=Random().nextBool();
    setState(() {
      if(testa){
        ris="Hai vinto bravo";
        moneta='images/testa.png';
        dimensione=200;
        vinti++;
      }
      else{
        ris="Hai perso mi dispiace";
        moneta='images/croce.png';
        dimensione=200;
      }
      print(testa);
    });
  }
  void _croce() {
    testa=Random().nextBool();
    setState(() {
      if(!testa){
        ris="Hai vinto bravo";
        moneta='images/croce.png';
        dimensione=200;
        vinti++;
      }
      else{
        ris="Hai perso mi dispiace";
        moneta='images/testa.png';
        dimensione=200;
      }
      print(testa);
    });
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(appBar: AppBar(backgroundColor: Theme.of(context).colorScheme.inversePrimary, title: Text(widget.title)),
        body: Center(child: Column(children: <Widget>[
          Padding(padding:EdgeInsets.all(20)),
          Row(
              mainAxisAlignment:MainAxisAlignment.center,
              children: [
                ElevatedButton(
                    onPressed: _testa,
                    child:
                    Image(
                        image: AssetImage('images/testa.png'),
                        height: 100
                    )),
                ElevatedButton(
                    onPressed: _croce,
                    child:
                    Image(
                        image: AssetImage('images/croce.png'),
                        height: 100
                    ))
              ]),
          Image(
              image: AssetImage(moneta),
              height: dimensione
          ),
          Text(ris,style: big),
          Text("Hai vinto: $vinti volte",style: TextStyle(fontSize: 30))
        ]))
    );
  }
}