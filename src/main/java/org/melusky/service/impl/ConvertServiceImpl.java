package org.melusky.service.impl;

import org.melusky.repository.ConvertRepository;
import org.melusky.service.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;

/**
 * Created by mikem on 6/12/2017.
 */
@Service
public class ConvertServiceImpl implements ConvertService {

    @Autowired
    private ConvertRepository convertRepository;

    @Override
    public Double convertToF(Double C) throws MalformedURLException {
        return convertRepository.convertToF_Soap(C);
    }
}
