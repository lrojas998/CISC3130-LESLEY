/*

Lesley Rojas
Assignment 3: Movie Titles

*/

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.TreeSet;
import java.util.Set;

public class main {

  public static void main (String [] args) {

    movieBST movies = new movieBST();

    String file = "../data/movies.csv"; //relative filename path

    BufferedReader br = null;

    int i = 0;

    String[] readData = null;

    String line = "";

    try {
      br = new BufferedReader(new FileReader(file));
      int counter = 0;
      br.readLine(); //skip column titles

   while ((line = br.readLine()) != null) {

     readData = line.split(",");
     readData[1] = readData[1].replaceAll("^\"|\"$", ""); //removes double quoation marks

     int year = getYear(readData[1]); //gets year
     readData[1] = cleanString(readData[1]); //removes year

     movies.insert(readData[1], year);//inserts to bst
   }
} catch (FileNotFoundException e) {
  e.printStackTrace();
} catch (IOException e) {
  e.printStackTrace();
} finally {
  if (br != null) {
      try {
          br.close();
      } catch (IOException e) {
          e.printStackTrace();
      }
    }
  }

    Set<String> setA = movies.subSet("Above the Rim", "Absolutely Anything");

    System.out.print(setA);

  }

  public static String cleanString(String title) {

    String newString = title;

    if(newString.charAt(newString.length()-1) == ')') {

        newString = newString.substring(0, newString.length()-6);

        }

        return newString;
    }

  public static int getYear(String title) {
    int year = 0;

    if(title.charAt(title.length()-1) == ')') {
      int exponent = 1;

        for(int i = 2; i <= 5; i++) { //a date has 5 digits

          char digit = title.charAt(title.length()-i);
           year += Character.getNumericValue(digit) * exponent;
           exponent *= 10;

        }

    }

    return year;
  }

}
