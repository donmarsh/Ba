package models;
import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;
import java.util.Objects;


public class Content {
  private int id;
  private String wordLink;
  private String powerpointLink;
  private String pdfLink;

  public Content(String wordLink, String powerpointLink, String pdfLink){
    this.wordLink = wordLink;
    this.powerpointLink = powerpointLink;
    this.pdfLink = pdfLink;
  }

   public String getPowerpointLink() {
     return powerpointLink;
   }

   public String getPdfLink() {
     return pdfLink;
   }

   public String getWordLink() {
     return wordLink;
   }

   public int getId() {
      return this.id = id;
   }

   public void setPowerpointLink(String powerpointLink) {
     this.powerpointLink = powerpointLink;
   }

   public void setPdfLink(String pdfLink) {
     this.pdfLink = pdfLink;
   }

   public void setWordLink(String wordLink) {
     this.wordLink = wordLink;
   }

   public void setId(int id) {
       this.id = id;
   }

   @Override
   public boolean equals(Object otherContent){
     if (!(otherContent instanceof Content)) {
       return false;
     } else {
       Content newContent = (Content) otherContent;
       return this.getPdfLink().equals(newContent.getPdfLink()) &&
       this.getId() == newContent.getId();
     }
   }
 }
