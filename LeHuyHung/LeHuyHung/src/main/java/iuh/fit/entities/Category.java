package iuh.fit.entities;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "CATEGORY")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NAME")
	private String name;

	@OneToMany(mappedBy = "category")
	private List<Product> listProducts;

	public Category() {
		super();
	}

	public Category(int id, String name, List<Product> listProducts) {
		super();
		this.id = id;
		this.name = name;
		this.listProducts = listProducts;
	}

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

	public List<Product> getListProducts() {
		return listProducts;
	}

	public void setListProducts(List<Product> listProducts) {
		this.listProducts = listProducts;
	}

//	@Override
//	public String toString() {
//		return "Category [id=" + id + ", name=" + name + ", listProducts=" + listProducts + "]";
//	}
	
	

}
