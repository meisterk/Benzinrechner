package model;

public class BenzinRechner implements IBenzinRechner{
    private double benzinInLiter;
    private double streckeInKm;
    
    @Override
    public void setBenzinInLiter(double benzinInLiter) {
        this.benzinInLiter = benzinInLiter;
    }

    @Override
    public void setStreckeInKm(double streckeInKm) {
        this.streckeInKm = streckeInKm;
    }

    @Override
    public double getDurchschnittsverbrauchInLiterPro100km() {
        double durchschnitt = this.benzinInLiter / this.streckeInKm * 100.0;
        return durchschnitt;
    }    
}
