package tn.esprit.spring.entity;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "reservation")
public class Reservation {

	
		 @Id
		 @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
		 
		 @ManyToOne
		 @JoinColumn(name="idU", referencedColumnName="idU")
		 private User user;
		 
		 @ManyToOne
		 @JoinColumn(name="idP", referencedColumnName="id")
		 private Property property;
		 
		 @Temporal(TemporalType.DATE)
		 private Date datefrom;
		 
		 @Temporal(TemporalType.DATE)
		 private Date dateto;
		 
		 
	    private boolean cancelled;


	    
	    
		public Reservation(User user, Property property, Date datefrom, Date dateto, boolean cancelled) {
			super();
			this.user = user;
			this.property = property;
			this.datefrom = datefrom;
			this.dateto = dateto;
			this.cancelled = cancelled;
		}


		public Reservation(Long id, User user, Property property, Date datefrom, Date dateto, boolean cancelled) {
			super();
			this.id = id;
			this.user = user;
			this.property = property;
			this.datefrom = datefrom;
			this.dateto = dateto;
			this.cancelled = cancelled;
		}


		public Reservation() {
			super();
			// TODO Auto-generated constructor stub
		}


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public User getUser() {
			return user;
		}


		public void setUser(User user) {
			this.user = user;
		}


		public Property getProperty() {
			return property;
		}


		public void setProperty(Property property) {
			this.property = property;
		}


		public Date getDatefrom() {
			return datefrom;
		}


		public void setDatefrom(Date datefrom) {
			this.datefrom = datefrom;
		}


		public Date getDateto() {
			return dateto;
		}


		public void setDateto(Date dateto) {
			this.dateto = dateto;
		}


		public boolean isCancelled() {
			return cancelled;
		}


		public void setCancelled(boolean cancelled) {
			this.cancelled = cancelled;
		}


		@Override
		public String toString() {
			return "Reservation [id=" + id + ", user=" + user + ", property=" + property + ", datefrom=" + datefrom
					+ ", dateto=" + dateto + ", cancelled=" + cancelled + "]";
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (cancelled ? 1231 : 1237);
			result = prime * result + ((datefrom == null) ? 0 : datefrom.hashCode());
			result = prime * result + ((dateto == null) ? 0 : dateto.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((property == null) ? 0 : property.hashCode());
			result = prime * result + ((user == null) ? 0 : user.hashCode());
			return result;
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Reservation other = (Reservation) obj;
			if (cancelled != other.cancelled)
				return false;
			if (datefrom == null) {
				if (other.datefrom != null)
					return false;
			} else if (!datefrom.equals(other.datefrom))
				return false;
			if (dateto == null) {
				if (other.dateto != null)
					return false;
			} else if (!dateto.equals(other.dateto))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (property == null) {
				if (other.property != null)
					return false;
			} else if (!property.equals(other.property))
				return false;
			if (user == null) {
				if (other.user != null)
					return false;
			} else if (!user.equals(other.user))
				return false;
			return true;
		}
		
		
	    
	    
	    
	    


	    
	}
