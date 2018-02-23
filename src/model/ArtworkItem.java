// Melissa Pettigrew
package model;

import java.text.DecimalFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "artwork")
public class ArtworkItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	@Column(name = "TITLE")
	private String title;
	@Column(name = "ARTIST_NAME")
	private String artistName;
	@Column(name = "MEDIA")
	private String media;
	@Column(name = "YEAR")
	private String year;
	@Column(name = "VALUE")
	private double value;

	public ArtworkItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public ArtworkItem(int id) {
		super();
		this.id = id;
	}


	public ArtworkItem(String title, String artistName, String media, String year, double value) {
		super();
		this.title = title;
		this.artistName = artistName;
		this.media = media;
		this.year = year;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "ArtworkItem [id=" + id + ", title=" + title + ", artistName=" + artistName + ", media=" + media
				+ ", year=" + year + ", value=" + value + "]";
	}

	public String returnArtworkDetails() {
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println("---------------------");
		return "Artwork ID: "+id+"\nName of artwork: " + title + "\nName of artist: " + artistName + "\nArtwork type: " + media
				+ "\nYear artwork was created: " + year + "\nMonetary value: $" + df.format(value);
	}

}
