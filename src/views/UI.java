package views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;



import model.MyTableModel;
import model.Student;

public class UI extends JFrame {

	ArrayList<Student> student = new ArrayList<Student>();
	private JTable table;
	private MyTableModel myTableModel;
	private JScrollPane scroll;
	
	
	private JTextField inputNome;
	private JTextField inputMatricula;
	private JTextField inputSexo;
	private JTextField inputEndereco;
	
	private JLabel labelNome;
	private JLabel labelMatricula;
	private JLabel labelSexo;
	private JLabel labelEndereco;
	
	private JButton buttonSalvar;
	private JButton buttonDeletar;
	private JButton buttonInserir;
	private JButton buttonView;
	
	

	public UI(){
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLayout(null);
	this.setBounds(10, 10, 500, 500);
	this.getContentPane().setBackground(Color.LIGHT_GRAY);
	
		inputNome = new JTextField();
		inputNome.setBounds(100, 50, 230, 30);
		
		labelNome = new JLabel("Nome:");
		labelNome.setBounds(30, 50, 50, 30);
	
		inputSexo = new JTextField();		
		inputSexo.setBounds(370, 50, 30, 30);
	
		labelSexo = new JLabel("Sexo:");
		labelSexo.setBounds(335, 50, 40, 30);
		
		inputMatricula = new JTextField();
		inputMatricula.setBounds(100, 90, 300, 30);
		
		labelMatricula = new JLabel("Matrícula:");
		labelMatricula.setBounds(30, 90, 60, 30);		
		
		inputEndereco = new JTextField();
		inputEndereco.setBounds(100, 130, 300, 30);
		
		labelEndereco = new JLabel("Endereço:");
		labelEndereco.setBounds(30, 130, 60, 30);
		
		
		buttonInserir = new JButton("Inserir");
		buttonInserir.addActionListener(listenerOfInserir());
		buttonInserir.setBounds(320, 170, 80, 30);
		
		buttonSalvar = new JButton("Salvar");
		buttonSalvar.addActionListener(listenerOfSalvar());
		buttonSalvar.setBounds(100, 405, 80, 30);
		
		buttonDeletar = new JButton("Deletar");
		buttonDeletar.addActionListener(listenerOfDeletar());
		buttonDeletar.setBounds(320, 405, 80, 30);
		
		buttonView = new JButton("View");
		buttonView.addActionListener(listenerOfView());
		buttonView.setBounds(210, 405, 80, 30);
		
		myTableModel = new MyTableModel(student);
		table = new JTable(myTableModel);
		scroll = new JScrollPane(table);	
		
	
		
		scroll.setBounds(100, 220, 300, 180);
		
		
		this.add(inputNome);
		this.add(labelNome);
		this.add(inputSexo);
		this.add(labelSexo);
		this.add(inputMatricula);
		this.add(labelMatricula);
		this.add(inputEndereco);
		this.add(labelEndereco);
		this.add(buttonInserir);
		this.add(buttonSalvar);
		this.add(buttonDeletar);
		this.add(buttonView);
		this.add(scroll);
	}
	


	private ActionListener listenerOfView() {
		ActionListener al = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(table.getSelectedRow() != -1) {
				JOptionPane.showMessageDialog(UI.this, student.get(table.getSelectedRow()).toString(), "Tupla selecionada", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(UI.this, "Selecione uma tupla da tabela", "Tupla não selecionada!!", JOptionPane.WARNING_MESSAGE);
				}
			}
		};
		
		return al;
	}


	public ActionListener visualizar() {
		ActionListener al = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				 table.addMouseListener(new MouseAdapter(){
				      public void mouseClicked(MouseEvent e){
				        if(e.getClickCount() == 2){
				       JOptionPane.showMessageDialog(UI.this, student.toString(), "Tupla", JOptionPane.INFORMATION_MESSAGE);
				        }
				      }
			 }); 
			}
		};
		
		return al;
	}


	//botão deletar 
	private ActionListener listenerOfDeletar() {
		
		ActionListener myListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(table.getSelectedRow() != -1) {
					myTableModel.removeRow(table.getSelectedRow());
				}else {
					JOptionPane.showMessageDialog(UI.this, "Selecione uma tupla da tabela", "Tupla não selecionada!!", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		};
		
		return myListener;
	}

	//botão salvar
	private ActionListener listenerOfSalvar() {
		
		ActionListener myListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					String outputName = JOptionPane.showInputDialog(UI.this, "Insira o nome do arquivo a ser criado (.txt)");
					FileWriter fw = new FileWriter(outputName, true);
					fw.append(System.lineSeparator()+"Instanciação"+System.lineSeparator());
					for(Student s : student) {
						fw.append(s.toString());
					}
					
					JOptionPane.showMessageDialog(UI.this, "Arquivo criado com sucesso!", "Parabéns!!", JOptionPane.INFORMATION_MESSAGE);
				fw.close();	
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		};
		
		
		return myListener;
	}


	//Botão inserir
	private ActionListener listenerOfInserir() {
		ActionListener myListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(inputNome.getText().trim().equals("") || inputMatricula.getText().trim().equals("") || inputSexo.getText().trim().equals("") || inputEndereco.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(UI.this, "Todos os campos são obrigatórios!!", "CAMPOS OBRIGATÓRIOS", JOptionPane.WARNING_MESSAGE);
				}else {
					student.add(new Student(Long.parseLong(inputMatricula.getText().trim()), inputNome.getText().trim(), inputSexo.getText().charAt(0), inputEndereco.getText().trim()));
					myTableModel.fireTableDataChanged();
					
					clearTextFields();
				}
				
			}
		};
		
		
		return myListener;
	}
	
	
	//Método que limpa os campos de texto;
	public void clearTextFields() {
		inputNome.setText("");
		inputMatricula.setText("");
		inputSexo.setText("");
		inputEndereco.setText("");
	}
}

	


