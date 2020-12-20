
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;

public class ChatServer {
    private static final int PORT = 01;
    private static final int PORT1 = 02;
    private static final int PORT2 = 03;

    private static HashSet<String> names = new HashSet<String>();
    private static HashSet<String> names1 = new HashSet<String>();
    private static HashSet<String> names2 = new HashSet<String>();
    
    private static HashSet<PrintWriter> writers = new HashSet<PrintWriter>();
    private static HashSet<PrintWriter> writers1 = new HashSet<PrintWriter>();
    private static HashSet<PrintWriter> writers2 = new HashSet<PrintWriter>();

    public static void main(String[] args) throws Exception {
    	names.add("all");

    	
        System.out.println("Connected the chat server.");
        ServerSocket listener = new ServerSocket(PORT);
        ServerSocket listener1 = new ServerSocket(PORT1);
        ServerSocket listener2 = new ServerSocket(PORT2);
        try {
            while (true) {
                new Handler(listener.accept()).start();
                new Handler1(listener1.accept()).start();
                new Handler2(listener2.accept()).start();
            }
        } finally {
            listener.close();
            listener1.close();
            listener2.close();
        }
    }
    private static class Handler extends Thread {
        private String name;
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

       
        public Handler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                while (true) {
                    out.println("SUBMITNAME");
                    name = in.readLine();
                    if (name == null) {
                        return;
                    }
                    synchronized (names) {
                        if (!names.contains(name)) {
                            names.add(name);
                            break;
                        }
                    }
                }
                out.println("NAMEACCEPTED"+name);
                writers.add(out);
                for(String a:names){
                	out.println("USER "+a);
                }
                

                while (true) {
                    String input = in.readLine();
                    if (input == null) {
                        return;
                    }
                    for (PrintWriter writer : writers) {
                        writer.println("MESSAGE " + name + " " + input);
                    }
                    for(String a:names){
                    	out.println("USER "+a);
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                // This client is going down!  Remove its name and its print
                // writer from the sets, and close its socket.
                if (name != null) {
                    names.remove(name);
                }
                if (out != null) {
                    writers.remove(out);
                }
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }
    }
    
    private static class Handler1 extends Thread {
        private String name;
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;
        public Handler1(Socket socket) {
            this.socket = socket;
        }
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                while (true) {
                    out.println("SUBMITNAME");
                    name = in.readLine();
                    if (name == null) {
                        return;
                    }
                    synchronized (names1) {
                        if (!names1.contains(name)) {
                            names1.add(name);
                            break;
                        }
                    }
                }

               out.println("NAMEACCEPTED");
                writers1.add(out);
                for(String a:names1){
                	out.println("USER "+a);
                }
                while (true) {
                    String input = in.readLine();
                    if (input == null) {
                        return;
                    }
                    for (PrintWriter writer : writers1) {
                        writer.println("MESSAGE " + name + " " + input);
                    }
                    for(String a:names1){
                    	out.println("USER "+a);
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                
                if (name != null) {
                    names1.remove(name);
                }
                if (out != null) {
                    writers1.remove(out);
                }
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }
    }
    private static class Handler2 extends Thread {
        private String name;
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

       
        public Handler2(Socket socket) {
            this.socket = socket;
        }

       
        public void run() {
            try {

                
                in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                
                while (true) {
                    out.println("SUBMITNAME");
                    name = in.readLine();
                    if (name == null) {
                        return;
                    }
                    synchronized (names2) {
                        if (!names2.contains(name)) {
                            names2.add(name);
                            break;
                        }
                    }
                }

                
                out.println("NAMEACCEPTED"+name);
                writers2.add(out);
                
                for(String a:names2){
                	out.println("USER "+a);
                }
                while (true) {
                    String input = in.readLine();
                    if (input == null) {
                        return;
                    }
                    
                    for (PrintWriter writer : writers2) {
                        writer.println("MESSAGE " + name + " " + input);
                    }
                    for(String a:names2){
                    	out.println("USER "+a);
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                if (name != null) {
                    names2.remove(name);
                }
                if (out != null) {
                    writers2.remove(out);
                }
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }
    }
}