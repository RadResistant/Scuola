<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Libreria</title>
</head>
<body>
    <form action="index.php">
        <button name="singup">Registrati</button>
        <button name="login">Accesso</button>
    </form>
    <?php
        if(isset($_GET["singup"])){
            header("Location:singup.php");
        }
        if(isset($_GET["login"])){
            header("Location:login.php");
        }
    ?>
</body>
</html>