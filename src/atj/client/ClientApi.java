package atj.client;

import atj.model.Rates;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.net.URI;
import java.util.Scanner;

public class ClientApi {
    private String readURL(String table, String code, int topCount) {
        Client client = ClientBuilder.newClient();
        URI uri = URI.create("http://api.nbp.pl/api/exchangerates/rates/" + table + "/" + code + "/last/" + topCount + "/");
        WebTarget webTarget = client.target(uri);
        return webTarget.request().accept(MediaType.TEXT_XML).get(String.class);
    }

    public String readXmlFile(String table, String code, int topCount) {
        String xml = readURL(table, code, topCount);
        return parseXmlFile(xml);
    }

    public Rates unmarshallRatesFromXml (String xml){
        Rates rates = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Rates.class);
            Unmarshaller jaxbUnMarshaller = jaxbContext.createUnmarshaller();
            rates = (Rates) jaxbUnMarshaller.unmarshal(new StringReader(xml));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rates;
    }

    private String parseXmlFile(String xmlFile) {
        Scanner sc;
        StringBuilder sb = new StringBuilder();
        try {
            sc = new Scanner(xmlFile);
            while (sc.hasNextLine()) {
                sb.append(sc.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "<Rates>" + sb.toString().split("<Rates>")[1].split("</Rates>")[0] + "</Rates>";
    }
}