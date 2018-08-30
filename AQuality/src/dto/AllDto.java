package dto;

import java.util.Date;

public class AllDto {

	private String type;
	private Date date;
	private String category;
	private String name;
	private String money;
	private String payment_source;
	private String payment_destination;
	private String store_name;
	private String memo;



	public AllDto(String type,Date date, String category, String name, String money, String payment_source,String payment_destination,
			String store_name, String memo) {
		super();
		this.type = type;
		this.date = date;
		this.category = category;
		this.name = name;
		this.money = money;
		this.payment_source = payment_source;
		this.store_name = store_name;
		this.memo = memo;
		this.payment_destination = payment_destination;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getPayment_source() {
		return payment_source;
	}
	public void setPayment_source(String payment_source) {
		this.payment_source = payment_source;
	}
	public String getStore_name() {
		return store_name;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getPayment_destination() {
		return payment_destination;
	}
	public void setPayment_destination(String payment_destination) {
		this.payment_destination = payment_destination;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}



}