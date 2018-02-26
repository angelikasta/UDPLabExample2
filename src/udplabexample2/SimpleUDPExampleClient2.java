package udplabexample2;

import java.io.*;
import java.net.*;

public class SimpleUDPExampleClient2 {

    public static void main(String[] args) throws Exception {
        try (DatagramSocket clientSocket = new DatagramSocket()) {
            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];
            
            BufferedReader inFromUser
                    = new BufferedReader(new InputStreamReader(System.in));
            InetAddress IPAddress = InetAddress.getByName("localhost");

            String sentence = inFromUser.readLine();
            sendData = sentence.getBytes();
            
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
            clientSocket.send(sendPacket);
            
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            
            String modifiedSentence = new String(receivePacket.getData());
            System.out.println("FROM SERVER:" + modifiedSentence);
        }
    }
}