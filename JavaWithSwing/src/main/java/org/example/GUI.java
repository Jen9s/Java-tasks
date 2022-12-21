package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    public  JButton button;
    public JTextField input1;
    public JTextField input2;
    public JTextField answer;

    public JComboBox comboBox1;
//    private JLabel label = new JLabel("Input:");
//    private JRadioButton radioButton1 = new JRadioButton("1");
//    private JRadioButton radioButton2 = new JRadioButton("2");
//    private JCheckBox jCheckBox = new JCheckBox("Check",false);

    public GUI(){
        JFrame frame = new JFrame("Window");
        frame.setSize(600, 100);
        JPanel panel= new JPanel();
        String[] items = {
                "Int",
                "Double",
                "String"
        };

        comboBox1 = new JComboBox(items);
        panel.add(comboBox1);
        button = new JButton("Press to");
        input1 = new JTextField("",5);
        panel.add(input1);
        input1.setText("");
        input2 = new JTextField("",5);
        panel.add(input2);
        input2.setText("");
        answer = new JTextField("",10);
        panel.add(answer);
        answer.setText("");
        panel.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                ActionListener actionListener = new ActionListener() {
//                    public void actionPerformed(ActionEvent e) {
//                        answer.setText("dasd");
//                    }
//                };
//                comboBox1.addActionListener(actionListener);
                int tmp = comboBox1.getSelectedIndex();


                switch (tmp){
                    case 0 :{
                        String str1 = input1.getText();
                        String str2 = input2.getText();
                        if(str1 != null && str2 != null) {
                            int first = Integer.parseInt(str1);
                            int second = Integer.parseInt(str2);
                            int result = first + second;
                            String resultString = String.valueOf(result);
                            answer.setText(resultString);
                        }
                        break;
                    }
                    case 1 :{
                        String str1 = input1.getText();
                        String str2 = input2.getText();
                        if(str1 != null && str2 != null) {
                            double first = Double.parseDouble(str1);
                            double second = Double.parseDouble(str2);
                            double result = first + second;
                            String resultString = String.valueOf(result);
                            answer.setText(resultString);
                        }
                        break;
                    }
                    case 2 :{
                        String str1 = input1.getText();
                        String str2 = input2.getText();
                        if(str1 != null && str2 != null) {
                            String resultString = str1 + " " + str2;
                            answer.setText(resultString);
                        }
                        break;
                    }

                }
            }
        });

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }


}



class GuiLoader{
    public static void main(String[] args) {
        GUI dick = new GUI();
    }
}