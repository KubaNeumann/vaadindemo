package com.example.vaadindemo;

import com.example.vaadindemo.domain.Car;
import com.example.vaadindemo.service.StorageService;
import com.vaadin.Application;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Table;
import com.vaadin.ui.Window;

public class VaadinApp extends Application {

	private static final long serialVersionUID = 1L;

	private BeanItemContainer<Car> carContainer = new BeanItemContainer<Car>(Car.class);
	private Table carsTable = new Table("Cars", carContainer);
	
	private Window mainWindow = new Window();
	private Button addCarButton = new Button("Add car");
	
	private Window carFormWindow;
	
	private StorageService storageService;

	public VaadinApp(StorageService storageService) {
		this.storageService = storageService;
	}
	
	public StorageService getStorageService() {
		return storageService;
	}

	@Override
	public void init() {

		initDataSource();
		updateCarTable();

		mainWindow.addComponent(carsTable);

		carsTable.setSelectable(true);
		carsTable.setImmediate(true);

		carsTable.addListener(new Table.ValueChangeListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				if (carsTable.getValue() != null) {
					mainWindow.showNotification("" + carsTable.getValue());
				}
			}
		});
		
		
		addCarButton.addListener(new Button.ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				
				if (carFormWindow != null) {
					mainWindow.removeWindow(carFormWindow);
				}
				
				BeanItem<Car> beanCarItem = new BeanItem<Car>(new Car());
				CarFormWindowFactory cff  = new CarFormWindowFactory(beanCarItem, VaadinApp.this);
				
				carFormWindow = cff.createWindow();
				mainWindow.addWindow(carFormWindow);
			}
		});

		mainWindow.addComponent(addCarButton);
		setMainWindow(mainWindow);
	}
	
	private void initDataSource(){
		
		Car c1 = new Car();
		c1.setId(1L);
		c1.setMake("Fiat");
		c1.setModel("Punto");
		storageService.addCar(c1);

		Car c2 = new Car();
		c2.setId(2L);
		c2.setMake("Ford");
		c2.setModel("Mondeo");
		storageService.addCar(c2);
	}
	
	public void updateCarTable(){
		carContainer.removeAllItems();
		carContainer.addAll(storageService.getAllCars());
	}
}
