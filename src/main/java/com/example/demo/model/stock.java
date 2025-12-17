
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
public class stock{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private long id;
  @column(unique=true)
  private String ticker;
  private String companyName;
  private String sector;
  private boolean active;
}