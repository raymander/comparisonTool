package org.vaadin.spring.comparisonTool.tests;

import org.junit.jupiter.api.Test;
import org.vaadin.spring.comparisonTool.CSVFileReader;
import org.vaadin.spring.comparisonTool.domain.DateData;
import org.vaadin.spring.comparisonTool.file_paths;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileReaderTest {

    String file_path = file_paths.TEST_FILE_PATH;
    ArrayList<DateData> dataList = new ArrayList<>();

    @Test
    public void ReaderShouldReturnArrayList() {
        dataList = CSVFileReader.readData(file_path);
        assertEquals(dataList.size(), 3);
        assertEquals(dataList.get(1).getNokiaData(), 2.98);
    }
}
