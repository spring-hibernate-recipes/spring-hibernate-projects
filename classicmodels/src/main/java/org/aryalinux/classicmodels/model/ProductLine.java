package org.aryalinux.classicmodels.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "productlines")
public class ProductLine {
	@Id
	private String productLine;
	@Column(columnDefinition = "varchar(4000)")
	private String textDescription;
	@Column(columnDefinition = "mediumtext")
	private String htmlDescription;
	@Lob
	@Column(columnDefinition="mediumblob")
	private byte[] image;

	public String getProductLine() {
		return productLine;
	}

	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}

	public String getTextDescription() {
		return textDescription;
	}

	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}

	public String getHtmlDescription() {
		return htmlDescription;
	}

	public void setHtmlDescription(String htmlDescription) {
		this.htmlDescription = htmlDescription;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

}
