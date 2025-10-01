<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
        $conn=mysqli_connect("10.1.0.52","saponaro","saponaro","saponaro_Gare");
        if(!$conn){
            die("Errore connessione ".mysqli_connect_err());
        }
    ?>
    <form action="aggiungiGare.php" method="post">
        <input type="text" name="descrizione" placeholder="inserisci la descrizione">
        <p>M<input type="radio" name="sesso" value="M"></p>
        <p>F<input type="radio" name="sesso" value="F"></p>
        <select name="specialita">
            <?php
                $query="SELECT * FROM Specialità";
                $result=mysqli_query($conn,$query);
                if(mysqli_num_rows($result)>0){
                    while($riga=mysqli_fetch_assoc($result)){
                        echo "<option value=".$riga["id_specialita"].">".$riga["descrizione"]."</option>";
                    }
                }
            ?>
        </select>
        <input type="submit" name="tasto">
    </form>
    <?php
        if(isset($_POST["tasto"]) && isset($_POST["descrizione"])){
            $query="INSERT INTO Gare(descrizione,genere,fk_id_s) VALUES ('".$_POST["descrizione"]."','".$_POST["sesso"]."','".$_POST["specialita"]."');";   
            if(!(mysqli_query($conn, $query))){
                echo "Error: " . $query . "<br>" . $conn->error;
            }
        }
        mysqli_close($conn);
    ?>
</body>
</html>