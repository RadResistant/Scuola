<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Libreria Regitrazione</title>
</head>
<body>
    <?php
        include("info.php");
        $conn=mysqli_connect($server,$username,$password,$database);
        if(!$conn){
            die("Errore connessione ".mysqli_connect_err());
        }
    ?>
        <form action="singup.php">
            <input type="text" name="nome" placeholder="Inserisci il nome">
            <input type="text" name="cognome" placeholder="Inserisci il cognome">
            <input type="text" name="email" placeholder="Inserisci l'email">
            <input type="password" name="password" placeholder="Inserisci la passsword">
            <button name="singup">Registrati</button>
        </form>
    <?php
        if(isset($_GET["singup"])){
            if(!empty($_GET["nome"]) && !empty($_GET["cognome"]) && !empty($_GET["email"]) && !empty($_GET["password"])){
                $nome=htmlspecialchars($_GET["nome"]);
                $cognome=htmlspecialchars($_GET["cognome"]);
                $email=strtolower(htmlspecialchars($_GET["email"]));
                $password=password_hash($_GET["password"],PASSWORD_DEFAULT);
                $queryRicerca="SELECT * FROM utenti WHERE email='".$email."';";
                $result=mysqli_query($conn, $queryRicerca);
                if(mysqli_num_rows($result)>0){
                    echo "<p>Email gia registrata</p>";
                }
                else{
                    $queryInserimento="INSERT INTO utenti(email,password,nome,cognome) VALUES ('".$email."','".$password."','".$nome."','".$cognome."');";
                    if(!(mysqli_query($conn, $queryInserimento))){
                        echo "Error: " . $queryInserimento . "<br>" . $conn->error;
                    }
                    else{
                        setcookie("email",$email,time()+3600);
                        setcookie("password",$_GET["password"],time()+3600);
                        header("Location:login.php");
                    }
                }
            }
            else{
                echo "<p>Riempire tutti i campi</p>";
            }
            mysqli_close($conn);
        }
    ?>
</body>
</html>