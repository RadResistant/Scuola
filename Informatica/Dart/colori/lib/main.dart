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
        colorScheme: ColorScheme.fromSeed(seedColor: Color.fromRGBO(255,255,255,0)),
        useMaterial3: true,
      ),
      home: const MyHomePage(title: 'Colori'),
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
  var big =TextStyle(fontSize: 80,color: Colors.black54);
  void _incrementCounter() {
    setState(() {
    });
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(appBar: AppBar(backgroundColor: Theme.of(context).colorScheme.inversePrimary, title: Text(widget.title)),
        body: Center(child: Column(children: <Widget>[
          Container(
            width: 200,
            child:Text('verde',style:big),
            color: Colors.green,
          ),
          Container(
              width: 300,
              child:Text('rosso',style:big),
              color: Colors.red
          ),
          Container(
              width: 400,
              child:Text('giallo',style:big),
              color: Colors.yellow
          ),
          Container(
              width: 200,
              child:Text('blu',style:big),
              color: Colors.blue
          ),
          Container(
              width: 300,
              child:Text('grigio',style:big),
              color: Colors.grey
          ),
        ]))
    );
  }
}