import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Store {

	public static void main(String[] args) {
		//Variables
		int numOfEntries;
		String str;
		String p;

		//Create Scanner
		Scanner reader = new Scanner(System.in);

		//Create Array
		String[][] addr = new String[4][100];

		//Set Row Names
		addr[0][0] = "Decimal IP Address";
		addr[1][0] = "Octal IP Address";
		addr[2][0] = "Hexidecimal IP Address";
		addr[3][0] = "Binary IP Address";

		//Get number of entries
		System.out.print("Enter the number of IP addresses you have: ");
		numOfEntries = reader.nextInt();

		//Clear things
		reader.nextLine();

		//Get the entries of IP addresses
		System.out.println("Enter your IP addresses(in base 10): ");
		for (int i = 1; i <= numOfEntries; i++) {
			p = reader.nextLine();
			addr[0][i] = p;
		}

		//Convert array to Octal
		for (int i = 1; i < 100; i++) {
			if (addr[0][i] != null) {
				String[] split = addr[0][i].split("\\.");
				for (int j = 0; j < split.length; j++) {
					int a = Integer.parseInt(split[j]);
					split[j] = Integer.toOctalString(a);
				}
				addr[1][i] = Arrays.toString(split);
			}
			else {
				break;
			}
		}

		//Convert array to Hexadecimal
		for (int i = 1; i < 100; i++) {
			if (addr[0][i] != null) {
				String[] split = addr[0][i].split("\\.");
				for (int j = 0; j < split.length; j++) {
					int a = Integer.parseInt(split[j]);
					split[j] = Integer.toHexString(a);
				}
				addr[2][i] = Arrays.toString(split);
			}
			else {
				break;
			}
		}

		//Convert array to Binary
		for (int i = 1; i < 100; i++) {
			if (addr[0][i] != null) {
				String[] split = addr[0][i].split("\\.");
				for (int j = 0; j < split.length; j++) {
					int a = Integer.parseInt(split[j]);
					split[j] = Integer.toBinaryString(a);
				}
				addr[3][i] = Arrays.toString(split);
			}
			else {
				break;
			}
		}

		//Format the arrays correctly
		for (int j = 0; j < 4; j++) {
			for (int i = 1; i < 100; i++) {
				if (addr[j][i] != null) {
					str = addr[j][i];
					str = str.replace(",",".");
					str = str.replace(" ","");
					str = str.replace("[","");
					str = str.replace("]","");
					addr[j][i] = str;
				}
			}
		}

		//Print array
		for (int i = 0; i < addr.length; i++) {
			for (int j = 0; j < numOfEntries+1; j++ ){
				if(j == 0){
					System.out.printf("%s: ",addr[i][j]);
				}
				else if(numOfEntries == 1) {
					System.out.printf("%s ",addr[i][j]);
				}
				else if(j == numOfEntries) {
					System.out.printf("%s ",addr[i][j]);
				}
				else {
					System.out.printf("%s, ",addr[i][j]);
				}
			}
			System.out.println();
		}

		//Close Scanner
		reader.close();

	}

}
