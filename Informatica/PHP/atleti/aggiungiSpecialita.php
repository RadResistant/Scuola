<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="aggiungiSpecialita.php" method="post">
        <input type="text" name="descrizione" placeholder="inserisci la specialità">
        <input type="submit" name="tasto">
    </form>
    <?php
        $conn=mysqli_connect("10.1.0.52","saponaro","saponaro","saponaro_Gare");
        if(!$conn){
            die("Errore connessione ".mysqli_connect_err());
        }
        if(isset($_POST["tasto"]) && isset($_POST["descrizione"])){
            $query="INSERT INTO Specialità(descrizione) VALUES ('".$_POST["descrizione"]."');";   
            if(!(mysqli_query($conn, $query))){
                echo "Error: " . $query . "<br>" . $conn->error;
            }
        }
    ?>
</body>
</html>