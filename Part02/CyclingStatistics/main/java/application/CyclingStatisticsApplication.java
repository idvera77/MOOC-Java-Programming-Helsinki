package application;

import java.util.Map;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane; // Importación obligatoria
import javafx.stage.Stage;

public class CyclingStatisticsApplication extends Application {

    @Override
    public void start(Stage stage) {
        CyclingStatistics statistics = new CyclingStatistics("helsinki-cycling-statistics.csv");

        // 1. Configurar los ejes y el BarChart
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Year / Month");
        yAxis.setLabel("Cyclists");

        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Cyclists at selected location");
        barChart.setLegendVisible(false);

        // 2. Lista de ubicaciones
        ListView<String> list = new ListView<>();
        ObservableList<String> items = FXCollections.observableArrayList(statistics.locations());
        list.setItems(items);

        // 3. Contenedor PRINCIPAL: GridPane (Requisito del Test)
        GridPane layout = new GridPane();
        // Añadimos la lista en la columna 0, fila 0
        layout.add(list, 0, 0);
        // Añadimos el gráfico en la columna 1, fila 0
        layout.add(barChart, 1, 0);

        // 4. Lógica de interacción
        list.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            Map<String, Integer> values = statistics.monthlyCyclists(newValue);

            barChart.getData().clear();
            XYChart.Series dataSeries = new XYChart.Series();
            dataSeries.setName(newValue);

            values.keySet().forEach(month -> {
                dataSeries.getData().add(new XYChart.Data<>(month, values.get(month)));
            });

            barChart.getData().add(dataSeries);
        });

        // 5. Escena con el GridPane como raíz
        Scene scene = new Scene(layout, 1000, 700);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(CyclingStatisticsApplication.class);
    }
}