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
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="Styles/stylePrenotazione.css">
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
                $ricercaPostiDisponibili="SELECT eventi.posti_disponibili FROM eventi WHERE eventi.id=".$_GET["id"];
                $resultPosti=mysqli_query($conn,$ricercaPostiDisponibili);
                $ricercaPrenotazioni="SELECT count(*) as tot FROM prenotazioni WHERE id_evento=".$_GET["id"];
                $resultPrenotazioni=mysqli_query($conn,$ricercaPrenotazioni);
                $prenotazioni=mysqli_fetch_assoc($resultPrenotazioni);
                $posti=mysqli_fetch_assoc($resultPosti);
                $postiDisponibili=$posti["posti_disponibili"]-$prenotazioni["tot"];
                echo "<h2>Posti disponibili: ".$postiDisponibili."</h2>";
            ?>
            <p><input type="radio" name="tipo" value="0" checked> Normale: <?php echo $GLOBALS["evento"]["costo"] ?>€</p>
            <p><input type="radio" name="tipo" value="1"> Vip: <?php echo $GLOBALS["evento"]["costo_vip"] ?>€</p>
            <?php
                if($postiDisponibili>0){
                    ?>
                    <button name="carrello">Aggiungi al carrello</button>
                    <?php
                }
            ?>
        </form>
        <?php
        $idEvento=$GLOBALS["evento"]["id"];
        if(isset($_POST["carrello"])){
            $_SESSION["carrello"][]=array("id"=>$idEvento,"tipo"=>$_POST["tipo"]);
            echo "<h2>Aggiunto al carrello</h2><a href='home.php'>Torna alla home</a><a href='carrello.php'>Vai al carrello</a>";
        }
        ?>
    </div>
</body>
</html>