<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signup eventi</title>
    <link rel="stylesheet" href="Styles/styleAccesso.css">
    <?php
        include "info.php";
        $conn=mysqli_connect($server,$uname,$password,$db);
        if(!$conn){
            die("Errore connessione al db nce arpova");
        }
        session_start();
    ?>
</head>
<body>
    <form>
        <input type="text" name="nome" placeholder="Nome">
        <input type="text" name="cognome" placeholder="Cognome">
        <input type="text" name="email"  placeholder="Email">
        <input type="password" name="passw" placeholder="Password">
        <button name="signup">Registrati</button>
        <?php
            if(isset($_GET["signup"])){
                if(!empty($_GET["nome"]) && !empty($_GET["cognome"]) && !empty($_GET["email"]) && !empty($_GET["passw"])){
                    $ricercaUtenti="SELECT * FROM utenti WHERE email='".$_GET["email"]."';";
                    $resultUtenti=mysqli_query($conn,$ricercaUtenti);
                    if(mysqli_num_rows($resultUtenti)==0){
                        $inserimentoUtente="INSERT INTO utenti(nome,cognome,email,passw) VALUES ('".$_GET["nome"]."','".$_GET["cognome"]."','".$_GET["email"]."','".password_hash($_GET["passw"],PASSWORD_DEFAULT)."');";
                        if(mysqli_query($conn,$inserimentoUtente)){
                            $_SESSION["email"]=$_GET["email"];
                            $_SESSION["login"]=1;
                            header("Location:home.php");
                        }
                    }
                    else{
                        echo "<p class='error'>Email già registrata</p>";
                    }
                }
                else{
                    echo "<p class='error'>Riempire tutti i campi</p>";
                }
            }
        ?>
    </form>
</body>
</html>