package application;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JokeApplication extends Application {

    @Override
    public void start(Stage window) {

        // 1. Crear el layout principal
        BorderPane layout = new BorderPane();

        // 2. Crear el menú de botones (HBox)
        HBox menu = new HBox();
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);
        menu.setAlignment(Pos.CENTER);

        Button jokeButton = new Button("Joke");
        Button answerButton = new Button("Answer");
        Button explanationButton = new Button("Explanation");

        menu.getChildren().addAll(jokeButton, answerButton, explanationButton);
        layout.setTop(menu);

        // 3. Crear las vistas (layouts secundarios para el contenido central)
        StackPane jokeLayout = createView("What do you call a bear with no teeth?");
        StackPane answerLayout = createView("A gummy bear.");
        StackPane explanationLayout = createView("Because 'gummy' refers to both the candy and having only gums!");

        // 4. Lógica de los botones para cambiar la vista central
        jokeButton.setOnAction((event) -> layout.setCenter(jokeLayout));
        answerButton.setOnAction((event) -> layout.setCenter(answerLayout));
        explanationButton.setOnAction((event) -> layout.setCenter(explanationLayout));

        // 5. Configuración inicial: mostrar el chiste al arrancar
        layout.setCenter(jokeLayout);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }

    // Método auxiliar para no repetir código al crear las etiquetas centradas
    private StackPane createView(String text) {
        StackPane layout = new StackPane();
        layout.setPrefSize(300, 180);
        layout.getChildren().add(new Label(text));
        layout.setAlignment(Pos.CENTER);
        return layout;
    }

    public static void main(String[] args) {
        launch(JokeApplication.class);
    }
}