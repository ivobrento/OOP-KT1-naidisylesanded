import java.util.ArrayList;
import java.util.List;

public class ViiviseHoiataja implements Kontrollija {

    private double lubatudViivis;
    private List<String> HoiatatavadLaenutajad = new ArrayList<>();

    public ViiviseHoiataja(double lubatudViivis) {
        this.lubatudViivis = lubatudViivis;
    }

    @Override
    public void salvestaViivis(String laenutajaNimi, String teoseKirjeldus, double viiviseSuurus) {
        if ((viiviseSuurus > lubatudViivis) && !(HoiatatavadLaenutajad.contains(laenutajaNimi))) {
            HoiatatavadLaenutajad.add(laenutajaNimi);
        }
    }

    public List<String> getHoiatatavadLaenutajad() {
        return HoiatatavadLaenutajad;
    }
}
