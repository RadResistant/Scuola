<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        table,th,td,tr{
            border: 2px black solid;
            border-collapse:1px;
        }
        .massima{
            background-color: green;
        }
        .medieMaterie{
            background-color:red;
        }
    </style>
</head>
<body>
    <?php
        $studenti=[
            [
                "studente"=>"Giovanni Bianchi",
                "matematica"=>7,
                "informatica"=>8,
                "italiano"=>6,
                "storia"=>9
            ],
            [
                "studente"=>"Mario Rossi",
                "matematica"=>7,
                "informatica"=>8,
                "italiano"=>6,
                "storia"=>9
            ],
            [
                "studente"=>"Luigi Verdi",
                "matematica"=>7,
                "informatica"=>6,
                "italiano"=>6,
                "storia"=>9
            ]
            ];
            function media($vettore){
                $totale=0;
                foreach($vettore as $tipo=>$dato){
                    if($tipo!="studente"){
                        $totale+=$dato;
                    }
                }
                return number_format(($totale/(count($vettore)-1)),2,".");
            }
            $medie=[];
            foreach($studenti as $studente){
                array_push($medie,media($studente));
            }
            function medieMaterie($materia,$vettore){
                $totale=0;
                foreach($vettore as $studente){
                    foreach($studente as  $tipo=>$dato){
                        if($tipo==$materia){
                            $totale+=$dato;
                        }
                    }
                }
                return number_format(($totale/(count($vettore))),2,".");
            }
            $medieMaterie=[];
            $materie=array("matematica","informatica","italiano","storia");
            foreach($materie as $materia){
                array_push($medieMaterie,medieMaterie($materia,$studenti));
            }
    ?>
    <table>
        <tr>
            <th>Studente</th>
            <th>Matematica</th>
            <th>Informatica</th>
            <th>Italiano</th>
            <th>Storia</th>
            <th>Media</th>
            <th>Stato</th>
        </tr>
        <?php
            for($i=0;$i<count($studenti);$i++){
                if($medie[$i]==max($medie)){
                    echo "<tr class="."massima".">";
                }
                else{
                    echo "<tr>";
                }
                echo "<td>".$studenti[$i]["studente"]."</td>";
                echo "<td>".$studenti[$i]["matematica"]."</td>";
                echo "<td>".$studenti[$i]["informatica"]."</td>";
                echo "<td>".$studenti[$i]["italiano"]."</td>";
                echo "<td>".$studenti[$i]["storia"]."</td>";
                echo "<td>".$medie[$i]."</td>";
                if($medie[$i]>=6){
                    echo "<td>Promosso</td>";
                }
                else{
                    echo "<td>Bocciato</td>";
                }
                echo "</tr>";
            }
            echo "<tr class='medieMaterie'>";
            echo "<td>Medie Materie</td>";
            foreach($medieMaterie as $mediaMateria){
                echo "<td>".$mediaMateria."</td>";
            }
            echo "</tr>";
        ?>
    </table>
</body>
</html>