package org.vaadin.spring.comparisonTool.components;

import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.vaadin.spring.comparisonTool.CSVFileReader;
import org.vaadin.spring.comparisonTool.domain.DateData;

import java.util.ArrayList;

@SpringComponent
@UIScope
public class CompareMultipleSeries extends AbstractChart {

    private final String FILE_PATH = "./src/main/resources/DATA.csv";

    public static ArrayList<DateData> dataList = new ArrayList<>();

    @Override
    public Chart init() {
        final Chart chart = new Chart();
        chart.setTimeline(true);

        if (dataList.isEmpty()) {
            dataList = CSVFileReader.readData(FILE_PATH);
        }

        for (DateData d : dataList) {
            System.out.println(d);
        }

        Configuration configuration = chart.getConfiguration();
        configuration.getTitle().setText("PRICE COMPARISON");
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