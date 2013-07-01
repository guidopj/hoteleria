package model.pruebas;

import java.util.Date;

public class Pruebas extends Thread{

	/**
	 * @param args
	 */
	
	public void run(){
		Date actual = new Date();

		while (true){
			int date = actual.getDate();
			System.out.print(date);
			try {
				this.sleep(60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Pruebas p = new Pruebas();
		p.start();
		
	}

}
