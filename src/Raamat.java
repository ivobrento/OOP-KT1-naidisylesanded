public class Raamat extends Teos {

    public Raamat(String teoseKirjeldus, String teoseTähis, String laenutaja, int päevadeArv) {
        super(teoseKirjeldus, teoseTähis, laenutaja, päevadeArv);
    }

    @Override
    public boolean kasHoidlast() {
        if (this.getTeoseTähis().equals("kollane") || this.getTeoseTähis().equals("sinine")) return true;
        else return false;
    }

    @Override
    public String toString() {
        return "Tegemist on raamatuga: " + super.toString();
    }

}
