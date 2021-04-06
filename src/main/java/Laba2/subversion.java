	package Laba2; //пакет Java классов

import java.awt.event.ActionListener; //библиотека для события слушателя
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*; // Библиотека для GUI (построена на основе awt)
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
	main_GUI = new JFrame("subversion");	// создание графического окна
	main_GUI.setTitle ("Using subversion for developers");
	main_GUI.setBounds(500,400,400,400);
	main_GUI.setResizable(false); // фиксированный размер окна
	
	

	
	main_panel = new JPanel(); // Панель - используется для организации компонентов в окне
	main_panel.setLayout(null);
	main_GUI.add(main_panel);
	
	JLabel laba_info = new JLabel("Лабораторная работа №2"); // Отображение текста или изображения
	laba_info.setBounds(120,100,150,30);
	main_panel.add(laba_info);
	
	JButton button_exit = new JButton("Выход"); // добавляем кнопку
	button_exit.setBounds(270,280,100,40);
	ActionListener actionListener = new ListenerButton(); //создаем слушатель
	button_exit.addActionListener(actionListener); // добавляем слушатель к кнопке
	main_panel.add(button_exit);
	
	JButton button_info = new JButton("Информация"); // добавляем кнопку
	button_info.setBounds(20,280,130,40);
	ActionListener infoListener = new ListenerButtonInfo(); //создаем слушатель
	button_info.addActionListener(infoListener); // добавляем слушатель к кнопке
	main_panel.add(button_info);
	
	
	JMenuBar menuBar = new JMenuBar();// Создаю строку главного меню
    main_GUI.setJMenuBar(menuBar);// Подключаю меню к интерфейсу
    JMenu editMenu = new JMenu ("Главная");// Создаю выпадающие меню
    menuBar.add(editMenu);// Добавление меню в меню бар

    JMenuItem menu1 = new JMenuItem("Отобразить логотип УГАТУ");// Добавление в меню действие 
    ActionListener Log = new lop();//создаем слушатель
    menu1.addActionListener(Log);// добавление слушателя к кнопке
    editMenu.add(menu1);// добавление в главное меню
    
    JMenuItem dowfile = new JMenuItem("Загрузить файл в проект15");// Добавление в меню действие 
    ActionListener Dowl = new DowFile();//создаем слушатель
    dowfile.addActionListener(Dowl);// добавление слушателя к кнопке
    editMenu.add(dowfile);// добавление в главное меню

    JMenuItem menu2 = new JMenuItem("Выход");// Добавление в меню действие 
    ActionListener actionListener_1 = new ListenerButton();//создаем слушатель
    menu2.addActionListener(actionListener_1);//добавление слушателя к кнопке
    editMenu.add(menu2);// Добавление в главное меню
    
    num_1 = new JTextField(10);// Добавляем поле 
    num_1.setText("Длина прям.");// Устанавливаем текст (default)
    num_1.setToolTipText("a");// Добавляем подсказку 
    num_1.setBounds(20,180,120,30);// Указываю местоположение и размер
    main_panel.add(num_1);// Добавление в панель
    
    num_1.addKeyListener(new KeyAdapter() {//Добавляем обработку событии клавиватуры
    	public void keyTyped(KeyEvent e) {//Добавляем метод который вызывается каждый раз при нажатии на клавиатуру
    		char c=e.getKeyChar();// Взвращаем введённый символ
    			if( ((c<'0')||(c>'9'))&&(c!='.')&&(c != KeyEvent.VK_BACK_SPACE)) {// Устанавливаем ограничения ввода
    				e.consume();//Добавляем потребитель события
    			
    			}
    	}
    });

    // Команда которая удаляет текст с панели при клике на неё
    num_1.addFocusListener(new FocusListener () {// Добавление слушателя фокус компонента
    	@Override 
    	public void focusGained (FocusEvent e) {
    	num_1.setText(null);	// Прописываем команду удаления текста 
    	}

		@Override
		public void focusLost(FocusEvent e) {// Вызывает текст при потере фокуса 
			
			
		}
    });
    
    num_2 = new JTextField(10);// Добавляем поле 
    num_2.setText("Ширина прям.");// Устанавливаем текст (default)
    num_2.setToolTipText("b");// Добавляем подсказку 
    num_2.setBounds(20,230,120,30);// Указываю местоположение и размер
    main_panel.add(num_2);// Добавление в панель
    
    num_2.addKeyListener(new KeyAdapter() {//Добавляем обработку событии клавиватуры
    	public void keyTyped(KeyEvent e) {//Добавляем метод который вызывается каждый раз при нажатии на клавиатуру
    		char c=e.getKeyChar();// Взвращаем введённый символ
    			if( ((c<'0')||(c>'9'))&&(c!='.')&&(c != KeyEvent.VK_BACK_SPACE)) {// Устанавливаем ограничения ввода
    				e.consume();//Добавляем потребитель события
    			
    			}
    	}
    });

 // Команда которая удаляет текст с панели при клике на неё
    num_2.addFocusListener(new FocusListener () {// Добавление слушателя фокус компонента
    	@Override 
    	public void focusGained (FocusEvent e) {
    	num_2.setText(null);	// Прописываем команду удаления текста 
    	}

		@Override
		public void focusLost(FocusEvent e) {//Вызывает текст при потере фокуса 
			
			
		}
    });
    
    
    otvet = new JTextField(10);// Добавляем поле 
    otvet.setEditable(false);// Выключаем возможность редактирования
    otvet.setText("");// Устанавливаем текст (default)
    otvet.setToolTipText("Ответ");// Добавляем подсказку 
    otvet.setBounds(250,180,120,30);// Указываю местоположение и размер
    main_panel.add(otvet);// Добавление в панель
    
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
	
	JButton perimetr = new JButton("Расчет");
	perimetr.setBounds(250,230,120,30);
	ActionListener ok = new raschet();
	perimetr.addActionListener(ok);	
	main_panel.add(perimetr);	
    
    
    
    label = new JLabel();//Отображение изображения
    label.setBounds(215,10,160,80); // Указываю местоположение и размер
 // Читаю изображение как BufferedImage
    BufferedImage img = null;// Устанавливаю для img нулевое значение
    try {
        img = ImageIO.read(new URL("http://xn--e1afhkfagivn.xn--p1ai/media/foto/logo.jpg"));// Присваиваю для img изображение
    }catch (IOException e){
        e.printStackTrace();
    }
    java.awt.Image dimg =img.getScaledInstance(label.getWidth(),label.getHeight(), java.awt.Image.SCALE_SMOOTH);// Изображение подгоняю под размеру label
    ImageIcon imageIcon=new ImageIcon(dimg);// Создание imageIcon
    label.setIcon(imageIcon);//Добавление логотипа
    main_panel.add(label);// Добавление label в панель 
    label.setVisible(false); // Скрываю label
    
    JComboBox comboBox = new JComboBox(); // создание списка
    comboBox.setBounds(40,142,310,25); // размер и местоположение списка
    comboBox.addItem("Переместить логотип УГАТУ в верхний правый угол"); // 1-ая строка списка
    comboBox.addItem("Переместить логотип УГАТУ в середину"); // 2-ая
    comboBox.addItem("Переместить логотип УГАТУ в левый верхний угол"); // 3-ая
    comboBox.addItem("Отсортировать данные в проекте15"); // 4-ая
   
	class box implements ActionListener { 

		@Override // ключевое слово, которое позволяет в дочернем классе заново создать реализацию метода родительского класса
		public void actionPerformed(ActionEvent e)
		{
		    if (e.getSource() == comboBox) { //получение ссылки на объект
		    	if (comboBox.getSelectedItem()=="Переместить логотип УГАТУ в верхний правый угол") { // проверка выбора
		    
					main_panel.add(label);  // добавление label на панель 
					label.setBounds(225,10,160,80); // размер и местополжение логотипа
					label.setIcon(imageIcon); //добавление логотипа
		    	}
		    	if (comboBox.getSelectedItem()=="Переместить логотип УГАТУ в середину") {
		    		
					main_panel.add(label);   
					label.setBounds(112,10,160,80); 
					label.setIcon(imageIcon); 
			    	}
		    	if (comboBox.getSelectedItem()=="Переместить логотип УГАТУ в левый верхний угол") {
		    		
					main_panel.add(label); 
					label.setBounds(8,10,160,80);
					label.setIcon(imageIcon);
			    	}
		   }
		}
	}
        
	class Listener implements ActionListener {

		//@Override // ключевое слово, которое позволяет в дочернем классе заново создать реализацию метода родительского класса
		public void actionPerformed(ActionEvent arg0) {

		vivod=JOptionPane.showInputDialog(subversion.this, "C:\\11.txt");

		}

		}
	ActionListener fiel = new Listener(); 
	dowfile.addActionListener(fiel); 
	
	ActionListener ccom = new box(); 	
	comboBox.addActionListener(ccom); 
    main_panel.add(comboBox); // добавление списка на панель
    
	main_GUI.setVisible(true);
	
	main_GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // закрытие окна JFrame и процесса Java
	}
	
	public class lop implements ActionListener {

        @Override 
        public void actionPerformed(ActionEvent arg0) {
  		

            label.setVisible(true);// Делает label видимым при нажатии на действие меню "Отобразить логотип УГАТУ"
        }
    }
	
	public class DowFile implements ActionListener {

        @Override 
        public void actionPerformed(ActionEvent arg0) {
  		

           
        }
    }
	
	
	public static void main(String[] args) { // интересные заметки: http://www.mstu.edu.ru/study/materials/java/
		student= new subversion();
		
	}

}
