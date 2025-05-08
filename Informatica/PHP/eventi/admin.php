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
    $ricercaUtente="SELECT * FROM utenti WHERE email='".$_SESSION["email"]."';";
    $resultUtente=mysqli_query($conn,$ricercaUtente);
    if(mysqli_num_rows($resultUtente)==1){
        $utente=mysqli_fetch_assoc($resultUtente);
        if(!$utente["is_admin"]){
            header("Location:home.php");
        }
    }
    else{
        if(mysqli_num_rows($resultUtente)==0){
            header("Location:home.php");
            die();
        }
        elseif(mysqli_num_rows($resultUtente)>1){
            die("<p class='error'>Errore nel database perfavore contattare il 3347565800</p>");
        }
    }
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="Styles/styleHome.css">
    <title>Gestione eventi</title>
</head>
<body>
    <a href="home.php" id="homeLink"><img id='homeIcon' src="https://cdn-icons-png.flaticon.com/512/25/25694.png" alt="Home"></a>
    <?php
        if(!isset($_GET["visualizzaPrenotazioni"])){
            echo "<div class='pannelloControlli'>";
        }
        if(!isset($_GET["aggiuntaEvento"]) && !isset($_GET["rimozioneEvento"]) && !isset($_GET["visualizzaPrenotazioni"])){
        ?>
            <form>
                <button name='aggiuntaEvento'>Aggiungi evento</button>
                <button name='rimozioneEvento'>Elimina evento</button>
                <button name="visualizzaPrenotazioni">Visualizza tutte le prenotazioni</button>
            </form>
        <?php
        }
        if(isset($_GET["rimozioneEvento"])){
        ?>
            <form>
                <select name="evento">
                    <?php
                        $ricercaEventi="SELECT * FROM eventi";
                        $resultEventi=mysqli_query($conn,$ricercaEventi);
                        if(mysqli_num_rows($resultEventi)>0){
                            while($evento=mysqli_fetch_assoc($resultEventi)){
                                echo "<option value=".$evento["id"].">".$evento["descrizione"]."</option>";
                            }
                        }
                    ?>
                </select>
                <button name="rimuovi">Elimina evento selezionato</button>
            </form>
        <?php
        }
        if(isset($_GET["rimuovi"])){
            $rimozioneEvento="DELETE FROM `eventi` WHERE `eventi`.`id`=".$_GET["evento"];
            if(!mysqli_query($conn,$rimozioneEvento)){
               echo "<p class='error'>Errore nella rimozione dell'evento</p>"; 
            }
            else{
                echo "<p class='giusto'>Evento rimosso correttamente</p>";
            }
        }
        if(isset($_GET["aggiuntaEvento"])){
            ?>
                <form>
                    <input type="text" name="descrizione" placeholder="Descrizione">
                    <input type="date" name="data">
                    <input type="number" name="posti_disponibili" placeholder="Posti disponibili">
                    <input type="text" name="costo" placeholder="Costo">
                    <input type="text" name="costo_vip" placeholder="Costo vip">
                    <button name="inserisci">Inserisci</button>
                </form>
            <?php
        }
        if(isset($_GET["inserisci"])){
            if(!empty($_GET["descrizione"]) && !empty($_GET["data"]) && !empty($_GET["posti_disponibili"]) && !empty($_GET["costo"]) && !empty($_GET["costo_vip"])){
                $inserimentoEvento="INSERT INTO eventi(descrizione,data,posti_disponibili,costo,costo_vip) VALUES ('".$_GET["descrizione"]."','".$_GET["data"]."',".$_GET["posti_disponibili"].",".$_GET["costo"].",".$_GET["costo_vip"].")";
                if(!mysqli_query($conn,$inserimentoEvento)){
                    echo "<p class='error'>Errore nell'aggiunta dell'evento</p>"; 
                 }
                 else{
                     echo "<p class='giusto'>Evento aggiunto correttamente</p>";
                 }
            }
        }
        if(!isset($_GET["visualizzaPrenotazioni"])){
            echo "</div>";
        }
    ?>
    <?php
        if(isset($_GET["visualizzaPrenotazioni"])){
            $ricercaPrenotazioni="SELECT * FROM utenti,prenotazioni,eventi WHERE utenti.id=prenotazioni.id_utente AND prenotazioni.id_evento=eventi.id";
            $resultPrenotazioni=mysqli_query($conn,$ricercaPrenotazioni);
            if(mysqli_num_rows($resultPrenotazioni)>0){
                while($prenotazione=mysqli_fetch_assoc($resultPrenotazioni)){
                    $prezzoPagato=$prenotazione["costo"];;
                    $isVip="Biglietto normale";
                    if($prenotazione["is_vip"]){
                        $prezzoPagato=$prenotazione["costo_vip"];
                        $isVip="Biglietto VIP";
                    }
                    $tipo="Utente";
                    if($prenotazione["is_admin"]){
                        $tipo="Amministratore";
                    }
                    echo "<div class='biglietto'><h2>".$tipo.": ".$prenotazione["nome"]." ".$prenotazione["cognome"]."-\n".$prenotazione["email"]."</h2><h2>Evento: ".$prenotazione["descrizione"]."</h2><h3>Data: ".$prenotazione["data"]."</h3><p>Prezzo: ".$prezzoPagato."€ ".$isVip."</p></div>";
                }
            }
        }
    ?>
</body>
</html>