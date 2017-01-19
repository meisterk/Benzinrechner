package gui;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage fenster) throws Exception {
        //---------------------------------------------
        // Vorbereitungen zum Laden des Layouts
        //---------------------------------------------
        URL url = getClass().getResource("layout.fxml");
        FXMLLoader loader = new FXMLLoader(url);

        //---------------------------------------------
        // Controller ist für Funktionlität zuständig
        //---------------------------------------------
        loader.setController(new Controller());

        //---------------------------------------------
        // Layout laden und in Fenster setzen
        //---------------------------------------------
        Parent parent = loader.load();
        fenster.setScene(new Scene(parent));

        //---------------------------------------------
        // Fenstereigenschaften setzen und Fenster anzeigen
        //---------------------------------------------
        fensterEigenschaftenSetzenUndAnzeigen(fenster);
    }
    
    private void fensterEigenschaftenSetzenUndAnzeigen(Stage fenster){
        fenster.setTitle("Benzinrechner");
        fenster.setResizable(false);
        fenster.show();
    }
}
