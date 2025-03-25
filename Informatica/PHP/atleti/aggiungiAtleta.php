<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="aggiungi.php" method="post">
        <input type="text" name="nome" placeholder="inserisci il nome">
        <input type="text" name="cognome" placeholder="inserisci il cognome">
        <input type="text" name="paese" placeholder="inserisci il paese di provenienza">
        <input type="submit" name="tasto">
    </form>
    <?php
        $conn=mysqli_connect("10.1.0.52","saponaro","saponaro","saponaro_Gare");
        if(!$conn){
            die("Errore connessione ".mysqli_connect_err());
        }
        if(isset($_POST["tasto"]) && isset($_POST["nome"]) && isset($_POST["cognome"]) && isset($_POST["paese"])){
            $query="INSERT INTO Atleti(nome,cognome,nazione) VALUES ('".$_POST["nome"]."','".$_POST["cognome"]."','".$_POST["paese"]."');";   
            if(!(mysqli_query($conn, $query))){
                echo "Error: " . $query . "<br>" . $conn->error;
            }
        }
    ?>
</body>
</html>