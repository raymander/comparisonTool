package org.vaadin.spring.comparisonTool.tests;

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
import org.junit.jupiter.api.Test;
import org.vaadin.spring.comparisonTool.components.CompareMultipleSeries;

public class UITest  {

    @Test
    public void Chart_TitleDisplayed() {
        Chart chart = CompareMultipleSeries.init();

    }

//
//    @Test
//    public void Chart_TitleCanBeChanged(@Autowired CompareMultipleSeries chart) {
//        final WebElement mychart = chart.init();
//        final WebElement title = getElementFromShadowRoot(chart,
//                By.className("highcharts-title"));
//        assertTrue(title.getText().contains("First Chart for Flow"));
//
//        final WebElement changeTitleButton = findElement(By.id("change_title"));
//        changeTitleButton.click();
//
//        final WebElement titleChanged = getElementFromShadowRoot(chart,
//                By.className("highcharts-title"));
//        assertTrue(titleChanged.getText()
//                .contains("First Chart for Flow - title changed"));
//    }
//
//    @Test
//    public void Chart_SeriesNameIsSet() {
//        final WebElement chart = getChartElement();
//        final WebElement series = getElementFromShadowRoot(chart,
//                By.className("highcharts-legend-item"));
//        assertTrue(series.getText().contains("Tokyo"));
//    }

}