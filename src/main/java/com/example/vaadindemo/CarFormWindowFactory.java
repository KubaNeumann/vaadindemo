package com.example.vaadindemo;

import java.util.ArrayList;
import java.util.List;

import com.example.vaadindemo.domain.Car;
import com.example.vaadindemo.util.IntRangeValidator;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.Field;
import com.vaadin.ui.Form;
import com.vaadin.ui.FormFieldFactory;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class CarFormWindowFactory extends Form implements FormFieldFactory {

	private static final long serialVersionUID = 1L;

	List<String> visibleFields = new ArrayList<String>();

	Button addButton = new Button("Add");
	Button closeButton = new Button("Close");

	Window modalWindow;

	BeanItem<Car> carBeanItem;
	
	VaadinApp vaadinApp;

	public CarFormWindowFactory(BeanItem<Car> carBeanItem, VaadinApp vaadinApp) {
		
		this.vaadinApp = vaadinApp;

		GridLayout gl = new GridLayout(2, 4);
		gl.setSpacing(true);

		setLayout(gl);

		this.carBeanItem = carBeanItem;
		visibleFields.add("make");
		visibleFields.add("yop");
		visibleFields.add("model");

		setImmediate(true);
		setValidationVisibleOnCommit(true);

		// 1.
		setFormFieldFactory(this);
		// 2.
		setItemDataSource(carBeanItem);
		// 3.
		setVisibleItemProperties(visibleFields);

		closeButton.addListener(ClickEvent.class, this, "closeWindowAction");
		addButton.addListener(ClickEvent.class, this, "addCarAction");

		gl.addComponent(addButton, 0, 3);
		gl.addComponent(closeButton, 1, 3);
	}

	@Override
	protected void attachField(Object propertyId, Field field) {
		String property = (String) propertyId;

		GridLayout gl = (GridLayout) getLayout();

		if ("make".equals(property)) {
			gl.addComponent(field, 0, 0, 1, 0);

		} else if ("yop".equals(property)) {
			gl.addComponent(field, 0, 2, 1, 2);

		} else if ("model".equals(property)) {
			gl.addComponent(field, 0, 1, 1, 1);
		}
	}

	@Override
	public Field createField(Item item, Object propertyId, Component uiContext) {

		String field = (String) propertyId;

		if ("make".equals(field)) {
			final ComboBox makeComboBox = new ComboBox();
			String[] makes = new String[] { "Warszawa", "Opel",
		            "Ford", "Syrena"};
			
			makeComboBox.setNewItemsAllowed(true);
			
			for(String make : makes) {
				makeComboBox.addItem(make);
			}
			makeComboBox.setRequired(true);		
			return makeComboBox;

		} else if ("yop".equals(field)) {
			TextField yopTextField = new TextField("Marka");
			yopTextField.setRequired(true);
			int min = 1900;
			int max = 2012;
			yopTextField.addValidator(new IntRangeValidator(min, max, "Out of range ("+ min + ", " + max + ") or not a number"));
			return yopTextField;

		} else if ("model".equals(field)) {
			TextField modelTextField = new TextField("Marka");
			modelTextField.setRequired(true);
			return modelTextField;
		}
		return null;
	}

	public Window createWindow() {
		modalWindow = new Window();
		modalWindow.setModal(true);
		modalWindow.setClosable(false);
		modalWindow.addComponent(this);

		((VerticalLayout) modalWindow.getContent()).setSizeUndefined();
		((VerticalLayout) modalWindow.getContent()).setMargin(true);
		((VerticalLayout) modalWindow.getContent()).setSpacing(true);

		return modalWindow;
	}

	public void closeWindowAction(ClickEvent event) {
		closeFormWindow();
		vaadinApp.updateCarTable();
	}

	public void addCarAction(ClickEvent event) {
		commit();
		Car car = carBeanItem.getBean();
		vaadinApp.getStorageService().addCar(car);
		closeFormWindow();
		vaadinApp.updateCarTable();
	}

	private void closeFormWindow() {
		Window mainWindow = modalWindow.getParent();
		mainWindow.removeWindow(modalWindow);
	}

}
