package br.com.tt.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "cpfConverter")
public class CpfConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		/*
		 * Ir� converter CPF formatado para um sem pontos e tra�o. Ex:
		 * 036.792.769-22 -> 03679246922
		 */
		String cpf = value;
		if (cpf != null && !cpf.equals("")) {

			cpf = cpf.replaceAll("\\.", "");
			cpf = cpf.replaceAll("\\-", "");
		}

		return cpf;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {

		/*
		 * Ir� converter CPF n�o formatado para com pontos e tra�o. Ex:
		 * 03679246922 -> 036.792.769-22
		 */
		String cpf = (String) value;
		if (cpf != null && cpf.length() == 11) {

			cpf = cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-"
					+ cpf.substring(9, 11);

		}

		return cpf;
	}

}
