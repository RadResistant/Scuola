<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="" method="get">
        <h1>calcolatrice</h1>
        <p><input type="number" name="num1">N1</p>
        <p><input type="number" name="num2">N2</p>
        <br>
        <select name="operazione">
            <option value="+">+</option>
            <option value="-">-</option>
            <option value="*">*</option>
            <option value="/">/</option>
            <option value="%">%</option>
        </select> 
        <br>
        <input type="submit" name="Submit">
        <input type="reset">
    </form>
    <?php
        if(isset($_GET["Submit"])){
            switch($_GET["operazione"]){
                case "+":
                    echo  (int)$_GET["num1"]+(int)$_GET["num2"];
                    break;
                case "-":
                    echo (int)$_GET["num1"]-(int)$_GET["num2"];
                    break;
                case "*":
                    echo (int)$_GET["num1"]*(int)$_GET["num2"];
                    break;
                case "/":
                    echo (int)$_GET["num1"]/(int)$_GET["num2"];
                    break;
                case "%":
                    echo (int)$_GET["num1"]%(int)$_GET["num2"];
                    break;
            }
        }
    ?>
</body>
</html>