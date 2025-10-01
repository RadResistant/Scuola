import 'dart:math';
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
      home: const MyHomePage(title: 'Slot machine'),
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
  int estratto1=0;
  int estratto2=0;
  int estratto3=0;
  var x=[1,2,3];
  int giri=0;
  int monete=50;
  String perso="";
  void _gira() {
    estratto1=Random().nextInt(3);
    estratto2=Random().nextInt(3);
    estratto3=Random().nextInt(3);
    setState(() {
      giri++;
      monete-=10;
      if(monete==0){
        perso="mi dispiace hai perso tutto";
      }
      if(estratto1==estratto2 && estratto2==estratto3){
        giri=0;
        monete+=30;
      }
      if(estratto1== estratto2 && estratto1!=estratto3){
        monete+=20;
      }
      if(estratto1== estratto3 && estratto1!=estratto2){
        monete+=20;
      }
      if(estratto2== estratto3 && estratto1!=estratto3){
        monete+=20;
      }
    });
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(appBar: AppBar(backgroundColor: Theme.of(context).colorScheme.inversePrimary, title: Text(widget.title)),
        body: Center(child: Column(
            crossAxisAlignment: CrossAxisAlignment.center,
            mainAxisAlignment: MainAxisAlignment.spaceAround,
            children: <Widget>[
              Row(
                  crossAxisAlignment: CrossAxisAlignment.center,
                  mainAxisAlignment: MainAxisAlignment.spaceAround,
                  children:[
                    AnimatedSwitcher(
                        duration: const Duration(milliseconds:500),
                        transitionBuilder:(Widget child,Animation<double> animation){
                          return ScaleTransition(scale: animation,child:child);
                        },
                        child: Image.asset(
                          'images/pianeta${x[estratto1]}.jpg',height: 100,
                          key: ValueKey<int>(estratto1),
                        )),
                    AnimatedSwitcher(
                        duration: const Duration(milliseconds:500),
                        transitionBuilder:(Widget child,Animation<double> animation){
                          return ScaleTransition(scale: animation,child:child);
                        },
                        child: Image.asset(
                          'images/pianeta${x[estratto2]}.jpg',height: 100,
                          key: ValueKey<int>(estratto2),
                        )),
                    AnimatedSwitcher(
                        duration: const Duration(milliseconds:500),
                        transitionBuilder:(Widget child,Animation<double> animation){
                          return ScaleTransition(scale: animation,child:child);
                        },
                        child: Image.asset(
                          'images/pianeta${x[estratto3]}.jpg',height: 100,
                          key: ValueKey<int>(estratto3),
                        ))]),
              Text("$giri"),
              ElevatedButton(onPressed: _gira, child: Text("Gira")),
              Text("$perso $monete")
            ])));
  }
}
