package socket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * AI提示词
 * 基于上述代码生成图形化界面，要求:
 * 窗口中有一个文本域用于显示聊天信息，在文本域下方生成一个输入框，用于让用户输入聊天信息，在该输入框右侧生成一个按钮，当点击该按钮时将输入框内容发送给服务端。该按钮上的文字为"发送"
 */
public class ClientGUI {
    private Socket socket;
    private BufferedReader br;
    private PrintWriter out;
    private JFrame frame = new JFrame("Chat Room");
    private JTextField textField = new JTextField();
    private JTextArea textArea = new JTextArea();
    public ClientGUI() {
        try {
            socket = new Socket("localhost", 8088);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getServerMessage() {
        try {
            return br.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    private void run() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        try {
            String nickname="No Name";
            while (true) {
                nickname = JOptionPane.showInputDialog(frame,
                        "请输入昵称:", "提示",
                        JOptionPane.QUESTION_MESSAGE);
                if(nickname!=null && !nickname.trim().isEmpty()){
                    out.println(nickname);
                    frame.setTitle("Chat Room - " + nickname);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                out.println(textField.getText());
                textField.setText("");
            }
        });

        frame.getContentPane().add(textField, BorderLayout.SOUTH);
        frame.getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);
        textArea.setEditable(false);
        frame.setVisible(true);

        while (true) {
            String line = getServerMessage();
            if (line == null)
                break;
            textArea.append(line + "\n");
        }
    }

    public static void main(String[] args) {
        ClientGUI client = new ClientGUI();
        client.run();
    }
}
