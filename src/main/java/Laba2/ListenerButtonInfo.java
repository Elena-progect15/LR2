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



// ����� ����������� ��������� (�������� ������� ������)
public class ListenerButtonInfo implements ActionListener {

	@Override // �������� �����, ������� ��������� � �������� ������ ������ ������� ���������� ������ ������������� ������
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
			
	JFrame secondN = new JFrame("subversion");	// �������� ������������ ����
	JTextArea txt = new JTextArea();
	txt.setEditable(false);
	secondN.setTitle ("��� ���������� ������� � ������ �������� ������");
	secondN.setBounds(500,400,400,300);
	secondN.setResizable(false); // ������������� ������ ����
	secondN.setLayout(null);
	
    String text1 = "�������� ����� ���������, ����� �������� ������: 19130164 ";  // ��������� ��������� �������� ��� ������������� ������
    String text2 = "�������� �� ����������, ����� �������� ������: 19130609 ";   
    String text3 = "������ ������ ���������, ���� ����������: 14.04.21, ����� �������� ������: 19131202 ";
    String text4 = "������ �������� ������:";	
    
    JLabel Kad = new JLabel();    // ��������� ��������� ��� ������ ������
    Kad.setBounds(10,0,500,60);  // �������� ������������ ������ � ����
    Kad.setText(text1);          // ��������� ������ � ����
    
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
    secondN.add(Kad); // ���������� ������ � ����
    secondN.add(Satt);
    secondN.add(Nab);
    secondN.add(zach);
    secondN.add(txt);
    
    JButton cancelButton = new JButton ("�����"); // �������� ������ �����
    cancelButton.setBounds(20,200,100,40); // ������������ ������ �����
    cancelButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            secondN.dispose(); // ��������� ������� ������ �����
        
        }
        
    });
    secondN.add(cancelButton); // ���������� ������ �����
    secondN.setVisible(true); // ��������� ����
	
	}

	
}

