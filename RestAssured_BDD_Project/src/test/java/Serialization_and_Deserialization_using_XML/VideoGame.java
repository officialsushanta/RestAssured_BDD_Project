package Serialization_and_Deserialization_using_XML;

import java.io.Serializable;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement

public class VideoGame implements Serializable {
	
	public int id;
	public String name;
	public String releaseDate;
	public String category;
	public int reviewScore;
	public String rating;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	public String toString() {
		return(this.id+" "+this.name+" "+this.releaseDate+" "+this.reviewScore+" "+this.category+" "+this.rating);
	}

}
