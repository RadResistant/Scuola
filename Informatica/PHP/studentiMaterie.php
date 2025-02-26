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
                "informatica"=>8,
                "italiano"=>6,
                "storia"=>9
            ]
        ]
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
    </table>
</body>
</html>