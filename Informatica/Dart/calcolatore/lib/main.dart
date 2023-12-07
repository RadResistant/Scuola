import 'package:flutter/material.dart';
void main() {
  runApp(const MyApp());
}
class MyApp extends StatelessWidget {
  const MyApp({super.key});
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        useMaterial3: true,
      ),
      home: const MyHomePage(title: 'Calcolatore'),
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
  final campoDiTesto=TextEditingController();
  double s=0;
  double inserito=0;
  var elenco=[];
  var tipoNumero=[];
  String numeropn="";
  void piu(){
    inserito=double.parse(campoDiTesto.text);
    s+=inserito;
    if(s==0){
      numeropn="Numero Neutro";
    }
    else{
      if(s>0){
        numeropn="Numero posistivo";
      }
      else{
        numeropn="Numero negativo";
      }
    }
    setState(() {
      tipoNumero.add("$numeropn");
      elenco.add("$s");
    });
  }
  void meno(){
    inserito=double.parse(campoDiTesto.text);
    s-=inserito;
    if(s==0){
      numeropn="Numero Neutro";
    }
    else{
      if(s>0){
        numeropn="Numero posistivo";
      }
      else{
        numeropn="Numero negativo";
      }
    }
    setState(() {
      tipoNumero.add("$numeropn");
      elenco.add("$s");
    });
  }
  void c(){
    setState(() {

    });
  }
  ListTile numeri(context,index) {
    return ListTile(
        title: Text("${elenco[index]}"),
        subtitle: Text("${tipoNumero[index]} ${elenco[index]}"),
        leading: Icon(Icons.favorite),
        tileColor: Colors.yellow
    );
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(appBar: AppBar(backgroundColor: Theme.of(context).colorScheme.inversePrimary, title: Text(widget.title)),
        body: Center(child: Column(children: <Widget>[
          Expanded(
              child:Material(
                  color:Colors.orange,
                  child: ListView.builder(
                      itemCount:elenco.length,
                      itemBuilder: numeri
                  ))
          ),
          TextField(
              controller: campoDiTesto
          ),
          Row(
              mainAxisAlignment: MainAxisAlignment.spaceAround,
              children: [
                ElevatedButton(
                    onPressed: piu,
                    child:Text("+")
                ),
                ElevatedButton(
                    onPressed: meno,
                    child:Text("-")
                ),
                ElevatedButton(
                    onPressed: c,
                    child:Text("C")
                )
              ])
        ]))
    );
  }
}