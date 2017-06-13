package org.melusky.endpoint;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.melusky.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ws.test.server.MockWebServiceClient;
import org.springframework.xml.transform.StringSource;

import javax.xml.transform.Source;

import java.io.IOException;

import static org.springframework.ws.test.server.RequestCreators.withPayload;
import static org.springframework.ws.test.server.ResponseMatchers.*;

/**
 * Created by mikem on 6/12/2017.
 */

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {Application.class, WebServiceConfig.class})
public class WebServiceConfigTest {

    @Autowired
    private ApplicationContext applicationContext;

    private MockWebServiceClient mockClient;
    private Resource xsdSchema = new ClassPathResource("service/convert.xsd");

    @Before
    public void init(){
        mockClient = MockWebServiceClient.createClient(applicationContext);
    }

    @Test
    public void valid_xsd_request_response_test() throws IOException {
        Source requestPayload = new StringSource("<ns2:tempConvertRequest xmlns:ns2=\"http://melusky.org/soap/service/jaxb\">\n" +
                "         <ns2:C>100</ns2:C>\n" +
                "      </ns2:tempConvertRequest>\n");
        Source responsePayload = new StringSource("<ns2:tempConvertResponse xmlns:ns2=\"http://melusky.org/soap/service/jaxb\">\n" +
                "         <ns2:F>212.0</ns2:F>\n" +
                "      </ns2:tempConvertResponse>\n");

        mockClient
                .sendRequest(withPayload(requestPayload))
                .andExpect(noFault())
                .andExpect(payload(responsePayload))
                .andExpect(validPayload(xsdSchema));
    }
//
//    @Test
//    public void id_cannot_be_0_test() throws IOException {
//        Source requestPayload = new StringSource(
//                "<ns2:getBeerRequest xmlns:ns2=\"http://memorynotfound.com/beer\">" +
//                        "<ns2:id>0</ns2:id>" +
//                        "</ns2:getBeerRequest>");
//
//        mockClient
//                .sendRequest(withPayload(requestPayload))
//                .andExpect(serverOrReceiverFault());
//    }

}