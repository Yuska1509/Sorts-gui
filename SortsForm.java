package com.company;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Yulia
 */
public class SortsForm {
    private JButton button1;
    private JProgressBar progressBar1;
    private JTextField mainTextField;
    private JLabel infoLabel;
    private JPanel mainPanel1;
    Integer barValue = 0;
    String infoLabelText = "";
    String result = "";
    Integer listLenght = 0;

    /**
     * testing sorts
     * @param list list that we sort
     */
    public void maintestspeed(int[] list) {
        Tester[] algs = new Tester[]{
                new Tester(new Sort.Comb(), "Yulia.CombSort"),
                new Tester(new Sort.Insertion(), "Yulia.Insertionsort"),
                new Tester(new Sort.Bubble(), "Yulia.BubbleSort"),
                new Tester(new Sort.Gnome(), "Yulia.GnomeSort"),
                new Tester(new Sort.Selection(), "Yulia.SelectionSort"),
                new Tester(new ArtemsSorts.Bubble(), "Artem.BubbleSort"),
                new Tester(new ArtemsSorts.Counting(), "Artem.CountingSort"),
                new Tester(new ArtemsSorts.Selection(), "Artem.SelectionSort"),
                new Tester(new ArtemsSorts.Comb(),"Artem.CombSort"),
                new Tester(new ArtemsSorts.Insertion(),"Artem.InsertionSort")
        };

        for (Tester alg : algs) {
            int[] toSort = list.clone();
            System.out.println(alg.name);
            infoLabelText = alg.name;
            alg.sort(toSort);
            result = result + "Время работы " + alg.name + ":  " + String.valueOf(alg.time) + " с" + "\n";
            barValue += 100/(algs.length);
        }
    }


    public SortsForm() {
        mainTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                progressBar1.setValue(0);
                infoLabel.setText("");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });

        button1.addActionListener(new ActionListener() { // start button
            @Override
            public void actionPerformed(ActionEvent e) {
                progressBar1.setValue(0);
                infoLabel.setText("");
                progressBar1.setMaximum(100);
                barValue = 0;
                result = "";
                Thread one = new Thread(() -> { // main thread
                    try {
                        while (barValue < 100) {
                            try { // if you put an integer
                                if (Integer.parseInt(mainTextField.getText()) > 0) {
                                    listLenght = Integer.parseInt(mainTextField.getText());
                                    Integer range = 10000;
                                    System.out.println("Creating array");
                                    infoLabel.setText("Creating array");
                                    infoLabelText = "Creating array";
                                    int[] list = InputPrint.getRandomArray(listLenght, range);
                                    maintestspeed(list);
                                } else { // you put a negative number
                                    infoLabelText = "Error";
                                    barValue = 100;
                                    result = "Длина списка должна быть натуральным числом.";

                                }
                            } catch (Exception ex) { // yuo put not integer
                                infoLabelText = "Error";
                                barValue = 100;
                                result = "Длина списка должна быть натуральным числом.";
                            }
                            Thread.sleep(1);
                            JOptionPane.showMessageDialog(null, result, "Результат для массива длины " + listLenght,
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                    }  catch(InterruptedException v) {
                        System.out.println(v.getMessage());
                    }
                });
                one.start();
                Thread two = new Thread(() -> { // updating progressbar and textfield
                    try {
                        while (barValue <= 100) {
                            infoLabel.setText(infoLabelText);
                            progressBar1.setValue(barValue);
                            Thread.sleep(1);
                        }
                    } catch (InterruptedException v) {
                        System.out.println(v.getMessage());
                    }
                });
                two.start();
            }
        });
    }

    /**
     * creating JFrame
     * @param args args
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new SortsForm().mainPanel1);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}