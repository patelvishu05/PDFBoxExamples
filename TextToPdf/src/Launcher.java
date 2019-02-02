import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.font.PDType1CFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class Launcher 
{
	public static void main (String args[])
	{

		PDDocument document = null;
		Scanner scanner = null;

		try 
		{
			scanner = new Scanner(new File("./assign4-part2.c"));
			String line="";
			while(scanner.hasNextLine())
				line += scanner.nextLine();
			
			File file = new File("./pdfFiles/sample.pdf");
			document = PDDocument.load(file);
			PDPage page = document.getPage(0);
			
			PDFont font = PDType1Font.TIMES_ROMAN;
			
			PDPageContentStream contentStream = new PDPageContentStream(document,page);
			contentStream.beginText();
			contentStream.setFont(font, 12);
			contentStream.newLineAtOffset(100, 700);			
			contentStream.showText(line.replaceAll("\t", " "));
			contentStream.endText();
			contentStream.close();
			document.save("./pdfFiles/sample.pdf");
			System.out.println("PDF created");  
			document.close();

			scanner.close();
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(document != null)
				document = null;
			if(scanner != null)
				scanner = null;
		}
	} 
}
