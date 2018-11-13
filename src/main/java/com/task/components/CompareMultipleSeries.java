package com.task.components;

import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import com.task.CSVFileReader;
import com.task.DateData;
import com.task.constants.FilePaths;

import java.util.ArrayList;

//Create a UI component
@SpringComponent
@UIScope
public class CompareMultipleSeries {

    private static ArrayList<DateData> dataList = new ArrayList<>();
    private static String file_path = FilePaths.FILE_PATH;

//  Create the chart
    public static Chart init() {
        final Chart chart = new Chart();
        chart.setTimeline(true);

        //Fetch data for dataseries
        if (dataList.isEmpty()) {
            dataList = CSVFileReader.readData(file_path);
        }

//        logging the datalist
//        for (DateData d : dataList) {
//            System.out.println(d);
//        }

        Configuration configuration = chart.getConfiguration();
        configuration.getTitle().setText("Financial performance chart");
        configuration.getTitle().setMargin(50);

        YAxis yAxis = new YAxis();
        Labels label = new Labels();
        label.setFormatter("function() { return (this.value > 0 ? ' + ' : '') + this.value + '%'; }");
        yAxis.setLabels(label);

        PlotLine plotLine = new PlotLine();
        plotLine.setValue(2);
        yAxis.setPlotLines(plotLine);
        configuration.addyAxis(yAxis);

        Tooltip tooltip = new Tooltip();
        tooltip.setPointFormat("<span>{series.name}</span>: <b>{point.y}</b> ({point.change}%)<br/>");
        tooltip.setValueDecimals(2);
        tooltip.setSplit(true);
        configuration.setTooltip(tooltip);

        DataSeries nokiaSeries = new DataSeries();
        nokiaSeries.setName("Nokia");

        //loop through fetched data list to map data to data series items
        for (DateData data : dataList) {
            DataSeriesItem item = new DataSeriesItem();
            item.setX(data.getDate());
            item.setY(data.getNokiaData());
            nokiaSeries.add(item);
        }

        DataSeries nordeaSeries = new DataSeries();
        nordeaSeries.setName("Nordea");

        for (DateData data : dataList) {
            DataSeriesItem item = new DataSeriesItem();
            item.setX(data.getDate());
            item.setY(data.getNordeaData());
            nordeaSeries.add(item);
        }

        DataSeries microsoftSeries = new DataSeries();
        microsoftSeries.setName("Microsoft");

        for (DateData data : dataList) {
            DataSeriesItem item = new DataSeriesItem();
            item.setX(data.getDate());
            item.setY(data.getMicrosoftData());
            microsoftSeries.add(item);
        }

        DataSeries teliaSeries = new DataSeries();
        teliaSeries.setName("Telia");

        for (DateData data : dataList) {
            DataSeriesItem item = new DataSeriesItem();
            item.setX(data.getDate());
            item.setY(data.getTeliaData());
            teliaSeries.add(item);
        }

        configuration.setSeries(nokiaSeries, nordeaSeries, microsoftSeries, teliaSeries);

        configuration.getyAxis().setClassName("yAxis");

        PlotOptionsSeries plotOptionsSeries = new PlotOptionsSeries();
        plotOptionsSeries.setCompare(Compare.PERCENT);
        configuration.setPlotOptions(plotOptionsSeries);

        RangeSelector rangeSelector = new RangeSelector();
        rangeSelector.setSelected(4);

        configuration.setRangeSelector(rangeSelector);

        configuration.getChart().setClassName("mychart");

        return chart;

    }
}