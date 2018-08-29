package dto;

import java.util.Date;

public class SpendingDto {

	private int id;
	private Date date;
	private String category;
	private String name;
	private String money;
	private String payment_source;
	private String store_name;
	private String memo;



	public SpendingDto(int id, Date date, String category,String name, String money, String payment_source, String store_name,String memo) {
		super();
		this.id = id;
		this.date = date;
		this.category = category;
		this.name = name;
		this.money = money;
		this.payment_source = payment_source;
		this.store_name = store_name;
		this.memo = memo;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
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



}
