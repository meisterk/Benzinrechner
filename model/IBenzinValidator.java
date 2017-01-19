package model;

public interface IBenzinValidator {

    void setBenzinInLiter(String benzinInLiter);

    void setStreckeInKm(String streckeInKm);

    String getDurchschnitt();

    String getBenzinFehlerMeldung();

    String getStreckenFehlerMeldung();
}
