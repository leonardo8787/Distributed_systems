/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author leonardo
 */
package classes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RmiImpl extends UnicastRemoteObject implements RmiInterface {

    public RmiImpl() throws RemoteException {
        super();
    }

    @Override
    public boolean GravaMsg(String msg) throws RemoteException {
        FileWriter writer;
        try {
            writer = new FileWriter("/home/leonardo/programming/sistemas_distribuidos_atv1/src/main/webapp/chat.txt", true);
            writer.write(msg + "\n"); // Adicione uma quebra de linha após a mensagem
            writer.close();
            return true; // Retorne true se a escrita for bem-sucedida
        } catch (IOException ex) {
            Logger.getLogger(RmiImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false; // Retorne false se houver um erro ao escrever
        }
    }

    @Override
    public String RecuperaMsgs() throws RemoteException {
        try {
            FileReader reader;
            try {
                reader = new FileReader("/home/leonardo/programming/sistemas_distribuidos_atv1/src/main/webapp/chat.txt");
                BufferedReader buffer = new BufferedReader(reader);
                StringBuilder messages = new StringBuilder();
                String line;
                while ((line = buffer.readLine()) != null) {
                    messages.append(line).append("\n");
                }
                reader.close();
                return messages.toString();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(RmiImpl.class.getName()).log(Level.SEVERE, null, ex);
                return ""; // Retorne uma string vazia se o arquivo não for encontrado
            }
        } catch (IOException ex) {
            Logger.getLogger(RmiImpl.class.getName()).log(Level.SEVERE, null, ex);
            return ""; // Retorne uma string vazia se houver um erro geral
        }
    }
}


/*

<%@page import = "java.io.FileWriter" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <Form name="FRMMSG" method="post" action="mensagem.jsp">
            <b>Mensagem: </b>  
            <input type="text" name="txtmsg" maxlength="200" size="210"> <br>
            <input type="submit" name="btnenviar" value="enviar">
        </Form>
        <%
            if(request.getParameter("txtmsg")!=null){
                FileWriter writer=new FileWriter("/home/leonardo/programming/sistemas_distribuidos_atv1/src/main/webapp/chat.txt", true);
                String msg = "<img src=\" " + session.getAttribute("radavatar") + "\" widht=\"30\" height=\"30\" +><font color=\""+session.getAttribute("radcor")+"\">" + session.getAttribute("txtnick") + "</font> diz: " + request.getParameter("txtMsg") + "<br>";
                writer.write(msg);
                writer.close();
            }
        %>

    </body>
</html>

*/