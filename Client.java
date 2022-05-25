package com.osi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        String host = "localhost";
        try (
            Socket clientSocket = new Socket(host, 8080);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            String input = "Катюша";
            out.write(input + "\n");
            out.flush();
            String serverAnswer = in.readLine();
            System.out.println("Server's answer - " + serverAnswer);
        } catch (IOException ex){
            ex.printStackTrace();
        }


    }
}
