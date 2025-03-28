<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
        if(!isset($_POST["tasto"])){
    ?> 
    <form action="login.php" method="post">
        <input type="text" name="name">
        <input type="password" name="password">
        <input type="submit" name="tasto">
    </form>
    <?php 
        }
        $servername="10.1.0.52";
        $username="saponaro";
        $passw="saponaro";
        $database="saponaro_utenti";
        $conn=mysqli_connect($servername,$username,$passw,$database);
        if(!$conn){
            die("Errore connessione ".mysqli_connect_err());
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