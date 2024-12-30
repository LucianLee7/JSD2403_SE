package socket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientGUI_CP {
    private Socket socket;
    private PrintWriter pw;
    private JTextArea textArea;

    public ClientGUI_CP(){
        try {
            socket = new Socket("localhost",8088);
            OutputStream out = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(out, StandardCharsets.UTF_8);
            BufferedWriter bw = new BufferedWriter(osw);
            pw = new PrintWriter(bw, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        // Create GUI
        JFrame frame = new JFrame("Chat Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        textArea = new JTextArea();
        textArea.setEditable(false);
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JTextField textField = new JTextField();
        frame.add(textField, BorderLayout.SOUTH);

        JButton sendButton = new JButton("Send");
        frame.add(sendButton, BorderLayout.EAST);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                textField.setText("");
                pw.println(text);
            }
        });

        frame.setVisible(true);

        // Start ServerHandler in a new thread
        ServerHandler handler = new ServerHandler();
        Thread t = new Thread(handler);
        t.setDaemon(true);
        t.start();
    }

    public static void main(String[] args) {
        ClientGUI_CP client = new ClientGUI_CP();
        client.start();
    }

    private class ServerHandler implements Runnable{
        @Override
        public void run() {
            try {
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);
                String line;
                while((line = br.readLine())!=null){
                    textArea.append(line + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
