<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vettori</title>
    <style>
        td{
            border:2px solid black;
        }
        table,th,tr,td{
            margin:0;
        }
        .sopra{
            background-color:green;
        }
        .sotto{
            background-color:red;
        }
    </style>
</head>
<body>
    <?php
        $vettore=riempi();
        function riempi(){
            $numeri=array();
            for($i=0;$i<101;$i++){
                $numeri[$i]=rand(1,1000);
            }
            return $numeri;
        }
        function massimo($numeri){
             $numeroMassimo=$numeri[0];
             foreach($numeri as $numero){
                 if($numeroMassimo<$numero){
                     $numeroMassimo=$numero;
                }
            }
            return $numeroMassimo;
            // return max($numeri);
        }
        function media($numeri){
            $totale=0;
            foreach($numeri as $numero){
                $totale+=$numero;
            }
            return $totale/count($numeri);
        }
    ?>
    <h1>Numeri Casuali</h1>
    <?php
        foreach($vettore as $numero){
            echo $numero."-";
        }
        echo("<h1>Massimo</h1>");
    ?>
    <?php
        echo massimo($vettore);
    ?>
    <h1>Media</h1>
    <?php
        echo round(media($vettore));
    ?>
    <h1>Tabella</h1>
    <table>
        <?php
            foreach($vettore as $numero){
                if($numero>round(media($vettore))){
                    echo "<tr><td>$numero</td></tr>";
                }
            }
        ?>
    </table>
</body>
</html>