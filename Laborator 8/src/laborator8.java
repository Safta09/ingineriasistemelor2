import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class laborator8 {
    public static void main(String[] args) {
        // Prima parte - citirea fișierului Excel
        readExcelFile("laborator8_input.xlsx");

        // A doua parte - generarea fișierului Excel
        generateExcelFile("output8.xlsx");
    }

    public static void readExcelFile(String fileName) {
        System.out.println("Citirea fișierului Excel: " + fileName);

        XSSFWorkbook workbook = null;
        try {
            FileInputStream file = new FileInputStream(new File(fileName));

            // Creează Workbook care face referință la fișierul .xlsx
            workbook = new XSSFWorkbook(file);

            // Obține primul sheet din workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            // Parcurge fiecare rând unul câte unul
            for (Row row : sheet) {
                // Pentru fiecare rând, parcurge toate coloanele
                for (Cell cell : row) {
                    // Verifică tipul celulei și formatează corespunzător
                    switch (cell.getCellType()) {
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        default:
                            System.out.print("\t");
                    }
                }
                System.out.println();
            }
            file.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (workbook != null) {
                try {
                    workbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println();
    }

    public static void generateExcelFile(String fileName) {
        System.out.println("Generarea fișierului Excel: " + fileName);

        // Creează un nou Workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        // Creează un Sheet nou
        XSSFSheet sheet = workbook.createSheet("Student Data");

        // Creează datele organizate într-un TreeMap
        Map<String, Object[]> data = new TreeMap<>();

        // Adaugă antetul
        data.put("1", new Object[] {"Name", "Surname", "Grade 1", "Grade 2", "Grade 3", "Grade 4", "Max", "Average"});

        // Adaugă datele studenților
        data.put("2", new Object[] {"Amit", "Shukla", 9, 8, 7, 5});
        data.put("3", new Object[] {"Lokesh", "Gupta", 8, 9, 6, 7});
        data.put("4", new Object[] {"John", "Adwards", 8, 8, 7, 6});
        data.put("5", new Object[] {"Brian", "Schultz", 7, 6, 8, 9});

        // Bold și Blue Grey
        XSSFFont headerFont = workbook.createFont();
        headerFont.setFontHeightInPoints((short) 12);
        headerFont.setFontName("Calibri");
        headerFont.setColor(IndexedColors.BLUE.getIndex());
        headerFont.setBold(true);

        //  Font și fundal verde
        XSSFCellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(headerFont);
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);


        // fondal galben- max,average
        XSSFCellStyle yellowStyle = workbook.createCellStyle();
        yellowStyle.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        yellowStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        int rownum = 0;
        for (Map.Entry<String, Object[]> entry : data.entrySet()) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = entry.getValue();
            int cellnum = 0;

            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);


                if (rownum == 1) {// la primul rand font
                    cell.setCellStyle(headerStyle);
                }

              // daca e string sau numar
                if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Integer) {
                    cell.setCellValue((Integer) obj);
                }
            }

            //  pentru max și average
            if (rownum > 1) {
                Cell maxCell = row.createCell(6); // Coloana G
                String maxFormula = "MAX(C" + rownum + ":F" + rownum + ")";
                maxCell.setCellFormula(maxFormula);
                maxCell.setCellStyle(yellowStyle);

                Cell avgCell = row.createCell(7); // Coloana H
                String avgFormula = "AVERAGE(C" + rownum + ":F" + rownum + ")";
                avgCell.setCellFormula(avgFormula);
                avgCell.setCellStyle(yellowStyle);
            }
        }


        for (int i = 0; i < 8; i++) {
            sheet.autoSizeColumn(i);
        }

        try {

            // Scrie in fsier
            FileOutputStream out = new FileOutputStream(fileName);
            workbook.write(out);
            out.close();
            System.out.println("Fișierul Excel a fost generat ");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}