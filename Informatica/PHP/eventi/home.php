<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Eventi</title>
    <link rel="stylesheet" href="styleHome.css">
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
    <h1>Tutti gli eventi-WORK IN PROGRESS</h1>
    <div class="pannelloControlli">
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
    </div>
    <?php
        $ricercaEventi="SELECT * FROM eventi";
        $resultEventi=mysqli_query($conn,$ricercaEventi);
        if(mysqli_num_rows($resultEventi)>0){
            while($evento=mysqli_fetch_assoc($resultEventi)){
                echo "<div class='biglietto'><h2>".$evento["descrizione"]."</h2><h3>Data: ".$evento["data"]."</h3><p>Prezzo: ".$evento["costo"]."  Vip: ".$evento["costo_vip"]."</p><a href='info.php?id=".$evento["id"]."'>Prenota ora>>></a></div>";
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