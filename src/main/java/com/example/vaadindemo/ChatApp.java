package com.example.vaadindemo;

import com.example.vaadindemo.service.MessageBroadcaster;
import com.example.vaadindemo.service.MessageData;
import com.example.vaadindemo.service.MessageListener;
import com.vaadin.annotations.Push;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

@Push
public class ChatApp extends UI implements MessageListener {

	private static final long serialVersionUID = 1L;
	
	private TextField autorTF = new TextField();
	private TextField messageTF = new TextField();
	private VerticalLayout messages = new VerticalLayout();
	private Button sendBtn = new Button(" Send ");

	@Override
	protected void init(VaadinRequest request) {
		
		VerticalLayout mainLayout = new VerticalLayout();
		
		mainLayout.addComponent(autorTF);
		mainLayout.addComponent(messageTF);
		mainLayout.addComponent(sendBtn);
		mainLayout.addComponent(messages);
		
		setContent(mainLayout);
		
		sendBtn.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				MessageBroadcaster.broadcast(new MessageData(messageTF.getValue(), autorTF.getValue()));
			}
		});
		
		MessageBroadcaster.registerListener(this);
	}

	@Override
	public void receiveMessage(final MessageData messageData) {
		
		access(new Runnable() {
			
			@Override
			public void run() {
				messages.addComponent(new Label(messageData.getAuthor() + ":" + messageData.text));
			}
		});
		
	}
	


}
