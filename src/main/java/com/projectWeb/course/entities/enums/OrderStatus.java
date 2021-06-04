package com.projectWeb.course.entities.enums;

public enum OrderStatus {

	WAITTING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	private OrderStatus(int code) {
		this.code = code;
	}
	
	//METODO PUBLIC PARA CESSAR OS VALORES DA CLASS
	public int getCode() {
		return code;
	}
	
	//METODO PARA CONVERTE O CODE NO NOME ASSOCIADO
	public static OrderStatus valueOf(int code) {
		for(OrderStatus value : OrderStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStuats code");
	}
}
