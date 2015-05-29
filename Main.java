package dz2.xmlYahooFinanceParser;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.xml.bind.*;

/*
 * parser for Yahoo Finance based on xml. created by Dima Koshlyak
 */

public class Main {

	public static void main(String[] args) throws IOException, JAXBException {

		File file = new File("result.txt");

		String request = "http://query.yahooapis.com/v1/public/yql?format=xml&q=select%20*%20from%20"
				+ "yahoo.finance.xchange%20where%20pair%20in%20(\"USDEUR\",%20\"USDUAH\")&env=store://datatables.org/alltableswithkeys";

		performRequest(request);

		JAXBContext jc = JAXBContext.newInstance(Query.class);
		Unmarshaller unmarshaller = jc.createUnmarshaller();

		Query query = (Query) unmarshaller.unmarshal(new File(
				"output_yahoo.xml"));

		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		marshaller.marshal(query, file);
		System.out.println(query);
	}

	private static void performRequest(String urlStr) throws IOException {
		System.out.println("Reqest has sent...");
		URL url = new URL(urlStr);
		StringBuilder sb = new StringBuilder();
		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					http.getInputStream()));
			char[] buf = new char[1000000];

			int r = 0;
			do {
				if ((r = br.read(buf)) > 0)
					sb.append(new String(buf, 0, r));
			} while (r > 0);
		} finally {
			http.disconnect();
		}
		BufferedWriter br = new BufferedWriter(new FileWriter(new File(
				"output_yahoo.xml")));
		br.write(sb.toString());
		br.close();
		System.out.println("Request has recieved...\n");
	}
}
