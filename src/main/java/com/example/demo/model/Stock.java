package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity

public class Stock{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  @Column(unique=true)
  private String ticker;
  private String companyName;
  private String sector;
  private Boolean active = true ;



public Long getId(){
  return id;
}
public void setId(Long id){
  this.id=id;
}
public String getTicker(){
  return ticker;
}
public void setTicker(String ticker){
  this.ticker=ticker;
}
public String getCompanyName(){
  return companyName;
}
public void setCompanyName(String companyName){
  this.companyName=companyName;
}
public String getSector(){
  return sector;
}
public void setSector(String sector){
  this.sector=sector;
}
public Boolean getActive(){
  return active;
}
public void setActive(Boolean active){
  this.active=active;
}
public Stock(Long id , String ticker, String companyName, String sector, Boolean active){
 this.id=id;
 this.ticker=ticker;
 this.companyName=companyName;
 this.sector=sector;
 this.active=active;
}
public Stock(){

}

}