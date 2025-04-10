<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestisci la libreria</title>
</head>
<body>
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
        <button name="eliminaLibro">Elimina Libro</button>
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
                    echo "<p>Autore registrato con successo</p>";
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
                    echo "<p>Categoria registrata con successo</p>";
                }
            }
            mysqli_close($conn);
        }
    ?>
    <?php
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
                        echo "<p>Autore registrato con successo</p>";
                    }
                }
                mysqli_close($conn);
            }
            if(isset($_GET["aggiungiLibro"])){
    ?>
                <h2>Inserimento autori</h2>
                <form action="gestore.php">
                    <input type="text" name="nomeLibro" placeholder="Inserisci il nome del libro">
                    <select name="autoreLibro">
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
                    <select name="categoriaLibro">
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
                    <button name="registraLibro">Registra</button>
                </form>
    <?php
            }
            if(isset($_GET["registraLibro"])){
                if(!empty($_GET["nomeLibro"]) && !empty($_GET["autoreLibro"]) && !empty($_GET["categoriaLibro"])){
                    $nome=htmlspecialchars($_GET["nomeLibro"]);
                    $autore=htmlspecialchars($_GET["autoreLibro"]);
                    $categoria=htmlspecialchars($_GET["categoriaLibro"]);
                    $inserimentoLibro="INSERT INTO libri(nome) VALUES ('".$nome."');";
                    $test=mysqli_query($conn,$inserimentoLibro);
                    if(!$test){
                        echo "Error: " . $inserimentoLibro . "<br>" . $conn->error;
                    }
                    else{
                        $ricercaAutori="SELECT * FROM libri WHERE libri.nome='".$nome."' LIMIT 1;";
                        $result=mysqli_query($conn,$ricercaAutori);
                        if(mysqli_num_rows($result)>0){
                            while($autore=mysqli_fetch_assoc($result)){
                                print_r($autore);
                            }
                        }
                    }
                }
                mysqli_close($conn);
            }
    ?>
</body>
</html>