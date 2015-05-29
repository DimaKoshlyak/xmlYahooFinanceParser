package dz2.xmlYahooFinanceParser;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "results")
@XmlAccessorType(XmlAccessType.FIELD)
public class Results {
	@XmlElement(name = "rate")
	private List<Rate> rates = new ArrayList<Rate>();
	
	public void add(Rate rate) {
        rates.add(rate);
	}
	
	@Override
	public String toString(){
		return Arrays.deepToString(rates.toArray());
	}
}
