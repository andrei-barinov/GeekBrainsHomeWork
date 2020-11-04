import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionButtonListener implements ActionListener {
    private JTextField inputField;
    private  JTextArea outField;
    private JButton submitBtn;

    public ActionButtonListener(JTextField inputField, JTextArea outField, JButton submitBtn) {
        this.inputField = inputField;
        this.outField = outField;
        this.submitBtn = submitBtn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == inputField){
            submitBtn.doClick();
        }
        else if(e.getSource() == submitBtn){
            String val = outField.getText() + inputField.getText() + "\n";
            outField.setText(val);
            inputField.setText("");
        }
    }
}
