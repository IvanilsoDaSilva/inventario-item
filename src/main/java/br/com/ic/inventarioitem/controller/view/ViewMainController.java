package br.com.ic.inventarioitem.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class ViewMainController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
