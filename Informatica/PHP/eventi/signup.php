<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signup eventi</title>
</head>
<body>
    <h1>WORK IN PROGRESS</h1>
    <form>
        <input type="text" name="nome" placeholder="Nome">
        <input type="text" name="cognome" placeholder="Cognome">
        <input type="text" name="email"  placeholder="Email">
        <input type="password" name="passw" placeholder="Password">
        <button name="signup">Registrati</button>
    </form>
    <?php
        if(isset($_GET["signup"])){
            if(!empty($_GET["nome"]) && !empty($_GET["cognome"]) && !empty($_GET["email"]) && !empty($_GET["passw"])){
                $inserimentoUtente="INSERT INTO utenti(nome,cognome,email,passw) VALUES ('".$_GET["nome"]."'";
            }
            else{
                echo "<p class='error'>Riempire tutti i campi</p>";
            }
        }
    ?>
</body>
</html>