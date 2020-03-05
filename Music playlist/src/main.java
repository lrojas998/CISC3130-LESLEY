//Lesley Rojas
//hw 2

import java.util.ArrayList;

public class main {
  public static void main(String [] args) {

    String[] fileNames = {"../data/week1.csv","../data/week2.csv"};

    ArrayList<MyQueue> weeklySongs = new ArrayList<>();

    for(int i = 0; i < fileNames.length; i++ ) {
      weeklySongs.add(new MyQueue());

      weeklySongs.get(i).convert(fileNames[i]);
      weeklySongs.get(i).sort();
    }

    //Print out the lists individually
    //System.out.println(weeklySongs.get(0));
    //System.out.println(weeklySongs.get(1));

    //Print out the lists in a loop
    for(int i = 0; i < weeklySongs.size(); i++) {
      System.out.println("\n\n\t\tLIST OF WEEK NUMBER " + (i+1) + "\t\t\n\n");
      System.out.println(weeklySongs.get(i));
    }



    //Creates new Queue with combination of other 2
    System.out.println("\n\n\t\tMERGED QUEUE " + "\t\t\n\n");
    weeklySongs.add(new MyQueue());
    weeklySongs.set(2, weeklySongs.get(2).mergingFunction(weeklySongs.get(0), weeklySongs.get(1)) );

    System.out.println(weeklySongs.get(2));


    //PLAYLIST

    Playlist playlist1 = new Playlist();
    SongHistoryList historyList1 = new SongHistoryList();

    playlist1.addSong("song 1");
    playlist1.addSong("song 2");
    playlist1.addSong("song 3");

    System.out.println(playlist1);

    for(int i = 0; i < 3; i++) {

             System.out.println("\nListening to: " + playlist1.getFirst() + "");

             historyList1.addSong(playlist1.listenToSong());

             System.out.println("Last Song Listened: " +historyList1.getFirst());
    }

    System.out.println("\n");
    System.out.println(historyList1);






  }
}
