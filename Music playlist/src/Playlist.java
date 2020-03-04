public class Playlist {

  private static class Song {

    private String track;
    private Song next;
    public Song(String track) {
      this.track = track;
      this.next = null;
    }

    public Song(String track, Song next) {
      this.track = track;
      this.next = next;
    }

    public void setNext(Song next) {
      this.next = next;
    }
  }

  private Song first, last;
  private int size;

  public void Playlist() {
    this.first = null;
		this.last = first;
		this.size = 0;
  }

  public void addSong(String s) {
    if(this.size == 0) {
      this.first = new Song(s);
      this.last = first;
      this.size++;
    } else {
      this.last.setNext(new Song(s));
      this.last = this.last.next;
      this.size++;
    }
  }

  public String listenToSong() {
    if (this.size == 0) {
      System.out.println("Empty playlist");
      return null;
    }

    String track = this.first.track;
    this.first = this.first.next;
    this.size--;

    return track;
  }

  public String toString() {

		if (this.size == 0) return "[EMPTY PLAYLIST]";

		StringBuilder sb = new StringBuilder();
		sb.append("Playlist:[");

		Song current = this.first;

		while(current.next != null) {
			sb.append(String.format("%s --> ", current.track));
			current = current.next;
		}
		sb.append(String.format("%s --> END]", current.track));

		return sb.toString();
	}

}
