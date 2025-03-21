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
        echo $_POST["tipo"]."<br>";
        $query="SELECT * FROM ".$_POST["tipo"];
        $result=mysqli_query($conn,$query);
        if(mysqli_num_rows($result)>0){
            while($riga=mysqli_fetch_assoc($result)){
                print_r($riga);
                echo "<br>";
            }
        }
    ?>
    <a href="menu.html">Torna al menu</a>
</body>
</html>