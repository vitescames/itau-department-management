package br.com.itau.departmentmanagement.response;

public class ResponseMessage {
	
	private String status;
	
	private String messages;

	public ResponseMessage(String status, String messages) {
		super();
		this.status = status;
		this.messages = messages;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessages() {
		return messages;
	}

	public void setMessages(String  messages) {
		this.messages = messages;
	}

}
