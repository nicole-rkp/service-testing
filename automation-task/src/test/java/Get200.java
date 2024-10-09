import automation.PropertyReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class Get200 {

    CloseableHttpClient client;
    CloseableHttpResponse response;

    @BeforeMethod
    public void setUp() throws Exception {
        client = HttpClientBuilder.create().build();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        client.close();
    }

    @Test(dataProvider = "endpoints")
    public void baseUrlReturns200(String endpoint) throws IOException {

    HttpGet request = new HttpGet(PropertyReader.getProperty("api_github") + endpoint);
    response = client.execute(request);

    int actualStatusCode = response.getStatusLine().getStatusCode();

    Assert.assertEquals(actualStatusCode, 200);

    }

    @Test
    public void rateLimitTest() throws IOException {

        HttpGet request = new HttpGet("rate_limit_url");
        response = client.execute(request);

        int actualStatusCode = response.getStatusLine().getStatusCode();

        Assert.assertEquals(actualStatusCode, 200);

    }

    @DataProvider
    private Object[][] endpoints() {
        return new Object[][]{
                {PropertyReader.getProperty("rate_limit_endpoint")},
                {PropertyReader.getProperty("users_endpoint")},
                {PropertyReader.getProperty("my_user_endpoint")},
        };
    }
}
