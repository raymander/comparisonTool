package org.vaadin.spring.comparisonTool;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.vaadin.spring.comparisonTool.domain.DateData;

import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CSVFileReader {

    public static ArrayList<DateData> dataList = new ArrayList<DateData>();

    // Java code to illustrate reading a
    // all data at once
    public static ArrayList <DateData> readData(String file)
    {
        try {
            // Create an object of file reader
            // class with CSV file as a parameter.
            FileReader filereader = new FileReader(file);

            // create csvReader object and skip first Line
            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(1)
                    .build();
            List<String[]> allData = csvReader.readAll();

            // print Data
            for (String[] row : allData) {
                String[] dataElements = new String[5];
                int i = 0;
                for (String cell : row) {
                    dataElements[i] = cell;
                    i++;
                }
                DateData datedata = new DateData(
                        toDate(dataElements[0]),
                        Double.valueOf(dataElements[1]),
                        Double.valueOf(dataElements[2]),
                        Double.valueOf(dataElements[3]),
                        Double.valueOf(dataElements[4])
                );

                dataList.add(datedata);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return dataList;
    }

    public static Date toDate(String date) throws ParseException {

        Date dateParsed=new SimpleDateFormat("yyyy-MM-dd").parse(date);
        return dateParsed;
    }

}
