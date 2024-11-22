package iuh.fit.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "PRODUCTS", uniqueConstraints = { @UniqueConstraint(columnNames = "CODE") })
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int iD;

	@Column(name = "CODE", length = 10, nullable = false, unique = true)
	@Size(max = 10, message = "Code must be at most 10 characters")
	private String code;

	@Column(name = "NAME", length = 50, nullable = false)
	@Size(max = 50, message = "Name must be at most 50 characters")
	@Pattern(regexp = "^[A-Z0-9]+$", message = "Name can only contain uppercase letters and numbers")
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "REGISTER_DATE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date registerDate;

	@Column(name = "IS_ACTIVE")
	private Boolean isActive;

	@Column(name = "PRICE", nullable = false)
	@DecimalMin(value = "0.01", inclusive = true, message = "Price must be greater than 0")
	private double price;

	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID")
	private Category category;

	public Product(int iD, @Size(max = 10, message = "Code must be at most 10 characters") String code,
			@Size(max = 50, message = "Name must be at most 50 characters") @Pattern(regexp = "^[A-Z0-9]+$", message = "Name can only contain uppercase letters and numbers") String name,
			String description, Date registerDate, Boolean isActive,
			@DecimalMin(value = "0.01", inclusive = true, message = "Price must be greater than 0") double price,
			Category category) {
		super();
		this.iD = iD;
		this.code = code;
		this.name = name;
		this.description = description;
		this.registerDate = registerDate;
		this.isActive = isActive;
		this.price = price;
		this.category = category;
	}

	
	
	public Product(@Size(max = 10, message = "Code must be at most 10 characters") String code,
			@Size(max = 50, message = "Name must be at most 50 characters") @Pattern(regexp = "^[A-Z0-9]+$", message = "Name can only contain uppercase letters and numbers") String name,
			String description, Date registerDate, Boolean isActive,
			@DecimalMin(value = "0.01", inclusive = true, message = "Price must be greater than 0") double price,
			Category category) {
		super();
		this.code = code;
		this.name = name;
		this.description = description;
		this.registerDate = registerDate;
		this.isActive = isActive;
		this.price = price;
		this.category = category;
	}



	public Product() {
		super();
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

//	@Override
//	public String toString() {
//		return "Product [iD=" + iD + ", code=" + code + ", name=" + name + ", description=" + description
//				+ ", registerDate=" + registerDate + ", isActive=" + isActive + ", price=" + price + ", category="
//				+ category + "]";
//	}

	
	
}
