<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
        $pasti=[
            "primo"=>["costo"=>5,"quantita"=>0],
            "secondo"=>["costo"=>8,"quantita"=>0],
            "dolce"=>["costo"=>50,"quantita"=>0],
            "amaro"=>["costo"=>6,"quantita"=>0],
            "caffe"=>["costo"=>10,"quantita"=>0]
        ];
        $pasti[$_GET["ordine"]]["quantita"]+=(int)$_GET["quant"];
        print_r($pasti);
        session_start();
        if(!isset($_SESSION["pasti"])){
            $_SESSION["pasti"]=$pasti;
        }
        echo "<br>";
        print_r($_SESSION);
        echo "<br>";
        $tot=0;
        foreach($pasti as $key=>$pasto){
            $_SESSION[$key]["quantita"]+=$pasto["quantita"];
        }
        echo "<table><tr><th>Nome</th><th>Quantità</th><th>Costo</th><th>Subtotale</th></tr>";
        foreach($_SESSION["pasti"] as $key=>$pasto){
            echo "<tr><td>".$key."</td><td>".$pasto["quantita"]."</td><td>".$pasto["costo"]."</td><td>".((int)$pasto["quantita"]*(int)$pasto["costo"])."</td></tr>";
        }
        echo "</table>";
        foreach($_SESSION["pasti"] as $key=>$pasto){
            $tot+=((int)$pasto["quantita"]*(int)$pasto["costo"]);
        }
        echo $tot+5;
    ?>
</body>
</html>