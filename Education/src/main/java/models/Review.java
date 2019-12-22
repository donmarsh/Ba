package models;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Review implements Comparable<Review> {
    private String content;
    private String writtenby;
    private int rating;
    private int id;
    private int noteid; //will be used to connect Restaurant to Review (one-to-many)
    private long createdat;
    private String formattedCreatedAt;

    public Review(String content, String writtenby, int rating, int noteid) {
        this.content = content;
        this.writtenby = writtenby;
        this.rating = rating;
        this.noteid = noteid;
        this.createdat = System.currentTimeMillis();
        setFormattedCreatedAt(); //we'll make me in a minute
    }

    public String getContent() {
        return content;
    }

    public String getWrittenBy() {
        return writtenby;
    }

    public int getRating() {
        return rating;
    }

    public long getCreatedat() {
      return createdat;
    }

    public String getFormattedCreatedAt(){
      Date date = new Date(createdat);
      String datePatternToUse = "MM/dd/yyyy @ K:mm a"; //see https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
      SimpleDateFormat sdf = new SimpleDateFormat(datePatternToUse);
      return sdf.format(date);
    }

    public int getId() {
        return id;
    }

    public int getNoteId() {
        return noteid;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setWrittenBy(String writtenby) {
        this.writtenby = writtenby;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setCreatedat() {
      this.createdat = System.currentTimeMillis(); // It'll become clear soon why we need this explicit setter
    }

    public void setFormattedCreatedAt(){
      Date date = new Date(this.createdat);
      String datePatternToUse = "MM/dd/yyyy @ K:mm a";
      SimpleDateFormat sdf = new SimpleDateFormat(datePatternToUse);
      this.formattedCreatedAt = sdf.format(date);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNoteId(int noteid) {
        this.noteid = noteid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Review)) return false;
        Review review = (Review) o;
        return rating == review.rating &&
                id == review.id &&
                noteid == review.noteid &&
                Objects.equals(content, review.content) &&
                Objects.equals(writtenby, review.writtenby);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, writtenby, rating, id, noteid);
    }

    @Override
    public int compareTo(Review reviewObject) {
      if (this.createdat < reviewObject.createdat)
      {
        return -1; //this object was made earlier than the second object.
      }
      else if (this.createdat > reviewObject.createdat){ //this object was made later than the second object
        return 1;
      }
      else {
        return 0; //they were made at the same time, which is very unlikely, but mathematically not impossible.
      }
    }
}
