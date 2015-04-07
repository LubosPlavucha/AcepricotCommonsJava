/**
 * 
 */
package com.lubosplavucha.commonutils.swing;

import javax.swing.DefaultButtonModel;
import javax.swing.JRadioButton;

/**
 * @author quixy
 *
 */
public class SwingUtil {

	
	/**
	 * Determines if radio button is selected.
	 * 
	 * @param radioButton
	 * @return
	 */
	public static boolean isRadioButtonSelected(JRadioButton radioButton) {
	   
		DefaultButtonModel model = (DefaultButtonModel)radioButton.getModel();
	    return model.getGroup().isSelected(model);
	}
	
	
}
