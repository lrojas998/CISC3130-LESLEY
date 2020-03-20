/*

Lesley Rojas
Assignment 3: Movie Titles

*/
import java.util.TreeSet;
import java.util.Set;

public class movieBST {

  public movieNode root;

  public movieBST() {
    root = null;
  }

  public void insert(String title, int releaseYear){

  movieNode newNode = new movieNode(title, releaseYear);

  if(root==null){

    root = newNode;
    return;

  }

  movieNode current = root;
  movieNode parent = null;

  while(true){

    parent = current;

    if( title.compareToIgnoreCase(current.getTitle()) < 0) { //title < current title

      current = current.getLeft();

      if(current==null){

        parent.setLeft(newNode);
        return;

      }

    }else {

      current = current.getRight(); //title > current title

      if(current==null){

        parent.setRight(newNode);
        return;

      }
    }
  }
}

public Set<String> subSet(String k1, String k2) {

  movieNode tmp = root;

  Set<String> setA = new TreeSet<String>();

  getSubSet(tmp, k1, k2, setA);

  setA.add(k2); //inserts last item

  return setA;

}

public void getSubSet(movieNode node, String k1, String k2, Set<String> setA) {

     if (node == null) {
         return;
     }

     if (k1.compareToIgnoreCase(node.getTitle()) < 0 ) {
         getSubSet(node.getLeft(), k1, k2, setA);
     }

     if (  (k1.compareToIgnoreCase(node.getTitle()) <= 0) && (k2.compareToIgnoreCase(node.getTitle()) >= 0)   ) {

         setA.add(node.getTitle());
         //System.out.println(node.getTitle() + " ");

     }

     if (k2.compareToIgnoreCase(node.getTitle()) > 0) {
         getSubSet(node.getRight(), k1, k2, setA);
     }
 }

public String toString() {

  String tmp = "\nEND";

  display(root);

  return tmp;
}

public void display(movieNode root){

		if(root!=null){

			display(root.getLeft());

      System.out.println(" " + root.getTitle());

      display(root.getRight());
		}
	}

}
