package atj;

import atj.client.ClientApi;
import atj.model.RatesStatistics;
import atj.service.RateService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class App {

    private final ClientApi clientApi = new ClientApi();
    private RateService rateService;

    @GET
    @Path("{table}/{code}/{topCount}")
    public RatesStatistics showAverageRateBid(@PathParam("table") String table, @PathParam("code") String code, @PathParam("topCount") Integer topCount) {
        rateService = new RateService(clientApi.unmarshallRatesFromXml(clientApi.readXmlFile(table, code, topCount)));
        return new RatesStatistics(rateService);
    }

}
