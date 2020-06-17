package tn.esprit.spring.entity;

import javax.persistence.*;



import javax.validation.constraints.NotNull;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * A Property.
 */

@Entity
@Table(name = "property")
public class Property implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private Double price;

	@Lob
	@Column(name = "description")
	private String description;

	@Enumerated(EnumType.STRING)
	@Column(name = "building_type")
	private BuildingType buildingType;

	@Enumerated(EnumType.STRING)
	@Column(name = "service_type")
	private ServiceType serviceType;

	@Column(name = "ref")
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
	public Date createdDate;

	@Column(name = "neartransport")
	private Boolean neartransport;

	@Column(name = "office")
	private Boolean office;

	@Column(name = "storage")
	private Boolean storage;

	@Column(name = "heating")
	private Boolean heating;

	@Column(name = "photo")
	private String photo;

	@NotNull
	@Column(name = "province")
	private String province;

	@NotNull
	@Column(name = "town")
	private String town;

	@Column(name = "latitude")
	private Double latitude;

	@Column(name = "longitude")
	private Double longitude;


	@ManyToOne
	private User user;

	
	@OneToMany(mappedBy = "property", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Favorits> favorits;

	
	@OneToMany(mappedBy = "property", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Reservation> reservation;
	
	@OneToMany
	private List<Visits> visits = new ArrayList<>();
	
	
	 public Property(String name, Double price, BuildingType buildingType, ServiceType serviceType,
				String description, Integer numberBedroom, Integer numberWc, Boolean furnished
				, Boolean garage,Date createdDate, 
				String province, String town, Double latitude, Double longitude) {
			super();
			this.name = name;
			this.price = price;
			this.buildingType = buildingType;
			this.serviceType = serviceType;
			this.description = description;
			this.numberBedroom = numberBedroom;
			this.numberWc = numberWc;
			this.furnished = furnished;
			this.garage = garage;
			this.createdDate=createdDate;
			this.province = province;
			this.town = town;
			this.latitude = latitude;
			this.longitude = longitude;
		}
	    
		public Property(Long propertyIdToBeUpdated, String name, Double price, BuildingType buildingType, ServiceType serviceType,
				String description, Integer numberBedroom, Integer numberWc, Boolean furnished,Boolean garage,Date createdDate,
				String province, String town, Double latitude, Double longitude) {
			super();
			this.id = propertyIdToBeUpdated;
			this.name = name;
			this.price = price;
			this.buildingType = buildingType;
			this.serviceType = serviceType;
			this.description = description;
			this.numberBedroom = numberBedroom;
			this.numberWc = numberWc;
			this.furnished = furnished;
			this.garage = garage;
			this.createdDate= createdDate;
			this.province = province;
			this.town = town;
			this.latitude = latitude;
			this.longitude = longitude;
		}
	   /*
	    @OneToMany(mappedBy="property")
		private List<DBFile> DBFile;
	   */

	    

	    
		public Property(String name, Double price, BuildingType buildingType, ServiceType serviceType, String description,
				String province,String town,Double latitude,Double longitude) {
			super();
			this.name = name;
			this.price = price;
			this.buildingType = buildingType;
			this.serviceType = serviceType;
			this.description = description;
			this.province = province;
			this.town = town;
			this.latitude = latitude;
			this.longitude = longitude;
		}

		
		

	public Property(Long propertyIdToBeUpdated, String name, Double price, String description,
			Integer numberBedroom, Integer numberWc, Boolean furnished, Boolean garage, String province,
			String town, Boolean pool, Boolean ac, Boolean heating, Boolean elevator, Boolean neartransport,
			Boolean storage, Boolean office, Boolean terrace) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.terrace = terrace;
		this.numberBedroom = numberBedroom;
		this.elevator = elevator;
		this.furnished = furnished;
		this.pool = pool;
		this.garage = garage;
		this.numberWc = numberWc;
		this.ac = ac;
		this.neartransport = neartransport;
		this.office = office;
		this.storage = storage;
		this.heating = heating;
		this.province = province;
		this.town = town;
	}
	
	

	public Property() {
		super();
	}

	public Property(String name, Double price, String description, BuildingType buildingType,
			ServiceType serviceType, String ref, Boolean visible, Boolean sold, Boolean terrace,
			Integer numberBedroom, Integer numberWc, Boolean elevator, Boolean furnished, Boolean pool,
			Boolean garage, Boolean ac, Date createdDate, Boolean neartransport, Boolean office, Boolean storage,
			Boolean heating, String photo, String province, String town, Double latitude, Double longitude,
			User current) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.terrace = terrace;
		this.numberBedroom = numberBedroom;
		this.elevator = elevator;
		this.furnished = furnished;
		this.pool = pool;
		this.garage = garage;
		this.numberWc = numberWc;
		this.ac = ac;
		this.neartransport = neartransport;
		this.office = office;
		this.storage = storage;
		this.heating = heating;
		this.province = province;
		this.town = town;
		this.province= province;
		this.longitude = longitude;
		this.latitude = latitude;
		this.photo = photo;
		this.buildingType = buildingType;
		this.serviceType = serviceType;
		this.createdDate = createdDate;
		this.sold = sold;
		this.visible = visible;
		this.ref = ref;
		
	}

	public List<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}

	public List<Favorits> getFavorits() {
		return favorits;
	}

	public void setFavorits(List<Favorits> favorits) {
		this.favorits = favorits;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public Property name(String name) {
		this.name = name;
		return this;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public Property price(Double price) {
		this.price = price;
		return this;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public Property description(String description) {
		this.description = description;
		return this;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BuildingType getBuildingType() {
		return buildingType;
	}

	public Property buildingType(BuildingType buildingType) {
		this.buildingType = buildingType;
		return this;
	}

	public void setBuildingType(BuildingType buildingType) {
		this.buildingType = buildingType;
	}

	public ServiceType getServiceType() {
		return serviceType;
	}

	public Property serviceType(ServiceType serviceType) {
		this.serviceType = serviceType;
		return this;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	public String getRef() {
		return ref;
	}

	public Property ref(String ref) {
		this.ref = ref;
		return this;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public Boolean isVisible() {
		return visible;
	}

	public Property visible(Boolean visible) {
		this.visible = visible;
		return this;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public Boolean isSold() {
		return sold;
	}

	public Property sold(Boolean sold) {
		this.sold = sold;
		return this;
	}

	public void setSold(Boolean sold) {
		this.sold = sold;
	}

	public Boolean isTerrace() {
		return terrace;
	}

	public Property terrace(Boolean terrace) {
		this.terrace = terrace;
		return this;
	}

	public void setTerrace(Boolean terrace) {
		this.terrace = terrace;
	}

	public Integer getNumberBedroom() {
		return numberBedroom;
	}

	public Property numberBedroom(Integer numberBedroom) {
		this.numberBedroom = numberBedroom;
		return this;
	}

	public void setNumberBedroom(Integer numberBedroom) {
		this.numberBedroom = numberBedroom;
	}

	public Boolean isElevator() {
		return elevator;
	}

	public Property elevator(Boolean elevator) {
		this.elevator = elevator;
		return this;
	}

	public void setElevator(Boolean elevator) {
		this.elevator = elevator;
	}

	public Boolean isFurnished() {
		return furnished;
	}

	public Property furnished(Boolean furnished) {
		this.furnished = furnished;
		return this;
	}

	public void setFurnished(Boolean furnished) {
		this.furnished = furnished;
	}

	public Boolean isPool() {
		return pool;
	}

	public Property pool(Boolean pool) {
		this.pool = pool;
		return this;
	}

	public void setPool(Boolean pool) {
		this.pool = pool;
	}

	public Boolean isGarage() {
		return garage;
	}

	public Property garage(Boolean garage) {
		this.garage = garage;
		return this;
	}

	public void setGarage(Boolean garage) {
		this.garage = garage;
	}

	public Integer getNumberWc() {
		return numberWc;
	}

	public Property numberWc(Integer numberWc) {
		this.numberWc = numberWc;
		return this;
	}

	public void setNumberWc(Integer numberWc) {
		this.numberWc = numberWc;
	}

	public Boolean isAc() {
		return ac;
	}

	public Property ac(Boolean ac) {
		this.ac = ac;
		return this;
	}

	public void setAc(Boolean ac) {
		this.ac = ac;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Boolean isNeartransport() {
		return neartransport;
	}

	public Property neartransport(Boolean neartransport) {
		this.neartransport = neartransport;
		return this;
	}

	public void setNeartransport(Boolean neartransport) {
		this.neartransport = neartransport;
	}

	public Boolean isOffice() {
		return office;
	}

	public Property office(Boolean office) {
		this.office = office;
		return this;
	}

	public void setOffice(Boolean office) {
		this.office = office;
	}

	public Boolean isStorage() {
		return storage;
	}

	public Property storage(Boolean storage) {
		this.storage = storage;
		return this;
	}

	public void setStorage(Boolean storage) {
		this.storage = storage;
	}

	public Boolean isHeating() {
		return heating;
	}

	public Property heating(Boolean heating) {
		this.heating = heating;
		return this;
	}

	public void setHeating(Boolean heating) {
		this.heating = heating;
	}



	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Boolean getVisible() {
		return visible;
	}

	public Boolean getSold() {
		return sold;
	}

	public Boolean getTerrace() {
		return terrace;
	}

	public Boolean getElevator() {
		return elevator;
	}

	public Boolean getFurnished() {
		return furnished;
	}

	public Boolean getPool() {
		return pool;
	}

	public Boolean getGarage() {
		return garage;
	}

	public Boolean getAc() {
		return ac;
	}

	public Boolean getNeartransport() {
		return neartransport;
	}

	public Boolean getOffice() {
		return office;
	}

	public Boolean getStorage() {
		return storage;
	}

	public Boolean getHeating() {
		return heating;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Property property = (Property) o;
		if (property.id == null || id == null) {
			return false;
		}
		return Objects.equals(id, property.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

	@Override
	public String toString() {
		return "Property{" + "id=" + id + ", name='" + name + "'" + ", price='" + price + "'" + ", description='"
				+ description + "'" + ", buildingType='" + buildingType + "'" + ", serviceType='" + serviceType + "'"
				+ ", ref='" + ref + "'" + ", visible='" + visible + "'" + ", sold='" + sold + "'" + ", terrace='"
				+ terrace + "'" + ", numberBedroom='" + numberBedroom + "'" + ", elevator='" + elevator + "'"
				+ ", furnished='" + furnished + "'" + ", pool='" + pool + "'" + ", garage='" + garage + "'"
				+ ", numberWc='" + numberWc + "'" + ", ac='" + ac + "'" + ", created='" + createdDate + "'"
				+ ", neartransport='" + neartransport + "'" + ", office='" + office + "'" + ", storage='" + storage
				+ "'" + ", heating='" + heating + "'" + '}';
	}

}