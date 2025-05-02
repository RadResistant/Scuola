<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Eventi</title>
</head>
<?php
    session_start();
    include "info.php";
    $conn=mysqli_connect($server,$uname,$password,$db);
    if(!$conn){
        die("Errore connessione al db nce arpova");
    }
    if(!isset($_SESSION["email"]) && $_SESSION["login"]!=1){
        header("Location:index.php");
    }
?>
<body>
    <h1>WORK IN PROGRESS</h1>
    <form><button name="logout">Log Out</button></form>
    <?php
        $ricercaUtente="SELECT * FROM utenti WHERE email='".$_SESSION["email"]."';";
        $resultUtente=mysqli_query($conn,$ricercaUtente);
        if(mysqli_num_rows($resultUtente)==1){
            $utente=mysqli_fetch_assoc($resultUtente);
            if($utente["is_admin"]){
                echo "Future funzioni per gestione eventi";
            }
        }
        else{
            if(mysqli_num_rows($resultUtente)==0){
                die("<p class='error'>Nessun utente trovato</p>");
            }
            elseif(mysqli_num_rows($resultUtente)>1){
                die("<p class='error'>Errore nel database perfavore contattare il 3347565800</p>");
            }
        }
    ?>
</body>
</html>
<?php
    if(isset($_GET["logout"])){
        session_destroy();
        header("Location:index.php");
    }
?>