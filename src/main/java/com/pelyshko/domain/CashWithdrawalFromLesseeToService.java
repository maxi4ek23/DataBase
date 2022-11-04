package com.pelyshko.domain;


import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cash_withdrawal_from_lessee_to_service", schema = "rent")
@Data
public class CashWithdrawalFromLesseeToService {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    @Column(name = "id")
    private Integer id;
	
	@Basic
	@Column(name = "price")
	private Integer price;
	
	@ManyToOne
	@JoinColumn(name = "reservation_id", referencedColumnName = "id")
	private Reservation reservation;
	
	@OneToOne(mappedBy = "cashWithdrawalFromLesseeToService")
    private CashWithdrawalFromServiceToOwner cashWithdrawalFromServiceToOwner;
}
