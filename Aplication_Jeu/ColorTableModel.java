package com.Aplication_Jeu;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class ColorTableModel extends AbstractTableModel {
    private int page = 0;
    public List<noteCell> list = new LinkedList<noteCell>();

    private Object rowData[][] = {
            {Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE},
            {Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE},
            {Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE},
            {Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE},
    };

    private String columnNames[] = { "1", "2", "3", "4"};

    public ColorTableModel() {
        this(0);
    }


    public ColorTableModel(int page) {
        setPage(page);
    }

    public void nextPage() {
    	
        if(list.size()<page+1){
    	list.add(getAllValuesCell());
    	System.out.println(list.get(page));
	    }
		else{
			if(compareNoteCell(list.get(page),getAllValuesCell())==false){//compare la valeur de la liste avec la valeur qui vient d'etre enregistr�e
				list.set(page,getAllValuesCell());
				System.out.println(list.get(page));
			}
		}
        
        setPage(page+1);
        if(list.size()>=page+1){//si la taille de la liste est sup�rieure ou �gale
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
				if(compareNoteCell(list.get(page),getAllValuesCell())==false){//compare la valeur de la liste avec la valeur qui vient d'etre enregistr�e
					list.set(page,getAllValuesCell());
					System.out.println(list.get(page));
				}
			}
        if(page <= 0)
            setPage(0);
        else{
        	setPage(page-1);
        }
        
        if(list.size()>=page+1){//si la taille de la liste est sup�rieure ou �gale
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
    		JOptionPane.showMessageDialog(null, "Vous �tes sur la premi�re mesure, il n'y a donc pas de mesure avant", "Error", JOptionPane.ERROR_MESSAGE);
    	}
    	else{
	    	/*if(compareNoteCell(list.get(page-1),getAllValuesCell())==false){//compare la valeur de la liste avec la valeur qui vient d'etre enregistr�e
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
    public String getAllValues(){//methode fausse
    	String a="";
    		for(int j=0;j<columnNames.length;j++){
    			a+=getColumnName(j)+" ";
    			for(int i=0;i<4;i++){
    				a+=transformValues(getValueAt(i,j)+"")+";";
    			}
    			a+="\r\n";
    		}
    	
		return a;
    	
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
		return cell;
    	
    }
    public String getAllcolumnValues(int column){
    	String a="";
			a+=getColumnName(column)+" ";
			for(int i=0;i<4;i++){
				a+=transformValues(getValueAt(i,column)+"")+";";
			}
			a+="\r\n";
	
	return a;
    }

    public Object getValueAt(int row, int column) {
        return rowData[row][column];
    }
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
    	for(int i=0;i<=list.size()-1;i++){
    		b=list.get(i).toString().trim().split("\n");
    		b[0]=(i*4)+1+" "+b[0];
    		b[1]=(i*4)+2+" "+b[1];
    		b[2]=(i*4)+3+" "+b[2];
    		b[3]=(i*4)+4+" "+b[3];
    		a+=b[0]+"\n"+b[1]+"\n"+b[2]+"\n"+b[3]+"\n";
    	}
    		
    	System.out.println(a);
    	
    	return a;
    }
}




