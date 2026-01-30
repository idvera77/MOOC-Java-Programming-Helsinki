package ticTacToe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {

    private String turno = "X";
    private Button[][] botones = new Button[3][3];
    private Label infoTurno = new Label("Turn: X");
    private boolean juegoTerminado = false;

    @Override
    public void start(Stage window) {
        // 1. Layout Principal
        BorderPane layout = new BorderPane();
        infoTurno.setFont(Font.font("Monospaced", 40));
        layout.setTop(infoTurno);

        // 2. Cuadrícula de juego (GridPane)
        GridPane cuadricula = new GridPane();
        
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                Button btn = new Button(" ");
                btn.setFont(Font.font("Monospaced", 40));
                
                // Guardamos referencia para comprobar victoria después
                botones[x][y] = btn;

                // Lógica de click
                btn.setOnAction((event) -> {
                    if (juegoTerminado || !btn.getText().equals(" ")) {
                        return; // No hace nada si ya hay símbolo o terminó el juego
                    }

                    btn.setText(turno);
                    
                    if (hayGanador()) {
                        infoTurno.setText("The end!");
                        juegoTerminado = true;
                    } else if (tableroLleno()) {
                        infoTurno.setText("The end!");
                        juegoTerminado = true;
                    } else {
                        // Cambiar turno
                        turno = turno.equals("X") ? "O" : "X";
                        infoTurno.setText("Turn: " + turno);
                    }
                });

                cuadricula.add(btn, x, y);
            }
        }

        layout.setCenter(cuadricula);

        Scene escena = new Scene(layout);
        window.setScene(escena);
        window.setTitle("Tic-Tac-Toe");
        window.show();
    }

    // Lógica para verificar si alguien ganó
    public boolean hayGanador() {
        // Filas y Columnas
        for (int i = 0; i < 3; i++) {
            if (compararTres(botones[i][0], botones[i][1], botones[i][2])) return true;
            if (compararTres(botones[0][i], botones[1][i], botones[2][i])) return true;
        }
        // Diagonales
        if (compararTres(botones[0][0], botones[1][1], botones[2][2])) return true;
        if (compararTres(botones[0][2], botones[1][1], botones[2][0])) return true;
        
        return false;
    }

    private boolean compararTres(Button b1, Button b2, Button b3) {
        String t1 = b1.getText();
        return !t1.equals(" ") && t1.equals(b2.getText()) && t1.equals(b3.getText());
    }
    
    private boolean tableroLleno() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (botones[x][y].getText().equals(" ")) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }
}