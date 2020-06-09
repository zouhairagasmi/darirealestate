package tn.esprit.spring.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.istack.NotNull;

@Entity
@Table(name="House")
public class House {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idHouse;
	
	@OneToMany
	private List<Visits> visits = new ArrayList<>();
	
	@ManyToOne
	private User owner;
	
	private Double price;
	
	@Temporal(TemporalType.DATE)
	private Date dateVisitDebut;
	
	@Temporal(TemporalType.DATE)
	private Date dateVisitFin;
	
	@NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Lob
    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "building_type")
    private BuildingType buildingType;

    @Enumerated(EnumType.STRING)
    @Column(name = "service_type")
    private ServiceType serviceType;

    @Column(name = "ref", nullable = false)
    private String ref;

    @Column(name = "visible")
    private Boolean visible;

    @Column(name = "sold")
    private Boolean sold;

    @Column(name = "terrace")
    private Boolean terrace;

    @Column(name = "number_bedroom")
    private Integer numberBedroom;

    @Column(name = "elevator")
    private Boolean elevator;

    @Column(name = "furnished")
    private Boolean furnished;

    @Column(name = "pool")
    private Boolean pool;

    @Column(name = "garage")
    private Boolean garage;

    @Column(name = "number_wc")
    private Integer numberWc;

    @Column(name = "ac")
    private Boolean ac;

    @Column(name = "created")
	public LocalDate created;

    @Column(name = "neartransport")
    private Boolean neartransport;

    @Column(name = "office")
    private Boolean office;

    @Column(name = "storage")
    private Boolean storage;

    @Column(name = "heating")
    private Boolean heating;
    
    @Column(name = "video")
    private String video;
    
    @OneToMany(mappedBy="property")
	private List<Vues> Vues;
    
    @OneToMany(mappedBy="property")
   	private List<DBFile> dBFile;
    
    @OneToOne
    @JoinColumn(unique = true)
    private Location location;


    @OneToMany(mappedBy = "property")
    private Set<DBFile> DBFile = new HashSet<>();
	
	public House() {
		super();
		// TODO Auto-generated constructor stub
	}

	public House(Long idhouse, User user, Double prices,Date dateDebut, Date dateFin) {
		super();
		idHouse = idhouse;
		owner = user;
		this.price = prices;
		dateVisitDebut = dateDebut;
		dateVisitFin = dateFin;
	}

	public Long getIdHouse() {
		return idHouse;
	}
	public void setIdHouse(Long idhouse) {
		idHouse = idhouse;
	}
	
	public List<Visits> getVisits() {
		return visits;
	}
	public void setVisits(List<Visits> visitss) {
		visits = visitss;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User user) {
		owner = user;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Temporal(TemporalType.DATE)
	public Date getDateVisitDebut() {
		return dateVisitDebut;
	}
	public void setDateVisitDebut(Date dateDebut) {
		dateVisitDebut = dateDebut;
	}
	@Temporal(TemporalType.DATE)
	public Date getDateVisitFin() {
		return dateVisitFin;
	}
	public void setDateVisitFin(Date dateFin) {
		dateVisitFin = dateFin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BuildingType getBuildingType() {
		return buildingType;
	}

	public void setBuildingType(BuildingType buildingType) {
		this.buildingType = buildingType;
	}

	public ServiceType getServiceType() {
		return serviceType;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public Boolean getSold() {
		return sold;
	}

	public void setSold(Boolean sold) {
		this.sold = sold;
	}

	public Boolean getTerrace() {
		return terrace;
	}

	public void setTerrace(Boolean terrace) {
		this.terrace = terrace;
	}

	public Integer getNumberBedroom() {
		return numberBedroom;
	}

	public void setNumberBedroom(Integer numberBedroom) {
		this.numberBedroom = numberBedroom;
	}

	public Boolean getElevator() {
		return elevator;
	}

	public void setElevator(Boolean elevator) {
		this.elevator = elevator;
	}

	public Boolean getFurnished() {
		return furnished;
	}

	public void setFurnished(Boolean furnished) {
		this.furnished = furnished;
	}

	public Boolean getPool() {
		return pool;
	}

	public void setPool(Boolean pool) {
		this.pool = pool;
	}

	public Boolean getGarage() {
		return garage;
	}

	public void setGarage(Boolean garage) {
		this.garage = garage;
	}

	public Integer getNumberWc() {
		return numberWc;
	}

	public void setNumberWc(Integer numberWc) {
		this.numberWc = numberWc;
	}

	public Boolean getAc() {
		return ac;
	}

	public void setAc(Boolean ac) {
		this.ac = ac;
	}

	public LocalDate getCreated() {
		return created;
	}

	public void setCreated(LocalDate created) {
		this.created = created;
	}

	public Boolean getNeartransport() {
		return neartransport;
	}

	public void setNeartransport(Boolean neartransport) {
		this.neartransport = neartransport;
	}

	public Boolean getOffice() {
		return office;
	}

	public void setOffice(Boolean office) {
		this.office = office;
	}

	public Boolean getStorage() {
		return storage;
	}

	public void setStorage(Boolean storage) {
		this.storage = storage;
	}

	public Boolean getHeating() {
		return heating;
	}

	public void setHeating(Boolean heating) {
		this.heating = heating;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public List<Vues> getVues() {
		return Vues;
	}

	public void setVues(List<Vues> vues) {
		Vues = vues;
	}

	public List<DBFile> getdBFile() {
		return dBFile;
	}

	public void setdBFile(List<DBFile> dBFile) {
		this.dBFile = dBFile;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Set<DBFile> getDBFile() {
		return DBFile;
	}

	public void setDBFile(Set<DBFile> dBFile) {
		DBFile = dBFile;
	}
	
}
