package com.sitarski.decertoapp.rest.boundary;

import com.sitarski.decertoapp.configuration.swagger.entity.SwaggerTag;
import com.sitarski.decertoapp.service.boundary.CalculationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/tokens")
@Api(tags = SwaggerTag.MATHEMATICAL_OPERATION)
public class CalculationRestController {

    private final CalculationService calculationService;

    @Autowired
    public CalculationRestController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @GetMapping(value = "/", produces = "application/json")
    public Integer doCalculation() {
        Integer result = calculationService.doCalculation();
        return result;
    }

}
