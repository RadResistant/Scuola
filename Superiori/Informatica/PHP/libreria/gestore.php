<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestisci la libreria</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <?php
        // Avvio la sessione
        session_start();
        // Controllo se la variabile superglobale "SESSION" all'indice "login" è diversa da 1
        if($_SESSION["login"]!=1){
            // Se lo è allora reindirizzo alla pagina "index.php"
            header("Location:index.php");
        }
    ?>
    <?php
        // Viene incluso il file nella quale risiedono le informazioni necessarie per connettersi al database
        include("info.php");
        // Effettuo la connessione al database con le informazioni residenti nel file "info.php"
        $conn=mysqli_connect($server,$username,$password,$database);
        // Controllo se la connessione non è andata a buon fine
        if(!$conn){
            // Se la connessione non è andata a buon fine allora fermo tutto il file e stampo a schermo l'errore
            die("Errore connessione ".mysqli_connect_err());
        }
    ?>
    <form action="gestore.php">
        <button name="aggiungiAutore">Aggiungi autore</button>
        <button name="aggiungiCategoria">Aggiungi categoria</button>
        <button name="aggiungiLibro">Aggiungi libro</button>
        <button name="modificaLibro">Modifica libro</button>
        <button name="eliminaLibro">Elimina libro</button>
        <button name="gestisciUtenti">Gestisci utenti</button>
        <button name="catalogo">Torna al catalogo</button>
    </form>
    <?php
        // Controllo se la variabile $_GET è impostata all'indice "aggiungiAutore"
        if(isset($_GET["aggiungiAutore"])){
            // Se lo è mostro il form per la aggiunta dell'autore
    ?>
            <h2>Inserimento autori</h2>
            <form action="gestore.php">
                <input type="text" name="nomeAutore" placeholder="Inserisci il nome">
                <input type="text" name="cognomeAutore" placeholder="Inserisci il cognome">
                <input type="text" name="cfAutore" placeholder="Inserisci il cf">
                <button name="registraAutore">Registra</button>
            </form>
    <?php
        }
        // Controllo se la variabile $_GET è impostata all'indice "registraAutore"
        if(isset($_GET["registraAutore"])){
            // Se lo è controllo se la variabile $_GET non è vuota negli indici "nomeAutore", "cognomeAutore" e "cfautore"
            if(!empty($_GET["nomeAutore"]) && !empty($_GET["cognomeAutore"]) && !empty($_GET["cfAutore"])){
                // Se non sono vuote allora assegno alla variabile "$nome" il nome dell'autore passato in input,
                $nome=htmlspecialchars($_GET["nomeAutore"]);
                // Alla variabile "$congome" il codice fiscale dell'autore passato in input e
                $cognome=htmlspecialchars($_GET["cognomeAutore"]);
                // Alla variabile "$cf" il cognome dell'autore passato in input
                $cf=strtoupper(htmlspecialchars($_GET["cfAutore"]));
                // Creo una variabile "$inserimentoAutore" e gli assegno come valore l'interrogazione di inserimento dell'autore, gli do come valori le variabili precedentemente create
                $inserimentoAutore="INSERT INTO autori(cf,nome,cognome) VALUES ('".$cf."','".$nome."','".$cognome."');";
                // Eseguo l'interrogazione e controllo se non è andata a buon fine
                if(!mysqli_query($conn,$inserimentoAutore)){
                    // Se non è andata a buon fine stampo a schermo l'errore
                    echo "Error: " . $inserimentoAutore . "<br>" . $conn->error;
                }
                else{
                    // Altrimenti stampo a schermo che l'autore è stato registrato
                    echo "<p class='giusto'>Autore registrato con successo</p>";
                }
            }
            // Chiudo la connessione
            mysqli_close($conn);
        }
        // Controllo se la variabile $_GET è impostata all'indice "aggiungiCategoria"
        if(isset($_GET["aggiungiCategoria"])){
            // Se lo è stampo il form per l'insermento della categoria
    ?>
            <h2>Inserimento Categorie</h2>
            <form action="gestore.php">
                <input type="text" name="descrizioneCategoria" placeholder="Inserisci la categoria">
                <button name="registraCategoria">Registra</button>
            </form>
    <?php
        }
        // Controllo se la variabile $_GET è impostata all'indice "registraCategoria"
        if(isset($_GET["registraCategoria"])){
            if(!empty($_GET["descrizioneCategoria"])){
                $descrizione=htmlspecialchars($_GET["descrizioneCategoria"]);
                $inserimentoCategoria="INSERT INTO categorie(descrizione) VALUES ('".$descrizione."');";
                if(!mysqli_query($conn,$inserimentoCategoria)){
                    echo "Error: " . $inserimentoCategoria . "<br>" . $conn->error;
                }
                else{
                    echo "<p class='giusto'>Categoria registrata con successo</p>";
                }
            }
            mysqli_close($conn);
        }
        if(isset($_GET["aggiungiLibro"])){
    ?>
    <h2>Inserimento libri</h2>
    <form action="gestore.php">
        <input type="text" name="nomeLibro" placeholder="Inserisci il nome">
        <select name="autori">
            <?php
                $ricercaAutori="SELECT * FROM autori";
                $result=mysqli_query($conn,$ricercaAutori);
                if(mysqli_num_rows($result)>0){
                    while($autore=mysqli_fetch_assoc($result)){
                        echo "<option value=".$autore["cf"].">".$autore["nome"]." ".$autore["cognome"]."</option>";
                    }
                }
            ?>
        </select>
        <select name="categorie">
            <?php
                $ricercaCategorie="SELECT * FROM categorie";
                $result=mysqli_query($conn,$ricercaCategorie);
                if(mysqli_num_rows($result)>0){
                    while($categoria=mysqli_fetch_assoc($result)){
                        echo "<option value=".$categoria["id"].">".$categoria["descrizione"]."</option>";
                    }
                }
            ?>
        </select>
        <button name="registraLibro">Registra libro</button>
    </form>
    <?php
        }
        if(isset($_GET["registraLibro"])){
            if(!empty($_GET["nomeLibro"]) && !empty($_GET["autori"]) && !empty($_GET["categorie"])){
                $nome=htmlspecialchars($_GET["nomeLibro"]);
                $autore=htmlspecialchars($_GET["autori"]);
                $categoria=htmlspecialchars($_GET["categorie"]);
                $inserimentoLibro="INSERT INTO libri(nome) VALUES ('".$nome."');";
                if(!mysqli_query($conn,$inserimentoLibro)){
                    echo "Error: " . $inserimentoLibro . "<br>" . $conn->error;
                }
                else{
                    $idLibro=mysqli_insert_id($conn);
                    $libroAutore="INSERT INTO libri(fk_libri,fk_autori) VALUES ('".$idLibro."','".$autore."');";
                    $libroCategoria="INSERT INTO libri_categorie(fk_libri,fk_categorie) VALUES ('".$idLibro."','".$categoria."');";
                }
            }
            mysqli_close($conn);
        }
        if(isset($_GET["modificaLibro"])){
    ?>
    <h2>Modifica Libri</h2>
    <form action="gestore.php">
        <select name="libro">
            <?php
                $ricercaLibri="SELECT * FROM libri";
                $result=mysqli_query($conn,$ricercaLibri);
                if(mysqli_num_rows($result)>0){
                    while($libro=mysqli_fetch_assoc($result)){
                        echo "<option value=".$libro["id"].">".$libro["nome"]."</option>";
                    }
                }
            ?>
        </select>
        <button name="libroScelto">Modifica libro</button>
    </form>
    <?php
        }
        if(isset($_GET["libroScelto"])){
    ?>
    <form action="gestore.php">
        <?php
            $queryLibri="SELECT * FROM libri WHERE id=".$_GET["libro"].";";
            $queryAutori="SELECT * FROM autori";
            $queryCategorie="SELECT * FROM categorie";
            $resultLibri=mysqli_query($conn,$queryLibri);
            $resultAutori=mysqli_query($conn,$queryAutori);
            $resultCategorie=mysqli_query($conn,$queryCategorie);
            $libro=mysqli_fetch_assoc($resultLibri);
            echo "Libro";
            foreach($libro as $key=>$content){
                if($key=="id"){
                    echo "<input type='text' name='".$key."' readonly value='".$content."'>";
                }
                else{
                    echo "<input type='text' name='".$key."' value='".$content."' placeholder='".$key."'>";
                }
            }
            echo "autore";
            echo "<select name='autore'>";
            while($riga=mysqli_fetch_assoc($resultAutori)){
                echo "<option value='".$riga["cf"]."'>".$riga["nome"]." ".$riga["cognome"]."</option>";
            }
            echo "</select>";
            echo "categoria";
            echo "<select name='categoria'>";
            while($riga=mysqli_fetch_assoc($resultCategorie)){
                echo "<option value='".$riga["id"]."'>".$riga["descrizione"]."</option>";
            }
            echo "</select>";
        ?>
        <button name="modificaCampiLibro">Modifica</button>
    </form>
    <?php
        }
        if(isset($_GET["modificaCampiLibro"]) || isset($_GET["modificaLibro"]) || isset($_GET["libroScelto"])){
            if(isset($_GET["id"]) && isset($_GET["nome"])){
                $libro=$_GET["id"];
                $nome=htmlspecialchars($_GET["nome"]);
                $autore=$_GET["autore"];
                $categoria=$_GET["categoria"];
                $campi="";
                foreach($_GET as $key=>$content){
                    if($key!="id" && $key!="autore" && $key!="categoria" && $key!="nome" && $key!="modificaCampiLibro"){
                        $campi.=", ".$key."='".$content."' ";
                    }
                }
                $modificaLibro="UPDATE `libri` SET `nome` = '".$nome."' ".$campi."WHERE `libri`.`id` = ".$libro.";";
                $modificaAutore="UPDATE `libri_autori` SET `fk_autore` = '".$autore."' WHERE `libri`.`id` = ".$libro.";";
                $modificaCategoria="UPDATE `libri_categorie` SET `fk_categorie` = '".$categoria."' WHERE `libri`.`id` = ".$libro.";";
                if(!mysqli_query($conn,$modificaLibro) && !mysqli_query($conn,$modificaAutore) && !mysqli_query($conn,$modificaCategoria)){
                    echo "Error: " . $modificaLibro . "<br>" . $conn->error;
                }
                else{
                    echo "<p class='giusto'>Libro modificato con successo</p>";
                }
                mysqli_close($conn);
            }
        }
        if(isset($_GET["eliminaLibro"])){
    ?>
    <h2>Elimina Libri</h2>
    <form action="gestore.php">
        <select name="libri">
            <?php
                $ricercaLibri="SELECT * FROM libri";
                $result=mysqli_query($conn,$ricercaLibri);
                if(mysqli_num_rows($result)>0){
                    while($libro=mysqli_fetch_assoc($result)){
                        echo "<option value=".$libro["id"].">".$libro["nome"]."</option>";
                    }
                }
            ?>
        </select>
        <button name="eliminaLibroScelto">Elimina</button>
    </form>
    <?php
        }
        if(isset($_GET["eliminaLibroScelto"])){
            if(!empty($_GET["libri"])){
                $libro=htmlspecialchars($_GET["libri"]);
                $eliminaLibro="DELETE FROM `libri` WHERE `libri`.`id` =".$libro.";";
                if(!mysqli_query($conn,$eliminaLibro)){
                    echo "Error: " . $eliminaLibro . "<br>" . $conn->error;
                }
                else{
                    echo "<p class='giusto'>Libro eliminato con successo</p>";
                }
            }
            mysqli_close($conn);
        }
        if(isset($_GET["catalogo"])){
            mysqli_close($conn);
            header("Location:catalogo.php");
        }
        if(isset($_GET["gestisciUtenti"])){
    ?>
        <form action="gestore.php">
            <select name="utente">
                <?php
                     $ricercaUtenti="SELECT * FROM utenti";
                     $result=mysqli_query($conn,$ricercaUtenti);
                     if(mysqli_num_rows($result)>0){
                         while($utente=mysqli_fetch_assoc($result)){
                            echo "<option value=".$utente["email"].">".$utente["nome"]." ".$utente["cognome"]."</option>";
                         }
                     }
                ?>
            </select>
            <button name="impostaGestore">Imposta come gestore</button>
            <button name="impostaUtente">Imposta come utente</button>
        </form>
    <?php
        }
        if(isset($_GET["impostaGestore"])){
            $modificaUtente="UPDATE `utenti` SET `is_gestore` = '1' WHERE `utenti`.`email` = '".$_GET["utente"]."';";
            if(!mysqli_query($conn,$modificaUtente)){
                echo "<p class='errore'>Errore</p>";
            }
            else{
                echo "<p class='giusto'>Utente impostato come gestore</p>";
            }
        }
        if(isset($_GET["impostaUtente"])){
            $modificaUtente="UPDATE `utenti` SET `is_gestore` = '0' WHERE `utenti`.`email` = '".$_GET["utente"]."';";
            if(!mysqli_query($conn,$modificaUtente)){
                echo "<p class='errore'>Errore</p>";
            }
            else{
                echo "<p class='giusto'>Utente impostato come utente</p>";
            }
        }
    ?>
</body>
</html>