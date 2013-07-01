package excepciones;

public class OutOfMoneyException extends Exception{
	
	public String getMessage() {
		return "no hay suficiente plata para dicha compra";
	}

}
