import 'package:flutter/material.dart';
void main() {
  runApp( HelloWorld() );
}
class HelloWorld extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(theme: ThemeData(primarySwatch: Colors.red),home: SchermataPrincipale());
  }
}
class SchermataPrincipale extends StatefulWidget {
  @override
  State<SchermataPrincipale> createState(){
    return _SchermataPrincipaleState();
  }
}
class _SchermataPrincipaleState extends State<SchermataPrincipale> {
  String riga1 = "Riga 1";
  String riga2 = "Riga 2";
  String riga3 = "Riga 3";
  @override
  Widget build(BuildContext context) {
    return Scaffold(appBar: AppBar(title: Text("organizzazione")),body:Column(children:[
      Container(child:Center(child:Text(riga1,style:TextStyle(backgroundColor:Colors.blue,fontSize:50))),color:Colors.yellow),
      Text(riga2),Text(riga3)
    ]));
  }
}