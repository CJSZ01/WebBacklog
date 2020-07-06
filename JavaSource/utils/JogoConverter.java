package utils;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import model.Jogo;

@FacesConverter("telefoneConverter")
public class JogoConverter implements Converter {

	

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if (arg2 == null) {
		      return null;
		    }
		return new Jogo();
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {

		if (arg2 == null) {
		      return null;
		    }
		
		Jogo jogo = (Jogo) arg2;
		
		return String.valueOf(jogo.getId());
	}
	
}
