package model;

public class BenzinValidator implements IBenzinValidator {

    // Eingabe
    private double benzinInLiter;
    private double streckeInKm;

    // Fehler
    private boolean benzinfehler;
    private boolean streckenfehler;

    private final IBenzinRechner benzinRechner;

    public BenzinValidator() {
        benzinRechner = new BenzinRechner();
    }

    @Override
    public void setBenzinInLiter(String benzinmenge) {
        try {
            benzinInLiter = Double.parseDouble(benzinmenge);
            benzinIstOK();
            benzinRechner.setBenzinInLiter(benzinInLiter);
        } catch (NumberFormatException e) {
            benzinIstNichtOK();
        }
    }

    private void benzinIstOK() {
        this.benzinfehler = false;
    }

    private void benzinIstNichtOK() {
        this.benzinfehler = true;
    }

    @Override
    public void setStreckeInKm(String strecke) {
        try {
            streckeInKm = Double.parseDouble(strecke);
            if (streckeInKm > 0.0) {
                streckeIstOK();
                benzinRechner.setStreckeInKm(streckeInKm);
            } else {
                streckeIstNichtOK();
            }
        } catch (NumberFormatException e) {
            streckeIstNichtOK();
        }
    }

    private void streckeIstOK() {
        this.streckenfehler = false;
    }

    private void streckeIstNichtOK() {
        this.streckenfehler = true;
    }

    @Override
    public String getDurchschnitt() {
        String durchschnittText = "";
        if (streckeUndBenzinOK()) {
            double durchschnittZahl
                    = benzinRechner.getDurchschnittsverbrauchInLiterPro100km();

            durchschnittText = String.format(
                    "Der durchschnittliche Verbrauch beträgt %.1f l/100km",
                    durchschnittZahl);
        }
        return durchschnittText;
    }

    private boolean streckeUndBenzinOK() {
        return !benzinfehler && !streckenfehler;
    }

    @Override
    public String getBenzinFehlerMeldung() {
        String fehlerText = "";
        if (benzinfehler) {
            fehlerText = "Bitte geben Sie eine Zahl ein.";
        }
        return fehlerText;
    }

    @Override
    public String getStreckenFehlerMeldung() {
        String fehlerText = "";
        if (streckenfehler) {
            fehlerText = "Bitte geben Sie eine positive Zahl ein.";
        }
        return fehlerText;
    }

}
