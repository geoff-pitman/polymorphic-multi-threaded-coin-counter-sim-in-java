//Author: Geoffrey Pitman
// Creation Date: March 18, 2015
// Due Date: March 24, 2015
// Course:  CSC 243
// Professor Name: Dr. Kaplan
// Assignment #2: A Coin Counter Simulation
// Filename: CoinCounterMechanism.java
// Purpose: This file contains the definition for the CoinCounterMechanism class.
//			This class simulates a mechanical coin counter by processing an in-stream of 
//			coins, sorting them, and counting them.  This is accomplished primarily through 
// 			an interaction between the Coin super-class and its subclasses, and the synchronous
//			queue.

import java.util.concurrent.SynchronousQueue;

public class CoinCounterMechanism
{
	int coins[] = {1, 5 ,10, 25, 50, 100}; 
	
	//keeps track of how many coins have been processed
	int coinPile[] = {0,0,0,0,0,0}; // coinPile[0]=penny, coinPile[1]=nickel, etc...
	
	//keeps track of total dollar amount processed
	double total = 0;
	
	RandomInteger rm = new RandomInteger(0,5);
	
	boolean consumerFlag = false;
	boolean producerFlag = false;
	
	void setConsumerFlag()
	{
		consumerFlag = true;
	}
	
	void resetConsumerFlag()
	{
		consumerFlag = false;
	}
	
	void setProducerFlag()
	{
		producerFlag = true;
	}
	
	void resetProducerFlag()
	{
		producerFlag = false;
	}
	
	public double getTotal()
	{
		return (total/100);
	}
	
	
	// gives access to number of each coin processed
	public int[] getCoinPile()
	{
		return coinPile;
	}
	
	final SynchronousQueue<Coin> queue = new SynchronousQueue<Coin>();
	
	Thread producer = new Thread("PRODUCER"){
	
		public void run() 
		{
			Integer genCoin;
			while (producerFlag)
			try
			{	
				genCoin = new Integer(coins[rm.nextRandomIntegerInRange()]);
				if (genCoin == 1)
				{
					Penny aPenny = new Penny();
					total += aPenny.getValue();
					coinPile[0]++;
					queue.put(aPenny);
					System.out.println("Coin dropped: " + aPenny.getName());
				}
				else if (genCoin == 5)
				{
					Nickel aNickel = new Nickel();
					total += aNickel.getValue();
					coinPile[1]++;
					queue.put(aNickel);
					System.out.println("Coin dropped: " + aNickel.getName());
				}
				else if (genCoin == 10)
				{
					Dime aDime = new Dime();
					total += aDime.getValue();
					coinPile[2]++;
					queue.put(aDime);
					System.out.println("Coin dropped: " + aDime.getName());
				}
				else if (genCoin == 25)
				{
					Quarter aQuarter = new Quarter();
					total += aQuarter.getValue();
					coinPile[3]++;
					queue.put(aQuarter);
					System.out.println("Coin dropped: " + aQuarter.getName());
				}
				else if (genCoin == 50)
				{
					HalfDollar aHalf = new HalfDollar();
					total += aHalf.getValue();
					coinPile[4]++;
					queue.put(aHalf);
					System.out.println("Coin dropped: " + aHalf.getName());	
				}
				else if (genCoin == 100)
				{
					Dollar aDollar = new Dollar();
					total += aDollar.getValue();
					coinPile[5]++;
					queue.put(aDollar);
					System.out.println("Coin dropped: " + aDollar.getName());
				}
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	};
	
	Thread consumer = new Thread("CONSUMER"){
		public void run ()
		{
			Coin aCoin;
			
			while (producerFlag)
			try 
			{
				aCoin = queue.take();
				System.out.println("Coin received: " + aCoin.getName());
			} catch (InterruptedException e)  
			{
				e.printStackTrace();
			}
		}
	};

}
