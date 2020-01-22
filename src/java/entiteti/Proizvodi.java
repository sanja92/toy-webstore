package entiteti;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="proizvodi"
    ,catalog="webprodavnica"
)
public class Proizvodi  implements java.io.Serializable {


     private Integer proizvodiId;
     private String nazivProizvoda;
     private double cena;
     private int kolicina;
     private String img;
     private Set<Kupci> kupcis = new HashSet<>(0);

    public Proizvodi() {
    }

	
    public Proizvodi(String nazivProizvoda, double cena, int kolicina, String img) {
        this.nazivProizvoda = nazivProizvoda;
        this.cena = cena;
        this.kolicina = kolicina;
    }
    public Proizvodi(String nazivProizvoda, double cena, int kolicina, Set<Kupci> kupcis) {
       this.nazivProizvoda = nazivProizvoda;
       this.cena = cena;
       this.kolicina = kolicina;
       this.kupcis = kupcis;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="proizvodi_id", unique=true, nullable=false)
    public Integer getProizvodiId() {
        return this.proizvodiId;
    }
    
    public void setProizvodiId(Integer proizvodiId) {
        this.proizvodiId = proizvodiId;
    }

    
    @Column(name="naziv_proizvoda", nullable=false, length=45)
    public String getNazivProizvoda() {
        return this.nazivProizvoda;
    }
    
    public void setNazivProizvoda(String nazivProizvoda) {
        this.nazivProizvoda = nazivProizvoda;
    }
    
    @Column(name="img", nullable=false)
    public String getImg() {
        return this.img;
    }
    
    public void setImg(String img) {
        this.img = img;
    }

    
    @Column(name="cena", nullable=false, precision=22, scale=0)
    public double getCena() {
        return this.cena;
    }
    
    public void setCena(double cena) {
        this.cena = cena;
    }

    
    @Column(name="kolicina", nullable=false)
    public int getKolicina() {
        return this.kolicina;
    }
    
    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

@ManyToMany(fetch=FetchType.EAGER, mappedBy="proizvodis")
    public Set<Kupci> getKupcis() {
        return this.kupcis;
    }
    
    public void setKupcis(Set<Kupci> kupcis) {
        this.kupcis = kupcis;
    }




}


