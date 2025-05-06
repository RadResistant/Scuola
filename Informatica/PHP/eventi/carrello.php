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
    <title>Carrello eventi</title>
    <link rel="stylesheet" href="Styles/styleCarrello.css">
</head>
<body>
    <h1>Carrello Eventi</h1>
    <div id='contenitoreEventi'>
        <?php
            if(!empty($_SESSION["carrello"])){
                foreach($_SESSION["carrello"] as $evento){
                    $ricercaEvento="SELECT * FROM eventi WHERE eventi.id=".$evento["id"];
                    $resultEvento=mysqli_query($conn,$ricercaEvento);
                    if(mysqli_num_rows($resultEvento)==1){
                        $datiEvento=mysqli_fetch_assoc($resultEvento);
                        $tipoPosto="Normale";
                        if($evento["tipo"]==1){
                            $tipoPosto="VIP";
                        }
                        echo "<div class='biglietto'><h2>".$datiEvento["descrizione"]."</h2><h3>".$datiEvento["data"]."</h3><h3>".$tipoPosto."</h3><form><input type='hidden' name='idEvento' value=".$datiEvento["id"]."><button name='rimuovi'>Rimuovi dal carrello</button></form></div>";
                    }
                }
            }
            else{
                echo "<h1>Nessun evento nel carrello</h1>";
            }
        ?>
    </div>
    <form id="conferma">
        <p>Totale:
            <?php
                if(!empty($_SESSION["carrello"])){
                    $totale=0;
                    foreach($_SESSION["carrello"] as $evento){
                        $ricercaEvento="SELECT * FROM eventi WHERE eventi.id=".$evento["id"];
                        $resultEvento=mysqli_query($conn,$ricercaEvento);
                        if(mysqli_num_rows($resultEvento)==1){
                            $datiEvento=mysqli_fetch_assoc($resultEvento);
                            if($evento["tipo"]==0){
                                $totale+=$datiEvento["costo"];
                            }
                            else{
                                $totale+=$datiEvento["costo_vip"];
                            }
                        }
                    }
                    echo $totale."€";
                }
                else{
                    echo "0€";
                }
            ?>
        </p>
        <?php
            if(!empty($_SESSION["carrello"])){
        ?>
                <button id='acquista' name="acquista">Acquista tutti i biglietti</button>
        <?php
            }
        ?>
    <?php
        if(isset($_GET["rimuovi"])){
            foreach($_SESSION["carrello"] as $key=>$evento){
                if($evento["id"]==$_GET["idEvento"]){
                    unset($_SESSION["carrello"][$key]);
                }
            }
        }
        if(isset($_GET["acquista"])){
            echo "<div class='confermaAcquisto'><h1>Sei sicuro di voler acuqistare i biglietti?</h1><form><button class='scelta' name='continuaAcquisto'>Sì</button><button class='scelta'>No</button></form></div>";
        }
        if(isset($_GET["continuaAcquisto"]) && isset($_SESSION["carrello"])){
            mysqli_autocommit($conn,false);
            mysqli_begin_transaction($conn);
            try{
                foreach($_SESSION["carrello"] as $evento){
                    $ricercaUtente="SELECT * FROM utenti WHERE email='".$_SESSION["email"]."';";
                    $resultUtente=mysqli_query($conn,$ricercaUtente);
                    if(mysqli_num_rows($resultUtente)==1){
                        $utente=mysqli_fetch_assoc($resultUtente);
                        $inserimentoPrenotazione="INSERT INTO prenotazioni(id_utente,id_evento,is_vip) VALUES (".$utente["id"].",".$evento["id"].",".$evento["tipo"].")";
                        mysqli_query($conn,$inserimentoPrenotazione);
                    }
                }
            }
            catch(mysqli_sql_exception $e){
                mysqli_rollback($conn);
                die("<h2>Prenotazioni non andate a buon fine</h2>");
            }
            mysqli_commit($conn);
            mysqli_autocommit($conn,true);
            echo "<h2>Prenotazioni andate a buon fine</h2><a href='home.php'>Torna alla home</a>";
            unset($_SESSION["carrello"]);
        }
        ?>
    </form>
</body>
</html>