
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
public class stock{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  @Column(unique=true)
  private String ticker;
  private String companyName;
  private String sector;
  private Boolean active;


}
public Long getid(){
  return id;
}
public Long setid(Long id){
  this.id=id;
}
public String getticker(){
  return ticker;
}
public String setticker(String ticker){
  this.ticker=ticker;
}
public String getcompanyName(){
  return companyName;
}
public String setcompanyName(String companyName){
  this.companyName=companyName;
}
public String getsector(){
  return sector;
}
public String setsector(String sector){
  this.sector=sector;
}
public Boolean getactive(){
  return active;
}
public Boolean setactive(Boolean active){
  this.active=active;
}


