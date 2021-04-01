package Laba2;

import java.awt.event.*;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import static java.nio.charset.StandardCharsets.UTF_8;


import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;



// класс реализующий слушатель (ожидания нажатия кнопки)
public class ListenerButtonInfo implements ActionListener {

	@Override // ключевое слово, которое позволяет в дочернем классе заново создать реализацию метода родительского класса
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
			
	JFrame secondN = new JFrame("subversion");	// создание графического окна
	JTextArea txt = new JTextArea();
	txt.setEditable(false);
	secondN.setTitle ("ФИО участников команды и номера зачетных книжек");
	secondN.setBounds(500,400,400,300);
	secondN.setResizable(false); // фиксированный размер окна
	secondN.setLayout(null);
	
    String text1 = "Кадалова Елена Вадимовна, номер зачетной книжки: 19130164 ";  // создается коллекция символов для представления текста
    String text2 = "Саттаров Ян Эдуардович, номер зачетной книжки: 19130609 ";   
    String text3 = "Набиев Руслан Ришатович, номер зачетной книжки: 19131202 ";
    String text4 = "Номера зачетных книжек:";	
    
    JLabel Kad = new JLabel();    // создается компонент для показа текста
    Kad.setBounds(10,0,500,60);  // задается расположение текста в окне
    Kad.setText(text1);          // установка текста в поле
    
    JLabel Satt = new JLabel();
    Satt.setBounds(10,0,500,100);
    Satt.setText(text2);
    
    JLabel Nab = new JLabel();
    Nab.setBounds(10,0,500,140);
    Nab.setText(text3);
    
    JLabel zach = new JLabel();
    zach.setBounds(10,0,500,20);
    zach.setText(text4);
    txt.setBounds(10,80,360,120);
    
	try {

	List<String> tek = Files.readAllLines(Paths.get(subversion.vivod), UTF_8);
	for (String y: tek) {

	txt.append(y+System.lineSeparator());
	}
	
	} catch (IOException zz) {
		
	}
    secondN.add(Kad); // добавление текста в окно
    secondN.add(Satt);
    secondN.add(Nab);
    secondN.add(zach);
    secondN.add(txt);
    
    JButton cancelButton = new JButton ("Выход"); // создание кнопки Выход
    cancelButton.setBounds(20,200,100,40); // расположение кнопки Выход
    cancelButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            secondN.dispose(); // результат нажатия кнопки Выход
        
        }
        
    });
    secondN.add(cancelButton); // добавление кнопки Выход
    secondN.setVisible(true); // видимость окна
	
	}

	
}

