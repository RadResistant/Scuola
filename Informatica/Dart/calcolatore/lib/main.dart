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
  double inserito=0;
  List<double> elenco=[0.0,];
  void piu(){
    inserito=double.parse(campoDiTesto.text);
    setState(() {
      elenco.add(elenco[elenco.length-1]+inserito);
      separi.add("");
    });
  }
  void meno(){
    inserito=double.parse(campoDiTesto.text);
    setState(() {
      elenco.add(elenco[elenco.length-1]-inserito);
      separi.add("");
    });
  }
  void c(){
    setState(() {
      elenco.removeRange(0, elenco.length);
      elenco.add(0);
    });
  }
  Widget separe(context,index){
    return Container(height: 5,);
  }
  ListTile numeri(context,index) {
    if(elenco[index]==0){
      return ListTile(
          title: Text("${elenco[index]}"),
          subtitle: Text("Numero neutro ${elenco[index]}"),
          leading: Icon(Icons.circle),
          tileColor: Colors.yellow,
          onLongPress:(){
            setState(() {
              elenco.remove(elenco[index]);
            });
          }
      );
    }
    else{
      if(elenco[index]>0){
        return ListTile(
            title: Text("${elenco[index]}"),
            subtitle: Text("Numero positivo ${elenco[index]}"),
            leading: Icon(Icons.favorite),
            tileColor: Colors.yellow,
            onLongPress:(){
              setState(() {
                elenco.remove(elenco[index]);
              });
            }
        );
      }
      else{
        return ListTile(
            title: Text("${elenco[index]}"),
            leading: Icon(Icons.heart_broken),
            tileColor: Colors.yellow,
            onLongPress:(){
              setState(() {
                elenco.remove(elenco[index]);
              });
            }
        );
      }
    }
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(appBar: AppBar(backgroundColor: Theme.of(context).colorScheme.inversePrimary, title: Text(widget.title)),
        body: Center(child: Column(children: <Widget>[
          Expanded(
              child:Material(
                  color:Colors.orange,
                  child: ListView.separated(
                      separatorBuilder:separe,
                      itemCount:elenco.length,
                      itemBuilder: numeri,
                      padding: EdgeInsets.all(5)
                  ))
          ),
          TextField(
            controller: campoDiTesto,
            textAlign: TextAlign.center,
            style: TextStyle(fontSize: 20),
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
