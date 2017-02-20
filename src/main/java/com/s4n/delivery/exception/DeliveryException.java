package com.s4n.delivery.exception;

/**
 * The ExceptionDrawingTool class provides operation to manage the exceptions 
 * of the application
 * @author sebas.monsalve@gmail.com
 *
 */
public class DeliveryException extends Exception{
	
	public static final String ERROR = "Error";
	public static final String WARNING = "Warning";
	
	protected String msnTechnical;
	protected String msnUser;
	protected String id;
	protected Exception exceptionSource;
	
	public DeliveryException() {	}

	public DeliveryException(String message, Exception exceptionSource) {
		super(message);
		this.exceptionSource = exceptionSource;
	}

	public DeliveryException(String msnTechnical, String msnUser, String id,
			Exception exceptionSource) {
		super();
		this.msnTechnical = msnTechnical;
		this.msnUser = msnUser;
		this.id = id;
		this.exceptionSource = exceptionSource;
	}
	
	public void showUserMessage(){
		System.out.println(id+": "+msnUser);
	}
	
	public void showTechnicalMessage(){
		System.out.println(id+":"+msnTechnical);
	}

	public String getMsnTechnical() {
		return msnTechnical;
	}

	public void setMsnTechnical(String msnTechnical) {
		this.msnTechnical = msnTechnical;
	}

	public String getMsnUser() {
		return msnUser;
	}

	public void setMsnUser(String msnUser) {
		this.msnUser = msnUser;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Exception getExceptionSource() {
		return exceptionSource;
	}

	public void setExceptionSource(Exception exceptionSource) {
		this.exceptionSource = exceptionSource;
	}

}
