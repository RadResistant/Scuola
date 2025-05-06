<?php
    $ricercaUtente="SELECT * FROM utenti WHERE email='".$_SESSION["email"]."';";
    $resultUtente=mysqli_query($conn,$ricercaUtente);
    if(mysqli_num_rows($resultUtente)==1){
        $utente=mysqli_fetch_assoc($resultUtente);
        if($utente["is_admin"]!=1){
            header("Location:home.php");
        }
    }
    else{
        if(mysqli_num_rows($resultUtente)==0){
            header("Location:home.php");
            die();
        }
        elseif(mysqli_num_rows($resultUtente)>1){
            die("<p class='error'>Errore nel database perfavore contattare il 3347565800</p>");
        }
    }
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>WORK IN PROGRESS</h1>
</body>
</html>