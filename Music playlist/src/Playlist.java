public class Playlist {

  private Song first, last;
  private int size;

  public void Playlist() {
    this.first = null;
		this.last = first;
		this.size = 0;
  }

  public int getSize() {
    return this.size;
  }

  public Song getFirst() {
    return this.first;
  }

  //addFront()
  public void addSong(String s) {
    if(this.size == 0) {
      this.first = new Song(s);
      this.last = first;
      this.size++;
    } else {
      Song newNode = new Song(s);
      newNode.setNext(this.first);
      this.last = this.first;

      this.first = newNode;
      this.size++;
    }
  }

  //removeFront()
  public Song listenToSong() {
    if (this.size == 0) {
      System.out.println("Empty playlist");
      return null;
    }

    Song current = this.first;
    this.first = this.first.getNext();

    this.size--;

    return current;
  }

  public String toString() {

		if (this.size == 0) return "[EMPTY PLAYLIST]";

		StringBuilder sb = new StringBuilder();
		sb.append("Playlist:[");

		Song current = this.first;

		while(current.getNext() != null) {
			sb.append(String.format("%s --> ", current.getTrack()));
			current = current.getNext();
		}
		sb.append(String.format("%s --> END]", current.getTrack()));

		return sb.toString();
	}

}
