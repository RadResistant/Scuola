<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>
<body>
    <?php
        include "info.php";
        $conn=mysqli_connect($servername,$username,$passw);
        if(!$conn){
            die(mysqli_connect_err());
        }
        $file=fopen("moto.csv","r");
        $fileInfo=pathinfo("moto.csv");
        $fileContent=explode("\n",fread($file,filesize("moto.csv")));
        print_r($fileContent);
        $dbName="saponaro_".$fileInfo["filename"];
        $creazioneDB="CREATE DATABASE ".$dbName;
        if(!mysqli_query($conn,$creazioneDB)){
            echo "no";
        }
        $creazioneTabella="";
    ?>
</body>
</html>