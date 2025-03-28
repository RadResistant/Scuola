<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tabelline</title>
    <link rel="stylesheet" href="style.css">
    <style>
        *{margin:0;}
        .pari { color: blue; }
        .dispari { color: red; }
        th,td,tr{border:2px black solid; margin:0;background-color:white}
        table{margin:0; padding:0; border:black solid 2px; background-color:black};
    </style>
</head>
<body>
    <h1>Tabelline</h1>
    <table>
        <tr>
            <th> </th> 
            <?php
            for ($y = 1; $y <= 10; $y++) {
                echo "<th>$y</th>";
            }
            ?>
        </tr>
        <?php
        for ($i = 1; $i <= 10; $i++) {
            echo "<tr>";
            echo "<th>$i</th>"; 
            for ($y = 1; $y <= 10; $y++) {
                $prodotto = $i * $y;
                // echo "<td class='({$prodotto % 2 == 0) ? "pari" : "dispari"}'>$prodotto</td>";
                $classe = ($prodotto % 2 == 0) ? "pari" : "dispari";
                // if($prodotto % 2 == 0){
                //     $classe="pari";
                // }else{
                //     $classe="dispari";
                // }
                echo "<td class='$classe'>$prodotto</td>";
            }
            echo "</tr>";
        }
        ?>
    </table>
</body>
</html>
