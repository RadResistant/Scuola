import 'package:flutter/material.dart';

void main() {
  runApp(const NomeApplicazione());
}

class NomeApplicazione extends StatelessWidget {
  const NomeApplicazione({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        useMaterial3: true,
      ),
      home: const PaginaHome(),
    );
  }
}

class PaginaHome extends StatefulWidget {
  const PaginaHome({super.key});

  @override
  State<PaginaHome> createState() => _PaginaHomeState();
}

class _PaginaHomeState extends State<PaginaHome> {
  double value=10;
  var doppio=0.0;
  void ciaooo(){
    doppio=value*2;
    setState(() {

    });
  }
  @override
  Widget build(BuildContext context) {

    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.green,
        title: Text("Applicazione esempio"),
      ),
      body: Column(
        children: [
          Container(
        color: Colors.blue,
        child:
          Row(
            children: [
              Expanded(
              child: Text(doppio.toString()),
              flex: 2,
            ),

            ]
          ),
        ),

          Slider(
              value: value,
              max: 30,
              min:0,
              divisions: 15,
              label: value.round().toString(),
              onChanged:(valore){
                setState(() {
                  value=valore;
                }
               );
              }
          ),
          ElevatedButton(onPressed:ciaooo, child:Text("moltiplica"))
        ],
      ),
      );
  }
}

