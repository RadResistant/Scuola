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
      home: const MyHomePage(title:""),
    );
  }
}
class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});
  final String title;
  @override
  State<MyHomePage> createState() => _MyHomePageState();
}
class Cibi{
  String nome;
  double prezzo;
  String immagine;
  Cibi(this.nome,this.prezzo,this.immagine);
}
class _MyHomePageState extends State<MyHomePage> {
  var menu=[
    Cibi("antipasto", 6.0,"images/antipasto.jpg"),
    Cibi("cappelletti",10.0,"images/cappelletti.jpg"),
    Cibi("carbonara", 7.5,"images/carbonara.jpg"),
    Cibi("amatriciana", 6.5,"images/amatriciana.jpg"),
    Cibi("costarelle", 12.0,"images/costarelle.jpg"),
    Cibi("dolce", 4.0,"images/dolce.jpg")];
  double prezzoFinale=0;
  List<String> presi=[];
  void _totale(int i) {
    setState(() {
      prezzoFinale+=menu[i].prezzo;
      presi.add(menu[i].nome);
    });
  }
  Widget separe(context,index){
    return Container(height: 5,);
  }
  ListTile menuCibi(context,index) {
    return ListTile(
        title: Text("${menu[index].nome} ${menu[index].prezzo}"),
        tileColor: Colors.yellow,
        leading: Image(image: AssetImage('${menu[index].immagine}')),
        onTap:(){
          _totale(index);
        }
    );
  }
  ListTile conto(context,index) {
    return ListTile(
        title: Text("${presi[index]}"),
        tileColor: Colors.yellow,
        onTap:(){
            setState(() {
              presi.remove(presi[index]);
            });
        }
    );
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(appBar: AppBar(backgroundColor: Colors.purple, title: Text("Menu")),
        body: Center(child: Column(children: <Widget>[
          Expanded(
              child:Material(
                  color:Colors.orange,
                  child: ListView.separated(
                      separatorBuilder:separe,
                      itemCount:menu.length,
                      itemBuilder: menuCibi,
                      padding: EdgeInsets.all(5)
                  ))
          ),
          Expanded(
              child:Material(
                  color: Colors.orange,
                  child: Row(
                      mainAxisAlignment: MainAxisAlignment.spaceAround,
                      children: [Text("totale:",style: TextStyle(fontSize: 10)),
                        Container(
                            color: Colors.deepOrange,
                            padding: EdgeInsets.all(20),
                            child:Text("$prezzoFinale",style: TextStyle(fontSize: 20))
                        )
                      ]))),
          Expanded(

            child:Material(
                color: Colors.orange ,
                child:ListView.separated(
                    separatorBuilder:separe,
                    itemCount:presi.length,
                    itemBuilder: conto,
                    padding: EdgeInsets.all(5)
                )
            ))
        ]))
    );
  }
}
