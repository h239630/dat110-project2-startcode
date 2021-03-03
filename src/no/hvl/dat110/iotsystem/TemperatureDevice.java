package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.common.TODO;

public class TemperatureDevice {

	private static final int COUNT = 10;

	public static void main(String[] args) {

		// simulated / virtual temperature sensor - sn.read();
		TemperatureSensor sn = new TemperatureSensor();
		System.out.println("Temperature device started");

		// TODO - start
		// create a client object and use it to
		Client client = new Client("Sensor", Common.BROKERHOST, Common.BROKERPORT);

		// - connect to the broker
		client.connect();
		String temp = "";
		// - publish the temperature(s)
		for (int i = 1; i < COUNT; i++) {
			temp = "" + sn.read();
			
			client.publish(Common.TEMPTOPIC, temp);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// - disconnect from the broker
		client.disconnect();

		// TODO - end

		System.out.println("Temperature device stopping ... ");


	}
}
