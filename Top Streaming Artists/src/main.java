//Lesley Rojas


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        BufferedReader br = null;
        String[][] mylist = new String[203][4]; //dimensions of file

        //Read data from csv file
        try {

            int i = 0;
            String[] readData = null;

            String line = "";

            br = new BufferedReader(new FileReader("./data/music_file.csv"));

            while ((line = br.readLine()) != null) {

                // use comma as separator
                readData = line.split(",");
                mylist[i][0] = readData[0];
                mylist[i][1] = readData[1];
                mylist[i][2] = readData[2];
                mylist[i][3] = readData[3];
                  i++;
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

        //Count number of artist occurrances
        String[][] tmp = new String[202][2];

        for(int x = 2;x< mylist.length - 1 ;x++ )
        {

          int count = 0;

            for (int j = 2;j < mylist.length ;j++ )
            {

                if(mylist[x][2].equals(mylist[j][2]))
                {
                  count++;
                }

            }
         tmp[x][0] = mylist[x][2];
         tmp[x][1] = String.valueOf(count);
       }

       ///WRITE ARTISTS AND TOTAL AMOUNT OF APPEARANCES

        try {
          FileWriter myWriter = new FileWriter("artistAppearance.txt");
          myWriter.write("ARTIST, TOTAL #");



          for(int k = 2; k < tmp.length - 1; k++) {
            Scanner scan = new Scanner (new File("artistAppearance.txt"));
            boolean flag = false;

            while( scan.hasNextLine() ) {

              String line = scan.nextLine();
              if(line.contains(tmp[k][0]))
                flag = true;

            }

            if(!flag) {
              myWriter.write("\n" + tmp[k][0]+", " + tmp[k][1]);

              myWriter.flush();
            }

          }

          myWriter.close();

        } catch (IOException e) {
          e.printStackTrace();
        }


        //add to linked list
        TopStreamingArtists artistNames = new TopStreamingArtists();

        String ln = "";
        String[] readData2 = null;

        try {
        Scanner scan = new Scanner (new File("artistAppearance.txt"));

        while( scan.hasNextLine() ) {

          ln = scan.nextLine();
          readData2 = ln.split(",");
          artistNames.insert(readData2[0]);
        }

        artistNames.displayList();
      } catch (FileNotFoundException e) {
        //
      }
    }

}

/* A node represents an artist */
 class Artist {
    private String name;
    private Artist next;
    public Artist(){
     name = null;
     next = null;
   }
   public Artist(String n) {
     name = n;
     next = null;
   }

   public String getName(){
     return name;
   }
   public Artist getNext(){
     return next;
   }

   public void setNext( Artist n){
   next = n;
 }
 }

/* The List TopStreamingArtists is composed of a series of artist names */
 class TopStreamingArtists {
    private Artist first;
    public void TopStreamingArtists(){
      first = null;
    }
    public boolean isEmpty(){
     return (first == null);
    }

    public void insert(String s) {

      if(isEmpty()) {
        first = new Artist(s);
      } else {
        Artist dummy = first;

        while(dummy.getNext() != null) {
          dummy = dummy.getNext();
        }

        dummy.setNext(new Artist(s));

      }

    }

    public void displayList() {
      if(isEmpty()) {
        System.out.println("EMPTY LIST");
      } else {

        Artist dummy = first;

        while(dummy != null) {
          System.out.println(dummy.getName());
          dummy = dummy.getNext();
        }
      }
    }
 }
