package com.jfeat.pdf.pages;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.FileOutputStream;
import java.io.IOException;

public class PdfPageNum {
    public static void printPageNumber(String pdfFilePath, int startPage, float fontSize, float offsetBottom) throws IOException, DocumentException{
        String pdfFileName = pdfFilePath.substring(0, pdfFilePath.length()-".pdf".length());
        PdfReader reader = new PdfReader(pdfFilePath);
        PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(String.format("%s-new.pdf",pdfFileName)));

        // if page num < 0, means the last one
        int numberOfPages = reader.getNumberOfPages();
        if(startPage<0){
            startPage = numberOfPages + startPage + 1;
        }
        // end

        ///
        for(int p=startPage; p<=numberOfPages; p++) {
            PdfContentByte canvas = stamp.getOverContent(p);

            float pageWidth = canvas.getPdfDocument().getPageSize().getWidth();
            //float pageHeight = canvas.getPdfDocument().getPageSize().getHeight();

            canvas.saveState();
                // begin text
                canvas.beginText();
                    canvas.setFontAndSize(BaseFont.createFont(), fontSize);
                    canvas.showTextAligned(PdfContentByte.ALIGN_CENTER, String.valueOf(p), pageWidth*0.5f, offsetBottom, 0);
                canvas.endText();
                // end text

            canvas.restoreState();
        }


        stamp.close();
        reader.close();
    }
}
