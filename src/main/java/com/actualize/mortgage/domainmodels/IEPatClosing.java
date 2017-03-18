package com.actualize.mortgage.domainmodels;

public class IEPatClosing  extends ClosingCostProperties{

	private static final long serialVersionUID = -5396028708375185601L;
	
	private String escrowAmount;

	public String getEscrowAmount() {
		return escrowAmount;
	}

	public void setEscrowAmount(String escrowAmount) {
		this.escrowAmount = escrowAmount;
	}
}
