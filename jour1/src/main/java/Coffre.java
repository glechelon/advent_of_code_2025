import java.util.ArrayList;
import java.util.List;

class Coffre {

    private int nombreSurLeCadran = 50;

    public List<Integer> tournerADroite(final int nomBreDeCliques) {
        final List<Integer> historique = new ArrayList<>();
        for (int i = 1; i <= nomBreDeCliques; i++) {
            nombreSurLeCadran = (100 + nombreSurLeCadran + 1) % 100;
            historique.add(nombreSurLeCadran);
        }
        //   System.out.println(this.nombreSurLeCadran);
        return historique;
    }

    public List<Integer> tournerAGauche(final int nomBreDeCliques) {
        final List<Integer> historique = new ArrayList<>();
        for (int i = 1; i <= nomBreDeCliques; i++) {
            nombreSurLeCadran = (100 + nombreSurLeCadran - 1) % 100;
            historique.add(nombreSurLeCadran);
        }
        // System.out.println(this.nombreSurLeCadran);
        return historique;
    }
}
