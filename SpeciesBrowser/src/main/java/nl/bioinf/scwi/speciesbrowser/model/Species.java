package nl.bioinf.scwi.speciesbrowser.model;

//public record Species(
//        String scientific,
//        String dutch,
//        String english) {}

public class Species {
    private String latinName;
    private String engName;
    private String nedName;

    public String getLatinName() {
        return latinName;
    }

    public String getEngName() {
        return engName;
    }

    public String getNedName() {
        return nedName;
    }

    public Species() {
    }

    public Species(String latinName, String engName, String nedName) {
        this.latinName = latinName;
        this.engName = engName;
        this.nedName = nedName;
    }
}