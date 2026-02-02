package application;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {

    @Override
    public void start(Stage stage) {
        // 1. Crear el Layout Principal
        BorderPane layout = new BorderPane();

        // 2. Crear los controles (Sliders y etiquetas)
        // Ahorro mensual
        BorderPane savingsLayout = new BorderPane();
        Slider savingsSlider = new Slider(25, 250, 50);
        savingsSlider.setShowTickMarks(true);
        savingsSlider.setShowTickLabels(true);
        Label savingsValue = new Label("50");
        savingsLayout.setLeft(new Label("Monthly savings"));
        savingsLayout.setCenter(savingsSlider);
        savingsLayout.setRight(savingsValue);
        savingsLayout.setPadding(new Insets(10));

        // Tasa de interés
        BorderPane interestLayout = new BorderPane();
        Slider interestSlider = new Slider(0, 10, 0);
        interestSlider.setShowTickMarks(true);
        interestSlider.setShowTickLabels(true);
        Label interestValue = new Label("0");
        interestLayout.setLeft(new Label("Yearly interest rate"));
        interestLayout.setCenter(interestSlider);
        interestLayout.setRight(interestValue);
        interestLayout.setPadding(new Insets(10));

        VBox topMenu = new VBox(savingsLayout, interestLayout);
        layout.setTop(topMenu);

        // 3. Crear el Gráfico
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();
        LineChart<Number, Number> chart = new LineChart<>(xAxis, yAxis);
        chart.setAnimated(false); // Desactivar animaciones para que el update sea instantáneo
        chart.setTitle("Savings Calculator");
        layout.setCenter(chart);

        // 4. Series de datos
        XYChart.Series savingsSeries = new XYChart.Series();
        savingsSeries.setName("Monthly Savings");
        XYChart.Series interestSeries = new XYChart.Series();
        interestSeries.setName("Savings + Interest");
        
        chart.getData().addAll(savingsSeries, interestSeries);

        // 5. Lógica de actualización (Listeners)
        ChangeListener<Number> updater = (obs, oldVal, newVal) -> {
            // Actualizar etiquetas de texto
            savingsValue.setText(String.format("%.2f", savingsSlider.getValue()));
            interestValue.setText(String.format("%.2f", interestSlider.getValue()));
            
            // Actualizar gráfico
            updateChart(savingsSlider.getValue(), interestSlider.getValue(), savingsSeries, interestSeries);
        };

        savingsSlider.valueProperty().addListener(updater);
        interestSlider.valueProperty().addListener(updater);

        // Cálculo inicial
        updateChart(50, 0, savingsSeries, interestSeries);

        stage.setScene(new Scene(layout, 800, 500));
        stage.show();
    }

    private void updateChart(double monthlySavings, double yearlyInterest, XYChart.Series savingsSeries, XYChart.Series interestSeries) {
        savingsSeries.getData().clear();
        interestSeries.getData().clear();

        double savingsTotal = 0;
        double interestTotal = 0;

        // Año 0
        savingsSeries.getData().add(new XYChart.Data(0, 0));
        interestSeries.getData().add(new XYChart.Data(0, 0));

        for (int year = 1; year <= 30; year++) {
            // Ahorro sin interés (lineal)
            savingsTotal += monthlySavings * 12;
            savingsSeries.getData().add(new XYChart.Data(year, savingsTotal));

            // Ahorro con interés compuesto
            // El interés se calcula sobre el total acumulado al final de cada año
            interestTotal = (interestTotal + monthlySavings * 12) * (1 + yearlyInterest / 100.0);
            interestSeries.getData().add(new XYChart.Data(year, interestTotal));
        }
    }

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }
}