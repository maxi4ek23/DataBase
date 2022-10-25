package com.platform.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CashWithdrawalFromServiceToOwner {
	private Integer id;
	private Integer price;
	private Integer cashWithdrawalFromLesseeToServiceId;
}
