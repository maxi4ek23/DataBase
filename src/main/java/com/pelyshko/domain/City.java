package com.pelyshko.domain;

import java.util.List;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "city", schema = "rent")
@Data
public class City {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    @Column(name = "id")
    private Integer id;
	
	@Basic
	@Column(name = "name", length = 50)
    private String name;
	
	@ManyToOne
	@JoinColumn(name = "region_id", referencedColumnName = "id")
	private Region region;
	
	@OneToMany(mappedBy = "city")
	private List<Adress> adresses;
}
