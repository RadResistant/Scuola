<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Libreira catalogo</title>
</head>
<body>
    <?php
        include("info.php");
        $conn=mysqli_connect($server,$username,$password,$database);
        if(!$conn){
            die("Errore connessione ".mysqli_connect_err());
        }
        $queryUtente="SELECT * FROM utenti WHERE email='".$_COOKIE["email"]."';";
        $result=mysqli_query($conn,$queryUtente);
        if(mysqli_num_rows($result)==1){
            $utente=mysqli_fetch_assoc($result);
            echo "<h1> Benvenuto ".$utente["nome"]."</h1>";
            if($utente["is_gestore"]){
                echo "<form action='gestore.php'><button>Gestisci la libreria</button></form>";
            }
            echo "<form action='catalogo.php'><button name='logout'>Log out</button></form>";
        }
        if(isset($_GET["logout"])){
            setcookie("email","",time()-1);
            setcookie("login","",time()-1);
            header("Location:index.php");
        }
        $queryLibri="SELECT libri.nome as nomeLibro,autori.nome as nomeAutore,autori.cognome as cognomeAutore, categorie.descrizione as descrizioneCategoria 
        FROM libri,libri_autori,autori,libri_categorie,categorie 
        WHERE libri.id=libri_autori.fk_libri AND libri_autori.fk_autori=autori.cf AND libri.id=libri_categorie.fk_libri AND libri_categorie.fk_categorie=categorie.id";
        $result=mysqli_query($conn,$queryLibri);
        if(mysqli_num_rows($result)>0){
            while($libro=mysqli_fetch_assoc($result)){
                echo "<p><strong>".$libro["nomeLibro"]."</strong> scritto da <strong>".$libro["nomeAutore"]." ".$libro["cognomeAutore"]."</strong> con categorie <strong>".$libro["descrizioneCategoria"]."</strong></p>";
            }
        }
    ?>
</body>
</html>