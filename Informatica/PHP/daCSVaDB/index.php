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
        $tabelle=array();
        foreach($fileContent as $key=>$content){
            if($key!=0){
                $tabelle[]=explode(",",$content);
            }
        }
        $dbName="saponaro_".$fileInfo["filename"];
        $ricercaDB="SHOW DATABASES WHERE database='".$dbName."';";
        $resultDB=mysqli_query($conn,$ricercaDB);
        if(mysqli_num_rows($resultDB)==0){
            $creazioneDB="CREATE DATABASE ".$dbName;
            if(!mysqli_query($conn,$creazioneDB)){
                echo "no";
            }
        }
        $ricercaTabelle="SELECT TABLE_NAME FROM information_schema.tables WHERE table_schema = '".$dbName."' AND TABLE_NAME=".$fileContent[0].";";
        $resultTabelle=mysqli_query($conn,$ricercaTabelle);
        if(mysqli_num_rows($resultTabelle)==0){
            $creazioneTabelle="CREATE TABLE ".$dbName.".".$fileContent[0]."(
                ".$tabelle[0][0]." ".$tabelle[0][2]."(".$tabelle[0][1]."),
                ".$tabelle[0][3]." ".$tabelle[0][5]."(".$tabelle[0][4]."),
                ".$tabelle[0][6]." ".$tabelle[0][8]."(".$tabelle[0][7]."),
            )";
            if(!mysqli_query($conn,$creazioneTabelle)){
                echo "no";
            }
        }
        $inserimentoDati="INSERT INTO ".$dbName.".".$fileContent[0]."(
            
        );";
    ?>
</body>
</html>