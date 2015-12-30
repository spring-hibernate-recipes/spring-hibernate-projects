package org.aryalinux.eshoppe.data.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "payslips")
public class PaySlip extends BaseEntity {
	@OneToOne(fetch = FetchType.LAZY)
	private Payout payout;

	public Payout getPayout() {
		return payout;
	}

	public void setPayout(Payout payout) {
		this.payout = payout;
	}

}
