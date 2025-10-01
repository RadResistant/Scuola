<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Visualizzazione eventi</title>
    <link rel="stylesheet" href="Styles/styleHome.css">
</head>
<?php
    session_start();
    include "info.php";
    $conn=mysqli_connect($server,$uname,$password,$db);
    if(!$conn){
        die("Errore connessione al db nce arpova");
    }
    if(!isset($_SESSION["email"]) && !$_SESSION["login"]){
        header("Location:index.php");
    }
?>
<body>
    <h1>Tutti gli eventi</h1>
    <form class="pannelloControlli"><button name="logout">Log Out</button>
    <?php
        $ricercaUtente="SELECT * FROM utenti WHERE email='".$_SESSION["email"]."';";
        $resultUtente=mysqli_query($conn,$ricercaUtente);
        if(mysqli_num_rows($resultUtente)==1){
            $utente=mysqli_fetch_assoc($resultUtente);
            if($utente["is_admin"]==1){
                echo "<button><a href='admin.php'>Gestione eventi</a></button>";
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
    <a href="carrello.php"><img id="carrello" src="https://cdn-icons-png.flaticon.com/512/649/649931.png" alt="Carrello"></a>
    </form>
    <?php
        $ricercaEventi="SELECT * FROM eventi WHERE data>='".date("Y-m-d")."';";
        $resultEventi=mysqli_query($conn,$ricercaEventi);
        if(mysqli_num_rows($resultEventi)>0){
            while($evento=mysqli_fetch_assoc($resultEventi)){
                $ricercaPrenotazioni="SELECT count(*) as tot FROM prenotazioni WHERE id_evento=".$evento["id"];
                $resultPrenotazioni=mysqli_query($conn,$ricercaPrenotazioni);
                $prenotazioni=mysqli_fetch_assoc($resultPrenotazioni);
                $postiDisponibili=$evento["posti_disponibili"]-$prenotazioni["tot"];
                echo "<div class='biglietto'><h2>".$evento["descrizione"]."</h2><h3>Data: ".$evento["data"]."</h3><h3>Posti disponibili: ".$postiDisponibili."</h3><p>Prezzo: ".$evento["costo"]."€  Vip: ".$evento["costo_vip"]."€</p><a class='prenotazione' href='prenotazioneEvento.php?id=".$evento["id"]."'>Prenota ora>>></a></div>";
            }
        }
    ?>
</body>
</html>
<?php
    if(isset($_GET["logout"])){
        unset($_SESSION["email"]);
        unset($_SESSION["login"]);
        header("Location:index.php");
    }
?>