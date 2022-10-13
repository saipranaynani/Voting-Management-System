package com.sdp3.main.helper;

public class Message {
	private String content;
	private String type;
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	public String getContent() {
		return content;
	}

	public Message(String content, String type) {
		super();
		this.content = content;
		this.type = type;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
