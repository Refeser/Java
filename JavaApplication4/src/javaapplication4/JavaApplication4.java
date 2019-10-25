package javaapplication4;
import java.util.*;
import java.util.LinkedList;
import java.awt.*;
import java.awt.event.*;
import java.lang.annotation.Native;
import javax.swing.*;

public class JavaApplication4 {
static int count;
public static void main(String[] args){
count = 0;
Balls balls = new Balls();
}
}
class Balls extends Frame implements Observer, ActionListener, ItemListener {
private LinkedList LL = new LinkedList();
private Color col;
private String name;
public Frame f;
private Button b;
private Choice c;
private TextField tf;
Balls(){
this.addWindowListener(new WindowAdapter2());
f = new Frame();
f.setSize(new Dimension(300,100));
f.setTitle("Контроль");
f.setLayout(new GridLayout());
f.addWindowListener(new WindowAdapter2());
b = new Button("Пуск");
b.setSize(new Dimension(10,40));
b.setActionCommand("OK");

b.addActionListener(this);
f.add(b, new Point(20,20));
c = new Choice();
c.addItem("Petrov");
c.addItem("Ivanov");
c.addItem("Sahibullin");
c.addItem("Zaripova");c.addItem("Galieva");
c.addItemListener(this);
f.add(c, new Point(60,20));
tf = new TextField();
f.add(tf);
f.setVisible(true);
this.setSize(500,200);
this.setVisible(true);
this.setLocation(100, 150);
}
public void update(Observable o, Object arg) {
Ball ball = (Ball)arg;
System.out.println ("x= " + ball.thr.getName() + ball.x);
repaint();
}
public void paint (Graphics g) {
if (!LL.isEmpty()){
for (Object LL1 : LL) {
Ball ball = (Ball) LL1;
g.setColor(ball.col);
//g.drawOval(ball.x, ball.y, 20, 20);
g.drawString(name, ball.x-10, ball.y+10);
}
}
}
public void itemStateChanged (ItemEvent iE) {}
public void actionPerformed (ActionEvent aE) {
String str = aE.getActionCommand();
if (str.equals ("OK")){
switch (c.getSelectedIndex()) {
case 0: col= Color.blue; name = "Petrov"; break;
case 1: col= Color.green; name = "Ivanov"; break;
case 2: col= Color.red; name = "Sahibullin"; break;
case 3: col= Color.black; name = "Zaripova"; break;
case 4: col= Color.ORANGE; name = "Galieva"; break;
}
Ball ball= new Ball(col, this.tf.getText());
LL.add(ball);
ball.addObserver(this);
}
repaint();
}
}
class Ball extends Observable implements Runnable {
Thread thr;
private boolean xplus;
private boolean yplus;

int x; int y;
Color col;
public Ball (Color col, String text) {
xplus = true; yplus = true;
x = 0; y = 30;
this.col = col;
JavaApplication4.count++;
thr = new Thread(this,JavaApplication4.count+":"+text+":");
thr.start();
}
public void run(){
    Frame f = new Frame();     
while (true){
if(x==475) xplus = false;
if(x==-1) xplus = true;
if(y==175) yplus = false;
if(y==29) yplus = true;
if(xplus) x++; else x--;
if(yplus) y++; else y--;
setChanged();notifyObservers (this);
try{Thread.sleep (10);}
catch (InterruptedException e){}
}
}
}

class WindowAdapter2 extends WindowAdapter {
public void windowClosing (WindowEvent wE) {System.exit (0);}
}