import 'package:flutter/material.dart';
void main() {
  runApp( HelloWorld() );
}
class HelloWorld extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(theme: ThemeData(primarySwatch: Colors.blue), home: SchermataPrincipale());
  }
}
class SchermataPrincipale extends StatefulWidget {
  @override
  State<SchermataPrincipale> createState(){
    return _SchermataPrincipaleState();
  }
}
class _SchermataPrincipaleState extends State<SchermataPrincipale> {
  String _testoPulsante = "Hello World!";
  String _testo='';
  void _saluta() {
    setState((){
      _testo = 'Ciao tonto!';
    });
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(appBar: AppBar(title: Text("La prima App")), body: Center(child: ElevatedButton(onPressed: _saluta, child: Text( _testoPulsante ))),body:Bottom(child: Text(_testo)));
  }
}