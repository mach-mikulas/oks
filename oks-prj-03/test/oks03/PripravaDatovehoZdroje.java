package oks03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PripravaDatovehoZdroje {

    private static List<String> nacteniSouboru(){

        String soubor = System.getProperty("datovy.zdroj.oks03");
        //String soubor = "priklady-oks-03.txt";

        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(soubor))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("#")) {
                    continue; // skip lines that start with #
                }

                if (line.trim().isEmpty()) {
                    continue;
                }

                lines.add(line);
            }
        } catch (IOException e) {

        }

        return lines;
    }

    static List<Object[]> listDvojiceBooleanString(){

        List<String> nacteneData = nacteniSouboru();
        List<Object[]> dvojice = new ArrayList<>();

        for(int i = 0; i < nacteneData.size(); i++){

            String[] casti = nacteneData.get(i).split(";");

            Object[] pole = new Object[2];
            pole[0] = Boolean.parseBoolean(casti[0]);
            pole[1] = casti[1];

            dvojice.add(pole);
        }

        return dvojice;
    }


}
