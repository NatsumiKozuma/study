package check;

import constants.Constants;

public class Check {


//		①フィールド変数firstNameとlastNameを宣言し、
//		firstName →　自分の名字　lastName →　自分の名前で初期化しなさい。
//		なお、変数のアクセス修飾子は「private」とする。//	
//		②firstNameとlastNameを引数で受け取って、
//		連結して表示させるメソッド「printName」を作成しなさい。
//		作成した関数のアクセス修飾子は「private」とする。
		
		private String firstName = "こうづま";
	    private String lastName = "なつみ";

	    private void printName(String firstName, String lastName) {
	        String fullName = firstName + lastName;
	        System.out.println("printNameメソッド　→ " + fullName);
	    }
	    
	    public static void main(String[] args) {
	       Check check = new Check();
	       check.printName(check.firstName, check.lastName);
	    	
	   
//	   3【Check.java】にてPetクラスとRobotPetクラスをインスタンス化して、下記の完成イメージを出力させなさい。	
	   
	       
	       
	    Pet pet = new Pet(Constants.CHECK_CLASS_JAVA,Constants.CHECK_CLASS_HOGE);
	    pet.introduce();
	    
	    RobotPet robotPet = new RobotPet(Constants.CHECK_CLASS_R2D2, Constants.CHECK_CLASS_LUKE);
        robotPet.introduce();
	    
	    }
}
//