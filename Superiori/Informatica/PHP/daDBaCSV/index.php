<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Convertitore</title>
</head>
<body>
    <?php
        // $path=$_SERVER["DOCUMENT_ROOT"]."/daDBaCSV/files/";
        // So che bastava mettere il /files/ prima del nome del file da aprire ma cosi almeno mi ricordo qualcosa di nuovo
        include "info.php";
        $conn=mysqli_connect($servername,$username,$passw,$db);
        if(!$conn){
            die(mysqli_connect_err());
        }
        $ricercaTabelle="SELECT TABLE_NAME FROM information_schema.tables WHERE table_schema = '".$db."';";
        $resultTabelle=mysqli_query($conn,$ricercaTabelle);
        if(mysqli_num_rows($resultTabelle)>0){
            while($tabella=mysqli_fetch_assoc($resultTabelle)){
                // $file=fopen($path.$tabella["TABLE_NAME"].".csv","w");
                $file=fopen($tabella["TABLE_NAME"].".csv","w");
                $ricercaContenuto="SELECT * FROM ".$tabella["TABLE_NAME"].";";
                $resultContenuto=mysqli_query($conn,$ricercaContenuto);
                if(mysqli_num_rows($resultContenuto)>0){
                    while($riga=mysqli_fetch_assoc($resultContenuto)){
                        $testo=implode(",",$riga)."\n";
                        fwrite($file,$testo);
                    }
                }
            }
        }
        echo "<h1>Fatto</h1>";
    ?>
</body>
</html>