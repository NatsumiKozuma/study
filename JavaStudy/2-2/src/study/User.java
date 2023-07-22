

package study;

/**
* User.java
*/
class User {

   // フィールド変数
   private String userName;
   private int id;
   private String password;

   // コンストラクタ
   public User(String userName, int id, String password) {
       this.userName = userName;
       this.id = id;
       this.password = password;
   }

   // ① 以下のルールに従いアカウント情報（名前、ID、パスワード）を出力するメソッドを作成してください。
   // アクセス修飾子:「protected」
   // メソッド名:「printAccountInfo」

   protected String userName() {
	   System.out.println("名前: " + userName);
	   }
   protected int id() {
	   System.out.println("ID: " + id);
	   }
   protected String password() {
	   System.out.println("パスワード: " + password);
	   }
   
   public class Main {
	    public static void main(String[] args) {
	        // Userクラスのインスタンスを生成
	        User user = new User("Road", "123", "road123");

	        // アカウント情報をコンソール出力するメソッドを呼び出し
	        user.printAccountInfo();
	    
	    }

