package org.melusky.repository.impl;

import og.melusky.soap.client.jaxb.ConvertTemperature;
import og.melusky.soap.client.jaxb.ConvertTemperatureSoap;
import og.melusky.soap.client.jaxb.TemperatureUnit;
import org.melusky.repository.ConvertRepository;
import org.springframework.stereotype.Repository;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by mikem on 6/12/2017.
 */
@Repository
public class ConvertRepositoryImpl implements ConvertRepository {

    @Override
    public Double convertToF_Static(Double C) {
        return 9.0/5 * C + 32;
    }

    @Override
    public Double convertToF_Soap(Double C) throws MalformedURLException {
        URL url = new URL("http://www.webservicex.net/ConvertTemperature.asmx?WSDL");
        ConvertTemperature svc = new ConvertTemperature(url);
        ConvertTemperatureSoap port = svc.getConvertTemperatureSoap();
        return port.convertTemp(C, TemperatureUnit.fromValue("degreeCelsius"), TemperatureUnit.fromValue("degreeFahrenheit"));
    }
}
