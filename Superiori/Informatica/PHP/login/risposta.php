<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<?php 
    $servername="10.1.0.52";
    $username="saponaro";
    $passw="saponaro";
    $database="saponaro_utenti";
    $conn=mysqli_connect($servername,$username,$passw,$database);
    if(!$conn){
        die("Errore connessione ".mysqli_connect_err());
    }
    if(isset($_COOKIE["name"]) && isset($_COOKIE["password"])){
        $nome=htmlspecialchars($_COOKIE["name"]);
        $password=htmlspecialchars($_COOKIE["password"]);
        $query="SELECT * FROM utenti WHERE nome='$nome' and password='$password'";
        $result=mysqli_query($conn,$query);
        if(mysqli_num_rows($result)>0){
            echo "si";
            while($riga=mysqli_fetch_assoc($result)){
                print_r($riga);
            }
        }
        else{
            echo "no";
            echo '<a href="login.php">Indietro</a>';
        }
    }
    if(isset($_POST["name"]) && isset($_POST["password"])){
        $nome=htmlspecialchars($_POST["name"]);
        $password=htmlspecialchars($_POST["password"]);
        $query="SELECT * FROM utenti WHERE nome='$nome' and password='$password'";
        $result=mysqli_query($conn,$query);
        if(mysqli_num_rows($result)>0){
            echo "si";
            while($riga=mysqli_fetch_assoc($result)){
                print_r($riga);
            }
            setcookie("name",$_POST["name"],time()+120);
            setcookie("password",$_POST["password"],time()+120);
        }
        else{
            echo "no";
            echo '<a href="login.php">Indietro</a>';
        }
        mysqli_close($conn);
    }
    ?>
</body>
</html>