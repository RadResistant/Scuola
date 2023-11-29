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
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.blueAccent),
        useMaterial3: true,
      ),
      home: const MyHomePage(title: 'Interfaccia'),
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
  int _counter = 0;
  void _incrementCounter() {
    setState(() {
      _counter++;
    });
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(backgroundColor: Theme.of(context).colorScheme.inversePrimary, title: Text(widget.title)),
        body: Column(children: [
          Row(children: [Expanded(child:Container(color: Colors.red, child: Text('base'))),
            Expanded(flex: 3, child:Container(padding:EdgeInsets.all(16.0),color: Colors.blueAccent, child: Text('ooo')))]),
          Row(children: [Expanded(child: Container(color: Colors.red.shade200, child: Text('altezza'))),
            Expanded(flex: 3,child: Padding(padding:EdgeInsets.all(16.0),child: Container(color: Colors.blueAccent.shade100, child: Text('ppp'))))]),
          Spacer(),
          Expanded(child: Container(child: Align(alignment: AlignmentDirectional.topCenter, child: Text('Complicato',style: TextStyle(color: Colors.blue,fontSize: 50)),))),
          Expanded(child: Container(child: Align(alignment: AlignmentDirectional.topCenter, child: Text('parecchio',style: TextStyle(backgroundColor: Colors.teal.shade200,color: Colors.red)))))]));
  }
}