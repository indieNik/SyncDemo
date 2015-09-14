package com.psl.sync;

public class SyncDemo extends Thread {

	Account acc;

	public SyncDemo(Account acc) {
		// TODO Auto-generated constructor stub
		this.acc = acc;
		System.out.println("Initial Deposit: " + acc.getBalance());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		for (int i = 0; i < 10; i++) {

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (Thread.currentThread().getName().equals("One")) {
				int bal = acc.getBalance();
				int fBal = bal + 10000;
				acc.setBalance(fBal);
				System.out.println("After Deposit: " + acc.getBalance());
			} else {
				int bal = acc.getBalance();
				int fBal = bal - 10000;
				acc.setBalance(fBal);
				System.out.println("After WithDrawal: " + acc.getBalance());
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account acc = new Account(10000);

		SyncDemo obj = new SyncDemo(acc);

		Thread t1 = new Thread(obj, "One");
		Thread t2 = new Thread(obj, "Two");

		t1.start();
		t2.start();

	}

}
