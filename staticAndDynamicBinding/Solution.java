package staticAndDynamicBinding;

/*
 * When type of the object is determined at compiled time(by the compiler), it is known as static binding.
 * If there is any private, final or static method in a class, there is static binding.
 * When type of the object is determined at run-time, it is known as dynamic binding.
 */
public class Solution {

	public static void main(String[] args) {
		Animal a = new Dog();
		a.eat();
	}
}
