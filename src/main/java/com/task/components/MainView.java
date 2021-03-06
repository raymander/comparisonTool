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
package com.task.components;

import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

//Core UI component accessible on localhost:8080
@Route("")
@PageTitle("Programming task for FA Solutions")
@HtmlImport("frontend://styles/CompareMultipleSeries.html")
public class MainView extends Div {

    public MainView() {

          VerticalLayout main = new VerticalLayout();

//        Setting up the chart, adding it to the layout and the view
          Chart mychart;
          mychart = CompareMultipleSeries.init();
          mychart.setWidth("85%");
          mychart.setHeight("700px");

          main.add(mychart);
          main.setAlignItems(FlexComponent.Alignment.CENTER);

          add(main);

    }
}
