<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>SOMMA</h1>
    <?php
        function somma($vettore){
            $somma=0;
            for($i=0;$i<count($vettore);$i++){
                $somma+=$vettore[$i];
            }
            return $somma;
        }
        $prezzi=array(1.2,2.5,2.6,5.4);
        echo somma($prezzi);
    ?>
    <h1>MEDIA</h1>
    <?php
        function media($vettore){
            $somma=0;
            for($i=0;$i<count($vettore);$i++){
                $somma+=$vettore[$i];
            }
            $somma/=count($vettore);
            return $somma;
        }
        $prezzi=array(1.2,2.5,2.6,5.4);
        echo media($prezzi);
    ?>
</body>
</html>