package com.codebind;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MainFormAppearance
{
    public JPanel createContentPane()
    {
        // создаём "панель", на которой и размещаюся остальные компоненты
        JPanel totalGUI = new JPanel(); //создаем поверхность
        totalGUI.setLayout(null);

        // Создаем поле для ввода тееста
        JTextField messageField = new JTextField();
        messageField.setLocation(25,25); // расположение поля
        messageField.setSize(350 , 50); // размер поля

        // создаем comboBox
        JComboBox messageBox = new JComboBox();
        messageBox.setLocation(25, 100);
        messageBox.setSize(350,50);

        // Создаём кнопку
        MyButton transferButton = new MyButton();
        transferButton.setLocation(86, 200); // расположение кнопки
        transferButton.setSize(228,113 ); // размер кнопки
        transferButton.setBorderPainted(false);
        transferButton.setFocusPainted(false);
        transferButton.setContentAreaFilled(false);
        transferButton.setRolloverIcon();

        //Vector<String> boxVector = new Vector<>(); // вектор для box

        // создаём объект-обработчик события
        ActionListener actionListener = actionEvent -> //создаем обработчик действий
        {
            String item = messageField.getText(); // забираем текст из поля
            //messageBox.addItem(item);
            int boxItem = messageBox.getItemCount();


            for (int i = 0; i <= boxItem   ; i++ ) //проверяем вектор на наличие строки
            {

                if(item.equals(messageBox.getItemAt(i)))
                {
                    //System.out.println("Bye world...");
                        JOptionPane.showMessageDialog(null, "Элемент уже существует!");
                        messageField.setText("");
                        break;
                        //messageBox.removeItem(item);

                }
                else // записываем текст в box
                {
                    if(!item.isEmpty())
                    {
                        //boxVector.addElement(item);
                        //messageBox.getItemCount();
                        //messageBox.getItemAt(0) ;
                        messageBox.addItem(item); // передаем текст в box
                        messageField.setText("");
                        break;
                    }
                }
            }

        }; // создаём действие
        // назначаем этот обработчик кнопке
        transferButton.addActionListener(actionListener);// прикрепляем действие к кнопке (срабоет по нажатии на неё)


        totalGUI.add(messageField); // добавляет поле на поверхность
        totalGUI.add(messageBox); //добавляем box на поверхность
        totalGUI.add(transferButton); // добавляем кнопку на поверхность

        return totalGUI;

    }
}
