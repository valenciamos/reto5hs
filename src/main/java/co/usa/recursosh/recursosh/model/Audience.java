package co.usa.recursosh.recursosh.model;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "audience")


public class Audience implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * id auditorio
     */
    private Integer id; 
    /**
     * nombre del auditorio
     */
    private String name;
    /**
     * dueño del auditorio
     */
    private String owner; 
   /**
     * capacidad del auditorio
     */
    private Integer capacity; 
    /**
     * descripcion del auditorio
     */
    private String description; 
    /**
     * relaciones
     */
    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("audiences")
    private Category category; 

    @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "audience")
    @JsonIgnoreProperties({ "audience", "client" })
    private List<Message> messages; 

    @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "audience")
    @JsonIgnoreProperties({ "audience", "client" })
    private List<Reservation> reservations;

    /**
     * metodos
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    
}
