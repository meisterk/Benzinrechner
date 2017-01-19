package model;

public interface IBenzinRechner {

    void setBenzinInLiter(double benzinInLiter);

    void setStreckeInKm(double streckeInKm);

    double getDurchschnittsverbrauchInLiterPro100km();
}
