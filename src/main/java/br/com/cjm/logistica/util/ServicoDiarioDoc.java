package br.com.cjm.logistica.util;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;




public class ServicoDiarioDoc  {

	private static String UPLOADED_FOLDER = "./";
	//Blank Document
    private XWPFDocument document = new XWPFDocument(); 
	
	public static void main(String[] args)throws Exception  {
		  XWPFDocument doc = new XWPFDocument(); 
	      
		  
	      //Write the Document in file system
	      FileOutputStream out = new FileOutputStream(new File(UPLOADED_FOLDER+"createparagraph.docx"));
	        
	      //create Paragraph
	      XWPFParagraph paragraph = doc.createParagraph();
	      XWPFRun run = paragraph.createRun();
	     // run.addPicture( new FileInputStream(new File("apm.png")), Document.p, Units.toEMU(60), Units.toEMU(60));
	      run.setText("POLÍCIA MILITAR DA BAHIA");
	      
	    //create table
	      XWPFTable table = doc.createTable();
			
	      //create first row
	      XWPFTableRow tableRowOne = table.getRow(0);
	      tableRowOne.getCell(0).setText("col one, row one");
	      tableRowOne.addNewTableCell().setText("col two, row one");
	      tableRowOne.addNewTableCell().setText("col three, row one");
			
	      //create second row
	      XWPFTableRow tableRowTwo = table.createRow();
	      tableRowTwo.getCell(0).setText("col one, row two");
	      tableRowTwo.getCell(1).setText("col two, row two");
	      tableRowTwo.getCell(2).setText("col three, row two");
			
	      //create third row
	      XWPFTableRow tableRowThree = table.createRow();
	      tableRowThree.getCell(0).setText("col one, row three");
	      tableRowThree.getCell(1).setText("col two, row three");
	      tableRowThree.getCell(2).setText("col three, row three");
				
	      doc.write(out);
	      out.close();
	      System.out.println("createparagraph.docx written successfully");
	 }
	
	public XWPFParagraph criarParagrafo() {
		XWPFParagraph paragraph = document.createParagraph();
		
		return paragraph;
	}
	
	public String criarDoc(String nome) throws Exception{
		 	
	      //Write the Document in file system
	      FileOutputStream out = new FileOutputStream( new File(UPLOADED_FOLDER+nome+".docx"));
//	      XWPFParagraph paragraph = document.createParagraph();
	      XWPFParagraph paragraph = criarParagrafo();
	     /* XWPFRun run = paragraph.createRun();
	      run.setText("At tutorialspoint.com, we strive hard to " +
	         "provide quality tutorials for self-learning " +
	         "purpose in the domains of Academics, Information " +
	         "Technology, Management and Computer Programming Languages.");*/
	      document.write(out);
	      out.close();
	      System.out.println(nome+".docx criado com sucesso! ");	
	      
		return nome;
		
	}
}
