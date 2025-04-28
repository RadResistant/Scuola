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
        // Viene incluso il file nella quale risiedono le informazioni necessarie per connettersi al database
        include("info.php");
        // Effettuo la connessione al database con le informazioni residenti nel file "info.php"
        $conn=mysqli_connect($server,$username,$password,$database);
        // Controllo se la connessione non è andata a buon fine
        if(!$conn){
            // Se la connessione non è andata a buon fine allora fermo tutto il file e stampo a schermo l'errore
            die("Errore connessione ".mysqli_connect_err());
        }
    ?>
    <!-- Creo il modulo per l'accesso -->
        <form action="login.php">
            <!-- Casella di testo necessaria per l'insermento dell'email -->
            <input type="text" name="email" placeholder="Inserisci l'email">
            <!-- Casella di testo necessaria per l'insermento della password -->
            <input type="password" name="password" placeholder="Inserisci la passsword">
            <!-- Pulsante per inviare i dati ad un controllo -->
            <button name="login">Accesso</button>
        </form>
    <?php
        // Avvio la sessione
        session_start();
        // Controllo se il pulsante con attrito "name" che è impostato su "login" è stato cliccato e quindi mandato in "GET" dal sito
        if(isset($_GET["login"])){
            // Controllo se i campi di testo con attributo "name" impostato rispettivamente a "email" e "password" sono stati compilati prima di essere passati in "GET" dal sito
            if(!empty($_GET["email"]) && !empty($_GET["password"])){
                // Creo una variabile chiamata "email" e imposto il suo valore a quello inserito nella casella con attributo "name" impostato su "email" prima però convertendo tutti i caratteri speciali in codifica "HTML" e mettendo tutto in minuscolo
                $email=strtolower(htmlspecialchars($_GET["email"]));
                // Creo una variabile "password" e imposto il suo valore a quello inserito nella casella con attributo "name" impostato su "password"
                $password=$_GET["password"];
                // Creo una variabile chiamata query e le assegno il valore di una interrogazione al database dove prende tutti gli utenti con email uguale a quella passata dalla variabile "email"
                $query="SELECT * FROM utenti WHERE email='".$email."';";
                // Mando l'interrogazione al database e inserisco il risultato in una variabile chiamata "result"
                $result=mysqli_query($conn,$query);
                // Controllo se il risultato restituito dal database è solo una riga
                if(mysqli_num_rows($result)==1){
                    // Se è solo una riga creo una variabile nominata "utente" e assegno ad essa i valori della riga trovata dall'interrogazione 
                    $utente=mysqli_fetch_assoc($result);
                    // Verifica se la password data è uguale a quella inserita nel database, cio viene eseguito con password verify perche nel database le password sono salvate come hash
                    if(password_verify($password,$utente["password"])){
                        // Imposto la variabile superglobale "SESSION" all'indice "email" con il valore contenuto nella variabile "email"
                        $_SESSION["email"]=$email;
                        // Imposto la variabile superglobale "SESSION" all'indice "login" con il valore 1 (cioè true)
                        $_SESSION["login"]=1;
                        // Reindirizzo alla pagina "catalogo.php"
                        header("Location:catalogo.php");
                    }
                    // Se la password non è quella giusta allora non permetto l'accesso
                    else{
                        // Stampo a schermo che la password è errata
                        echo "<p class='errore'>Password errata</p>";
                    }
                }
                // Se il risultato dell'interrogazione è diverso da 1 non permetto i controlli che porteranno all'accesso
                else{
                    // Stampo a schermo che l'email non è stata trovata
                    echo "<p class='errore'>Email non trovata</p>";
                }
            }
            // Se i campi non sono tutti compilati allora non permetto i controlli che porteranno all'accesso
            else{
                // Stampo a schermo che i campi non sono del tutto compilati
                echo "<p class='errore'>Riempire tutti i campi</p>";
            }
            // Chiudo la connessione con il database
            mysqli_close($conn);
        }
        // Controllo se la variabile superglobale "SESSION" agli indici "login" e "email" sono impostati
        if(isset($_SESSION["login"]) && isset($_SESSION["email"])){
            // Se cosi fosse controllo se la variabile superglobale "SESSION" all'indice "login" è impostata a 1 
            if($_SESSION["login"]==1){
                // Se cosi fosse allora creo una variabile chiamata "email" e imposto il suo valore a quello gia presente nella variabile superglobale "SESSION" e per sicurezza porto tutti i caratteri in minuscolo
                $email=strtolower($_SESSION["email"]);
                // Creo una variabile chiamata query e le assegno il valore di una interrogazione al database dove prende tutti gli utenti con email uguale a quella passata dalla variabile "email"
                $query="SELECT * FROM utenti WHERE email='".$email."';";
                // Mando l'interrogazione al database e inserisco il risultato in una variabile chiamata "result"
                $result=mysqli_query($conn,$query);
                // Controllo se il risultato restituito dal database è solo una riga
                if(mysqli_num_rows($result)==1){
                    // Se è solo una riga creo una variabile nominata "utente" e assegno ad essa i valori della riga trovata dall'interrogazione 
                    $utente=mysqli_fetch_assoc($result);
                    // Imposto la variabile superglobale "SESSION" all'indice "email" con il valore contenuto nella variabile "email"
                    $_SESSION["email"]=$email;
                    // Imposto la variabile superglobale "SESSION" all'indice "login" con il valore 1 (cioè true)
                    $_SESSION["login"]=1;
                    // Reindirizzo alla pagina "catalogo.php"
                    header("Location:catalogo.php");
                }
                // Chiudo la connessione con il database
                mysqli_close($conn);
            }
        }
    ?>
</body>
</html>