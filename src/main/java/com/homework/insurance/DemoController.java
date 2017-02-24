package com.homework.insurance;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * DemoController listens to user's selection and returns corresponding results.
 * <p>
 * Created by v_slo on 24/02/2017.
 */
@Controller
public class DemoController {

    @RequestMapping("/insurance")
    public String insurance(@RequestParam(value = "module", required = false, defaultValue = "Bike") String module,
                            @RequestParam(value = "coverage", required = false, defaultValue = "500") String coverage,
                            Model model) {
        model.addAttribute("module", module);
        model.addAttribute("coverage", coverage);
        return "insurance";
    }
}
