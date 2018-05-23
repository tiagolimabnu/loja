package br.com.loja.comum;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.loja.entity.ClienteEntity;
import br.com.loja.entity.FornecedorEntity;


@FacesConverter(forClass = ClienteEntity.class)
public class ClienteConverter implements Converter {
	  @Override
	    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
	        if (value != null && !value.isEmpty()) {
	            return (ClienteEntity) uiComponent.getAttributes().get(value);
	        }
	        return null;
	    }

	    @Override
	    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
	        if (value instanceof FornecedorEntity) {
	        	ClienteEntity clienteEntity = (ClienteEntity) value;
	            if (clienteEntity != null && clienteEntity instanceof ClienteEntity && clienteEntity.getId() != null) {
	                uiComponent.getAttributes().put( clienteEntity.getId().toString(), clienteEntity);
	                return clienteEntity.getId().toString();
	            }
	        }
	        return "";
	    }
		
	
}
