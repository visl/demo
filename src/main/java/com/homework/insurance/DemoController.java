package com.homework.insurance;

import com.homework.insurance.helper.InsurancePriceHelper;
import com.homework.insurance.helper.InsurancePriceHelperImpl;
import com.homework.insurance.model.Insurance;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


/**
 * DemoController listens to user's selection and returns corresponding results.
 * <p>
 * Created by v_slo on 24/02/2017.
 */
@Controller
public class DemoController {

    private static final Logger logger = Logger.getLogger(DemoController.class);
    private InsurancePriceHelper helper = new InsurancePriceHelperImpl();
    private List<Insurance> insurances = new ArrayList<>();

    @PostConstruct
    public void init() {
        insurances.add(new Insurance("Bike", 0.0, "0", 3000.0, "3k", 30));
        insurances.add(new Insurance("Jewellery", 500.0, "500", 10000.0, "10k", 5));
        insurances.add(new Insurance("Electronics", 500.0, "500", 6000.0, "6k", 35));
        insurances.add(new Insurance("Sports Equipment ", 0.0, "0", 20000.0, "20k", 30));

        logger.debug("Insurances are initialised " + (insurances.size() > 0));
        logger.debug("Insurances count " + insurances.size());
    }

    @RequestMapping(name = "/insurance", method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute("insurances", insurances);
        return "insurance";
    }


    @RequestMapping(name = "/insurance", method = RequestMethod.POST)
    public String post(@RequestParam(value = "module", required = false, defaultValue = "") String module,
                       @RequestParam(value = "coverage", required = false, defaultValue = "") String coverage,
                       Model model) {
        model.addAttribute("insurances", insurances);

        model.addAttribute("result", helper.generateResult(insurances, module, coverage));

        return "insurance";
    }
}
