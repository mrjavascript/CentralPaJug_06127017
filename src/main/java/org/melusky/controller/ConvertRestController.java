package org.melusky.controller;

import org.melusky.service.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;

/**
 * Created by mikem on 6/12/2017.
 */
@RestController
public class ConvertRestController {

    @Autowired
    private ConvertService convertService;

    @RequestMapping(value = "/api/convert/{C}", method = RequestMethod.GET)
    public Double convertToF(@PathVariable Double C) throws MalformedURLException {
        return convertService.convertToF(C);
    }


}
