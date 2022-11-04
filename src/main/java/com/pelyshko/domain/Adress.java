package com.pelyshko.domain;

import javax.persistence.*;
import java.util.List;
import lombok.Data;

@Entity
@Table(name = "adress", schema = "rent")
@Data
public class Adress {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    @Column(name = "id")
    private Integer id;
	
	@Basic
	@Column(name = "street", length = 50)
	private String street;
	
	@Basic
	@Column(name = "house_number")
	private Integer houseNumber;
	
	@ManyToOne
	@JoinColumn(name = "city_id", referencedColumnName = "id")
	private City city;
	
	@OneToMany(mappedBy = "adress")
	private List<Dwelling> dwellings;
}
