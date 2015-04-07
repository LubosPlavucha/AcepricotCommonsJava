package com.acepricot.java.commons.math;

import java.math.BigDecimal;

/**
 * Class contains utility methods to compute percentages.
 * 
 * @author lubos.plavucha
 *
 */
public class Percentage {
	
	

	
	/**
	 * Returns percentage number of the amount computed from the base amount.
	 * 
	 * @param baseAmount - base amount
	 * @param quotientAmount - amount which percentage is to be computed
	 * @return
	 */
	public static double percAmount(BigDecimal baseAmount, BigDecimal quotientAmount) {
		if(baseAmount.signum() == 0)
			return 0;	// number cannot be divided by 0
	    return (quotientAmount.doubleValue() / baseAmount.doubleValue()) * 100;
	}
	
	
	/**
	 * Returns quotient amount as a percentage quotient from the base amount.
	 * 
	 * @param baseAmount
	 * @param quotientPerc
	 * @return
	 */
	public static double percQuotient(BigDecimal baseAmount, BigDecimal quotientPerc) {
	    return (baseAmount.doubleValue() / 100) * quotientPerc.doubleValue();
	}
	
	public static int percQuotient(int baseAmount, int quotientPerc) {
	    return (baseAmount/100) * quotientPerc;
	}
	
	public static void main(String[] args) {
	
		BigDecimal base = new BigDecimal(5);
		BigDecimal one = new BigDecimal(80);

		System.out.println(Percentage.percQuotient(base, one));
	
	}

}
