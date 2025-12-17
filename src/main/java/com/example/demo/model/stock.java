package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
@Table(
  name = ""
)
public class stock{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  @Column(unique=true)
  private String ticker;
  private String companyName;
  private String sector;
  private Boolean active;



public Long getid(){
  return id;
}
public void setid(Long id){
  this.id=id;
}
public String getticker(){
  return ticker;
}
public void setticker(String ticker){
  this.ticker=ticker;
}
public String getcompanyName(){
  return companyName;
}
public void setcompanyName(String companyName){
  this.companyName=companyName;
}
public String getsector(){
  return sector;
}
public void setsector(String sector){
  this.sector=sector;
}
public Boolean getactive(){
  return active;
}
public void setactive(Boolean active){
  this.active=active;
}
public stock(Long id , String ticker, String companyName, String sector, Boolean active){
 this.id=id;
 this.ticker=ticker;
 this.companyName=companyName;
 this.sector=sector;
 this.active=active;
}
public stock(){

}

}