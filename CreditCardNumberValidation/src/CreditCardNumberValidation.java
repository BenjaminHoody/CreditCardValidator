import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CreditCardNumberValidation
	{

		static long [] creditCardNumber = new long[16];
		static int numOfValidCardNums = 0;
		static int numOfInvalidCardNums = 0;
		
		public static void main(String[] args)  throws IOException
			{
				
				getCardNumber();		
				System.out.println("The Number of Valid Credit Card Numbers is " + numOfValidCardNums + "!");
				System.out.println("The Number of Invalid Credit Card Numbers is " + numOfInvalidCardNums + "!");
				
				seperateChallenges();
			
				generateValidCardNums();
				System.out.println("The Number of Valid Credit Card Numbers is " + numOfValidCardNums + "!");
				System.out.println("The Number of Invalid Credit Card Numbers is " + numOfInvalidCardNums + "!");
			}
		
		public static void getCardNumber() throws IOException
		{
			Scanner myFile = new Scanner(new File("CardNums.txt"));
		
			while(myFile.hasNextLong())
				{
						long number = myFile.nextLong();
			
						for(int i = 15; i >= 0; i--)
							{
								creditCardNumber[i] = number % 10;
								number = number / 10;
							}
			
						changeNumber();
						checkValidity();
				}
			
		}
		
		public static void changeNumber()
		{
						
			for(int i =0; i < creditCardNumber.length; i += 2)
				{					
					creditCardNumber[i] = creditCardNumber[i]*2;
					
					if(creditCardNumber[i]>9)
						{
							long digit1 = creditCardNumber[i] % 10;
							long digit2 = creditCardNumber[i] / 10;
							creditCardNumber[i] = digit1+digit2;
						}
					
				}
		}
		
		public static void checkValidity()
			{
				int sum = 0;
				
				for(int i = 0;  i < creditCardNumber.length; i++)
					{
						sum += creditCardNumber[i];
					}
				
				if(sum % 10 == 0)
					{
						numOfValidCardNums++;
					
						for(int i = 0; i < 16; i++)
							{
								System.out.print(creditCardNumber[i]);
							}
						System.out.println("\n");
					}
				
				else
					{
						numOfInvalidCardNums++;
					}
				
				
			}
		
		public static void generateValidCardNums()
		{
			boolean stillGenerating = true;
			int NumberOFRandomCardNumber = 0;
			
			while(stillGenerating)
				{
					
					for(int i = 0; i < 16; i++)
						{
							creditCardNumber[i] = (int) (Math.random()*10);
						}
					
					changeNumber();
					checkValidity();
					
					if(numOfValidCardNums==100)
						{
							stillGenerating = false;
						}
				}
		}
		
		public static void seperateChallenges()
			{
				Scanner userFakeInput = new Scanner(System.in);
				String pause;
				pause = userFakeInput.nextLine();
			}
	}

//practice
