<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modifica</title>
</head>
<body>
    <?php
        $conn=mysqli_connect("10.1.0.52","saponaro","saponaro","saponaro_Gare");
        if(!$conn){
            die("Errore connessione ".mysqli_connect_err());
        }
    ?>
    <form action="modificaAtleti.php" method="get">
        <select name="atleti">
            <?php
                $queryAtleti="SELECT * FROM Atleti;";
                $result=mysqli_query($conn,$queryAtleti);
                if(mysqli_num_rows($result)>0){
                    while($riga=mysqli_fetch_assoc($result)){
                        echo "<option value=".$riga["id_atleta"].">".$riga["nome"]." ".$riga["cognome"]." ".$riga["nazione"]."</option>";
                    }
                }
                mysqli_close($conn);
            ?>
        </select>
        <input type="submit" name="tasto">
    </form>
</body>
</html>