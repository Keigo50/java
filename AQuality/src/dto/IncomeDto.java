package dto;

import java.util.Date;

public class IncomeDto {
	private int id;
	private Date date;
	private String category;
	private String money;
	private String payment_destination;
	private String memo;


	public IncomeDto(int id, Date date, String category, String money, String payment_destination, String memo) {
		super();
		this.id = id;
		this.date = date;
		this.category = category;
		this.money = money;
		this.payment_destination = payment_destination;
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


	public String getMoney() {
		return money;
	}


	public void setMoney(String money) {
		this.money = money;
	}


	public String getPayment_destination() {
		return payment_destination;
	}


	public void setPayment_destination(String payment_destination) {
		this.payment_destination = payment_destination;
	}


	public String getMemo() {
		return memo;
	}


	public void setMemo(String memo) {
		this.memo = memo;
	}


	//以下getter,setter


}
