package com.homework.insurance.helper;

import com.homework.insurance.model.Insurance;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * InsurancePriceHelperImpl validates input and calculates the price.
 * <p>
 * Created by v_slo on 24/02/2017.
 */
public class InsurancePriceHelperImpl implements InsurancePriceHelper {

    private static final Logger logger = Logger.getLogger(InsurancePriceHelperImpl.class);

    @Override
    public String generateResult(final List<Insurance> insurances,
                                 final String module,
                                 final String coverage) {
        Insurance selectedInsurance = getInsuranceByModule(insurances, module);
        if (selectedInsurance == null) {
            return "Error : " + module + " is invalid as insurance type";
        }
        if (!validateCoverage(selectedInsurance, coverage)) {
            return "Error : " + coverage + " coverage is invalid for " + module;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("For " + module + " insurance type ");
        sb.append("and " + coverage + " coverage ");
        sb.append("the price will be " + buildPrice(selectedInsurance, coverage));
        return sb.toString();
    }

    /**
     * Builds price depending on the risk.
     *
     * @param selectedInsurance
     * @param coverage
     * @return price
     */
    private Double buildPrice(final Insurance selectedInsurance, final String coverage) {
        return Double.valueOf(coverage) * selectedInsurance.getRisk() / 1000;
    }

    /**
     * Finds insurance by module.
     *
     * @param insurances
     * @param module
     * @return null if not found
     */
    private Insurance getInsuranceByModule(final List<Insurance> insurances,
                                           final String module) {
        for (Insurance insurance : insurances) {
            if (insurance.getModule().equals(module)) {
                return insurance;
            }
        }
        return null;
    }

    /**
     * Validates coverage against selected insurance module and its range set.
     *
     * @param insurance
     * @param coverage
     * @return boolean true if validation passes
     */
    private boolean validateCoverage(final Insurance insurance,
                                     final String coverage) {
        try {
            Double inputCoverage = Double.parseDouble(coverage);
            if (inputCoverage != Double.NaN
                    && insurance.getFromCoverageRange() <= inputCoverage
                    && insurance.getToCoverageRange() >= inputCoverage) {
                return true;
            }
        } catch (NumberFormatException e) {
            logger.error("Input coverage is not valid:" + coverage);
        }
        return false;
    }
}
