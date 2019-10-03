package relatorio;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import monitor.Monitor;
import monitor.MonitorDAO;
import ponto.Ponto;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Everton
 */
public class Relatorio {
    
    public static void gerarRelatorio(List<Ponto> listaPontos){
        Monitor monitor = listaPontos.get(0).getMonitor();
        
        
        String f1 = "teste";
        Document document = new Document(PageSize.A4, 20, 20, 20, 20);
        Font regular = new Font(FontFamily.HELVETICA, 12);
        Font bold = new Font(FontFamily.HELVETICA, 12, Font.BOLD);
        try {
            PdfWriter.getInstance(document, new FileOutputStream("D:\\Relatorio.pdf"));
            document.open();

            Image jpg = Image.getInstance("src/imagens/relatorio.jpg");
            jpg.setAlignment(1);
            document.add(jpg);

            Paragraph cab = new Paragraph("Relatório de Monitoria | FVS & COPEX");
            cab.setAlignment(1);
            document.add(cab);

            document.add(new Paragraph(" "));

            Paragraph nome = new Paragraph("Monitor.:    " + monitor.getAluno().getNome(), bold);
            document.add(nome);
            nome = new Paragraph("Curso.:       " + monitor.getCurso(), bold);
            document.add(nome);
            nome = new Paragraph("Disciplina.: " + monitor.getDisciplina(), bold);
            document.add(nome);
            nome = new Paragraph("Email.:       " + monitor.getAluno().getEmail(), bold);
            document.add(nome);

            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));

            PdfPTable table = new PdfPTable(4);
            PdfPCell col1 = new PdfPCell(new Paragraph("DATA DO PONTO"));
            col1.setHorizontalAlignment(Element.ALIGN_CENTER);
            col1.setBackgroundColor(new BaseColor(180, 180, 180));

            PdfPCell col2 = new PdfPCell(new Paragraph("HORA DE ENTRADA"));
            col2.setHorizontalAlignment(Element.ALIGN_CENTER);
            col2.setBackgroundColor(new BaseColor(180, 180, 180));

            PdfPCell col3 = new PdfPCell(new Paragraph("HORA DE SAÍDA"));
            col3.setHorizontalAlignment(Element.ALIGN_CENTER);
            col3.setBackgroundColor(new BaseColor(180, 180, 180));

            PdfPCell col4 = new PdfPCell(new Paragraph("HORAS TRABALHADAS"));
            col4.setHorizontalAlignment(Element.ALIGN_CENTER);
            col4.setBackgroundColor(new BaseColor(180, 180, 180));

            table.addCell(col1);
            table.addCell(col2);
            table.addCell(col3);
            table.addCell(col4);

            table.addCell("teste");
            table.addCell("testttt");
            table.addCell("tgddd");
            table.addCell("horas");
            table.setWidthPercentage(100.0f);

            table.addCell("teste");
            table.addCell("testttt");
            table.addCell("tgddd");
            table.addCell("horas");
            table.setWidthPercentage(100.0f);

            document.add(table);

        }
        catch(DocumentException de) {
            System.err.println(de.getMessage());
        }
        catch(IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        document.close();
        
        JOptionPane.showMessageDialog(null, "Relatório gerado com sucesso!");
    }
}
