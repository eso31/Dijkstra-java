import java.util.*;
public class Dijkstra{

	int negativeSign = 0;
	boolean findedI = false;
	boolean findedJ = false;
	boolean findedK = false;

	public static void main(String arg[]){
		new Dijkstra();
	}

	public Dijkstra(){
		Scanner miScanner = new Scanner(System.in);
		
		System.out.print("Number of Cases: ");
		int tests=Integer.parseInt(miScanner.nextLine());

		for(int i=0; i<tests; i++)
			test(i+1);
	}

	public void test(int caseNumber){
		Scanner miScanner2 = new Scanner(System.in);
		
		System.out.print("L X: ");
		String lx = miScanner2.nextLine();
		String[] arraylx = lx.split(" ");
		int l=Integer.parseInt(arraylx[0]);
		int x=Integer.parseInt(arraylx[1]);

		System.out.print("string: ");
		String s = miScanner2.nextLine();

		if(s.length()!=l){
			System.out.println("Invalid data!");
			return;
		}


		String finalString = "";

		for(int i=0; i<x; i++){
			finalString+=s;
		}


		//System.out.println(finalString);

		finalString = find(finalString, "i");
		//System.out.println(finalString);
		finalString = find(finalString, "j");
		//System.out.println(finalString);
		finalString = find(finalString, "k");
		//System.out.println(finalString);

		if(findedI&&findedJ&&findedK)
			System.out.println("Case #"+caseNumber+" YES");
		else
			System.out.println("Case #"+caseNumber+" NO");

		findedI = findedJ = findedK = false;
		System.out.println("");
	}

	public String find(String word, String toFind){
		String[] x = word.split("");

		String sign = "";
		String a = x[0];
		if(check(a,toFind))
			return String.join("",word).substring(1,word.length());

		for(int i=1; i<x.length; i++){
			//System.out.print(a+" * "+x[i]+" = ");
			a = multiply(a,x[i]);

			sign="";
			if(negativeSign%2==0)
				sign="";
			else
				sign="-";
			//System.out.println(sign+a);

			if(check(a,toFind))
				return String.join("",word).substring(i+1,word.length());
		}

		return "";
	}

	public boolean check(String a, String toFind){
		if(a.equals(toFind)&&(negativeSign%2==0)){
			if(toFind.equals("i"))
				findedI = true;
			else if(toFind.equals("j"))
				findedJ = true;
			else if(toFind.equals("k"))
				findedK = true;

			negativeSign = 0;

			return true;
		}

		return false;
	}


	public String multiply(String a, String b){
		switch(a){
			case "1":{
				if(b.equals("1")){
					return "1";
				}
				else if(b.equals("i")){
					return "i";
				}
				else if(b.equals("j")){
					return "j";
				}
				else if(b.equals("k")){
					return "k";
				}
				break;
			}
			case "i":{
				if(b.equals("1")){
					return "i";
				}
				else if(b.equals("i")){
					negativeSign++;
					return "1";
				}
				else if(b.equals("j")){
					return "k";
				}
				else if(b.equals("k")){
					negativeSign++;
					return "j";
				}
				break;
			}
			case "j":{
				if(b.equals("1")){
					return "j";
				}
				else if(b.equals("i")){
					negativeSign++;
					return "k";
				}
				else if(b.equals("j")){
					negativeSign++;
					return "1";
				}
				else if(b.equals("k")){
					return "i";
				}
				break;
			}
			case "k":{
				if(b.equals("1")){
					return "k";
				}
				else if(b.equals("i")){
					return "j";
				}
				else if(b.equals("j")){
					negativeSign++;
					return "i";
				}
				else if(b.equals("k")){
					negativeSign++;
					return "1";
				}
				break;
			}
		}
		return null;
	}
}