package web.model;

public class Car {

    private String model;
    private String bibik;
    private int series;

    public Car(){}

    public Car(String mod, String bib, int ser){
        model = mod;
        bibik = bib;
        series = ser;
    }


    public String getModel() {
        return model;
    }

    public int getSeries() {
        return series;
    }

    public String getBibik() {
        return bibik;
    }

    public void setBibik(String bibik) {
        this.bibik = bibik;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSeries(int series) {
        this.series = series;
    }
}

