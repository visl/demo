package com.homework.insurance.helper;

import com.homework.insurance.model.Insurance;

import java.util.List;

/**
 * InsurancePriceHelper.
 *
 * Created by v_slo on 24/02/2017.
 */
public interface InsurancePriceHelper {

    /**
     * Validates module and coverage against existing insurances and calculates the price
     * taking risks into account.
     *
     * @param insurances
     * @param module
     * @param coverage
     * @return price or error message
     */
    String generateResult(List<Insurance> insurances,
                          String module,
                          String coverage);
}
