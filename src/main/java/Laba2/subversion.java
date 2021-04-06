	package Laba2; //����� Java �������

import java.awt.event.ActionListener; //���������� ��� ������� ���������
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*; // ���������� ��� GUI (��������� �� ������ awt)
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

public class subversion {
	
	protected JFrame main_GUI;
    protected JPanel main_panel;
    private JLabel label;
    private JTextField num_1;
    private JTextField num_2;
    private JTextField otvet;
    protected static subversion student;
    static String vivod="";
    
	public subversion() {
	main_GUI = new JFrame("subversion");	// �������� ������������ ����
	main_GUI.setTitle ("Using subversion for developers");
	main_GUI.setBounds(500,400,400,400);
	main_GUI.setResizable(false); // ������������� ������ ����
	
	

	
	main_panel = new JPanel(); // ������ - ������������ ��� ����������� ����������� � ����
	main_panel.setLayout(null);
	main_GUI.add(main_panel);
	
	JLabel laba_info = new JLabel("������������ ������ �2"); // ����������� ������ ��� �����������
	laba_info.setBounds(120,100,150,30);
	main_panel.add(laba_info);
	
	JButton button_exit = new JButton("�����"); // ��������� ������
	button_exit.setBounds(270,280,100,40);
	ActionListener actionListener = new ListenerButton(); //������� ���������
	button_exit.addActionListener(actionListener); // ��������� ��������� � ������
	main_panel.add(button_exit);
	
	JButton button_info = new JButton("����������"); // ��������� ������
	button_info.setBounds(20,280,130,40);
	ActionListener infoListener = new ListenerButtonInfo(); //������� ���������
	button_info.addActionListener(infoListener); // ��������� ��������� � ������
	main_panel.add(button_info);
	
	
	JMenuBar menuBar = new JMenuBar();// ������ ������ �������� ����
    main_GUI.setJMenuBar(menuBar);// ��������� ���� � ����������
    JMenu editMenu = new JMenu ("�������");// ������ ���������� ����
    menuBar.add(editMenu);// ���������� ���� � ���� ���

    JMenuItem menu1 = new JMenuItem("���������� ������� �����");// ���������� � ���� �������� 
    ActionListener Log = new lop();//������� ���������
    menu1.addActionListener(Log);// ���������� ��������� � ������
    editMenu.add(menu1);// ���������� � ������� ����
    
    JMenuItem dowfile = new JMenuItem("��������� ���� � ������15");// ���������� � ���� �������� 
    ActionListener Dowl = new DowFile();//������� ���������
    dowfile.addActionListener(Dowl);// ���������� ��������� � ������
    editMenu.add(dowfile);// ���������� � ������� ����

    JMenuItem menu2 = new JMenuItem("�����");// ���������� � ���� �������� 
    ActionListener actionListener_1 = new ListenerButton();//������� ���������
    menu2.addActionListener(actionListener_1);//���������� ��������� � ������
    editMenu.add(menu2);// ���������� � ������� ����
    
    num_1 = new JTextField(10);// ��������� ���� 
    num_1.setText("����� ����.");// ������������� ����� (default)
    num_1.setToolTipText("a");// ��������� ��������� 
    num_1.setBounds(20,180,120,30);// �������� �������������� � ������
    main_panel.add(num_1);// ���������� � ������
    
    num_1.addKeyListener(new KeyAdapter() {//��������� ��������� ������� �����������
    	public void keyTyped(KeyEvent e) {//��������� ����� ������� ���������� ������ ��� ��� ������� �� ����������
    		char c=e.getKeyChar();// ��������� �������� ������
    			if( ((c<'0')||(c>'9'))&&(c!='.')&&(c != KeyEvent.VK_BACK_SPACE)) {// ������������� ����������� �����
    				e.consume();//��������� ����������� �������
    			
    			}
    	}
    });

    // ������� ������� ������� ����� � ������ ��� ����� �� ��
    num_1.addFocusListener(new FocusListener () {// ���������� ��������� ����� ����������
    	@Override 
    	public void focusGained (FocusEvent e) {
    	num_1.setText(null);	// ����������� ������� �������� ������ 
    	}

		@Override
		public void focusLost(FocusEvent e) {// �������� ����� ��� ������ ������ 
			
			
		}
    });
    
    num_2 = new JTextField(10);// ��������� ���� 
    num_2.setText("������ ����.");// ������������� ����� (default)
    num_2.setToolTipText("b");// ��������� ��������� 
    num_2.setBounds(20,230,120,30);// �������� �������������� � ������
    main_panel.add(num_2);// ���������� � ������
    
    num_2.addKeyListener(new KeyAdapter() {//��������� ��������� ������� �����������
    	public void keyTyped(KeyEvent e) {//��������� ����� ������� ���������� ������ ��� ��� ������� �� ����������
    		char c=e.getKeyChar();// ��������� �������� ������
    			if( ((c<'0')||(c>'9'))&&(c!='.')&&(c != KeyEvent.VK_BACK_SPACE)) {// ������������� ����������� �����
    				e.consume();//��������� ����������� �������
    			
    			}
    	}
    });

 // ������� ������� ������� ����� � ������ ��� ����� �� ��
    num_2.addFocusListener(new FocusListener () {// ���������� ��������� ����� ����������
    	@Override 
    	public void focusGained (FocusEvent e) {
    	num_2.setText(null);	// ����������� ������� �������� ������ 
    	}

		@Override
		public void focusLost(FocusEvent e) {//�������� ����� ��� ������ ������ 
			
			
		}
    });
    
    
    otvet = new JTextField(10);// ��������� ���� 
    otvet.setEditable(false);// ��������� ����������� ��������������
    otvet.setText("");// ������������� ����� (default)
    otvet.setToolTipText("�����");// ��������� ��������� 
    otvet.setBounds(250,180,120,30);// �������� �������������� � ������
    main_panel.add(otvet);// ���������� � ������
    
	class raschet implements ActionListener {
		public void actionPerformed(ActionEvent z) {
			double side2,a,b;			
			a = Double.parseDouble(num_1.getText());
			b = Double.parseDouble(num_2.getText());	  
			side2 = (a + b)*2;
			String ot = Double.toString(side2);
			otvet.setText(ot); 
			}
		}
	
	JButton perimetr = new JButton("������");
	perimetr.setBounds(250,230,120,30);
	ActionListener ok = new raschet();
	perimetr.addActionListener(ok);	
	main_panel.add(perimetr);	
    
    
    
    label = new JLabel();//����������� �����������
    label.setBounds(215,10,160,80); // �������� �������������� � ������
 // ����� ����������� ��� BufferedImage
    BufferedImage img = null;// ������������ ��� img ������� ��������
    try {
        img = ImageIO.read(new URL("http://xn--e1afhkfagivn.xn--p1ai/media/foto/logo.jpg"));// ���������� ��� img �����������
    }catch (IOException e){
        e.printStackTrace();
    }
    java.awt.Image dimg =img.getScaledInstance(label.getWidth(),label.getHeight(), java.awt.Image.SCALE_SMOOTH);// ����������� �������� ��� ������� label
    ImageIcon imageIcon=new ImageIcon(dimg);// �������� imageIcon
    label.setIcon(imageIcon);//���������� ��������
    main_panel.add(label);// ���������� label � ������ 
    label.setVisible(false); // ������� label
    
    JComboBox comboBox = new JComboBox(); // �������� ������
    comboBox.setBounds(40,142,310,25); // ������ � �������������� ������
    comboBox.addItem("����������� ������� ����� � ������� ������ ����"); // 1-�� ������ ������
    comboBox.addItem("����������� ������� ����� � ��������"); // 2-��
    comboBox.addItem("����������� ������� ����� � ����� ������� ����"); // 3-��
    comboBox.addItem("������������� ������ � �������15"); // 4-��
   
	class box implements ActionListener { 

		@Override // �������� �����, ������� ��������� � �������� ������ ������ ������� ���������� ������ ������������� ������
		public void actionPerformed(ActionEvent e)
		{
		    if (e.getSource() == comboBox) { //��������� ������ �� ������
		    	if (comboBox.getSelectedItem()=="����������� ������� ����� � ������� ������ ����") { // �������� ������
		    
					main_panel.add(label);  // ���������� label �� ������ 
					label.setBounds(225,10,160,80); // ������ � ������������� ��������
					label.setIcon(imageIcon); //���������� ��������
		    	}
		    	if (comboBox.getSelectedItem()=="����������� ������� ����� � ��������") {
		    		
					main_panel.add(label);   
					label.setBounds(112,10,160,80); 
					label.setIcon(imageIcon); 
			    	}
		    	if (comboBox.getSelectedItem()=="����������� ������� ����� � ����� ������� ����") {
		    		
					main_panel.add(label); 
					label.setBounds(8,10,160,80);
					label.setIcon(imageIcon);
			    	}
		   }
		}
	}
        
	class Listener implements ActionListener {

		//@Override // �������� �����, ������� ��������� � �������� ������ ������ ������� ���������� ������ ������������� ������
		public void actionPerformed(ActionEvent arg0) {

		vivod=JOptionPane.showInputDialog(subversion.this, "C:\\11.txt");

		}

		}
	ActionListener fiel = new Listener(); 
	dowfile.addActionListener(fiel); 
	
	ActionListener ccom = new box(); 	
	comboBox.addActionListener(ccom); 
    main_panel.add(comboBox); // ���������� ������ �� ������
    
	main_GUI.setVisible(true);
	
	main_GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �������� ���� JFrame � �������� Java
	}
	
	public class lop implements ActionListener {

        @Override 
        public void actionPerformed(ActionEvent arg0) {
  		

            label.setVisible(true);// ������ label ������� ��� ������� �� �������� ���� "���������� ������� �����"
        }
    }
	
	public class DowFile implements ActionListener {

        @Override 
        public void actionPerformed(ActionEvent arg0) {
  		

           
        }
    }
	
	
	public static void main(String[] args) { // ���������� �������: http://www.mstu.edu.ru/study/materials/java/
		student= new subversion();
		
	}

}
