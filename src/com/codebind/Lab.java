package com.codebind;


import javax.swing.*;
import java.awt.*;





 public class Lab
{
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true); //установка стандартного внешнего вида фрейма
        JFrame frame = new JFrame("Main Frame"); // заголовок фрейма

        // Создаем панель для добавления компонентов
        MainFormAppearance form = new MainFormAppearance(); // внешность формы
        frame.setContentPane(form.createContentPane()); // передача компонентов внешки фрейму
        frame.getContentPane().setBackground( Color.WHITE );

        // задаём операцию, которая выполниться при закрытии
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 370); // задаём размер окна
        frame.setVisible(true); //  форма будет видимой
    }
}
