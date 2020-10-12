import javax.script.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ActionButtonListener  implements ActionListener {

    private JTextField outField;
    private StringBuilder sb;

    public ActionButtonListener(JTextField outField) {
        this.outField = outField;
        this.sb = new StringBuilder();
    }

    public  void covertExplanation (String explanation){

    }


    @Override
    public void actionPerformed(ActionEvent e){
        JButton jButton = (JButton) e.getSource();
        if ((jButton.getText()) == "C") {
            outField.setText("");
        }
        else if (jButton.getText() == "=") {
            String explanation = outField.getText();
            try{
                ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
                ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("Nashorn");
                Object expResult1 = scriptEngine.eval(explanation);
                String result = expResult1.toString();
                outField.setText(result.toString());
            } catch (Exception c){
                c.printStackTrace();
            }
            /*int indexMinus = explanation.indexOf("-"); //Сложение и вычитание для двух чисел
            if (indexMinus != -1) {
                int a = Integer.parseInt(explanation.substring(0, indexMinus));
                int b = Integer.parseInt(explanation.substring(indexMinus + 1, explanation.length()));
                int result = a - b;
                outField.setText(Integer.toString(result));
            } else {
                int indexPlus = explanation.indexOf("+");
                if (indexPlus != -1) {
                    int a = Integer.parseInt(explanation.substring(0, indexPlus));
                    int b = Integer.parseInt(explanation.substring(indexPlus + 1, explanation.length()));
                    int result = a + b;
                    outField.setText(Integer.toString(result));
                }
            }*/
        }
        else{
                String val = sb.append(outField.getText())
                        .append(jButton.getText())
                        .toString();
                outField.setText(val);
                sb.setLength(0);
        }
    }
}