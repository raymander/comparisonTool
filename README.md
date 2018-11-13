Financial Comparison Tool

This project is a tool for graphically showing how selected financial instruments (such as stocks) are performing. Performance is calculated in percents and can be compared over selected time period.

For presenting graphical solution, the project uses Vaadin Charts. Data is fetched from .csv file in resources folder. UI core component is MainView.java, which creates a chart to show by calling init method from CompareMultipleSeries.java

Running the project 

Run “mvn clean install spring-boot:run” in the project root directory. After the server has started point your browser to http://localhost:8080 to see the resulting application.
