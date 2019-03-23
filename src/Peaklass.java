import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Peaklass {

    public static List<Teos> loeTeosed(String failiNimi) throws FileNotFoundException {

        File fail = new File(failiNimi);
        List<Teos> teosteList = new ArrayList<>();

        try (Scanner sc = new Scanner(fail, "UTF-8")) {//Ära unusta throws Exception

            while (sc.hasNextLine()) {
                String[] ridaMassiivina = sc.nextLine().split("; ");

                if (!ridaMassiivina[0].contains("/")) {
                    Raamat raamat = new Raamat(ridaMassiivina[0], ridaMassiivina[1], ridaMassiivina[2],
                                Integer.parseInt(ridaMassiivina[3]));
                    teosteList.add(raamat);
                }
                else {
                    Ajakiri ajakiri = new Ajakiri(ridaMassiivina[0], ridaMassiivina[1], ridaMassiivina[2],
                            Integer.parseInt(ridaMassiivina[3]));
                    teosteList.add(ajakiri);
                }
            }

        }

        return teosteList;

    }

    public static void main(String[] args) throws FileNotFoundException {
        List<Teos> sorteeritavadTeosed = loeTeosed("laenutus.txt");

        System.out.println(sorteeritavadTeosed + "\n");

        for (Teos element:sorteeritavadTeosed) {
            System.out.println(element.getLaenutaja() + " viivis: " + element.arvutaViivis());
        }

        java.util.Collections.sort(sorteeritavadTeosed);

        System.out.println("\n" + sorteeritavadTeosed);

        ViiviseHoiataja hoiataja = new ViiviseHoiataja(0.2);
        SuurimaViiviseLeidja suurimViivis = new SuurimaViiviseLeidja();

        for (Teos element:sorteeritavadTeosed) {
            element.arvutaViivis(hoiataja);
            element.arvutaViivis(suurimViivis);
        }

        System.out.println("\nSaid hoiatuse: " + hoiataja.getHoiatatavadLaenutajad() + "\n");
        suurimViivis.saadaHoiatus();


    }

}
