package br.com.loja.comum;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.loja.entity.CategoriaEntity;


@FacesConverter(forClass = CategoriaEntity.class)
public class CategoriaConverter implements Converter {
	  @Override
	    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
	        if (value != null && !value.isEmpty()) {
	            return (CategoriaEntity) uiComponent.getAttributes().get(value);
	        }
	        return null;
	    }

	    @Override
	    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
	        if (value instanceof CategoriaEntity) {
	        	CategoriaEntity categoriaEntity = (CategoriaEntity) value;
	            if (categoriaEntity != null && categoriaEntity instanceof CategoriaEntity && categoriaEntity.getId() != null) {
	                uiComponent.getAttributes().put( categoriaEntity.getId().toString(), categoriaEntity);
	                return categoriaEntity.getId().toString();
	            }
	        }
	        return "";
	    }
		
	
}
