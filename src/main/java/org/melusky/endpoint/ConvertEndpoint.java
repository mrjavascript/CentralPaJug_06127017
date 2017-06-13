package org.melusky.endpoint;

import org.melusky.repository.ConvertRepository;
import org.melusky.soap.service.jaxb.TempConvertRequest;
import org.melusky.soap.service.jaxb.TempConvertResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Created by mikem on 6/12/2017.
 */
@Endpoint
public class ConvertEndpoint {

    private static final String NAMESPACE_URI = "http://melusky.org/soap/service/jaxb";

    @Autowired
    private ConvertRepository convertRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "tempConvertRequest")
    @ResponsePayload
    public TempConvertResponse convertToF(@RequestPayload TempConvertRequest request) {
        TempConvertResponse response = new TempConvertResponse();
        response.setF(convertRepository.convertToF_Static(request.getC()));
        return response;
    }

}
