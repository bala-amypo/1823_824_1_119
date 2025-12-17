
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
  private boolean active;


}
public long getid(){
  return id;
}
public long setid(Long id){
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
public String setcompanyName(){
  this.companyName=companyName;
}
public 