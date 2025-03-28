<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        table{
            border-collapse:collapse;
        }
        tr,td,th{
            border:2px solid black;
        }
    </style>
</head>
<body>
    <?php
        $conn=mysqli_connect("10.1.0.52","saponaro","saponaro","saponaro_Gare");
        if(!$conn){
            die("Errore connessione ".mysqli_connect_err());
        }
        echo $_GET["tipo"]."<br>";
        $query="SELECT * FROM ".$_GET["tipo"];
        $result=mysqli_query($conn,$query);
        if(mysqli_num_rows($result)>0){
            echo "<table>";
            while($riga=mysqli_fetch_assoc($result)){
                echo "<tr>";
                foreach($riga as $dato){
                    echo "<td>".$dato."</td>";
                }
                echo"</tr>";
            }
            echo "</table>";
        }
    ?>
    <a href="menu.html">Torna al menu</a>
</body>
</html>