package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;

@Entity
public class userportfolio{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  private Long userId;
  @Column(unique=true)
  private String portfolioName;
  @PrePersist
  private Timestamp createdAt;
  private Timestamp updatedAt;
  private Boolean active;

  public Long getid(){
  return id;
}
public void setid(Long id){
  this.id=id;
}
public String getuserId(){
  return userId;
}
public void setuserId(String userId){
  this.userId=userId;
}
public String getportfolioName(){
  return portfolioName;
}
public void setportfolioName(String portfolioName){
  this.portfolioName=portfolioName;
}
public String getcreatedAt(){
  return createdAt;
}
public void setcreatedAt(String createdAt){
  this.createdAt=createdAt;
}
public Boolean getupdatedAt(){
  return updatedAt;
}
public void setupdatedAt(Boolean updatedAt){
  this.updatedAt=updatedAt;
}
public Boolean getactive(){
  return active;
}
public void setactive(Boolean active){
  this.active=active;
}
public stock(Long id ,Long userId , String portfolioName, Timestamp createdAt , Timestamp updatedAt ,  Boolean active){
 this.id=id;
 this.userId=userId;
 this.portfolioName=portfolioName;
 this.createdAt=createdAt;
  this.updatedAt=updatedAt;
 this.active=active;
}
public userportfolio(){

}


}