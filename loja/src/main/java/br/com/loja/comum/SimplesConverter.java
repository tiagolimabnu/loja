package br.com.loja.comum;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.loja.entity.FornecedorEntity;


@FacesConverter(forClass = FornecedorEntity.class)
public class SimplesConverter implements Converter {
	  @Override
	    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
	        if (value != null && !value.isEmpty()) {
	            return (FornecedorEntity) uiComponent.getAttributes().get(value);
	        }
	        return null;
	    }

	    @Override
	    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
	        if (value instanceof FornecedorEntity) {
	        	FornecedorEntity fornecedorEntity = (FornecedorEntity) value;
	            if (fornecedorEntity != null && fornecedorEntity instanceof FornecedorEntity && fornecedorEntity.getId() != null) {
	                uiComponent.getAttributes().put( fornecedorEntity.getId().toString(), fornecedorEntity);
	                return fornecedorEntity.getId().toString();
	            }
	        }
	        return "";
	    }
		
	
}
