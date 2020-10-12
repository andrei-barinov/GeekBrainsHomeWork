import javax.swing.*;
import java.awt.*;

public class Calculator {
    private JFrame mainFrame;
    public Calculator(){
        mainFrame = new JFrame();
        mainFrame.setTitle("Calculator");
        mainFrame.setBounds(100, 100, 300, 500);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainFrame.setLayout(new BorderLayout());
        JPanel top = new JPanel();
        JPanel bottom = new JPanel();
        top.setLayout(new GridLayout());
        bottom.setLayout(new GridLayout(5, 3));
        mainFrame.add(top, BorderLayout.NORTH);
        mainFrame.add(bottom, BorderLayout.CENTER);

        JTextField outField = new JTextField();
        top.add(outField, BorderLayout.CENTER);
        outField.setEditable(false);

        ActionButtonListener abListener = new ActionButtonListener(outField);
        for(int i=0; i <= 9; i++){
            JButton digitButton = new JButton(String.valueOf(i));
            bottom.add(digitButton);
            digitButton.addActionListener(abListener);
        }

        JButton plusBtn = new JButton("+");
        bottom.add(plusBtn);
        plusBtn.addActionListener(abListener);

        JButton minusBtn = new JButton("-");
        bottom.add(minusBtn);
        minusBtn.addActionListener(abListener);

        JButton CancelBtn = new JButton("C");
        bottom.add(CancelBtn);
        CancelBtn.addActionListener(abListener);

        JButton SmbBtn = new JButton("=");
        bottom.add(SmbBtn);
        SmbBtn.addActionListener(abListener);

        mainFrame.setVisible(true);
    }
}
