package test;

import main.DateData;
import org.junit.jupiter.api.Test;
import main.CSVFileReader;
import main.FilePaths;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CSVFileReaderTest {

    String file_path = FilePaths.TEST_FILE_PATH;
    ArrayList<DateData> dataList = new ArrayList<>();

    @Test
    public void ReaderShouldReturnArrayList() {
        dataList = CSVFileReader.readData(file_path);
        assertEquals(dataList.size(), 3);
        assertEquals(dataList.get(1).getNokiaData(), 2.98);
    }
}
