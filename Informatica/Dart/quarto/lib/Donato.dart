import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Da Donato, con mollica o senza',
      theme: ThemeData(
          colorScheme: ColorScheme.fromSeed(seedColor: Colors.pinkAccent),
          useMaterial3: true),
      home: const MyHomePage(title: 'Flutter Demo Home Page'),
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
  double _totPanini = 0;
  final _cNPanini = TextEditingController();
  final _cPPanini = TextEditingController();
  void _panini() {
    double _pPanini = double.parse(_cPPanini.text);
    double _nPanini = double.parse(_cNPanini.text);
    setState(() {
      _totPanini = _nPanini * _pPanini;
    });
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(appBar: AppBar(backgroundColor: Theme.of(context).colorScheme.inversePrimary, title: Text(widget.title)),
        body: Center(
            child: Column(
                children: <Widget>[
                  Text('Numero Panini'),
                  TextField(
                      controller: _cNPanini
                  ),
                  Text('Prezzo panini'),
                  TextField(
                      controller: _cPPanini
                  ),
                  ElevatedButton(onPressed: _panini,
                      child: const Text('Calcola')),
                  Text('Il totale è $_totPanini')
                ])));
  }
}