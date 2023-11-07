import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart';
void main() {
  debugPaintSizeEnabled = true;
  runApp(interfaccia());
}
class interfaccia extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(theme: ThemeData(primarySwatch: Colors.blueGrey), home: SchermataPrincipale());
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
    return Scaffold(appBar: AppBar(title: Container(child: Text("Organizzazione"))),
        body: Column(children: <Widget>[
          Expanded(
            flex: 2,
            child: Container(
                child: Center(
                    child: Text("riga 1",
                        style: TextStyle(
                            backgroundColor: Colors.red, fontSize: 50))),
                color: Colors.yellow),
          ),
          Expanded(
              child: Container(
                  color: Colors.green,
                  child: Align(
                      child: Text("riga 2"),
                      alignment: Alignment.centerRight))),
          Expanded(
              child: Container(
                child: Text("riga 3"),
                color: Colors.blue,
              )),
        ]));
  }
}