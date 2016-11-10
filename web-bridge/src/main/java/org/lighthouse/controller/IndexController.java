package org.lighthouse.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by christian on 09/11/16.
 */
@RestController
public class IndexController {

    @RequestMapping("index")
    public String index() {
        return "working";
    }
}
