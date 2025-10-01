<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <style>
        /* Stili generali per il corpo */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        /* Stile per il modulo */
        form {
            background-color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 300px;
        }

        form p {
            margin-bottom: 15px;
            font-size: 14px;
        }

        form input, form select, form button {
            width: 100%;
            padding: 8px;
            font-size: 14px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        form button {
            background-color: #4CAF50;
            color: white;
            font-weight: bold;
            border: none;
            cursor: pointer;
        }

        form button:hover {
            background-color: #45a049;
        }

        /* Stili per la tabella */
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            font-size: 14px;
        }

        table th, table td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }

        table th {
            background-color: #4CAF50;
            color: white;
        }

        table tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        table tr:hover {
            background-color: #ddd;
        }
        </style>

</head>
<body>
    <form method="get">
        <p>Nome: <input type="text" name="nome"></p>
        <p>Cognome: <input type="text" name="cognome"></p>
        <p>Classe: <select name="classe">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
        </select></p>
        <p>Data di nascita: <input type="date" name="dNascita"></p>
        <button type="submit" name="tasto">Invia</button>
    </form>
    <?php
        $studenti=[
            ["nome"=>"Mario", "cognome"=>"Rossi", "classe"=>1,"dNascita"=>"2023-12-25"],
            ["nome"=>"Martina", "cognome"=>"Bianchi", "classe"=>5,"dNascita"=>"2002-10-27"]
        ];

        if(isset($_GET["tasto"])){
            $persone=["nome"=>$_GET["nome"], "cognome"=>$_GET["cognome"], "classe"=>$_GET["classe"],"dNascita"=>$_GET["dNascita"]];
            array_push($studenti, $persone);
            echo "<table>";
            echo "<tr> <th>Nome</th> <th>Cognome</th> <th>Classe</th> <th>Data</th> </tr>";
            for($i=0; $i<count($studenti); $i++){
                echo "<tr>";
                echo "<td>".$studenti[$i]["nome"]."</td>";
                echo "<td>".$studenti[$i]["cognome"]."</td>";
                echo "<td>".$studenti[$i]["classe"]."</td>";
                echo "<td>".$studenti[$i]["dNascita"]."</td>";
                echo "</tr>";
            }
            echo "</table>";
        }
    ?>
</body>
</html>