/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.uv.dsweb.practica01.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebastian
 */
public class DSWebPractica01Server {

    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Server iniciado...");

            while (true) {
                Socket cliente = server.accept();
                ClienteSocket clienteSocket = new ClienteSocket(cliente);
                clienteSocket.start();
                System.out.println("Cliente Aceptado....");
            }
            
        } catch (IOException ex) {
            Logger.getLogger(DSWebPractica01Server.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

/*try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Server iniciado...");
            
            Socket cliente = server.accept();
            System.out.println("Cliente aceptado");
            
            InputStreamReader isr = new InputStreamReader(cliente.getInputStream());
            BufferedReader reader = new BufferedReader(isr);
            String msg = reader.readLine();
            
            OutputStreamWriter osw = new OutputStreamWriter(cliente.getOutputStream());
            BufferedWriter writer = new BufferedWriter(osw);
            
            writer.write("Saludos desde cliente...");
            writer.flush();
            
            System.out.println("Cliente: " + msg);
            
            } catch (IOException ex) {
            Logger.getLogger(DSWebPractica01Server.class.getName()).log(Level.SEVERE, null, ex);
            }    */
