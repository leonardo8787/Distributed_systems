<%-- 
    Document   : votos
    Created on : 30 de ago. de 2023, 19:40:31
    Author     : leonardo
--%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Urna Eletrônica</title>
<style>
  body {
    font-family: Arial, sans-serif;
    text-align: center;
  }
  h1 {
    margin-bottom: 20px;
  }
  .options {
    display: flex;
    justify-content: center;
    gap: 20px;
    margin-bottom: 20px;
  }
  button {
    padding: 10px 20px;
    font-size: 16px;
    background-color: #4CAF50;
    color: white;
    border: none;
    cursor: pointer;
  }
  button:hover {
    background-color: #45a049;
  }
</style>
</head>
<body>
    <center>
        <form name="frmlogin" method="get" action="votos.jsp">
            <h1>Urna Eletrônica</h1>
            <div class="options">
              <div>
                <label for="azul"><input type="radio" id="azul" name="cor" value="azul"> Azul</label>
              </div>
              <div>
                <label for="verde"><input type="radio" id="verde" name="cor" value="verde"> Verde</label>
              </div>
              <div>
                <label for="roxo"><input type="radio" id="roxo" name="cor" value="roxo"> Roxo</label>
              </div>
              <div>
                <label for="vermelho"><input type="radio" id="vermelho" name="cor" value="vermelho"> Vermelho</label>
              </div>
            </div>
            <input type="submit" value="votar">
        </form>
    </center>
</body>
</html>

