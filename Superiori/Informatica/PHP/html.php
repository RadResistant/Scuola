<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Questa Pagina fa schifo</h1>
    <?php
        include 'helloWorld.php';
        $numero=rand(1,100);
        if($numero%2==0){
            echo $numero;
        }
        else{
            echo "No che è disparo";
        }
        echo $numero;
    ?>
</body>
</html>