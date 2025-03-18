<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form method="GET">
        <input type="text" name="email">
        <input type="password" name="password">
        <input type="date" name="datadiNascita">
        <input type="submit" name="tasto">
    </form>
    <?php
        if(isset($_GET["tasto"])){
            if(strtolower($_GET["email"])=="paolo" && strtolower($_GET["password"])=="rossi"){
                echo "<h1> Ciao ".$_GET["email"]."</h1>";
            }
            else{
                echo "<h1>Accesso negato</h1>";
            }
            if(isset($_GET["datadiNascita"])){
             //calcola l'eta in base alla data di nascita    
            }
        }
    ?>
</body>
</html>