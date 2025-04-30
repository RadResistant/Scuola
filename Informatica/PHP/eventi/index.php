<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Log-in eventi</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <?php
        include "info.php";
        $conn=mysqli_connect($server,$uname,$password,$db);
        if(!$conn){
            die("Errore connessione al db nce arpova");
        }
        start_session();
    ?>
    <div>
        <form>
            <input type="text" name="email">
            <input type="password" name="passw">
            <button name="login">Accedi</button>
            <?php
                if(isset($_GET["login"])){
                    if(!empty($_GET["email"]) && !empty($_GET["passw"])){
                        $ricercaUtente="SELECT * FROM utenti WHERE email = '".$_GET["email"]."';";
                        $resultUtente=mysqli_query($conn,$ricercaUtente);
                        if(mysqli_num_rows($resultUtente)=1){
                            $utente=mysqli_fetch_assoc($resultUtente);
                            if(password_verify($_GET["passw"],$utente["password"])){
                                $_SESSION["email"]=$_GET["email"];
                                $_SESSION["login"]=1;
                                header("Location:home.php");
                            }
                        }
                    }
                    else{
                        echo "<p class='error'>Riempi tutti i campi</p>";
                    }
                }
            ?>
            <p>Non sei registrato?</p>
            <button name="signup">Registrati</button>
        </form>    
    </div>
</body>
</html>
<?php
    if(isset($_GET["signup"])){
        header("Location:signup.php");
    }
?>