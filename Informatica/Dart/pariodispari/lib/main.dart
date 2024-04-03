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
      home: const MyHomePage(title: 'Pari o Dispari'),
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
  List<double> numPari=[];
  List<double> numDispari=[];
  double valoreSlider=1;
  void aggiungi(){
    setState(() {
      if(valoreSlider%2==0){
        numPari.add(valoreSlider);
      }
      else{
        numDispari.add(valoreSlider);
      }
    });
  }
  Widget separe(context,index){
    return Container(height: 5,);
  }
  ListTile pari(context,index) {
    if (numPari[index] % 2 == 0) {
      return ListTile(
        title: Text("${numPari[index]}"),
        onTap: () {
          setState(() {
            numDispari.add(numPari[index]);
            numPari.remove(numPari[index]);
          });
        },
        tileColor: Colors.yellow,
      );
    }
    else{
      return ListTile(
        title: Text("${numPari[index]}"),
        leading: Icon(Icons.circle),
        onTap: () {
          setState(() {
            numDispari.add(numPari[index]);
            numPari.remove(numPari[index]);
          });
        },
        tileColor: Colors.yellow,
      );
    }
  }
  ListTile dispari(context,index){
    if(numDispari[index]%2==0){
      return ListTile(
        title:Text("${numDispari[index]}"),
        leading: Icon(Icons.square),
        onTap:(){
          setState(() {
            numPari.add(numDispari[index]);
            numDispari.remove(numDispari[index]);
          });
        },
        tileColor: Color.fromRGBO(255, 255, 255,1),
      );
    }
    else{return ListTile(
      title:Text("${numDispari[index]}"),
      onTap:(){
        setState(() {
          numPari.add(numDispari[index]);
          numDispari.remove(numDispari[index]);
        });
      },
      tileColor: Color.fromRGBO(255, 255, 255,1),
    );


    }
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(appBar: AppBar(backgroundColor: Theme.of(context).colorScheme.inversePrimary, title: Text(widget.title)),
        body: Center(child: Column(children: <Widget>[
          Expanded(
              flex: 5,
              child: Material(
                  color: Color.fromRGBO(0, 0, 255,1),
                  child:ListView.separated(
                      separatorBuilder: separe,
                      itemBuilder:pari,
                      itemCount: numPari.length,
                      padding: EdgeInsets.all(5)
                  )
              )
          ),
          Expanded(
              flex: 1,
              child: Material(
                color: Colors.pink,
                child: Row(
                    children: [
                      Expanded(
                          child:Slider(
                              max: 5,
                              min: 1,
                              divisions: 4,
                              value: valoreSlider,
                              label: valoreSlider.toString(),
                              onChanged: (double value){
                                setState(() {
                                  valoreSlider=value;
                                });
                              }
                          )
                      )
                      ,
                      ElevatedButton(
                          onPressed: aggiungi,
                          child: Text("+"))
                    ]),
              )
          ),
          Expanded(
              flex: 5,
              child: Material(
                  color: Color.fromRGBO(0, 255, 0,1),
                  child:ListView.separated(
                      separatorBuilder: separe,
                      itemBuilder:dispari,
                      itemCount: numDispari.length,
                      padding: EdgeInsets.all(5)
                  )
              )
          )
        ]))
    );
  }
}
