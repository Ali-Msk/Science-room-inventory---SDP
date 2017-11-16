
/* *
 * By Vincent Zhang
 * To read the Button that get teacher name
 * */
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addTeacherButtonListener implements ActionListener {
JTextField textField;
 public addTeacherButtonListener(JTextField textField){
 super();
 this.textField=textField;
 }
 
 public void actionPerformed(ActionEvent e) {
  HelpGUILauncher.teacherName.add(textField.getText());

 }

}