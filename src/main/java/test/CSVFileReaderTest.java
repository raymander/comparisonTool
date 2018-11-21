package test;

import com.task.DateData;
import org.junit.jupiter.api.Test;
import com.task.CSVFileReader;
import com.task.constants.FilePaths;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CSVFileReaderTest {

    private String file_path = FilePaths.TEST_FILE_PATH;
    private ArrayList<DateData> dataList = new ArrayList<>();

    @Test
    public void ReaderShouldReturnArrayList() {
        dataList = CSVFileReader.readData(file_path);
        assertEquals(dataList.size(), 3);
        assertEquals(dataList.get(1).getNokiaData(), 2.98);
    }
}
