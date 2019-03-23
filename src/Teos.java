public abstract class Teos implements Comparable<Teos> {

    private String teoseKirjeldus;
    private String teoseTähis;
    private String laenutaja;
    private int päevadeArv;

    public Teos(String teoseKirjeldus, String teoseTähis, String laenutaja, int päevadeArv) {
        this.teoseKirjeldus = teoseKirjeldus;
        this.teoseTähis = teoseTähis;
        this.laenutaja = laenutaja;
        this.päevadeArv = päevadeArv;
    }

    public String getTeoseKirjeldus() {
        return teoseKirjeldus;
    }

    public String getTeoseTähis() {
        return teoseTähis;
    }

    public String getLaenutaja() {
        return laenutaja;
    }

    public int getPäevadeArv() {
        return päevadeArv;
    }

    public abstract boolean kasHoidlast();

    public int laenutusaeg() {
        if (teoseTähis.equals("roheline")) return 1;
        else if (teoseTähis.equals("kollane")) return 30;
        else if (teoseTähis.equals("sinine")) return 60;
        else if (teoseTähis.equals("puudub")) return 14;
        else return 0;
    }

    public double päevaneViivis() {
        if (teoseTähis.equals("kollane") || teoseTähis.equals("sinine")) return 0.05;
        else if (teoseTähis.equals("puudub")) return 0.15;
        else if (teoseTähis.equals("roheline")) return 2;
        else return 0;
    }

    public void arvutaViivis(Kontrollija kontrollija) {
        if (päevadeArv > laenutusaeg()) {
            kontrollija.salvestaViivis(laenutaja, teoseKirjeldus, (päevaneViivis())*
                    (päevadeArv-laenutusaeg()));
        }
    }

    //Meetod testimiseks
    public double arvutaViivis() {
        if (päevadeArv > laenutusaeg()) {
            return (päevaneViivis()) * (päevadeArv-laenutusaeg());
        }
        else return 0;
    }

    @Override
    public String toString() {
        return "Teos{" +
                "teoseKirjeldus='" + teoseKirjeldus + '\'' +
                ", teoseTähis='" + teoseTähis + '\'' +
                ", lubatudLaenutusAeg='" + laenutusaeg() + '\'' +
                ", tähisePäevaneViivis='" + päevaneViivis() + '\'' +
                ", laenutaja='" + laenutaja + '\'' +
                ", laenutatudPäevadeArv=" + päevadeArv + '\'' +
                ", kasHoidlastTellida=" + kasHoidlast() +
                '}';
    }

    @Override
    public int compareTo(Teos võrreldav) {
        return this.teoseKirjeldus.compareTo(võrreldav.teoseKirjeldus);
    }
}
