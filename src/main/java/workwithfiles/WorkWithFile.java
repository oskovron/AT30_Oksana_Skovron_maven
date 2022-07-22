package workwithfiles;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkWithFile {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = null;

        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("Oksana, Anton, Natalia, Marcin"));

//        Path path = Paths.get(System.getProperty("user.home"), "gitStudy", "AT30_Oksana_Skovron_maven", "src",
//                "main", "resources");
        String workingDir = System.getProperty("user.dir");
        Path path = Paths.get(workingDir, "src", "main", "resources");
        try {
            fos = new FileOutputStream(path + "\\fos.csv");
            for (String a : list) {
                fos.write(a.getBytes());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                fos.close();
            }
        }

        writeFromCSWtoXXLS(path + "\\fos.csv", path + "\\outFile.xlsx");

        Files.deleteIfExists(Paths.get(path + "\\fos.csv"));
        Files.deleteIfExists(Paths.get(path + "\\outFile.xlsx"));

    }

    public static void writeFromCSWtoXXLS(String pathIn, String pathOut) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(pathIn));
        String s = reader.readLine();
        String[] split = s.split(",");

        Workbook workbook = new XSSFWorkbook();
        Sheet page = workbook.createSheet("page");
        int rowIndex = 0;
        while (rowIndex < split.length) {
            Row row = page.createRow(rowIndex);
            Cell cell = row.createCell(0);
            cell.setCellValue(split[rowIndex]);
            rowIndex++;
        }
        FileOutputStream fos = new FileOutputStream(pathOut);
        workbook.write(fos);
        reader.close();
        fos.close();
    }

}
