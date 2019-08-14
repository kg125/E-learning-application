package eduWebApp.domain;

public  class Delay {
	public static void delay(long ms) {
			try {
				Thread.sleep(ms);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//return 0;
	}
}
