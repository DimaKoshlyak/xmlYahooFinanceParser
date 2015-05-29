package dz2.xmlYahooFinanceParser;

import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "query")
public class Query {
	@XmlElement(name = "results")
	private List<Results> resultss;
	private int count;
	private String created;
	private String lang;
	
	public void add(Results results) {
        resultss.add(results);
	}
	
	@XmlElement(name = "Count")
	public void setCount(int count) {
		this.count = count;
	}
	
	@XmlElement(name = "Created")
	public void setCreated(String created) {
		this.created = created;
	}
	
	@XmlElement(name = "Lang")
	public void setLang(String lang) {
		this.lang = lang;
	}

	public int getCount() {
		return count;
	}

	public String getCreated() {
		return created;
	}

	public String getLang() {
		return lang;
	}

	 @Override
	 public String toString() {
	 return Arrays.deepToString(resultss.toArray());
	 }


}
