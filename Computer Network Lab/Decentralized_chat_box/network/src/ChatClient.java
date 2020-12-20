

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashSet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ChatClient {

    BufferedReader in;
    PrintWriter out;
    JFrame frame = new JFrame("Chatting_Box");
    JTextField textField = new JTextField(30);
    JTextArea messageArea = new JTextArea(10, 30);
    JTextArea message = new JTextArea(6, 15);
    JTextField button=new JTextField(10);
    JLabel l=new JLabel("login as : ");
    
    private static HashSet<String> names = new HashSet<String>();

    public ChatClient() {
    	frame.setSize(400, 400);
    	frame.setLayout(new FlowLayout());;
        textField.setEditable(false);
        messageArea.setEditable(false);
        message.setEditable(false);

        frame.getContentPane().add(new JScrollPane(messageArea));
        frame.getContentPane().add(textField);
        frame.getContentPane().add(new JScrollPane(message));
        frame.add(l);
        frame.getContentPane().add(button);
        
        textField.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                out.println(textField.getText());
                textField.setText("");
            }
        });
    }

    private String getServerAddress() {
        return JOptionPane.showInputDialog(
            frame,
            "Enter IP Address of the Server : ",
            "Welcome to the Chatter",
            JOptionPane.QUESTION_MESSAGE);
    }

    private String getPort() {
        return JOptionPane.showInputDialog(
                frame,
                "Choose a port:",
                "Screen name selection",
                JOptionPane.PLAIN_MESSAGE);
    }

    private String getName() {
        return JOptionPane.showInputDialog(
            frame,
            "Choose a name:",
            "Name",
            JOptionPane.PLAIN_MESSAGE);
    }

    private void run() throws IOException {
        String serverAddress = getServerAddress();
        Socket socket = new Socket(serverAddress, Integer.parseInt(getPort()));
        in = new BufferedReader(new InputStreamReader(
            socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        String name = null;

        while (true) {
            String line = in.readLine();
            String[] a=line.split(" ");
            HashSet<String> aa=new HashSet<String>();
            for(int i=0;i<a.length;i++){
            	aa.add(a[i]);
            }
            
            if (line.startsWith("SUBMITNAME")) {
                out.println(getName());
            } else if (line.startsWith("NAMEACCEPTED")) {
                textField.setEditable(true);
                name=line.substring(12);
                System.out.println(name);
                button.setText(name);
            } 
            
            else if (line.startsWith("MESSAGE")&&a[2].equals(name)) {
                messageArea.append(a[1] + " > ");
                for(int i=3;i<a.length;i++){
                	messageArea.append(a[i] + "\n");
                }
            }
            else if (line.startsWith("MESSAGE")&&a[2].equals("all")) {
            	messageArea.append(a[1] + " > ");
                for(int i=3;i<a.length;i++){
                	messageArea.append(a[i] + "\n");
                }
            }
            else if (line.startsWith("USER")) {
            	if(!names.contains(line.substring(5))){
            		names.add(line.substring(5));
            	}
            	message.setText("");
            	for(String b:names){
            		message.append(b + "\n");
            	}
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ChatClient client = new ChatClient();
        client.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        client.frame.setVisible(true);
        client.run();
    }
}