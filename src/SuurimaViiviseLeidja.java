import java.util.ArrayList;
import java.util.List;

public class SuurimaViiviseLeidja implements Kontrollija {

    private List<String> suurimViivis = new ArrayList<>();

    @Override
    public void salvestaViivis(String laenutajaNimi, String teoseKirjeldus, double viiviseSuurus) {
        if (suurimViivis.isEmpty()) {
            suurimViivis.add(laenutajaNimi);
            suurimViivis.add(teoseKirjeldus);
            suurimViivis.add(String.valueOf(viiviseSuurus));
        }
        else if (viiviseSuurus > Double.parseDouble(suurimViivis.get(2))) {
            suurimViivis.set(0, laenutajaNimi);
            suurimViivis.set(1, teoseKirjeldus);
            suurimViivis.set(2, String.valueOf(viiviseSuurus));
        }

    }

    public void saadaHoiatus() {
        if (suurimViivis.isEmpty()) {
            System.out.println("Viivised puuduvad.");
        }
        else {
            System.out.println("Ekstra hoiatame suurima viivise omanikku:\n" +
                    "Laenutaja: " + suurimViivis.get(0) + ". Teos: " + suurimViivis.get(1));
        }
    }

}
