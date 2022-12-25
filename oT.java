import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class oT extends JFrame implements ActionListener {
JButton btnNext, btnBookmark;
JLabel label;
ButtonGroup bg;
int m[] = new int[10];
JRadioButton radioButton[] = new JRadioButton[5];
int current = 0, count = 0, x = 1, y = 1, now = 0;
oT(String s) {
super(s);
label = new JLabel();
add(label);
bg = new ButtonGroup();
for (int i = 0; i < 5; i++) {
radioButton[i] = new JRadioButton();
add(radioButton[i]);
bg.add(radioButton[i]);
}
btnNext = new JButton("Next Question");
btnBookmark = new JButton("Bookmark Question");
btnNext.addActionListener(this);
btnBookmark.addActionListener(this);
add(btnNext);
add(btnBookmark);
set();
label.setBounds(30, 40, 450, 20);
radioButton[0].setBounds(50, 80, 450, 20);
radioButton[1].setBounds(50, 110, 200, 20);
radioButton[2].setBounds(50, 140, 200, 20);
radioButton[3].setBounds(50, 170, 200, 20);
btnNext.setBounds(100, 240, 150, 30);
btnBookmark.setBounds(270, 240, 200, 30);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(null);
setLocation(250, 100);
setVisible(true);
setSize(700, 600);
Color c = new Color(0, 206, 209);
getContentPane().setBackground(c);
}
/* handle all event */
public void actionPerformed(ActionEvent e) {
if (e.getSource() == btnNext) {
if (qcheck())
count = count + 1;
current++;
set();
if (current == 9) {
btnNext.setEnabled(false);
btnBookmark.setText("Result");
}
}
if (e.getActionCommand().equals("Bookmark Question")) {
JButton bk = new JButton("Bookmark " + x);
bk.setBounds(480, 20 + 30 * x, 150, 30);
add(bk);
bk.addActionListener(this);
m[x] = current;
x++;
current++;
set();
if (current == 9)
btnBookmark.setText("Score");
setVisible(false);
setVisible(true);
}
for (int i = 0, y = 1; i < x; i++, y++) {
if (e.getActionCommand().equals("Bookmark" + y)) {
if (qcheck())
count = count + 1;
now = current;
current = m[y];
set();
((JButton) e.getSource()).setEnabled(false);
current = now;
}
}
if (e.getActionCommand().equals("Result")) {
if (qcheck())
count = count + 1;
current++;
JOptionPane.showMessageDialog(this, "Your score is :"+count);
System.exit(0);
}
}
/* Setting Questions with options */
void set() {
radioButton[4].setSelected(true);
if (current == 0) {
label.setText("Q1:Who invented Java Language ");
radioButton[0].setText("Dennis Ritchie");
radioButton[1].setText("Larry Page");
radioButton[2].setText("James Gosling");
radioButton[3].setText("Serge Page");
}
if (current == 1) {
label.setText("Q2: Which concept allows you to reuse the written code?");
radioButton[0].setText("Encapsulation");
radioButton[1].setText("Abstraction");
radioButton[2].setText("Inheritance");
radioButton[3].setText(" Polymorphism");
}
if (current == 2) {
label.setText("Q3:java.util.Collections is a:");
radioButton[0].setText(" Class");
radioButton[1].setText(" Interface");
radioButton[2].setText(" Object");
radioButton[3].setText(" None of the above");
}
if (current == 3) {
label.setText("Que4: Wrapping data and its related functionality into a single entity is known as _____________");
radioButton[0].setText(" Abstraction");
radioButton[1].setText("Encapsulation");
radioButton[2].setText("Polymorphism");
radioButton[3].setText("Modularity");
}
if (current == 4) {
label.setText("Q5: What does a comment look like in Java?");
radioButton[0].setText(" //comment");
radioButton[1].setText("--comment");
radioButton[2].setText("==comment");
radioButton[3].setText("///comment");
}
if (current == 5) {
label.setText("Q6: Which of the following is not an OOPS concept in Java?");
radioButton[0].setText("Polymorphism");
radioButton[1].setText("Inheritance");
radioButton[2].setText("Compilation");
radioButton[3].setText("Encapsulation");
}
if (current == 6) {
label.setText("Q7: Which component is used to compile, debug and execute the java programs?");
radioButton[0].setText("JRE");
radioButton[1].setText("JIT");
radioButton[2].setText("JDK");
radioButton[3].setText("JVM");
}
if (current == 7) {
label.setText("Q8: Which one of the following is not a Java feature?");
radioButton[0].setText("Object-oriented");
radioButton[1].setText("Use of pointers");
radioButton[2].setText("Portable");
radioButton[3].setText("Dynamic and Extensible");
}
if (current == 8) {
label.setText("Q9: Which of these cannot be used for a variable name in Java?");
radioButton[0].setText("identifier & keyword");
radioButton[1].setText("identifier");
radioButton[2].setText("keyword");
radioButton[3].setText("none of the mentioned");
}
if (current == 9) {
label.setText("Q10: What is the extension of java code files?");
radioButton[0].setText(".js");
radioButton[1].setText(".txt");
radioButton[2].setText(".class");
radioButton[3].setText(".java");
}
label.setBounds(30, 40, 450, 20);
for (int i = 0, j = 0; i <= 90; i += 30, j++)
radioButton[j].setBounds(50, 80 + i, 200, 20);
}
/* declare right answers. */
boolean qcheck() {
if (current == 0)
return (radioButton[2].isSelected());
if (current == 1)
return (radioButton[2].isSelected());
if (current == 2)
return (radioButton[0].isSelected());
if (current == 3)
return (radioButton[1].isSelected());
if (current == 4)
return (radioButton[0].isSelected());
if (current == 5)
return (radioButton[2].isSelected());
if (current == 6)
return (radioButton[1].isSelected());
if (current == 7)
return (radioButton[1].isSelected());
if (current == 8)
return (radioButton[2].isSelected());
if (current == 9)
return (radioButton[3].isSelected());
return false;
}
public static void main(String s[]) {
    new oT("Online Exam Portal");
    }
    }