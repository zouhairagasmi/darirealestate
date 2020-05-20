package tn.esprit.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
	@Table(name = "files")
	public class DBFile {

	    @Id
	    //@GeneratedValue(strategy = GenerationType.AUTO)
	    @GeneratedValue(generator = "uuid")
	    @GenericGenerator(name = "uuid", strategy = "uuid2")
	    private String id;

	    private String fileName;

	    private String fileType;

	    @Lob
	    private byte[] data;
	    
	    @ManyToOne
	    private Property property;

	    public DBFile() {

	    }

	    public DBFile(String fileName, String fileType, byte[] data) {
	        this.fileName = fileName;
	        this.fileType = fileType;
	        this.data = data;
	    }

		public DBFile(String id, String fileName, String fileType, byte[] data) {
			super();
			this.id = id;
			this.fileName = fileName;
			this.fileType = fileType;
			this.data = data;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getFileName() {
			return fileName;
		}

		public void setFileName(String fileName) {
			this.fileName = fileName;
		}

		public String getFileType() {
			return fileType;
		}

		public void setFileType(String fileType) {
			this.fileType = fileType;
		}

		public byte[] getData() {
			return data;
		}

		public void setData(byte[] data) {
			this.data = data;
		}

		public Property getProperty() {
			return property;
		}

		public void setProperty(Property property) {
			this.property = property;
		}

}
