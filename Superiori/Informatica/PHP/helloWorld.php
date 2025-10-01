<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hello world</title>
</head>
<body>
    <h1>
        <?php
            $dio="Dio";
            $porco="negro";
            if(true){
                echo $dio.$porco;
            }
        ?>
    </h1>
    <h1>
        <?php
            for($i=0;$i<1;$i++){
                echo "il primo numero è ".rand(1,50)."<br>";
            }
        ?>
    </h1>
    <h1>
        <?php
            echo "il secondo numero è ".rand(1,50);
        ?>
    </h1>
    <h1>
        <?php
            echo "il terzo numero è ".rand(1,50);
        ?>
    </h1>
    <h1>
        <?php
            $ciao=array("Buongiorno","Buonpomeriggio","Buonasera");
            $nome="SAMU";
            $ora=date("H");
            if($ora<13 && $ora>6){
                echo $ciao[0]." ".$nome;
            }
            elseif($ora>13 && $ora<20){
                echo $ciao[1]." ".$nome;
            }
            else{
                echo $ciao[2]." ".$nome;
            }
        ?>
    </h1>
</body>
</html>