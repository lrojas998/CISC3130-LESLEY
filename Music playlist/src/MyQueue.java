import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;

public class MyQueue {

  LinkedList queue;

  public MyQueue() {
    queue = new LinkedList();
  }

  @SuppressWarnings("unchecked")
  public void convert(String file) {

    BufferedReader br = null;

    int i = 0;
    String[] readData = null;

    String line = "";

    try {
       br = new BufferedReader(new FileReader(file));
       int counter = 0;
       br.readLine();
       br.readLine();
      while ((line = br.readLine()) != null) {
        readData = line.split(",");
        readData[1] = readData[1].replaceAll("^\"|\"$", ""); //removes double quoation marks
        enqueue(readData[1]);
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
   }

//merges two queues no duplicates
  public MyQueue mergingFunction(MyQueue q1, MyQueue q2) {
    String element = "";
    MyQueue newQueue = new MyQueue();
    while( !(q1.isEmpty() && q2.isEmpty()) ) {

      if(!q1.isEmpty()) {
        element = q1.dequeue();
          if(!newQueue.findElement(element))
            newQueue.enqueue(element);
      }

      if(!q2.isEmpty()) {
        element = q2.dequeue();
          if(!newQueue.findElement(element))
            newQueue.enqueue(element);
      }

    }

    return newQueue;

  }

  public void sort() {
    queue.sortList();
  }

  //finds if string exists in queue already
  public boolean findElement(String e) {
    return queue.findElement(e);
  }

  public String dequeue() {
    return queue.removeFirst();
  }

  public void enqueue(String data) {
    queue.addLast(data);
  }

  public boolean isEmpty() {
		return queue.isEmpty();
	}

  public String toString() {
    return queue.toString();
  }
}
