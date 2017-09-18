package codingBat;

public class Main {

	public static void main(String[] args) {
		// stringTimes
		String stringTimes = new Main().stringTimes("Hi", 2);
		// frontTimes
		String frontTimes = new Main().frontTimes("Chocolate", 2);
		// countXX
		int countXX  = new Main().countXX("abcxx");
		// stringBits
		String stringBits = new Main().stringBits("Hello");
		// stringBits
		String stringSplosion = new Main().stringBits("Code");
		// last2
		int last2 = new Main().last2("hixxhi");
		// arrayCount9
		int[] nums = {1, 2, 9};
		int arrayCount9 = new Main().arrayCount9(nums);
		// stringX
		String stringX = new Main().stringX("xxHxix");
		//altPairs
		String altPairs = new Main().altPairs("Chocolate");
		// stringYak
		String stringYak = new Main().stringYak("yak123ya");
		//array667
		int [] nums1 = {6,6,6,5,7};
		int array667 = new Main().array667(nums1);
		// noTriples
		boolean noTriples = new Main().noTriples(nums1);
	}
	//	Given a string and a non-negative int n, return a larger string that
	//	is n copies of the original string.
	//
	//			stringTimes("Hi", 2) → "HiHi"
	//			stringTimes("Hi", 3) → "HiHiHi"
	//			stringTimes("Hi", 1) → "Hi"
	public String stringTimes(String str, int n) {
		String hi = "";

		for(int i = 0; i<n; i++){
			hi += str;
		}
		return hi;
	}
	//	Given a string and a non-negative int n, we'll say that
	//	the front of the string is the first 3 chars, or whatever
	//	is there if the string is less than length 3. Return n copies
	//	of the front;
	//
	//	frontTimes("Chocolate", 2) → "ChoCho"
	//	frontTimes("Chocolate", 3) → "ChoChoCho"
	//	frontTimes("Abc", 3) → "AbcAbcAbc"
	public String frontTimes(String str, int n) {
		String front3 = "";
		String frontTimes = "";

		if(str.length()>3){
			front3 = str.substring(0,3);
		}
		else{
			front3 = str;
		}

		for(int i = 0; i < n ; i++){
			frontTimes += front3;
		}
		return frontTimes;
	}

	//Count the number of "xx" in the given string.
	//We'll say that overlapping is allowed, so "xxx"
	//	contains 2 "xx".
	//
	//countXX("abcxx") → 1
	//countXX("xxx") → 2
	//countXX("xxxx") → 3
	int countXX(String str) {
		int count = 0;
		for (int i = 0; i < str.length()-1; i++) {
			if (str.substring(i, i+2).equals("xx")) count++;
		}
		return count;
	}

	//Given a string, return true if the first instance of "x"
	//in the string is immediately followed by another "x".
	//
	//doubleX("axxbb") → true
	//doubleX("axaxax") → false
	//doubleX("xxxxx") → true
	boolean doubleX(String str) {
		// indexOf
		int index = str.indexOf("x");
		if(index == -1){return false;};

		// 2文字以上
		if (index+1 >= str.length()) return false;

		if(str.substring(index, index+2).equals("xx")){
			return true;
		}
		return false;
	}


	// Given a string, return a new string made of every other char starting with the first,
	// so "Hello" yields "Hlo".
	//stringBits("Hello") → "Hlo"
	//stringBits("Hi") → "H"
	//stringBits("Heeololeo") → "Hello"
	public String stringBits(String str) {
		String bits = "";
		// 2個飛ばして文字を結合していく
		for(int i=0; i<str.length();i+=2){
			bits =  bits + str.substring(i, i+1);
		}
		return bits;
	}

	//	Given a non-empty string like "Code" return a string like "CCoCodCode".
	//
	//			stringSplosion("Code") → "CCoCodCode"
	//			stringSplosion("abc") → "aababc"
	//			stringSplosion("ab") → "aab"
	public String stringSplosion(String str) {
		String result = "";
		// 先頭から文字列を足していく
		for(int i = 0; i < str.length(); i++){
			result = result + str.substring(0, i+1);
		}
		return result;
	}

	//Given a string, return the count of the number of times
	// that a substring length 2 appears in the string and also
	// as the last 2 chars of the string, so "hixxxhi" yields 1
	// (we won't count the end substring).
	//
	//last2("hixxhi") → 1
	//last2("xaxxaxaxx") → 1
	//last2("axxxaaxx") → 2
	public int last2(String str) {
		// 最後尾2文字を変数に格納
		String end = "";
		if(str.length()>=2){
			end = str.substring(str.length()-2);
		}
		// 比較用変数
		String sub = "";
		// カウント用変数
		int count = 0;
		for(int i =0; i< str.length()-2; i++){
			sub = str.substring(i,i+2);
			if(sub.equals(end)){
				count++;
			}
		}
		return count;
	}

	//Given an array of ints, return the number of 9's in the array.
	//
	//arrayCount9([1, 2, 9]) → 1
	//arrayCount9([1, 9, 9]) → 2
	//arrayCount9([1, 9, 9, 3, 9]) → 3
	public int arrayCount9(int[] nums) {
		int count = 0;
		// 数値配列のうち、9があったらカウントアップする
		for(int num: nums){
			if(num == 9){
				count++;
			}
		}
		return count;
	}
	//	Given an array of ints, return true if one of the first 4 elements
	//	in the array is a 9. The array length may be less than 4.
	//
	//			arrayFront9([1, 2, 9, 3, 4]) → true
	//			arrayFront9([1, 2, 3, 4, 9]) → false
	//			arrayFront9([1, 2, 3, 4, 5]) → false
	public boolean arrayFront9(int[] nums) {
		// 数値配列に9が要素の４番目までに属すること
		for(int i=0; i <nums.length;i++){
			if(nums[i] == 9 && i <3){
				return true;
			}
		}
		return false;
	}
	//	Given an array of ints, return true if the sequence of numbers 1, 2, 3
	//	appears in the array somewhere.
	//
	//			array123([1, 1, 2, 3, 1]) → true
	//			array123([1, 1, 2, 4, 1]) → false
	//			array123([1, 1, 2, 1, 2, 3]) → true
	public boolean array123(int[] nums) {
		// 数値配列の要素で、要素が1,2,3と並ぶ場合を正とする
		for(int i =0 ; i< nums.length-2; i++){
			if(nums[i]==1 && nums[i+1]==2 && nums[i+2] ==3){
				return true;
			}
		}
		return false;
	}
	//	Given 2 strings, a and b, return the number of the positions where they contain
	//			the same length 2 substring. So "xxcaazz" and "xxbaaz" yields 3,
	//			since the "xx", "aa", and "az" substrings appear in the same place in both strings.
	//
	//			stringMatch("xxcaazz", "xxbaaz") → 3
	//			stringMatch("abc", "abc") → 2
	//			stringMatch("abc", "axc") → 0
	public int stringMatch(String a, String b) {
		// aとbで長さを比較
		int length = Math.min(a.length(), b.length());
		// 文字列一致カウント
		int count =0;

		for(int i=0; i< length-1;i++){
			String subA = a.substring(i, i+2);
			String subB = b.substring(i, i+2);
			if(subA.equals(subB)){
				count++;
			}
		}
		return count;
	}

	//Given a string, return a version where all the "x" have been removed.
	//		Except an "x" at the very start or end should not be removed.
	//
	//stringX("xxHxix") → "xHix"
	//stringX("abxxxcd") → "abcd"
	//stringX("xabxxxcdx") → "xabcdx"
	public String stringX(String str) {
		// strが2文字以下の場合はstrをそのまま返す
		if(str.length()<=2){return str;}
		String start = "";
		String end = "";
		// 最初と最後の文字が"x"以外の場合、"x"を除く
		if(str.substring(0,1).equals("x")){
			start = "x";
		}
		if(str.substring(str.length()-1).equals("x")){
			end = "x";
		}

		String stringX = str.replaceAll("x","");
		return start + stringX + end;
	}

	//Given a string, return a string made of the chars at indexes 0,1, 4,5, 8,9 ...
	//	so "kittens" yields "kien".
	//
	//altPairs("kitten") → "kien"
	//altPairs("Chocolate") → "Chole"
	//altPairs("CodingHorror") → "Congrr"
	public String altPairs(String str) {
		String sub = "";
		// strが1文字以下の場合はstrをそのまま返す
		if(str.length()<=1){return str;};
		for(int i =0; i< str.length(); i+=4){
			if((i+1)==str.length()){
				sub = sub + str.substring(i,i+1);
			}else{
				sub = sub + str.substring(i,i+2);
			}
		}
		return sub;
	}
	//	Suppose the string "yak" is unlucky. Given a string, return a version
	//	where all the "yak" are removed, but the "a" can be any char.
	//	The "yak" strings will not overlap.
	//
	//			stringYak("yakpak") → "pak"
	//			stringYak("pakyak") → "pak"
	//			stringYak("yak123ya") → "123ya"
	public String stringYak(String str) {
		// iの時に"y"/i+2の時に"k"の場合は文字列から取り除く
		String result = "";
		for(int i =0; i <str.length();i++){
			if(i+2<str.length()&&str.charAt(i) == 'y' && str.charAt(i+2) == 'k'){
				i =  i + 2;
			}else{
				result = result + str.substring(i, i+1);
			}
		}
		return result;
	}
	//	Given an array of ints, return the number of times that two 6's are next to each other
	//	in the array. Also count instances where the second "6" is actually a 7.
	//
	//			array667([6, 6, 2]) → 1
	//			array667([6, 6, 2, 6]) → 1
	//			array667([6, 7, 2, 6]) → 1
	public int array667(int[] nums) {
		int count = 0;
		for(int i=0; i < nums.length-1;i++){
			if(nums[i] == 6 && (nums[i+1] ==6 ||nums[i+1] ==7)){
				count++;
			}
		}
		return count;
	}
	//	Given an array of ints, we'll say that a triple is a value appearing 3 times in
	//	a row in the array. Return true if the array does not contain any triples.
	//
	//	noTriples([1, 1, 2, 2, 1]) → true
	//	noTriples([1, 1, 2, 2, 2, 1]) → false
	//	noTriples([1, 1, 1, 2, 2, 2, 1]) → false
	public boolean noTriples(int[] nums) {
		int count = 0;
		// 数字がtripleではないときにtrueを返す(tripleがあったらfalse）
		for(int i=0 ; i<nums.length-2; i++){
			int first = nums[i];
			if(nums[i+1]== first && nums[i+2]== first){
				return false;
			}
		}
		return true;
	}
	//	Given an array of ints, return true if it contains a 2, 7, 1 pattern: a value,
	//	followed by the value plus 5, followed by the value minus 1.
	//	Additionally the 271 counts even if the "1" differs by 2 or less
	//	from the correct value.
	public boolean has271(int[] nums) {

	}

}
