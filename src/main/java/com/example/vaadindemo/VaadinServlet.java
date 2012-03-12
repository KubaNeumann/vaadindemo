package com.example.vaadindemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.AbstractApplicationServlet;

@WebServlet(urlPatterns = "/*")
public class VaadinServlet extends AbstractApplicationServlet {

	private static final long serialVersionUID = 1L;
	
	Application myVaadinApp = new VaadinApp();

	@Override
	protected Application getNewApplication(HttpServletRequest request)
			throws ServletException {
		
		return myVaadinApp;
	}

	@Override
	protected Class<? extends Application> getApplicationClass()
			throws ClassNotFoundException {
		
		return VaadinApp.class;
	}

}
