/*

Lesley Rojas
Assignment 4: Movie Genres

*/

import java.io.*;
import java.util.*;

public class main {
  public static void main (String [] args) {

    HashMap<String, List<String>> map = new HashMap<>();

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

     readData = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
     readData[1] = readData[1].replaceAll("^\"|\"$", ""); //removes double quoation marks

     insertData(map, readData[1], readData[2]);
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

    displayData(map);


  }

  //inserts data into hashmap, (KEY: genre, VALUE: List of Movies)
  public static void insertData(HashMap<String, List<String>> map, String title, String genre) {

    String[] genreData = null;
    genreData = genre.split("\\|");

    for(int i = 0; i < genreData.length; i++) {
      if(!map.containsKey(genreData[i])) {
        map.put(genreData[i], new ArrayList<String>());
        map.get(genreData[i]).add(title);
      } else {
        map.get(genreData[i]).add(title);
      }
    }
  }

  public static void displayData(HashMap<String, List<String>> map) {
    int oldest_year = 2020;//will store oldest movie
    for (Map.Entry<String, List<String>> mapElement : map.entrySet()) {

      List<String> totalMovies = new ArrayList<>();
      totalMovies =  mapElement.getValue();

      int fiveyear_size = totalMovies.size();

      //finds amount of movies per genre in last 5 years
      for(int x = 0; x < totalMovies.size(); x++) {
        int year = getYear(totalMovies.get(x));

        if(year < 2020-5)
          fiveyear_size--;
        if(year != 0 && year < oldest_year) //find oldest movie
          oldest_year = year;

      }
      System.out.println("\n" + mapElement.getKey());
      System.out.println("TOTAL AMOUNT: " + totalMovies.size());
      System.out.println("LAST 5 YR AMOUNT: " + fiveyear_size);
    }

    //prints total amount of movies for categories per year
    for(int curr_year = oldest_year; curr_year <= 2020; curr_year++) {
      System.out.println("\n\nYEAR: " + curr_year);
      for (Map.Entry<String, List<String>> mapElement : map.entrySet()) {

        List<String> totalMovies = new ArrayList<>();
        totalMovies =  mapElement.getValue();


        int curr_size = totalMovies.size();

        for(int x = 0; x < totalMovies.size(); x++) {
          int year = getYear(totalMovies.get(x));

          if(year != curr_year)
            curr_size--;

        }
      System.out.println(mapElement.getKey() + ": " + curr_size);
      }
    }
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

  public static void insertData(HashMap<String, List<String>> map, String title, String genre) {

    String[] genreData = null;
    genreData = genre.split("\\|");

    for(int i = 0; i < genreData.length; i++) {
      if(!map.containsKey(genreData[i])) {
        map.put(genreData[i], new ArrayList<String>());
        map.get(genreData[i]).add(title);
      } else {
        map.get(genreData[i]).add(title);
      }
    }
  }
}
