<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
        include "../info.php";
        if($_FILES["nomefile"]["error"]==0){
            $contenuto=file($_FILES["nomefile"]["tmp_name"]);
            foreach($contenuto as $riga){
                $r=explode(',',$riga);
                $sql="insert into persona values (null,'$r[0]','$r[1]',$r[2]) ";
                echo $sql;
            }
        }
    ?>
    <form method="post" enctype="multipart/form-data">
        <input type="file" name="nomefile">
        <input type="submit">
    </form>
</body>
</html>