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
                <button name="aAutore">Registra</button>
            </form>
            <?php
        }
        if(isset($_GET["aAutore"])){
            if(!empty($_GET["nomeAutore"]) && !empty($_GET["cognomeAutore"]) && !empty($_GET["cfAutore"])){
                $nome=htmlspecialchars($_GET["nomeAutore"]);
                $cognome=htmlspecialchars($_GET["cognomeAutore"]);
                $cf=strtoupper(htmlspecialchars($_GET["cfAutore"]));
                $inserimentoAutore="INSERT INTO autori(cf,nome,cognome) VALUES ('".$cf."','".$nome."','".$cognome."');";
                if(!mysqli_query($conn,$inserimentoAutore)){
                    echo "Error: " . $queryInserimento . "<br>" . $conn->error;
                }
                else{
                    echo "<p>Autore registrato con successo</p>";
                }
            }
            mysqli_close($conn);
        }
    ?>
</body>
</html>