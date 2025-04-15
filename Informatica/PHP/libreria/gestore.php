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
        session_start();
        if(isset($_SESSION["email"]) && isset($_SESSION["login"]) && $_SESSION["login"]==1){
    ?>
    <?php
        include("info.php");
        $conn=mysqli_connect($server,$username,$password,$database);
        if(!$conn){
            die("Errore connessione ".mysqli_connect_err());
        }
    ?>
    <h1>WORK in Progress</h1>
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
        if(isset($_GET["aggiungiAutore"])){
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
        if(isset($_GET["registraAutore"])){
            if(!empty($_GET["nomeAutore"]) && !empty($_GET["cognomeAutore"]) && !empty($_GET["cfAutore"])){
                $nome=htmlspecialchars($_GET["nomeAutore"]);
                $cognome=htmlspecialchars($_GET["cognomeAutore"]);
                $cf=strtoupper(htmlspecialchars($_GET["cfAutore"]));
                $inserimentoAutore="INSERT INTO autori(cf,nome,cognome) VALUES ('".$cf."','".$nome."','".$cognome."');";
                if(!mysqli_query($conn,$inserimentoAutore)){
                    echo "Error: " . $inserimentoAutore . "<br>" . $conn->error;
                }
                else{
                    echo "<p class='giusto'>Autore registrato con successo</p>";
                }
            }
            mysqli_close($conn);
        }
        if(isset($_GET["aggiungiCategoria"])){
    ?>
            <h2>Inserimento Categorie</h2>
            <form action="gestore.php">
                <input type="text" name="descrizioneCategoria" placeholder="Inserisci la categoria">
                <button name="registraCategoria">Registra</button>
            </form>
    <?php
        }
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
        <!-- <select name="libri">
            <?php
                // $ricercaLibri="SELECT * FROM libri";
                // $result=mysqli_query($conn,$ricercaLibri);
                // if(mysqli_num_rows($result)>0){
                //     while($libro=mysqli_fetch_assoc($result)){
                //         echo "<option value=".$libro["id"].">".$libro["nome"]."</option>";
                //     }
                // }
            ?>
        </select> -->
        <?php
            $queryLibri="SELECT * FROM libri";
            $queryAutori="SELECT * FROM autori";
            $queryCategorie="SELECT * FROM categorie";
            $resultLibri=mysqli_query($conn,$queryLibri);
            $resultAutori=mysqli_query($conn,$queryAutori);
            $resultCategorie=mysqli_query($conn,$queryCategorie);
            $libro=mysqli_fetch_assoc($resultLibri);
            $autore=mysqli_fetch_assoc($resultAutori);
            $categoria=mysqli_fetch_assoc($resultCategorie);
            echo "Libro";
            foreach($libro as $key=>$content){
                echo "<input type='text' name='".$key."' value='".$content."'>";
            }
            echo "autore";
            foreach($autore as $key=>$content){
                echo "<select name='".$key."'>";
                
            }
        ?>
        <button name="modificaCampiLibro">Modifica</button>
    </form>
    <?php
        }
        if(isset($_GET["modificaCampiLibro"])){
            if(!empty($_GET["libri"]) && !empty($_GET["nuovoNome"])){
                $libro=htmlspecialchars($_GET["libri"]);
                $nuovoNome=htmlspecialchars($_GET["nuovoNome"]);
                $modificaNome="UPDATE `libri` SET `nome` = '".$nuovoNome."' WHERE `libri`.`id` = ".$libro.";";
                if(!mysqli_query($conn,$modificaNome)){
                    echo "Error: " . $modificaNome . "<br>" . $conn->error;
                }
                else{
                    echo "<p class='giusto'>Nome del libro modificato con successo</p>";
                }
            }
            mysqli_close($conn);
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
    <?php
        }
        else{
            header("Location:index.php");
        }
    ?>
</body>
</html>