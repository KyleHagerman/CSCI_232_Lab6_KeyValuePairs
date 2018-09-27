
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Author: Kyle Hagerman
 * Date: 3/23/2018
 * Overview: Reads a CSV file and generates a Hash Table. This example used for Star Wars Planets
 * Put the CSV file in the input and specify it's title in the main method to run
 * Sources: Mkyong.com
 */
public class main {
    static Charset charset = Charset.forName("US-ASCII");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        // Instantiate Array Class
        Array starWarsPlanets = new Array();
        
        // Instantiate KVPair Class for each CSV from input file
        final Path IN_PATH = FileSystems.getDefault().getPath("input", "StarWarsPlanets.csv");
            BufferedReader in = Files.newBufferedReader(IN_PATH, charset);
            String keyValuePair = null;
            while((keyValuePair = in.readLine()) != null){
                String[] numAndPlanet = keyValuePair.split(",");
                KVPair kvp = new KVPair(Integer.valueOf(numAndPlanet[0]), numAndPlanet[1]);
                starWarsPlanets.insert(kvp);
            }
            starWarsPlanets.printHash();
        
        // Add each CSV with insert method
        // The insert method will call other fxns as needed such as re-hash, collision, an array doubling method
    }
    
}
