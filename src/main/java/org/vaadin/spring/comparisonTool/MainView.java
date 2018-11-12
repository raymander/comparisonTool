/*
 * Copyright 2000-2017 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.vaadin.spring.comparisonTool;

import com.vaadin.flow.component.charts.Chart;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import org.vaadin.spring.comparisonTool.components.CompareMultipleSeries;

import java.util.ArrayList;

@Route("")
public class MainView extends Div {

    private RouterLink link;

    public MainView(@Autowired CompareMultipleSeries template, @Autowired CompareMultipleSeries chart) {

        //Label greeting = new Label(greeter.sayHello());
//        Style grretingStyle = greeting.getElement().getStyle();
//        grretingStyle.set("display", "block");
//        grretingStyle.set("margin-bottom", "10px");


//        link = new RouterLink(
//                getTranslation("root.navigate_to_component"),
//                ViewComponent.class);
//
//        Style linkStyle = link.getElement().getStyle();
//        linkStyle.set("display", "block");
//        linkStyle.set("margin-bottom", "10px");

          Chart mychart;
          mychart = chart.init();
          add(mychart, template);

//    @Override
//    public void localeChange(LocaleChangeEvent event) {
//        link.setText(
//                getTranslation("root.navigate_to_component"));
//    }

    }
}
