package gui;

import model.BenzinValidator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.*;
import javafx.scene.control.*;
import model.IBenzinValidator;

public class Controller implements Initializable {

    //---------------------------------------------
    // Membervariablen für Steuerelemente
    //---------------------------------------------
    @FXML
    private TextField textFieldBenzin;
    @FXML
    private TextField textFieldStrecke;
    @FXML
    private Button buttonBerechnen;
    @FXML
    private Label labelAusgabe;
    @FXML
    private Label labelBenzinError;
    @FXML
    private Label labelStreckeError;

    //---------------------------
    // Sonstige Membervariablen
    //---------------------------
    private IBenzinValidator validator;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //---------------------------------------------
        // Eventhandler für Button
        //---------------------------------------------
        buttonBerechnen.setOnAction(event -> {
            datenAnValidatorSenden();
            datenVomValidatorHolenUndAusgeben();
        }
        );

        //---------------------------------------------
        //Beim Start des Programms
        //---------------------------------------------        
        // Server erstellen
        this.validator = new BenzinValidator();

        datenAnValidatorSenden();
        datenVomValidatorHolenUndAusgeben();
    }

    private void datenAnValidatorSenden() {
        String benzinmenge = textFieldBenzin.getText();
        validator.setBenzinInLiter(benzinmenge);

        String strecke = textFieldStrecke.getText();
        validator.setStreckeInKm(strecke);
    }

    private void datenVomValidatorHolenUndAusgeben() {
        String durchschnitt = validator.getDurchschnitt();
        labelAusgabe.setText(durchschnitt);

        String benzinfehler = validator.getBenzinFehlerMeldung();
        labelBenzinError.setText(benzinfehler);

        String streckenfehler = validator.getStreckenFehlerMeldung();
        labelStreckeError.setText(streckenfehler);
    }
}
