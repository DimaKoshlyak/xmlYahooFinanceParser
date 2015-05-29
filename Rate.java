package dz2.xmlYahooFinanceParser;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "rate")
public class Rate {

	private String id;
	private String Name;
	private double Rate;
	private String Date;
	private String Time;
	private String Ask;
	private String Bid;

	@XmlElement(name = "id")
	public void setId(String id) {
		this.id = id;
	}

	@XmlElement(name = "Name")
	public void setName(String name) {
		Name = name;
	}

	@XmlElement(name = "Rate")
	public void setRate(double rate) {
		Rate = rate;
	}

	@XmlElement(name = "Date")
	public void setDate(String date) {
		Date = date;
	}

	@XmlElement(name = "Time")
	public void setTime(String time) {
		Time = time;
	}

	@XmlElement(name = "Ask")
	public void setAsk(String ask) {
		Ask = ask;
	}

	@XmlElement(name = "Bid")
	public void setBid(String bid) {
		Bid = bid;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return Name;
	}

	public double getRate() {
		return Rate;
	}

	public String getDate() {
		return Date;
	}

	public String getTime() {
		return Time;
	}

	public String getAsk() {
		return Ask;
	}

	public String getBid() {
		return Bid;
	}
	
	@Override
	public String toString(){
		return "Name =" + Name  + " Rate = " + Rate + "";
		
	}
}