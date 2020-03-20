/*

Lesley Rojas
Assignment 3: Movie Titles

*/

public class movieNode {
  private String title;
  private int releaseYear;

  private movieNode left;
  private movieNode right;

  public movieNode() {

    title = "";
    releaseYear = 0;
    left = null;
    right = null;

  }

  public movieNode(String title, int releaseYear) {

    this.title = title;
    this.releaseYear = releaseYear;
    left = null;
    right = null;

  }

  public String getTitle() {

    return title;

  }

  public int getReleaseYear() {

    return releaseYear;

  }

  public void setLeft(movieNode left) {

    this.left = left;

  }

  public void setRight(movieNode right) {

    this.right = right;

  }

  public movieNode getLeft() {

    return left;

  }

  public movieNode getRight() {

    return right;

  }

}
