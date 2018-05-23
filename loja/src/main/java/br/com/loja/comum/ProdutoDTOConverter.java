package br.com.loja.comum;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.loja.entity.ClienteEntity;
import br.com.loja.entity.ProdutoDTO;


@FacesConverter(forClass = ProdutoDTO.class)
public class ProdutoDTOConverter implements Converter {
	  @Override
	    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
	        if (value != null && !value.isEmpty()) {
	            return (ClienteEntity) uiComponent.getAttributes().get(value);
	        }
	        return null;
	    }

	    @Override
	    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
	        if (value instanceof ProdutoDTO) {
	        	ProdutoDTO produtoDTO = (ProdutoDTO) value;
	            if (produtoDTO != null && produtoDTO instanceof ProdutoDTO && produtoDTO.getId() != null) {
	                uiComponent.getAttributes().put( produtoDTO.getId().toString(), produtoDTO);
	                return produtoDTO.getId().toString();
	            }
	        }
	        return "";
	    }
		
	
}
