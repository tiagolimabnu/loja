package br.com.loja.util.jsf;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class RecuperaSessionRequest {
	
	//Recupera sessao
	public static HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	}

	//Recupera request
	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}

	//Recupera nome do usuario
	public static String getUsuario(){
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		return  session.getAttribute("usuarioLogado").toString();
	}

	//recupera id do usuario
	public static String getIdUsuario(){
		HttpSession session = getSession();
		if ( session != null )
			return (String) session.getAttribute("id");
		else
			return null;
	}
	
}
