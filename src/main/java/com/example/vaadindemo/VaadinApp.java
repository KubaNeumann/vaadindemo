package com.example.vaadindemo;

import com.vaadin.Application;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

public class VaadinApp extends Application {

	private static final long serialVersionUID = 1L;

	@Override
	public void init() {
		Window mainWindow = new Window();

		
		mainWindow.addComponent(new Label("Hello Wordl"));

		setMainWindow(mainWindow);
	}
}
