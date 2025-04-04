<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
        session_start();
        if(isset($_POST["prodotto"])){
            $_SESSION["prodotto".count($_SESSION)]=$_POST["prodotto"];
            foreach($_SESSION as $prodotto){
                echo "<p>".$prodotto."</p><br>";
            }
        }
    ?>
    <form action="carrello.php" method="get">
        <input type="submit" value="elimina" name="cancella">
    </form>
    <?php
        if(isset($_GET["cancella"]) && !empty($_SESSION)){
            session_destroy();
        }
    ?>
    <a href="selezione.php">Indi(ano)etro</a>
</body>
</html>