package com.Aplication_Jeu;

public class noteCell {
	
	String page;
	String[][] tab=new String[4][16];
	
	public noteCell(String page){
		this.page=page;
	}
	
	public boolean putNoteCellTable(noteCell cell,int row,int col){
		
		String[] rowCell = cell.toString().trim().split("\n");
		String[] rowCellData1=rowCell[0].toString().trim().split(";");
		String[] rowCellData2=rowCell[1].toString().trim().split(";");
		String[] rowCellData3=rowCell[2].toString().trim().split(";");
		String[] rowCellData4=rowCell[3].toString().trim().split(";");

		
		
		String[][] tab ={ {rowCellData1[0],rowCellData1[1],rowCellData1[2],rowCellData1[3],rowCellData1[4],rowCellData1[5],rowCellData1[6],rowCellData1[7],rowCellData1[8],rowCellData1[9],rowCellData1[10],rowCellData1[11],rowCellData1[12],rowCellData1[13],rowCellData1[14],rowCellData1[15]},
						  {rowCellData2[0],rowCellData2[1],rowCellData2[2],rowCellData2[3],rowCellData2[4],rowCellData2[5],rowCellData2[6],rowCellData2[7],rowCellData2[8],rowCellData2[9],rowCellData2[10],rowCellData2[11],rowCellData2[12],rowCellData2[13],rowCellData2[14],rowCellData2[15]},
						  {rowCellData3[0],rowCellData3[1],rowCellData3[2],rowCellData3[3],rowCellData3[4],rowCellData3[5],rowCellData3[6],rowCellData3[7],rowCellData3[8],rowCellData3[9],rowCellData3[10],rowCellData3[11],rowCellData3[12],rowCellData3[13],rowCellData3[14],rowCellData3[15]},
						  {rowCellData4[0],rowCellData4[1],rowCellData4[2],rowCellData4[3],rowCellData4[4],rowCellData4[5],rowCellData4[6],rowCellData4[7],rowCellData4[8],rowCellData4[9],rowCellData4[10],rowCellData4[11],rowCellData4[12],rowCellData4[13],rowCellData4[14],rowCellData4[15]} 
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
	
	public String toString(boolean bool){
		String[] rowCell = this.page.trim().split("\n");
		String[] rowCellData1=rowCell[0].toString().trim().split(";");
		String[] rowCellData2=rowCell[1].toString().trim().split(";");
		String[] rowCellData3=rowCell[2].toString().trim().split(";");
		String[] rowCellData4=rowCell[3].toString().trim().split(";");

		
		
		String[][] tab ={ {rowCellData1[0],rowCellData1[1],rowCellData1[2],rowCellData1[3],rowCellData1[4],rowCellData1[5],rowCellData1[6],rowCellData1[7],rowCellData1[8],rowCellData1[9],rowCellData1[10],rowCellData1[11],rowCellData1[12],rowCellData1[13],rowCellData1[14],rowCellData1[15]},
						  {rowCellData2[0],rowCellData2[1],rowCellData2[2],rowCellData2[3],rowCellData2[4],rowCellData2[5],rowCellData2[6],rowCellData2[7],rowCellData2[8],rowCellData2[9],rowCellData2[10],rowCellData2[11],rowCellData2[12],rowCellData2[13],rowCellData2[14],rowCellData2[15]},
						  {rowCellData3[0],rowCellData3[1],rowCellData3[2],rowCellData3[3],rowCellData3[4],rowCellData3[5],rowCellData3[6],rowCellData3[7],rowCellData3[8],rowCellData3[9],rowCellData3[10],rowCellData3[11],rowCellData3[12],rowCellData3[13],rowCellData3[14],rowCellData3[15]},
						  {rowCellData4[0],rowCellData4[1],rowCellData4[2],rowCellData4[3],rowCellData4[4],rowCellData4[5],rowCellData4[6],rowCellData4[7],rowCellData4[8],rowCellData4[9],rowCellData4[10],rowCellData4[11],rowCellData4[12],rowCellData4[13],rowCellData4[14],rowCellData4[15]} 
						  };
		this.tab=tab;
		String text;
		if(bool==true){
		
		text=this.tab[0][0]+";"+this.tab[0][1]+";"+this.tab[0][2]+";"+this.tab[0][3]+";"+"\r\n";
		text+=this.tab[0][4]+";"+this.tab[0][5]+";"+this.tab[0][6]+";"+this.tab[0][7]+";"+"\r\n";
		text+=this.tab[0][8]+";"+this.tab[0][9]+";"+this.tab[0][10]+";"+this.tab[0][11]+";"+"\r\n";
		text+=this.tab[0][12]+";"+this.tab[0][13]+";"+this.tab[0][14]+";"+this.tab[0][15]+";"+"\r\n";
		text+=this.tab[1][0]+";"+this.tab[1][1]+";"+this.tab[1][2]+";"+this.tab[1][3]+";"+"\r\n";
		text+=this.tab[1][4]+";"+this.tab[1][5]+";"+this.tab[1][6]+";"+this.tab[1][7]+";"+"\r\n";
		text+=this.tab[1][8]+";"+this.tab[1][9]+";"+this.tab[1][10]+";"+this.tab[1][11]+";"+"\r\n";
		text+=this.tab[1][12]+";"+this.tab[1][13]+";"+this.tab[1][14]+";"+this.tab[1][15]+";"+"\r\n";
		
		text+=this.tab[2][0]+";"+this.tab[2][1]+";"+this.tab[2][2]+";"+this.tab[2][3]+";"+"\r\n";
		text+=this.tab[2][4]+";"+this.tab[2][5]+";"+this.tab[2][6]+";"+this.tab[2][7]+";"+"\r\n";
		text+=this.tab[2][8]+";"+this.tab[2][9]+";"+this.tab[2][10]+";"+this.tab[2][11]+";"+"\r\n";
		text+=this.tab[2][12]+";"+this.tab[2][13]+";"+this.tab[2][14]+";"+this.tab[2][15]+";"+"\r\n";
		text+=this.tab[3][0]+";"+this.tab[3][1]+";"+this.tab[3][2]+";"+this.tab[3][3]+";"+"\r\n";
		text+=this.tab[3][4]+";"+this.tab[3][5]+";"+this.tab[3][6]+";"+this.tab[3][7]+";"+"\r\n";
		text+=this.tab[3][8]+";"+this.tab[3][9]+";"+this.tab[3][10]+";"+this.tab[3][11]+";"+"\r\n";
		text+=this.tab[3][12]+";"+this.tab[3][13]+";"+this.tab[3][14]+";"+this.tab[3][15]+";"+"\r\n";
		}
		else{
			text="erreur";
		}
		return text;
		
	}
}
