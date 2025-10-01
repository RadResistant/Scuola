<!-- Non inserisco i commenti su gran parte dell HTML perchè do per scontato che sappiate cosa sia -->
<!-- Spero che con tutti questi commenti il codice lo possa capire anche Adam(<3) -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>Libreria</title>
</head>
<body>
    <form action="index.php">
        <button name="singup">Registrati</button>
        <button name="login">Accesso</button>
    </form>
    <?php
        // Controllo se è stato premuto il tasto con attributo "name" uguale a "singup"
        if(isset($_GET["singup"])){
            // Se è stato premuto questo allora reindirizzo alla pagina "singup.php"
            header("Location:singup.php");
        }
        // Controllo se è stato premuto il tasto con attributo "name" uguale a "login"
        if(isset($_GET["login"])){
            // Se è stato premuto questo allora reindirizzo alla pagina "login.php"
            header("Location:login.php");
        }
    ?>
</body>
</html>