import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Rettangulo',
      theme: ThemeData(
          colorScheme: ColorScheme.fromSeed(seedColor: Colors.pinkAccent),
          useMaterial3: true),
      home: const Principale(title: 'Rettangolo'),
    );
  }
}

class Principale extends StatefulWidget {
  const Principale({super.key, required this.title});
  final String title;
  @override
  State<Principale> createState() => _PrincipaleState();
}
class _PrincipaleState extends State<Principale> {
  double _area = 0;
  double _perimetro=0;
  final _cBase = TextEditingController();
  final _cAltezza = TextEditingController();
  void _rettangolo() {
    double _base = double.parse(_cBase.text);
    double _altezza = double.parse(_cAltezza.text);
    setState(() {
      _area = _base * _altezza;
      _perimetro=(_base+_altezza)*2;
    });
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(appBar: AppBar(backgroundColor: Theme.of(context).colorScheme.inversePrimary, title: Text(widget.title)),
        body: Center(
            child: Column(
                children: <Widget>[
                  Padding(padding: EdgeInsets.all(40) ),
                  Text('Base:'),
                  TextField(
                      controller: _cBase
                  ),
                  Text('Altezza:'),
                  TextField(
                      controller: _cAltezza
                  ),
                  Padding(padding: EdgeInsets.all(20)),
                  ElevatedButton(
                      onPressed: _rettangolo,
                      child: const Text('Calcola area+perimetro',style: TextStyle(color: Colors.redAccent,fontSize: 30)),
                      style: ButtonStyle(backgroundColor: MaterialStatePropertyAll<Color>(Colors.green))
                  ),
                  Text('Perimetro= $_perimetro',style: TextStyle(color: Colors.pink,fontSize:30)),
                  Text('Area= $_area',style: TextStyle(color: Colors.pink,fontSize:30))
                ])));
  }
}