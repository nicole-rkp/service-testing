package automation;

import automation.dto.ValCurs;
import automation.dto.Valute;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(PropertyReader.getProperty("bnmUrl"));
        HttpResponse response = client.execute(request);

        BufferedReader rd = new BufferedReader
                (new InputStreamReader(
                        response.getEntity().getContent()));

        String fullResponse = "";
        String line = "";

        while ((line = rd.readLine()) != null) {
            fullResponse += line + "\r\n";
        }

        XStream xstream = new XStream();
        xstream.addPermission(AnyTypePermission.ANY);

        xstream.processAnnotations(ValCurs.class);
        xstream.processAnnotations(Valute.class);

        xstream.addImplicitCollection(ValCurs.class, "valutes", Valute.class);
        ValCurs valCurs = (ValCurs) xstream.fromXML(fullResponse);

        /*for (Valute valute : valCurs.getValutes()) {
            System.out.println(valute.getName());
        }*/

 //       System.out.println(xstream.toXML(valCurs));

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        System.out.println(mapper.writeValueAsString(valCurs));

    }

}
