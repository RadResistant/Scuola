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
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.red),
        useMaterial3: true,
      ),
      home: const MyHomePage(title: 'Fast Slow Food'),
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
  double _antipasti = 4.50;
  double _primi = 6.5;
  double _secondi = 8.5;
  double _currentSliderValue1 = 0;
  double _currentSliderValue2 = 0;
  double _currentSliderValue3 = 0;
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(backgroundColor: Colors.blue.shade300, title: Text(widget.title)),
      body: Container(decoration: BoxDecoration(image: DecorationImage(image: AssetImage("images/tovaglia.jpeg"), repeat: ImageRepeat.repeat)),
        child: Column(
          children: <Widget>[
            Text('Antipasti, $_antipasti euro',style: TextStyle(fontSize: 30,fontWeight: FontWeight.bold)),
            Image(image: AssetImage('images/antipasto.jpeg'), height: 120, width: 500),
            Row(
              children: [
                Expanded(
                    child:Slider(
                      max: 100,
                      divisions: 100,
                      value: _currentSliderValue1,
                      label: _currentSliderValue1.round().toString(),
                      onChanged: (double value) {
                        setState(() {
                          _currentSliderValue1 = value;
                        });
                      })),
                Text('${_currentSliderValue1.round()}: ${_currentSliderValue1.toInt()*_antipasti}euro',
                  style: TextStyle(fontSize: 20,fontWeight: FontWeight.bold),),]),
            Text('Primi, $_primi euro',style: TextStyle(fontSize: 30,fontWeight: FontWeight.bold)),
            Image(image: AssetImage('images/primo.jpeg'), height: 120, width: 500),
            Row(
              children: [
                Expanded(
                    child:Slider(
                      max: 100,
                      divisions: 100,
                      value: _currentSliderValue2,
                      label: _currentSliderValue2.round().toString(),
                      onChanged: (double value) {
                        setState(() {
                          _currentSliderValue2 = value;
                        });
                      }
                    )),
                Text('${_currentSliderValue2.round()}: ${_currentSliderValue2.toInt()*_primi}euro',
                  style: TextStyle(fontSize: 20,fontWeight: FontWeight.bold))]),
            Text('Secondi, $_secondi euro',style: TextStyle(fontSize: 30,fontWeight: FontWeight.bold)),
            Image(image: AssetImage('images/secondo.jpeg'),height: 120,width: 500),
            Row(
              children: [
                Expanded(
                  child: Slider(
                    max: 100,
                    divisions: 100,
                    value: _currentSliderValue3,
                    label: _currentSliderValue3.round().toString(),
                    onChanged: (double value) {
                      setState(() {
                        _currentSliderValue3 = value;
                      });
                    })),
                Text('${_currentSliderValue3.round()}: ${_currentSliderValue3.toInt()*_secondi}euro',
                    style: TextStyle(fontSize: 20,fontWeight: FontWeight.bold))]),
            Text('Totale: ${(_currentSliderValue1.toDouble()*_antipasti)+(_currentSliderValue2.toDouble()*_primi)+(_currentSliderValue3.toDouble()*_secondi)} Euro',
                style: TextStyle(fontSize: 20))
          ])));
  }
}