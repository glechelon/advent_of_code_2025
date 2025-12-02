import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static long resolvePassword(String cheminFichier) throws IOException {

        final List<String> instructions = Files.readAllLines(Path.of(cheminFichier));
        //  System.out.println(instructions);

        final Coffre coffre = new Coffre();
        final List<Integer> historiqueNombresSurLeCadran = new ArrayList<>();

        for (String instruction : instructions) {
            final int nombresDeCliques = Integer.parseInt(instruction.substring(1));
            if (instruction.startsWith("L")) {
                historiqueNombresSurLeCadran.addAll(coffre.tournerAGauche(nombresDeCliques));
            } else if (instruction.startsWith("R")) {
                historiqueNombresSurLeCadran.addAll(coffre.tournerADroite(nombresDeCliques));
            }
            //   System.out.println(historiqueNombresSurLeCadran);
        }


        return historiqueNombresSurLeCadran.stream()
                .filter(nombre -> nombre.equals(0))
                .count();
    }


}

