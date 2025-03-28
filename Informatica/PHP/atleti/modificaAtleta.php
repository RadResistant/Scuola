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
        if(!(isset($_GET["tasto"]))){
    ?>
    <form action="modificaAtleta.php" method="get">
        <select name="atleti">
            <?php
                $queryAtleti="SELECT * FROM Atleti;";
                $result=mysqli_query($conn,$queryAtleti);
                if(mysqli_num_rows($result)>0){
                    while($riga=mysqli_fetch_assoc($result)){
                        echo "<option value=".$riga["id_atleta"].">".$riga["nome"]." ".$riga["cognome"]." ".$riga["nazione"]."</option>";
                    }
                }
            ?>
        </select>
        <input type="submit" name="tasto">
    </form>
    <?php
        }
        else{
            $queryAtleta="SELECT * FROM Atleti WHERE id_atleta='".$_GET["atleti"]."';";
            $result=mysqli_query($conn,$queryAtleta);
            if(mysqli_num_rows($result)==1){
                while($riga=mysqli_fetch_assoc($result)){
    ?>
                    <form action="modificaAtleta.php" method="post">
                        <?php
                            echo '<input name="id" type="text" value='.$riga["id_atleta"].">";
                            echo '<input name="nome" type="text" value='.$riga["nome"].">";
                            echo '<input name="cognome" type="text" value='.$riga["cognome"].">";
                            echo '<input name="nazione" type="text" value='.$riga["nazione"].">";
                        ?>
                        <input type="submit" name="nuovo">
                    </form>
    <?php
                }
            }
        }
        if(isset($_POST["nuovo"])){
            $queryModifica="UPDATE Atleti SET nome='".$_POST["nome"]."' AND cognome='".$_POST["cognome"]."' AND nazione='".$_POST["nazione"]."' WHERE `Atleti`.`id_atleta`='"$_POST["id"]"';"
        }
    ?>
</body>
</html>