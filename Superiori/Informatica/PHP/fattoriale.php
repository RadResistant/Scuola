<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
        $totale=1;
        for($numero=rand(1,5);$numero>1;$numero--){
            $totale*=$numero;
            $numero--;
        }
        echo $totale;
    ?>
</body>
</html>