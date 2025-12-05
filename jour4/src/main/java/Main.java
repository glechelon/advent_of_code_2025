import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {


    public static long calculerNombreRouleauxAccessibles(String cheminFichier) throws IOException {
        final List<String> lignes = Files.readAllLines(Path.of(cheminFichier));
        final List<Position> positions = convertirEnPositions(lignes);
        //   System.out.println(positions);

        return positions.stream()
                .map(position -> calculerPositionsAdjacentes(position, positions))
                //      .peek(System.out::println)
                .map(List::size)
                .filter(nombreDePositionsAdjacentes -> nombreDePositionsAdjacentes < 4)
                .count();


    }

    private static List<Position> convertirEnPositions(List<String> lignes) {
        final List<Position> positions = new ArrayList<>();
        for (int i = 0; i < lignes.size(); i++) {
            List<String> ligne = Arrays.asList(lignes.get(i).split(""));
            for (int j = 0; j < ligne.size(); j++) {
                if (ligne.get(j).equals("@")) {
                    positions.add(new Position(j, i));
                }
            }

        }
        return positions;
    }

    private static List<Position> calculerPositionsAdjacentes(Position positionDeDepart, List<Position> positions) {
        final List<Position> positionsAdjacentes = new ArrayList<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                final Position positionAdjacente = new Position(positionDeDepart.x() + j, positionDeDepart.y() + i);
                if (positionAdjacente.x() >= 0 && positionAdjacente.y() >= 0) {
                    if (!positionAdjacente.equals(positionDeDepart) && positions.contains(positionAdjacente)) {
                        positionsAdjacentes.add(positionAdjacente);
                    }
                }
            }
        }
        return positionsAdjacentes;
    }


}

