<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
        if(isset($_COOKIE["name"]) && isset($_COOKIE["password"])){
            header("Location:risposta.php");
        }
    ?>
    <form action="risposta.php" method="post">
        <input type="text" name="name">
        <input type="password" name="password">
        <input type="submit" name="tasto">
    </form>
</body>
</html>