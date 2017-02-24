package com.Aplication_Jeu;

public class noteCell {
	
	String page;
	
	public noteCell(String page){
		this.page=page;
	}
	
	public boolean putNoteCellTable(noteCell cell,int row,int col){
		
		String[] rowCell = cell.toString().trim().split("\n");
		String[] rowCellData1=new String[4];
		String[] rowCellData2=new String[4];
		String[] rowCellData3=new String[4];
		String[] rowCellData4=new String[4];
		boolean[] boobool = new boolean[4];
		for(int i =0 ; i<4;i++){
			String j =rowCell[i].trim();
			switch(i){
			case 0:
				rowCellData1=j.split(";");
				break;
			case 1:
				rowCellData2=j.split(";");
				break;
			case 2:
				rowCellData3=j.split(";");
				
				break;
			case 3:
				rowCellData4=j.split(";");
				break;
			}
		}
		/*rowCellData1[0]=rowCellData1[0].charAt(2)+"";
		rowCellData2[0]=rowCellData2[0].charAt(2)+"";
		rowCellData3[0]=rowCellData3[0].charAt(2)+"";
		rowCellData4[0]=rowCellData4[0].charAt(2)+"";*/
		String[][] tab ={ {rowCellData1[0],rowCellData1[1],rowCellData1[2],rowCellData1[3]},
						  {rowCellData2[0],rowCellData2[1],rowCellData2[2],rowCellData2[3]},
						  {rowCellData3[0],rowCellData3[1],rowCellData3[2],rowCellData3[3]},
						  {rowCellData4[0],rowCellData4[1],rowCellData4[2],rowCellData4[3]} 
						  };
		boolean b=false;
		if(tab[row][col].compareTo("0")==0){
			b=false;
			//System.out.println(row+" "+ col +"faux");
		}
		else if(tab[row][col].compareTo("1")==0){
			b=true;
			//System.out.println(row+" "+ col +"vrai");
		}
		return b;
	}
	
	public String toString(){
		return this.page;
	}
}
