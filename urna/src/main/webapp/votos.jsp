<%--
Document   : votos
Created on : 30 de ago. de 2023, 19:40:31
Author     : leonardo
--%>
<%@ page import="urnaMiddleware.RmiInterface" %>
<%@ page import="java.rmi.Naming" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.FileReader" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.FileWriter" %>
<%@ page import="java.util.HashMap" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <style>
        .custom-table {
            width: 80%;
            margin: auto;
            border-collapse: separate;
            border-spacing: 0;
        }

        .custom-table th,
        .custom-table td {
            padding: 12px 15px;
            text-align: center;
        }

        .custom-table th {
            background-color: #333;
            color: #fff;
            border: 1px solid #333;
        }

        .custom-table td {
            background-color: #f2f2f2;
            border: 1px solid #ddd;
        }
    </style>
</head>
<body>
    <center>
        <table class="custom-table">
            <tr>
                <th>Candidato</th>
                <th>Quantidade de votos</th>
                <th>Porcentagem</th>
                <th>% de votos</th>
            </tr>

            <%

            RmiInterface objRmi = (RmiInterface)Naming.lookup("rmi://localhost:7777/ServidorVoto");
            String cor = objRmi.RecuperaVoto();
               
            
            if(request.getParameter("cor")!=null){
                try{
                    String msg = request.getParameter("cor");
                    objRmi.GravaVoto(msg);
                }catch(Exception e){
                    out.println("Erro: " + e.getMessage());
                }
            }
                /*
                if (cor != null) {
                    FileWriter writer = new FileWriter("/home/leonardo/NetBeansProjects/urna/src/main/webapp/texto.txt", true); 
                    writer.write(cor + "\n");
                    out.print(cor);
                    writer.close();
                }
*/

                HashMap<String, Integer> corCountMap = new HashMap<String, Integer>();
                try {
                    FileReader reader = new FileReader("/home/leonardo/NetBeansProjects/urna/src/main/webapp/texto.txt");
                    BufferedReader buffer = new BufferedReader(reader);
                    String line;
                    while ((line = buffer.readLine()) != null) {
                        if (line.trim().isEmpty()) {
                            continue;
                        }
                        Integer count = corCountMap.get(line);
                        if (count == null) {
                            count = 1;
                        } else {
                            count++;
                        }
                        corCountMap.put(line, count);
                    }
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                int totalVotos = 0;
                for (Integer count : corCountMap.values()) {
                    totalVotos += count;
                }

                for (HashMap.Entry<String, Integer> entry : corCountMap.entrySet()) {
                    cor = entry.getKey();
                    int corCount = entry.getValue();
                    double porcentagem = (corCount * 100.0) / totalVotos;

                    out.println("<tr>");
                    out.println("<td>" + cor + "</td>");
                    out.println("<td>" + corCount + "</td>");
                    out.println("<td><div style='width: " + porcentagem + "%; background-color: #4f46e5; color:white;'>" + String.format("%.2f", porcentagem) + "%   </div></td>");
                    out.println("<td>" + String.format("%.2f", porcentagem) + "%</td>");
                    out.println("</tr>");
                }

            %>
        </table>
        <a href="index.jsp">Voltar</a>
    </center>
</body>
</html>

