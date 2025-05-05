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
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="stylePrenotazione.css">
    <title>Prenotazione Evento
        <?php
            $ricercaEvento="SELECT * FROM eventi WHERE eventi.id=".$_GET["id"];
            $resultEvento=mysqli_query($conn,$ricercaEvento);
            if(mysqli_num_rows($resultEvento)==1){
                $evento=mysqli_fetch_assoc($resultEvento);
                echo $evento["descrizione"];
            }
        ?>
    </title>
</head>
<body>
    <div>
        <form method="post">
            <h1><?php echo $GLOBALS["evento"]["descrizione"] ?></h1>
            <?php
                $ricercaPostiDisponibili="SELECT eventi.posti_disponibilli FROM eventi WHERE eventi.id=".$_GET["id"];
                $resultPosti=mysqli_query($conn,$ricercaPostiDisponibili);
                $ricercaPrenotazioni="SELECT count(*) as tot FROM prenotazioni WHERE id_evento=".$_GET["id"];
                $resultPrenotazioni=mysqli_query($conn,$ricercaPrenotazioni);
                $prenotazioni=mysqli_fetch_assoc($resultPrenotazioni);
                $posti=mysqli_fetch_assoc($resultPosti);
                $postiDisponibili=$posti["posti_disponibilli"]-$prenotazioni["tot"];
                echo "<h2>Posti disponibili: ".$postiDisponibili."</h2>";
            ?>
            <p><input type="radio" name="tipo" value="normale" checked> Normale: <?php echo $GLOBALS["evento"]["costo"] ?>€</p>
            <p><input type="radio" name="tipo" value="vip"> Vip: <?php echo $GLOBALS["evento"]["costo_vip"] ?>€</p>
            <?php
                if($postiDisponibili>0){
                    ?>
                    <button name="prenota">Prenota</button>
                    <?php
                }
            ?>
        </form>
        <?php
        $idEvento=$GLOBALS["evento"]["id"];
        if(isset($_POST["prenota"])){
            $ricercaUtente="SELECT * FROM utenti WHERE email='".$_SESSION["email"]."';";
            $resultUtente=mysqli_query($conn,$ricercaUtente);
            if(mysqli_num_rows($resultUtente)==1){
                $utente=mysqli_fetch_assoc($resultUtente);
                $tipo=0;
                if($_POST["tipo"]=="vip"){
                    $tipo=1;
                }
                $inserimentoPrenotazione="INSERT INTO prenotazioni(id_utente,id_evento,is_vip) VALUES (".$utente["id"].",".$_GET["id"].",".$tipo.")";
                if(!mysqli_query($conn,$inserimentoPrenotazione)){
                    echo "<h2>Prenotazione non andata a buon fine</h2>";
                }
                else{
                    echo "<h2>Prenotazione andata a buon fine</h2><a href='home.php'>Torna alla home</a>";
                }
            }
        }
        ?>
    </div>
</body>
</html>