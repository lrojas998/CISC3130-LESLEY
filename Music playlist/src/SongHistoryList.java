public class SongHistoryList  {

  private Song first, last;
  private int size;

  public void SongHistoryList () {
    this.first = null;
		this.last = first;
		this.size = 0;
  }

  public Song getFirst() {
    return this.first;
  }

  //addFront()
  public void addSong(Song s) {
    if(this.size == 0) {
      this.first = new Song(s.getTrack());
      this.last = first;
      this.size++;
    } else {
      Song newNode = new Song(s.getTrack());
      newNode.setNext(this.first);
      this.last = this.first;

      this.first = newNode;
      this.size++;
    }
  }

  //removeFront()
  public Song lastListened() {
    if (this.size == 0) {
      System.out.println("Empty Song History");
      return null;
    }

    Song current = this.first;

    this.first = this.first.getNext();
    this.size--;

    return current;
  }

  public String toString() {

		if (this.size == 0) return "[EMPTY SONG HISTORY]";

		StringBuilder sb = new StringBuilder();
		sb.append("Song History:[");

		Song current = this.first;

		while(current.getNext() != null) {
			sb.append(String.format("%s --> ", current.getTrack()));
			current = current.getNext();
		}
		sb.append(String.format("%s --> END]", current.getTrack()));

		return sb.toString();
	}

}
