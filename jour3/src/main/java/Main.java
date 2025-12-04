import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {


    public static Integer calculerJoltageTotal(String cheminFichier) throws IOException {
        final List<String> lignes = Files.readAllLines(Path.of(cheminFichier));
        return lignes.stream()
                .map(ligne -> ligne.split(""))
                .map(Arrays::asList)
                .map(Main::extraireMaxComboPile)
                .map(Integer::parseInt)
                .peek(System.out::println)
                .reduce(Integer::sum)
                .orElse(0);

    }

    private static String extraireMaxComboPile(List<String> banqueBrute) {
        final List<String> combosPiles = new ArrayList<>();
        for (int i = 0; i < banqueBrute.size() - 1; i++) {
            for (int j = i + 1; j < banqueBrute.size(); j++) {
                combosPiles.add(banqueBrute.get(i) + banqueBrute.get(j));
            }
        }
        return combosPiles.stream()
                .max(Comparator.naturalOrder())
                .orElse("0");
    }


}

