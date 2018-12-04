package ba.unsa.rpr.tutorijal7;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Tutorijal {

    static ArrayList<Grad> ucitajGradove(){
                ArrayList<Grad> gradovi = new ArrayList<>();
                Scanner ulaz;
                try {
                    ulaz = new Scanner(new FileReader("mjerenja.txt"));
                } catch (FileNotFoundException e) {
                    System.out.println("Datoteka ulaz.txt ne postoji ili se ne može otvoriti");
                    System.out.println("Greška: " + e);
                    return null;
                }
                int i,j=0;

                while(ulaz.hasNext()) {
                    String jednaLinija = ulaz.next();
                    String[] podstringovi = jednaLinija.split(",");
                    double[] pomocni = new double[ 1000 ];
                    for(i=0; i < podstringovi.length-1; i++){
                        pomocni[i] = Double.parseDouble( podstringovi [i+1] );
                    }

                        gradovi.add( new Grad() );
                        gradovi.get(j).setNaziv(podstringovi [0]);
                        gradovi.get(j).setTemperature(pomocni);
                        j+=1;

                }
                ulaz.close();
                return gradovi;
    }

    public static void main(String[] args) {

            }
    }
}