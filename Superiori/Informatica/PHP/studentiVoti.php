<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>    
    <?php
    // So che poteva essere fatto con un solo doppio foreach
        $studenti = [
        ["nome" => "Mario", "voto" => 8],
        ["nome" => "Lucia", "voto" => 9],
        ["nome" => "Giovanni", "voto" => 7]
        ];
        echo "<table>";
        foreach($studenti as $studente){
            foreach($studente as $tipo=>$dato){
                //echo "<tr><td>$dato</td><td>$dato</td><tr>";
                if($tipo=="nome"){
                    echo "<tr><td>$dato</td>";
                }
                else{
                    echo "<td>$dato</td><tr>";
                }
            }
        }
        echo "</table>";
        echo "<hr>";
        $totale=0;
        foreach($studenti as $studente){
            foreach($studente as $tipo=>$dato){
                if($tipo=="voto"){
                    $totale+=$dato;
                }
            }
        }
        echo $totale/count($studenti);
        echo "<hr>";
        $votoAlto=0;
        $alunnoAlto="";
        $votoBasso=10;
        $alunnoBasso="";
        foreach($studenti as $studente){
            foreach($studente as $tipo=>$dato){
                if($tipo=="voto"){
                    if($votoAlto<$dato){
                        $votoAlto=$dato;
                        $alunnoAlto=$studente;
                    }
                    if($votoBasso>$dato){
                        $votoBasso=$dato;
                        $alunnoBasso=$studente;
    
                }
                }
            }
        }
        echo "il peggiore ".$alunnoBasso["nome"]." ".$votoBasso." il migliore ".$alunnoAlto["nome"]." ".$votoAlto;
    ?>
</body>
</html>
<!--
Alternativa di Clementi
<!DOCTYPE html>
<html>
  <head>
    <title>Hello, World!</title>
    <link rel="stylesheet" href="styles.css" />
  </head>
  <body>
    <?php/*
    $studenti = [
        ["nome" => "Mario", "voto" => 8],
        ["nome" => "Lucia", "voto" => 9],
        ["nome" => "Giovanni", "voto" => 4],
            ["nome" => "Urba", "voto" => 12]
    ];
    echo "<table>";
    for( $i=0; $i<count($studenti);$i++ ){
        echo "<tr>";
        echo "<td>".$studenti[$i]["nome"]."</td>";
        echo "<td>".$studenti[$i]["voto"]."</td>";
        echo "</tr>";
    }
    echo "</table>";
    function calcAvg($v){
        $som;
        for( $i=0; $i<count($v);$i++ ){
            $som+=$v[$i]["voto"];
        }
        return $som/count($v);
    }
    echo "media: ".calcAvg($studenti)."<br>";
    function calcMaxMin($vect){
        $max=0;
        for( $i=0; $i<count($vect);$i++ ){
            if($max<$vect[$i]["voto"]){
                $max=$vect[$i]["voto"];
            }
        }
    
    
        $min=$max;
        for( $i=0; $i<count($vect);$i++ ){
            if($min>$vect[$i]["voto"]){
                $min=$vect[$i]["voto"];
            }
        }
    
        return "max: ".$max."  min: ".$min;
    }
    echo calcMaxMin($studenti);*/
?>
  </body>
</html>
-->