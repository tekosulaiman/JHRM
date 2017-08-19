package org.app.portofolio.webui.hr.common.utilities;

import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Textbox;

public class ComponentConditionUtil {

	/**
	 * 
	 * @param textboxs
	 */
	public static void disableTextbox(Textbox... textboxs) {
		for(Textbox textbox : textboxs) {
			textbox.setDisabled(true);
		}
	}
	
	/**
	 * 
	 * @param comboboxs
	 */
	public static void disableCombobox(Combobox...comboboxs) {
		for (Combobox combobox: comboboxs) {
			combobox.setDisabled(true);
		}
	}
	
	/**
	 * 
	 * @param checkboxs
	 */
	public static void disableCheckbox(Checkbox...checkboxs) {
		for (Checkbox checkbox: checkboxs) {
			checkbox.setDisabled(true);
		}
	}
	
	/**
	 * 
	 * @param textboxs
	 */
	public static void enableTextbox(Textbox... textboxs) {
		for(Textbox textbox : textboxs) {
			textbox.setDisabled(false);
		}
	}
	
	/**
	 * 
	 * @param comboboxs
	 */
	public static void enableCombobox(Combobox...comboboxs) {
		for (Combobox combobox: comboboxs) {
			combobox.setDisabled(false);
		}
	}
	
	/**
	 * 
	 * @param checkboxs
	 */
	public static void enableCheckbox(Checkbox...checkboxs) {
		for (Checkbox checkbox: checkboxs) {
			checkbox.setDisabled(false);
		}
	}
	
	/**
	 * 
	 * @param textboxs
	 */
	public static void visibleTextbox(Textbox... textboxs) {
		for(Textbox textbox : textboxs) {
			textbox.setVisible(true);
		}
	}
	
	/**
	 * 
	 * @param comboboxs
	 */
	public static void visibleCombobox(Combobox...comboboxs) {
		for (Combobox combobox: comboboxs) {
			combobox.setVisible(true);
		}
	}
	
	/**
	 * 
	 * @param checkboxs
	 */
	public static void visibleCheckbox(Checkbox...checkboxs) {
		for (Checkbox checkbox: checkboxs) {
			checkbox.setVisible(true);
		}
	}
	
	/**
	 * 
	 * @param buttons
	 */
	public static void visibleButton(Button...buttons) {
		for (Button button: buttons) {
			button.setVisible(true);
		}
	}
	
	/**
	 * 
	 * @param textboxs
	 */
	public static void invisibleTextbox(Textbox... textboxs) {
		for(Textbox textbox : textboxs) {
			textbox.setVisible(false);
		}
	}
	
	/**
	 * 
	 * @param comboboxs
	 */
	public static void invisibleCombobox(Combobox...comboboxs) {
		for (Combobox combobox: comboboxs) {
			combobox.setVisible(false);
		}
	}
	
	/**
	 * 
	 * @param checkboxs
	 */
	public static void invisibleCheckbox(Checkbox...checkboxs) {
		for (Checkbox checkbox: checkboxs) {
			checkbox.setVisible(false);
		}
	}
	
	/**
	 * 
	 * @param buttons
	 */
	public static void invisibleButton(Button...buttons) {
		for (Button button: buttons) {
			button.setVisible(false);
		}
	}
}
