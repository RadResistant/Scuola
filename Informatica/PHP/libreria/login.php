<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>Libreria accesso</title>
</head>
<body>
<?php
        include("info.php");
        $conn=mysqli_connect($server,$username,$password,$database);
        if(!$conn){
            die("Errore connessione ".mysqli_connect_err());
        }
    ?>
        <form action="login.php">
            <input type="text" name="email" placeholder="Inserisci l'email">
            <input type="password" name="password" placeholder="Inserisci la passsword">
            <button name="login">Accesso</button>
        </form>
    <?php
        session_start();
        if(isset($_GET["login"])){
            if(!empty($_GET["email"]) && !empty($_GET["password"])){
                $email=strtolower(htmlspecialchars($_GET["email"]));
                $password=$_GET["password"];
                $query="SELECT * FROM utenti WHERE email='".$email."';";
                $result=mysqli_query($conn,$query);
                if(mysqli_num_rows($result)==1){
                    $utente=mysqli_fetch_assoc($result);
                    if(password_verify($password,$utente["password"])){
                        $_SESSION["email"]=$email;
                        $_SESSION["login"]=1;
                        header("Location:catalogo.php");
                    }
                    else{
                        echo "<p class='errore'>Password errata</p>";
                    }
                }
            }
            else{
                echo "<p class='errore'>Riempire tutti i campi</p>";
            }
            mysqli_close($conn);
        }
        if(isset($_SESSION["login"]) && isset($_SESSION["email"])){
            if($_SESSION["login"]==1){
                $email=strtolower($_SESSION["email"]);
                $query="SELECT * FROM utenti WHERE email='".$email."';";
                $result=mysqli_query($conn,$query);
                if(mysqli_num_rows($result)==1){
                    $utente=mysqli_fetch_assoc($result);
                    $_SESSION["email"]=$email;
                    $_SESSION["login"]=1;
                    header("Location:catalogo.php");
                }
                mysqli_close($conn);
            }
        }
    ?>
</body>
</html>