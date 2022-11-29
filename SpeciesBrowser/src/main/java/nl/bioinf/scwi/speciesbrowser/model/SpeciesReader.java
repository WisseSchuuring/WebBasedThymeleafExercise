package nl.bioinf.scwi.speciesbrowser.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SpeciesReader {
    public static List<Species> speciesDataReader() {
        List<Species> speciesList = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Path.of("/homes/wsfschuuring/Desktop/Thema10/Thema10/SpeciesBrowser/data/speciesData.csv"))) {
            String line;
            reader.readLine(); // Skip first line
            while ((line = reader.readLine()) != null) {
                String[] splitLine = line.split(";");
                Species species = new Species(splitLine[0], splitLine[1], splitLine[2]);
                speciesList.add(species);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return speciesList;
    }
}
