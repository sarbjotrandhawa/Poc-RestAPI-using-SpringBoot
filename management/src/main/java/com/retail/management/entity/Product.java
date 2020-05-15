package com.retail.management.entity;

import java.math.BigDecimal;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "Product")
@Data
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String displayName;
	private String vendor;
	private String catagory;
	private String brand;
	private String description;
	private BigDecimal weight;
	private String barcode;

	@Override
	public String toString() {
		return "Product [id=" + id + ", displayName=" + displayName + ", vendor=" + vendor + ", catagory=" + catagory
				+ ", brand=" + brand + ", description=" + description + ", weight=" + weight + ", barcode=" + barcode
				+ "]";
	}

}
