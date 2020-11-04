import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

public class Chat extends JFrame {
    private JFrame mainFrame;

    public Chat(){

        mainFrame = new JFrame();
        mainFrame.setBounds(500, 200, 700, 400);
        mainFrame.setTitle("Chat Demo");
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout()); //Способ размещения внутри mainFrame

        JPanel top = new JPanel();
        JPanel bottom = new JPanel();
        top.setLayout(new BorderLayout()); //Способ размещения внутри top
        bottom.setLayout(new BorderLayout()); //Способ размещения внутри bottom

        mainFrame.add(top, BorderLayout.CENTER);
        mainFrame.add(bottom, BorderLayout.PAGE_END);

        JMenuBar mainMenu = new JMenuBar();// Менюшка
        JMenu mFile = new JMenu("File");
        JMenu mEdit = new JMenu("Edit");
        JMenuItem miFileNew = new JMenuItem("New");
        JMenuItem miFileExit = new JMenuItem("Exit");
        setJMenuBar(mainMenu);
        mainMenu.add(mFile);
        mainMenu.add(mEdit);
        mFile.add(miFileNew);
        mFile.addSeparator(); // разделительная линия в меню
        mFile.add(miFileExit);

        miFileExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("BYE");
            }
        });

        top.add(mainMenu, BorderLayout.NORTH);

        JTextField inputField = new JTextField();// Поле ввода сообщения
        bottom.add(inputField, BorderLayout.CENTER);

        JButton submitBtn = new JButton("Submit"); //Кнопка отправки
        bottom.add(submitBtn, BorderLayout.EAST);

        JTextArea outField = new JTextArea(); //Поле вывода
        JScrollPane scrollPane = new JScrollPane(outField);
        top.add(outField, BorderLayout.CENTER);
        outField.setEditable(false);
        //outField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT); //Выравнивание по левому краю

        ActionButtonListener abListener = new ActionButtonListener(inputField, outField, submitBtn);
        submitBtn.addActionListener(abListener);
        inputField.addActionListener(abListener);

        mainFrame.setVisible(true);
    }
}
