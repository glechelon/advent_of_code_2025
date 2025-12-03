import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

public class Main {


    public static Long calculerSommeIdInvalides(String cheminFichier) throws IOException {

        final List<String> plagesBrutes = Arrays.asList(Files.readString(Path.of(cheminFichier))
                .split(","));

        final List<PlageId> plagesIds = plagesBrutes.stream()
                .map(Main::convertirEnPlageId)
                .filter(plageId -> !plageId.idDebut().startsWith("0") && !plageId.idFin().startsWith("0"))
                .toList();
        System.out.println(plagesIds);
        return plagesIds.stream()
                .map(plageId -> LongStream.range(Long.parseLong(plageId.idDebut()), Long.parseLong(plageId.idFin()) + 1))
                .map(idDansLaPlage -> idDansLaPlage.filter(Main::estInvalide).sum())
                .reduce(Long::sum).orElse(0L);

    }

    private static boolean estInvalide(long id) {
        final String idString = String.valueOf(id);
        for (int i = 1; i < idString.length() / 2 + 1; i++) {
            final String patternATester = idString.substring(0, i);
            final String patternRepeteATester = patternATester.repeat(idString.length() / i);
         //   System.out.println(patternATester + " " + patternRepeteATester + " " + idString);
            if (patternRepeteATester.equals(idString)) {
                return true;
            }
        }
        return false;
    }

    private static PlageId convertirEnPlageId(String plageBrute) {
        final String[] idsDeLaPlage = plageBrute.split("-");
        return new PlageId(idsDeLaPlage[0], idsDeLaPlage[1]);
    }
}

