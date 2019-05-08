package com.henriquemisael.kuadro.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(PhaseController.PATH)
public class PhaseController implements Controller {

    static final String PATH = "/api/phase";
}
