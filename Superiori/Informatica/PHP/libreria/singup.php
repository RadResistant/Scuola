<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>Libreria Regitrazione</title>
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
    <!-- Creo il modulo per la registrazione -->
        <form action="singup.php">
            <!-- Casella di testo necessaria per l'insermento del nome -->
            <input type="text" name="nome" placeholder="Inserisci il nome">
            <!-- Casella di testo necessaria per l'insermento del cognome -->
            <input type="text" name="cognome" placeholder="Inserisci il cognome">
            <!-- Casella di testo necessaria per l'insermento dell'email -->
            <input type="text" name="email" placeholder="Inserisci l'email">
            <!-- Casella di testo necessaria per l'insermento della password -->
            <input type="password" name="password" placeholder="Inserisci la passsword">
            <!-- Pulsante per inviare i dati ad un controllo -->
            <button name="singup">Registrati</button>
        </form>
    <?php
        // Avvio la sessione
        session_start();
        // Controllo se il pulsante con attrito "name" che è impostato su "singup" è stato cliccato e quindi mandato in "GET" dal sito
        if(isset($_GET["singup"])){
            // Controllo se i campi di testo con attributo "name" impostato rispettivamente a "nome", "cognome", "email" e "password" sono stati compilati prima di essere passati in "GET" dal sito
            if(!empty($_GET["nome"]) && !empty($_GET["cognome"]) && !empty($_GET["email"]) && !empty($_GET["password"])){
                // Creo una variabile chiamata "nome" e imposto il suo valore a quello inserito nella casella con attributo "name" impostato su "nome" prima però convertendo tutti i caratteri speciali in codifica "HTML"
                $nome=htmlspecialchars($_GET["nome"]);
                // Creo una variabile chiamata "email" e imposto il suo valore a quello inserito nella casella con attributo "cognome" impostato su "cognome" prima però convertendo tutti i caratteri speciali in codifica "HTML"
                $cognome=htmlspecialchars($_GET["cognome"]);
                // Creo una variabile chiamata "email" e imposto il suo valore a quello inserito nella casella con attributo "name" impostato su "email" prima però convertendo tutti i caratteri speciali in codifica "HTML" e mettendo tutto in minuscolo
                $email=strtolower(htmlspecialchars($_GET["email"]));
                // Creo una variabile "password" e imposto il suo valore a quello dell'"hash" corrispondente alla password inserita nella casella con attributo "name" impostato su "password"
                $password=password_hash($_GET["password"],PASSWORD_DEFAULT);
                // Creo una variabile chiamata query e le assegno il valore di una interrogazione al database dove prende tutti gli utenti con email uguale a quella passata dalla variabile "email"
                $queryRicerca="SELECT * FROM utenti WHERE email='".$email."';";
                // Mando l'interrogazione al database e inserisco il risultato in una variabile chiamata "result"
                $result=mysqli_query($conn, $queryRicerca);
                // Controllo se il risultato restituito dal database sono più di 0 righe
                if(mysqli_num_rows($result)>0){
                    // Se ci sono più di 0 righe allora stampo a schermo che l'email è stata già registrata
                    echo "<p class='errore'>Email gia registrata</p>";
                }
                // Se il risultato restituito dal database sono 0 righe allora procedo con la registrazione
                else{
                    // Creo una variabile chiamata "queryInserimento" e le assegno come valore l'interrogazione di inserimento dei dati passandole le variabili "email", "password", "nome" e "cognome"
                    $queryInserimento="INSERT INTO utenti(email,password,nome,cognome,is_gestore) VALUES ('".$email."','".$password."','".$nome."','".$cognome."',0);";
                    // Mando l'interrogazione e controllo se il risultato restituito è 0 (cioè false) che poi viene "ribaltato" dall'operatore NOT(!)
                    if(!(mysqli_query($conn, $queryInserimento))){
                        // Se il risultato "ribaltato" è 1 (cioè true) allora stampo a schermo l'errore 
                        echo "Error: " . $queryInserimento . "<br>" . $conn->error;
                    }
                    // Se invece il risultato ribaltato è 0 l'utente è stato registrato
                    else{
                        // Imposto la variabile superglobale "SESSION" all'indice "email" con il valore contenuto nella variabile "email"
                        $_SESSION["email"]=$email;
                        // Imposto la variabile superglobale "SESSION" all'indice "login" con il valore 1 (cioè true)
                        $_SESSION["login"]=1;
                        // Reindirizzo alla pagine "login.php"
                        header("Location:login.php");
                    }
                }
            }
            // Se uno o più campi non sono stati riempiti non permetto la registrazione
            else{
                // Stampo a schermo di riempire tutti i campi
                echo "<p class='errore'>Riempire tutti i campi</p>";
            }
            // Chiudo la connessione con il database
            mysqli_close($conn);
        }
    ?>
</body>
</html>