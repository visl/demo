package com.homework.insurance.helper;

import com.homework.insurance.model.Insurance;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by v_slo on 24/02/2017.
 */
public class InsurancePriceHelperImplTest {

    private InsurancePriceHelper helper = new InsurancePriceHelperImpl();

    private List<Insurance> insurances = new ArrayList<>();

    @Before
    public void setup() {
        insurances.add(new Insurance("Bike", 0.0, 3000.0, 30));
        insurances.add(new Insurance("Jewellery", 500.0, 10000.0, 5));

    }

    @Test
    public void generateResultSuccess() throws Exception {
      String result =  helper.generateResult(insurances, "Bike", "5");

      assertEquals("For Bike insurance type and 5 coverage the price will be 0.15", result);
    }

    @Test
    public void invalidModule() throws Exception {
        String result =  helper.generateResult(insurances, "Car", "500");

        assertEquals("Error : Car is invalid as insurance type", result);
    }

    @Test
    public void invalidCoverageZero() throws Exception {
        String result =  helper.generateResult(insurances, "Jewellery", "0");

        assertEquals("Error : 0 coverage is invalid for Jewellery", result);
    }

    @Test
    public void invalidCoverageNonNumber() throws Exception {
        String result =  helper.generateResult(insurances, "Jewellery", "0^");

        assertEquals("Error : 0^ coverage is invalid for Jewellery", result);
    }

    @Test
    public void invalidCoverageForSelectedIsurance() throws Exception {
        String result =  helper.generateResult(insurances, "Jewellery", "50");

        assertEquals("Error : 50 coverage is invalid for Jewellery", result);
    }

}
