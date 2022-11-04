package com.pelyshko.domain;


import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "dwelling", schema = "rent")
@Data
public class Dwelling {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    @Column(name = "id")
    private Integer id;
	
	@Basic
	@Column(name = "area")
	private Integer area;
	
	@Basic
	@Column(name = "floor")
	private Integer floor;
	
	@Basic
	@Column(name = "rooms_number")
	private Integer roomsNumber;
	
	@Basic
	@Column(name = "description", length = 100)
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "adress_id", referencedColumnName = "id")
	private Adress adress;
	
	@ManyToOne
	@JoinColumn(name = "reservation_id", referencedColumnName = "id")
	private Reservation reservation;
	
	@ManyToOne
	@JoinColumn(name = "dwelling_owner_id", referencedColumnName = "id")
	private DwellingOwner dwellingOwner;
}
