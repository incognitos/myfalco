package com.falco.model;

public class TimeLog {
	private String date;
	private String cardId;
	private String name;
	private String timeIn;
	private String timeOut;

	public String[] getFields(){
		return new String[]{date,cardId,name,timeIn,timeOut};
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTimeIn() {
		return timeIn;
	}

	public void setTimeIn(String timeIn) {
		this.timeIn = timeIn;
	}

	public String getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(String timeOut) {
		this.timeOut = timeOut;
	}
}
