package com.Aplication_Jeu;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class ColorTableModel extends AbstractTableModel {
    private int page = 0;
    public List<noteCell> list = new LinkedList<noteCell>();

    private Object rowData[][] = {
            {Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE,Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE,Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE,Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE},
            {Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE,Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE,Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE,Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE},
            {Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE,Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE,Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE,Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE},
            {Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE,Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE,Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE,Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE},
    };

    private String columnNames[] = { "1", "2", "3", "4","5","6","7","8","9","10","11","12","13","14","15","16"};

    public ColorTableModel() {
        this(0);
    }


    public ColorTableModel(int page) {
        setPage(page);
    }

    public void nextPage() {
    	
        if(list.size()<page+1){
    	list.add(getAllValuesCell());
    	//System.out.println(list.get(page));
	    }
		else{
			if(compareNoteCell(list.get(page),getAllValuesCell())==false){//compare la valeur de la liste avec la valeur qui vient d'etre enregistrée
				list.set(page,getAllValuesCell());
				System.out.println(list.get(page));
			}
		}
        
        setPage(page+1);
        if(list.size()>=page+1){//si la taille de la liste est supérieure ou égale
        	noteCell cell=list.get(page);
        	for(int row=0; row < getRowCount(); row++) {
                for(int col=0; col < getColumnCount(); col++) {
                	setValueAt(cell.putNoteCellTable(cell, row, col), row , col);
                }
            }
    	}
        else{
        	for(int row=0; row < getRowCount(); row++) {
                for(int col=0; col < getColumnCount(); col++) {
                    setValueAt(Boolean.FALSE, row, col);
                }
            }
        }
    }




	public void previousPage() {
		System.out.println(page);
		if(list.size()<page+1){
	    	list.add(getAllValuesCell());
	    	System.out.println(list.get(page));
		    }
			else{
				if(compareNoteCell(list.get(page),getAllValuesCell())==false){//compare la valeur de la liste avec la valeur qui vient d'etre enregistrée
					list.set(page,getAllValuesCell());
					System.out.println(list.get(page));
				}
			}
        if(page <= 0)
            setPage(0);
        else{
        	setPage(page-1);
        }
        
        if(list.size()>=page+1){//si la taille de la liste est supérieure ou égale
        	noteCell cell=list.get(page);
        	int i=0;
        	for(int row=0; row < getRowCount(); row++) {
                for(int col=0; col < getColumnCount(); col++) {
                	//System.out.println(i++);
                	setValueAt(cell.putNoteCellTable(cell, row, col), row , col);
                }
            }
    	}
        else{
        	for(int row=0; row < getRowCount(); row++) {
                for(int col=0; col < getColumnCount(); col++) {
                    setValueAt(Boolean.FALSE, row, col);
                }
            }
        }
    	if(list.size()==0){
    		JOptionPane.showMessageDialog(null, "Vous êtes sur la première mesure, il n'y a donc pas de mesure avant", "Error", JOptionPane.ERROR_MESSAGE);
    	}
    	else{
	    	/*if(compareNoteCell(list.get(page-1),getAllValuesCell())==false){//compare la valeur de la liste avec la valeur qui vient d'etre enregistrée
				list.set(page-1,getAllValuesCell());
			}*/
    	}
    }
    
    public void setPage(int page) {
        this.page = page;
        for(int i=0; i < columnNames.length; i++) {
            int pageCount = page*columnNames.length+i+1;
            this.columnNames[i] = ""+pageCount;
        }
        
        fireTableStructureChanged();
    }

    public void reset() {
        for(int row=0; row < getRowCount(); row++) {
            for(int col=0; col < getColumnCount(); col++) {
                setValueAt(Boolean.FALSE, row, col);
            }
        }
        setPage(0);
    }
    
    public int getColumnCount() {
        return columnNames.length;
    }

    public String getColumnName(int column) {
        return columnNames[column];
    }

    public int getRowCount() {
        return rowData.length;
    }
    public noteCell getAllValuesCell(){
    	String a="";
    	
    	for(int row=0; row < getRowCount(); row++) {
            for(int col=0; col < getColumnCount(); col++) {
    				a+=transformValues(getValueAt(row,col)+"")+";";
    			}
    			a+="\r\n";
    		}
    		noteCell cell= new noteCell(a);
    		System.out.println(a);
		return cell;
    	
    }
    /*public String getAllcolumnValues(int column){
    	String a="";
			a+=getColumnName(column)+" ";
			for(int i=0;i<4;i++){
				a+=transformValues(getValueAt(i,column)+"")+";";
			}
			a+="\r\n";
	
	return a;
    }*/

    public Object getValueAt(int row, int column) {
        return rowData[row][column];
    }
    /*public noteCell getAllValues(){
		String a="";
		for(int i=0;i<4;i++){
			for(int j=0;j<16;j++){
			}
		}
		noteCell cell= new noteCell(a);
		System.out.println(a);
    	return cell;
    	
    }*/
    public String transformValues(String s){
    	if(s.compareTo("true")==0){
    		s="1";
    	}
    	else if(s.compareTo("false")==0){
    		s="0";
    	}
    		
		return s;
    	
    }

    public Class getColumnClass(int column) {
        return (getValueAt(0, column).getClass());
    }

    public void setValueAt(Object value, int row, int column) {
        rowData[row][column] = value;
    }

    public boolean isCellEditable(int row, int column) {
        return true;
    }
    
    public boolean compareNoteCell(noteCell note1, noteCell note2){

    	if(note1.toString().compareTo(note2.toString())==0){
    		return true;
    	}
    	else{
    		return false;
    	}
    	
    }
    
    public String noteCellWriting(){
    	String a="";
    	String[] b = new String[4];
    	
    	for(noteCell n: list){
    		a+=n.toString(true);
    	}
    		
    	System.out.println(a);
    	
    	return a;
    }
}




