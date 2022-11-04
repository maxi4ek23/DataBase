package com.platform.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CashWithdrawalFromLesseeToService {
	private Integer id;
	private Integer price;
	private Integer reservationId;
}
