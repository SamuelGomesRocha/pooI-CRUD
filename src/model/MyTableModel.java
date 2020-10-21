package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	
	private ArrayList<Student> list;
	private String[] header = {"Nome", "Matrícula", "Sexo", "Endereço"};
	
	
	public MyTableModel(ArrayList<Student> l) {
		this.list = l;
	}
	
	
	
	
	//Conta a quantidade de linhas
	@Override
	public int getRowCount() {
		return list.size();
	}
	
	//Conta a quantidade de colunas 
	@Override
	public int getColumnCount() {
		return header.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
	
		Student student = list.get(rowIndex);
		
		switch(columnIndex) {
			case 0:
				return student.getNome();
			case 1:
				return student.getMatricula();
			case 2:
				return student.getSexo();
			case 3: 
				return student.getEndereco();
			default:
				return null;
				
				
		}
	}
	
	@Override
	public String getColumnName(int column) {
		return header[column];
		
	}
	
	public void removeRow(int index) {
		this.list.remove(index);
		this.fireTableRowsDeleted(index, index);
	}
	

}
