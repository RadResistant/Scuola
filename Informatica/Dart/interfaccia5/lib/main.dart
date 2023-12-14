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
        useMaterial3: true,
      ),
      home: const MyHomePage(title:""),
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
  void _incrementCounter() {
    setState(() {
    });
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(appBar: AppBar(backgroundColor: Colors.blue, title: Center(child:Text("organizzazione") )),
        body: Center(child: Column(children: <Widget>[
          Expanded(child:Row(children: [
            Expanded(
                child:Container(
                    color: Colors.orange,
                    padding: EdgeInsets.all(40),
                    child: Container(
                        color: Colors.white,
                        child: Center(
                            child:Text("3",style:TextStyle(fontSize: 50))
                        )))),
            Expanded(
                child:Column(
                    children:[Expanded(
                        child:Container(
                            child:Text("1",style:TextStyle(fontSize: 50)),
                            color: Colors.purple,
                            width: double.infinity,
                            alignment: Alignment.centerRight)),
                      Expanded(
                          child:Container(
                              padding: EdgeInsets.fromLTRB(70, 50, 60, 50),
                              child:Container(
                                  color: Colors.yellow,
                                  child:Center(
                                      child:Text("2",style:TextStyle(fontSize: 50))
                                  )))),
                      Expanded(child:
                      Container(
                        color: Colors.green,
                        child:Text("Bu",style:TextStyle(fontSize: 50)),
                        width: double.infinity,
                        alignment:Alignment.center ,
                      )),
                      Expanded(child:
                      Text("4",style: TextStyle(fontSize: 50),)
                      )
                    ]))
          ]))
        ]))
    );
  }
}
