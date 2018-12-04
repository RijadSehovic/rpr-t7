package ba.unsa.rpr.tutorijal7;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
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

    static UN ucitajXml(ArrayList<Grad> gradovi){
        UN claniceUN = new UN();
        Document xmldoc = null;
        try {
            DocumentBuilder docReader
                    = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            xmldoc = docReader.parse(new File("proba.xml"));
        } catch (Exception e) {
            System.out.println("drzave.xml nije validan XML dokument");
            return null;
        }
        NodeList djeca = xmldoc.getChildNodes();
        for(int i = 0; i < djeca.getLength(); i++) {
            Node dijete = djeca.item(i);

            if (dijete instanceof Element) {
                Element e = (Element) dijete;
                NodeList djecaDrzave = e.getChildNodes();
                for(int j = 0; i < djecaDrzave.getLength(); i++) {
                    Node dijeteDrzave = djecaDrzave.item(i);
                    if(dijeteDrzave instanceof Element){
                        if(((Element)dijeteDrzave).getTagName() =="naziv")
                         dijeteDrzave.getTextContent();
                    }
                }

            }
        }


        return claniceUN;
    }

    public static void main(String[] args) {

            }
    }