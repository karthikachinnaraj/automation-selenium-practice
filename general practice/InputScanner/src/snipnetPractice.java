import java.util.Arrays;

public class snipnetPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter a number:");
//		int a = sc.nextInt();
//		System.out.println("Enter your name:");
//		String name = sc.nextLine();
		
//		Scanner scanner=new Scanner(System.in);
//		System.out.print("Enter your Age");
//		int age=scanner.nextInt();
//		System.out.print("Enter the full name");
//		String name=scanner.nextLine();
//	System.out.println("Hello "+name+",You are "+age+" years old");
	
		/*
		 * Scanner scanner=new Scanner(System.in);
		 * System.out.println("Enter the number"); int number=scanner.nextInt();
		 * if(number%2==0) { System.out.println("Even"); } else {
		 * System.out.println("Odd"); }
		 */
//		int number=10;
//		for(int i=1;i<=number;i++) {
//			System.out.println(i);
//			if(i==5) {
//				continue;
//			}
//			if(i==8) {
//				break;
//			}
//			System.out.println("Print numbers "+i);
//			}
//		Scanner scanner= new Scanner(System.in);
//		System.out.println("Enter the string in Uppercase :");
//		String upcase=scanner.nextLine();
//		
//		String Lowcase=upcase.toLowerCase();
//		System.out.println(Lowcase);
		
		int[] arr= {23,34,5,67,99,100,99};


		int[] sortedDesc = Arrays.stream(arr)
                         .distinct() // remove duplicates
                         .boxed()    // convert to Integer stream to sort reverse
                         .sorted((a, b) -> b - a)
                         .mapToInt(i -> i)
                         .toArray();
System.out.println(sortedDesc);		int[] arr= {23,34,5,67,99,100,99};


		int[] sortedDesc = Arrays.stream(arr)
                         .distinct() // remove duplicates
                         .boxed()    // convert to Integer stream to sort reverse
                         .sorted((a, b) -> b - a)
                         .mapToInt(i -> i)
                         .toArray();
System.out.println(sortedDesc);
		}
		}
	


