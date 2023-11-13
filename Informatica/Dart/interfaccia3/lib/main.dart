import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart';
void main() {
  debugPaintSizeEnabled = true;
  runApp(interfaccia());
}
class interfaccia extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        theme: ThemeData(primarySwatch: Colors.blue),
        home: SchermataPrincipale());
  }
}
class SchermataPrincipale extends StatefulWidget {
  @override
  State<SchermataPrincipale> createState() {
    return _SchermataPrincipaleState();
  }
}
class _SchermataPrincipaleState extends State<SchermataPrincipale> {
  String _testoPulsante = "Hello World!";
  void _saluta() {
    _testoPulsante = 'Ciao Mondo!';
    setState(() {});
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(title: Container(child: Text("pippo"))),
        body: Column(children: <Widget>[
          Row(children:[Expanded(child: Container(child: (Align(child: Text("Base"), alignment: Alignment.centerLeft)),color: Colors.red)),
            Expanded(flex:2,child:Container(child: (Align(child: Text("oooo"), alignment: Alignment.centerLeft)),color: Colors.orangeAccent))] ),
          Row(children:[Expanded(child: Container(child: (Align(child: Text("Altezza"), alignment: Alignment.centerLeft)),color: Colors.green)),
            Expanded(flex:2,child:Container(child: (Align(child: Text("pppp"), alignment: Alignment.centerLeft)),color: Colors.blueAccent))])
        ]));
  }
}