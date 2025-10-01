<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
        include "info.php";
        $conn=mysqli_connect($servername,$username,$password);
        if(!$conn){
            die("Errore");
        }
        $dbName="saponaro_magazzino";
        $ricercaDB="SHOW DATABASES LIKE '".$dbName."'";
        $resultDB=mysqli_query($conn,$ricercaDB);
        if(mysqli_num_rows($resultDB)==0){
            $creazioneDB="CREATE DATABASE saponaro_magazzino;";
            if(!mysqli_query($conn,$creazioneDB)){
                die("Errore");
            }
            echo "ciao";
        }
        $ricercaTabelle="SELECT TABLE_NAME FROM information_schema.tables WHERE table_schema = '".$dbName."';";
        $resultTabelle=mysqli_query($conn,$ricercaTabelle);
        while($tabella=mysqli_fetch_assoc($resultTabelle)){
            $cancellazioneTabelle="DROP TABLE ".$dbName.".".$tabella["TABLE_NAME"].";";
            if(!mysqli_query($conn,$cancellazioneTabelle)){
                die("Errore");
            }
        }
        $creazioneTabellaFornitori="CREATE TABLE ".$dbName.".fornitori(
            codice_fornitore varchar(11) PRIMARY KEY,
            ragione_sociale varchar(40) NOT NULL,
            indirizzo varchar(35) NOT NULL,
            cap char(5),
            citta varchar(30)
        );";
        if(!mysqli_query($conn,$creazioneTabellaFornitori)){
            die("Errore");
        }
        $creazioneTabellaArticoli="CREATE TABLE ".$dbName.".articoli(
            codice_articolo varchar(15) PRIMARY KEY,
            descrizione varchar(35) NOT NULL,
            quantita int NOT NULL,
            prezzo double NOT NULL,
            fk_fornitore varchar(11),
            FOREIGN KEY (fk_fornitore) REFERENCES fornitori(codice_fornitore)
            ON UPDATE CASCADE 
            ON DELETE CASCADE
        );";
        if(!mysqli_query($conn,$creazioneTabellaArticoli)){
            die("Errore");
        }
        $file=fopen("Maga.csv","r");
        $fileLog=fopen("Log.txt","w");
        $fileRows=explode("\n",fread($file,filesize("Maga.csv")));
        $fileContent=array();
        foreach($fileRows as $fileRow){
            $row=explode(",",$fileRow);
            $fileContent[]=$row;
        }
        foreach($fileContent as $key=>$content){
            if($content[0]=="F"){
                $ricercaDuplicati="SELECT * FROM ".$dbName.".fornitori WHERE codice_fornitore='".$content[1]."'";
                $resultDuplicati=mysqli_query($conn,$ricercaDuplicati);
                if(mysqli_num_rows($resultDuplicati)==0){
                    $inserimentoValori="INSERT INTO ".$dbName.".fornitori(codice_fornitore,ragione_sociale,indirizzo,cap,citta) VALUES 
                    ('".$content[1]."','".$content[2]."','".$content[3]."','".$content[4]."','".$content[5]."');";
                    if(!mysqli_query($conn,$inserimentoValori)){
                       die("Errore");
                    }
                }
                else{
                    fwrite($fileLog,"Error at line ".($key+1)."\n");
                }
            }
            if($content[0]=="A"){
                $ricercaDuplicati="SELECT * FROM ".$dbName.".articoli WHERE codice_articolo='".$content[1]."'";
                $resultDuplicati=mysqli_query($conn,$ricercaDuplicati);
                $ricercaEsterna="SELECT * FROM ".$dbName.".fornitori WHERE codice_fornitore='".$content[5]."'";
                $resultEsterna=mysqli_query($conn,$ricercaEsterna);
                if(mysqli_num_rows($resultDuplicati)==0 && mysqli_num_rows($resultEsterna)==1){
                    $inserimentoValori="INSERT INTO ".$dbName.".articoli(codice_articolo,descrizione,quantita,prezzo,fk_fornitore) VALUES 
                    ('".$content[1]."','".$content[2]."',".$content[3].",".$content[4].",'".$content[5]."');";
                    if(!mysqli_query($conn,$inserimentoValori)){
                        die("Errore");
                    }
                }
                else{
                    echo "no";
                    fwrite($fileLog,"Error at line ".($key+1)."\n");
                }
            }
        }
    ?>
    <form>
        <h1>Seleziona un fornitore e mostrero tutti gli atricoli</h1>
        <select name="fornitore">
            <?php
                $ricercaFornitori="SELECT * FROM ".$dbName.".fornitori;";
                $resultFornitori=mysqli_query($conn,$ricercaFornitori);
                if(mysqli_num_rows($resultFornitori)>0){
                    while($fornitore=mysqli_fetch_assoc($resultFornitori)){
                        echo "<option value='".$fornitore["codice_fornitore"]."'>".$fornitore["ragione_sociale"]."</option>";
                    }
                }
            ?>
        </select>
        <button name="cercaArticoli">Ricerca</button>
        <?php
            if(isset($_GET["cercaArticoli"])){
                $ricercaArticoli="SELECT * FROM ".$dbName.".articoli WHERE fk_fornitore='".$_GET["fornitore"]."';";
                $resultArticoli=mysqli_query($conn,$ricercaArticoli);
                if(mysqli_num_rows($resultArticoli)>0){
                    while($articolo=mysqli_fetch_assoc($resultArticoli)){
                        echo "<p>".$articolo["descrizione"]."<p>";
                    }
                }
            }
        ?>
    </form>
    <form>
        <h1>seleziona la quantita e ti diro un articolo che ce ne so de meno</h1>
        <input type="number" name="quantita">
        <button name="ricera">Invia</button>
        <?php
            if(isset($_GET["ricera"])){
                $ricercaArticoliMassimo="SELECT * FROM ".$dbName.".articoli WHERE quantita<".$_GET["quantita"];
                $resultArticoliMassimo=mysqli_query($conn,$ricercaArticoliMassimo);
                if(mysqli_num_rows($resultArticoliMassimo)>0){
                    while($articolo=mysqli_fetch_assoc($resultArticoliMassimo)){
                        echo "<p>".$articolo["descrizione"]."<p>";
                    }
                }
            }
        ?>
    </form>
</body>
</html>