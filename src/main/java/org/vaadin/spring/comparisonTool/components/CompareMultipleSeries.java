package org.vaadin.spring.comparisonTool.components;

import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.Compare;
import com.vaadin.flow.component.charts.model.Configuration;
import com.vaadin.flow.component.charts.model.Labels;
import com.vaadin.flow.component.charts.model.PlotLine;
import com.vaadin.flow.component.charts.model.PlotOptionsSeries;
import com.vaadin.flow.component.charts.model.RangeSelector;
import com.vaadin.flow.component.charts.model.Tooltip;
import com.vaadin.flow.component.charts.model.YAxis;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.vaadin.spring.comparisonTool.components.AbstractChart;

@SpringComponent
public class CompareMultipleSeries extends AbstractChart {

    @Override
    public Chart init() {
        final Chart chart = new Chart();
        chart.setTimeline(true);

        Configuration configuration = chart.getConfiguration();
        configuration.getTitle().setText("Prices comparison");

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
        configuration.setTooltip(tooltip);

//        DataSeries aaplSeries = new DataSeries();
//        aaplSeries.setName("AAPL");
//        for (StockPrices.PriceData data : StockPrices.fetchAaplPrice()) {
//            DataSeriesItem item = new DataSeriesItem();
//            item.setX(data.getDate());
//            item.setY(data.getPrice());
//            aaplSeries.add(item);
//        }
//        DataSeries googSeries = new DataSeries();
//        googSeries.setName("GOOG");
//        for (StockPrices.PriceData data : StockPrices.fetchGoogPrice()) {
//            DataSeriesItem item = new DataSeriesItem();
//            item.setX(data.getDate());
//            item.setY(data.getPrice());
//            googSeries.add(item);
//        }
//        DataSeries msftSeries = new DataSeries();
//        msftSeries.setName("MSFT");
//        for (StockPrices.PriceData data : StockPrices.fetchMsftPrice()) {
//            DataSeriesItem item = new DataSeriesItem();
//            item.setX(data.getDate());
//            item.setY(data.getPrice());
//            msftSeries.add(item);
//        }
//        configuration.setSeries(aaplSeries, googSeries, msftSeries);

        PlotOptionsSeries plotOptionsSeries = new PlotOptionsSeries();
        plotOptionsSeries.setCompare(Compare.PERCENT);
        configuration.setPlotOptions(plotOptionsSeries);

        RangeSelector rangeSelector = new RangeSelector();
        rangeSelector.setSelected(4);
        configuration.setRangeSelector(rangeSelector);

        System.out.print("vf;vnf;v");
        return chart;

    }
}