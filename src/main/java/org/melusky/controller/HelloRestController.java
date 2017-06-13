package org.melusky.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mikem on 6/12/2017.
 */
@RestController
public class HelloRestController {

    @RequestMapping(value = "/api/hello")
    public String printHello() {
        return "Hi!";
    }


}
