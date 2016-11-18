import java.io.*; 
import java.net.*; 

class TCPClient { 
	public static void main(String[] args) throws Exception{
            String sentence;
            String modifiedSentence;
            
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

            Socket clientSocket = new Socket("hostname",6789); 

		/*
		Server always runs first.
		If it runs between two computers: One runs client, the other runs server. In client must be the server IP.
		If it runs on one computer: It need to have both client and server. First server (Run File) IP form that computer.
		*/
            
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            
            sentence = inFromUser.readLine();
            
            outToServer.writeBytes(sentence + '\n');
            
            modifiedSentence = inFromServer.readLine();
            
            System.out.println("FROM SERVER: " + modifiedSentence);
            
            clientSocket.close();
    }
    
}