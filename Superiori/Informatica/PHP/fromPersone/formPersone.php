<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Buongiorno 
        <?php
            echo $_GET["nome"]." ".$_GET["cognome"]
        ?>       
    </h1>
    <h2>Sei 
        <?php
            switch ($_GET["sesso"]){
                case "M":
                    echo "maschio";
                    break;
                case "F":
                    echo "femmina";
                    break;
            }
        ?>
    </h2>
    <h2>Partecipante la classe: <?php echo $_GET["classe"]; ?></h2>
    <h2>Nato il: <?php echo $_GET["dNascita"]; ?></h2>
</body>
</html>