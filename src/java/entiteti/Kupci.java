package entiteti;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "kupci",
         catalog = "webprodavnica"
)
public class Kupci implements java.io.Serializable {

    private Integer kupciId;
    private String ime;
    private String e_mail;
    private String adresa;
    private String password;
    private Set<Proizvodi> proizvodis = new HashSet<>(0);

    public Kupci() {
    }

    public Kupci(String ime, String e_mail, String adresa, String password) {
        this.ime = ime;
        this.e_mail = e_mail;
        this.adresa = adresa;
        this.password = password;
    }

    public Kupci(String ime, String e_mail, String adresa, String password, Set<Proizvodi> proizvodis) {
        this.ime = ime;
        this.e_mail = e_mail;
        this.adresa = adresa;
        this.password = password;
        this.proizvodis = proizvodis;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "kupci_id", unique = true, nullable = false)
    public Integer getKupciId() {
        return this.kupciId;
    }

    public void setKupciId(Integer kupciId) {
        this.kupciId = kupciId;
    }
    
    @Column(name = "ime", nullable = false, length = 50)
    public String getIme() {
        return this.ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    @Column(name = "e_mail", nullable = false, length = 50)
    public String getE_mail() {
        return this.e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    @Column(name = "adresa", nullable = false, length = 50)
    public String getAdresa() {
        return this.adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Column(name = "password", nullable = false, length = 50)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "prodaja", catalog = "webprodavnica", joinColumns = {
        @JoinColumn(name = "kupci_id", nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "proizvodi_id", nullable = false, updatable = false)})
    public Set<Proizvodi> getProizvodis() {
        return this.proizvodis;
    }

    public void setProizvodis(Set<Proizvodi> proizvodis) {
        this.proizvodis = proizvodis;
    }

}
