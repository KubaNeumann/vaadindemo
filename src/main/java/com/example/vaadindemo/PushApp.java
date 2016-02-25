package com.example.vaadindemo;

import com.vaadin.annotations.Push;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickListener;

@Push
public class PushApp extends UI {

	private VerticalLayout mainLayout = new VerticalLayout();
	private Label myLabel1 = new Label("Waiting to start...");
	private Button myButton1 = new Button("Start 1");
	private Label myLabel2 = new Label("Waiting to start...");
	private Button myButton2 = new Button("Start 2");

	@Override
	protected void init(VaadinRequest request) {

		mainLayout.setSizeFull();

		myLabel1.setSizeUndefined();
		myLabel2.setSizeUndefined();
		setContent(mainLayout);

		mainLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

		mainLayout.addComponent(myLabel1);
		mainLayout.addComponent(myButton1);
		mainLayout.addComponent(myLabel2);
		mainLayout.addComponent(myButton2);

		myButton1.addClickListener((ClickListener) event -> new UpdateLabelThread(6, myLabel1, "Started 1!").start());

		myButton2.addClickListener((ClickListener) event -> new UpdateLabelThread(3, myLabel2, "Started 2!").start());
	}

	class UpdateLabelThread extends Thread {

		private int waitSeconds = 0;
		private Label label;
		private String text;

		public UpdateLabelThread(int waitSeconds, Label label, String text) {
			this.waitSeconds = waitSeconds;
			this.label = label;
			this.text = text;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(waitSeconds * 1000);
			} catch (InterruptedException e) {
			}
			access(() -> label.setValue(text));
		}
	}
}
