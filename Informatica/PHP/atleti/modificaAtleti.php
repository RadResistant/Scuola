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
    <form action="modificaAtleti.php" method="post">
        <?php
            if(!isset($_POST["modifica"]) && !isset($_POST["elimina"])){
                $queryAtleti="SELECT * FROM Atleti WHERE id_atleta=".$_GET["atleti"].";";
                $result=mysqli_query($conn,$queryAtleti);
                if(mysqli_num_rows($result)>0){
                    while($riga=mysqli_fetch_assoc($result)){
                        echo '<input type="text" name="nome" value='.$riga["nome"].'>
                            <input type="text" name="cognome" value='.$riga["cognome"].'>
                            <input type="text" name="nazione" value='.$riga["nazione"].'>
                            ';
                    }
                }
            }
        ?>
        <input type="submit" name="modifica" value="Modifica">
        <input type="submit" name="elimina" value="Elimina">
    </form>
    <?php
        if(isset($_POST["modifica"])){
            $queryModifica="UPDATE Atleti SET nome='".$_POST["nome"]."' AND cognome='".$_POST["cognome"]."' AND nazione='".$_POST["nazione"]."' WHERE `Atleti`.`id_atleta`='".$_POST["id_atleta"]."';";
            if(!(mysqli_query($conn, $queryModifica))){
                echo "Error: " . $queryModifica . "<br>" . $conn->error;
            }
        }
        if(isset($_POST["elimina"])){
            $queryElimina="DELETE FROM `Atleti` WHERE `Atleti`.`id_atleta`='".$_POST["id_atleta"]."';";
            if(!(mysqli_query($conn, $queryElimina))){
                echo "Error: " . $queryElimina . "<br>" . $conn->error;
            }
        }
        mysqli_close($conn);
    ?>
</body>
</html>