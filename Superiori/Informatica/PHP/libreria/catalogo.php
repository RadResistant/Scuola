<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Libreira catalogo</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <?php
        // Avvio la sessione
        session_start();
        // Controllo se la variabile superglobale "SESSION" all'indice "login" è diversa da 1
        if($_SESSION["login"]!=1){
            // Se lo è allora reindirizzo alla pagina "index.php"
            header("Location:index.php");
        }
    ?>
    <?php
        // Viene incluso il file nella quale risiedono le informazioni necessarie per connettersi al database
        include("info.php");
        // Effettuo la connessione al database con le informazioni residenti nel file "info.php"
        $conn=mysqli_connect($server,$username,$password,$database);
        // Controllo se la connessione non è andata a buon fine
        if(!$conn){
            // Se la connessione non è andata a buon fine allora fermo tutto il file e stampo a schermo l'errore
            die("Errore connessione ".mysqli_connect_err());
        }
        // Creo una variabile chiamata "queryUtente" e ne imposto il valore con l'interrogazione dove chiedo gli utenti filtrandoli per email con l'email impostata nella variabile superglobale "SESSION" all'indice "email"
        $queryUtente="SELECT * FROM utenti WHERE email='".$_SESSION["email"]."';";
        // Mando l'interrogazione al database e inserisco il risultato in una variabile chiamata "result"
        $result=mysqli_query($conn,$queryUtente);
        // Controllo se il risultato restituito dal database è solo una riga
        if(mysqli_num_rows($result)==1){
            // Se è solo una riga creo una variabile nominata "utente" e assegno ad essa i valori della riga trovata dall'interrogazione 
            $utente=mysqli_fetch_assoc($result);
            // Stampo a schermo il benvenuto con il nome dell'utente che ha effettuato l'accesso
            echo "<h1> Benvenuto ".$utente["nome"]."</h1><br>";
            // Controllo che la variabile "utente" all'indice "is_gestore" sia impostata a "true" (quindi 1) 
            if($utente["is_gestore"]){
                // Nel caso che la variabile sia impostata a "true" stampo a schermo il pulsante che porta alla pagina di gestione della libreria
                echo "<form action='gestore.php'><button>Gestisci la libreria</button></form><br>";
            }
            // Stampo a schermo il form contenente il bottone che consentira di effettuare l'uscita dal profilo a cui si è precedenetmente acceduti
            echo "<form action='catalogo.php'><button name='logout'>Log out</button></form><br>";
        }
        // Controllo se la variabile "GET" all'indice "logout" sia stata impostata dal bottone
        if(isset($_GET["logout"])){
            // Se cosi fosse distruggo la sessione 
            session_destroy();
            // E reindirizzo alla pagina "index.php"
            header("Location:index.php");
        }
        // Creo una variabile chiamata "queryLibri" e imposto il suo valore con l'interrogazione necessaria per avere tutti i libri con i relativi autori e le relative categorie 
        $queryLibri="SELECT libri.nome as nomeLibro,autori.nome as nomeAutore,autori.cognome as cognomeAutore, categorie.descrizione as descrizioneCategoria 
        FROM libri,libri_autori,autori,libri_categorie,categorie 
        WHERE libri.id=libri_autori.fk_libri AND libri_autori.fk_autori=autori.cf AND libri.id=libri_categorie.fk_libri AND libri_categorie.fk_categorie=categorie.id";
        // Mando l'interrogazione al database e inserisco il risultato in una variabile chiamata "result"
        $result=mysqli_query($conn,$queryLibri);
        // Controllo se il risultato restituito dal database è costituito da più di 0 righe
        if(mysqli_num_rows($result)>0){
            // Mentre nella variabile "libro" e ancora possibile inserire come valore una riga ricevuta dal database
            while($libro=mysqli_fetch_assoc($result)){
                // Stampo a schermo il nome dei libri presenti
                echo "<p><strong>".$libro["nomeLibro"]."</strong>";
                // Per ogni campo presente nella variabile "libro" 
                foreach($libro as $key=>$content){
                    // Controllo che il campo non sia "nomeLibro", "nomeAutore", "cognomeAutore" o "descrizione Categoria"
                    if($key!="nomeLibro" || $key!="nomeAutore" || $key!="cognomeAutore" || $key!="descrizioneCategoria" ){
                        // Se non lo è stampo a schermo sia il nome del campo che il contenuto
                        echo $key." :".$content;
                    }
                }
                // Stampo a schermo il resto delle informazioni del libro
                echo " scritto da <strong>".$libro["nomeAutore"]." ".$libro["cognomeAutore"]."</strong> con categorie <strong>".$libro["descrizioneCategoria"]."</strong></p>";
            }
        }
    ?>
</body>
</html>