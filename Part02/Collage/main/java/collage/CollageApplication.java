package collage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CollageApplication extends Application {

    @Override
    public void start(Stage stage) {
        // 1. Cargar la imagen original
        Image monaLisa = new Image("file:monalisa.png");
        PixelReader lector = monaLisa.getPixelReader();

        int anchoOriginal = (int) monaLisa.getWidth();
        int altoOriginal = (int) monaLisa.getHeight();

        // 2. Crear una nueva imagen vacía para el collage (mismo tamaño que la original)
        WritableImage collage = new WritableImage(anchoOriginal, altoOriginal);
        PixelWriter escritor = collage.getPixelWriter();

        // 3. Lógica del Collage
        // Recorremos la MITAD del ancho y la MITAD del alto (para crear la miniatura)
        for (int y = 0; y < altoOriginal / 2; y++) {
            for (int x = 0; x < anchoOriginal / 2; x++) {

                // Leemos el píxel de la original saltando de 2 en 2
                // (0,0)->(0,0), (1,0)->(2,0), (2,0)->(4,0)...
                Color colorPixel = lector.getColor(x * 2, y * 2);

                // Calculamos el color NEGATIVO
                double red = 1.0 - colorPixel.getRed();
                double green = 1.0 - colorPixel.getGreen();
                double blue = 1.0 - colorPixel.getBlue();
                double opacity = colorPixel.getOpacity();

                Color colorNegativo = new Color(red, green, blue, opacity);

                // Dibujamos el píxel en las 4 posiciones de la cuadrícula
                // Top-left
                escritor.setColor(x, y, colorNegativo);
                // Top-right
                escritor.setColor(x + anchoOriginal / 2, y, colorNegativo);
                // Bottom-left
                escritor.setColor(x, y + altoOriginal / 2, colorNegativo);
                // Bottom-right
                escritor.setColor(x + anchoOriginal / 2, y + altoOriginal / 2, colorNegativo);
            }
        }

        ImageView imagenMostrada = new ImageView(collage);
        Pane layout = new Pane(imagenMostrada);
        stage.setScene(new Scene(layout));
        stage.show();
    }

    public static void main(String[] args) {
        launch(CollageApplication.class);
    }
}