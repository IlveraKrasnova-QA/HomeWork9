package ru.krasnova;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ReadingFilesTest {
    private ClassLoader cl = ReadingFilesTest.class.getClassLoader();

    @Test
    void csvFileParsingTest() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(cl.getResourceAsStream("testFiles.zip"))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().contains("сотрудники.csv")) {
                    CSVReader csvReader = new CSVReader(new InputStreamReader(zis));
                    List<String[]> data = csvReader.readAll();
                    Assertions.assertEquals(6, data.size());
                    Assertions.assertArrayEquals(
                            new String[]{"1", "C234", "Катерина Глухова", "gluhkat@compfny.ru"},
                            data.get(2)
                    );
                    break;
                }
            }
        }
    }

    @Test
    void pdfFileParsingTest() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(cl.getResourceAsStream("testFiles.zip"))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().contains("рецепт.pdf")) {
                    try (InputStream pdfStream = zis) {
                        PDF pdf = new PDF(pdfStream);
                        Assertions.assertEquals("Zamzar", pdf.creator);
                    }
                    break;
                }
            }
        }
    }

    @Test
    void xlsxFileParsingTest() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(cl.getResourceAsStream("testFiles.zip"))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().contains("история заказов.xlsx")) {
                    try (InputStream xlsStream = zis) {
                        XLS xls = new XLS(xlsStream);
                        String actualValue = xls.excel.getSheetAt(0).getRow(3).getCell(0).getStringCellValue();
                        Assertions.assertTrue(actualValue.contains("Первый заказ"));
                    }
                    break;
                }
            }
        }
    }
}


