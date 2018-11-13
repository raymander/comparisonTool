package test;

/*
 * #%L
 * Vaadin Charts
 * %%
 * Copyright (C) 2014 Vaadin Ltd
 * %%
 * This program is available under Commercial Vaadin Add-On License 3.0
 * (CVALv3).
 *
 * See the file licensing.txt distributed with this software for more
 * information about licensing.
 *
 * You should have received a copy of the CVALv3 along with this program.
 * If not, see <https://vaadin.com/license/cval-3>.
 * #L%
 */

import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.Configuration;
import main.components.CompareMultipleSeries;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CompareMultipleSeriesTest {

    private Chart chart;
    private Configuration conf;

    @BeforeEach
    public void CreateChart() {
        chart = CompareMultipleSeries.init();
        conf = chart.getConfiguration();
    }

    @Test
    public void ChartShouldExist() {
        assertNotNull(chart);
    }

    @Test
    public void ChartShouldHaveTitle() {
        assertTrue(conf.getTitle().getText().contains("Financial performance chart"));
    }

    @Test
    public void ChartShouldHaveDataSeries() {
        assertEquals(4, conf.getSeries().size());
    }

}