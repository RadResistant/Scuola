<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Eventi</title>
</head>
<?php
    session_start();
    if(!isset($_SESSION["email"]) && $_SESSION["login"]!=1){
        header("Location:index.php");
    }
?>
<body>
    <h1>WORK IN PROGRESS</h1>
    <form>
        <button name="logout">Log Out</button>
    </form>
</body>
</html>
<?php
    if(isset($_GET["logout"])){
        session_destroy();
        header("Location:index.php");
    }
?>