package text;

public class test {

	public static void main(String[] args) {
		for(int i = 1; i <=200; i++){
		System.out.println(Fibonacci(i));
		}
	}
	public static int  Fibonacci(int n){
		if(n <=2 ) return n;
		return Fibonacci(n-1)+ Fibonacci(n-2);
	}

}
