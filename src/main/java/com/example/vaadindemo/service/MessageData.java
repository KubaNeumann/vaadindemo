package com.example.vaadindemo.service;

public class MessageData {
	
	public String text;
	public String author;
	public MessageData(String text, String author) {
		super();
		this.text = text;
		this.author = author;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

}