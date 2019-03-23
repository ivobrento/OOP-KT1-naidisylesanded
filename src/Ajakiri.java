public class Ajakiri extends Teos {

    public Ajakiri(String teoseKirjeldus, String teoseTähis, String laenutaja, int päevadeArv) {
        super(teoseKirjeldus, teoseTähis, laenutaja, päevadeArv);
    }

    @Override
    public boolean kasHoidlast() {
        int ilmumisAasta = 0;
        StringBuilder sb = new StringBuilder(50);
        sb.append(getTeoseKirjeldus());
        sb.delete(0, (sb.indexOf("/")+1));
        sb.delete(sb.indexOf(","), sb.length());
        //System.out.println(sb);
        if (Integer.parseInt(sb.toString()) <= 2000) return true;
        else return false;
    }

    @Override
    public String toString() {
        return "Tegemist on ajakirjaga: " + super.toString();
    }
}
