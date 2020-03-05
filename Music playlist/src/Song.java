public class Song {

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

  public String getTrack() {
    return track;
  }

  public Song getNext() {
    return next;
  }

  public void setNext(Song next) {
    this.next = next;
  }

  public String toString() {
    return "" + this.track;
  }
}
