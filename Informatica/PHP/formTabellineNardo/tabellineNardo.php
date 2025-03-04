<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tabelline</title>
    <link rel="stylesheet" href="style.css">
    <style>
        .pari {
            color: blue;
        }

        .dispari {
            color: red;
        }
    </style>
</head>

<body>
    <h1>Tabelline</h1>
    <table border="1">
        <tr>
            <th> </th>
            <?php
            $inizio = $_GET["numero"];
            if(is_numeric($inizio))
            for ($y = $inizio; $y <= 10; $y++) {
                echo "<th>$y</th>";
            }
            echo "</tr>";
            for ($i = $inizio; $i <= 10; $i++) {
                echo "<tr>";
                echo "<th>$i</th>";
                for ($y = $inizio; $y <= 10; $y++) {
                    $prodotto = $i * $y;
                    $classe = ($prodotto % 2 == 0) ? "pari" : "dispari";
                    echo "<td class='$classe'>$prodotto</td>";
                }
                echo "</tr>";
            }
            ?>
    </table>
</body>

</html>