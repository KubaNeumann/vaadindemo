package com.example.vaadindemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MessageBroadcaster {
	
	static ExecutorService executorService = Executors.newSingleThreadExecutor();
	
	static List<MessageListener> listeners = new ArrayList<MessageListener>();
	
	public static synchronized void  registerListener(MessageListener listener){
		listeners.add(listener);
	}
	
	public static synchronized void deregisterListener(MessageListener listener){
		listeners.remove(listener);		
	}
	
	public static synchronized void broadcast(final MessageData messageData){
		
		for (final MessageListener aListener: listeners){
			executorService.execute(new Runnable() {

				@Override
				public void run() {
					aListener.receiveMessage(messageData);
				}
			});
		}
	}
}
