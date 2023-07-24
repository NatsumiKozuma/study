package study;

// ① TaskクラスにCalculatorクラスを継承させなさい。

    /**
     * タスクの実行
     */
 public class Task extends Calculator{
	 
 
    	 
    	

        // ② Calculator.javaのすべてのオーバーロードメソッド「plus」に適当な引数を与え、下記画像のよう出力されるようコーディングしなさい。
        // 尚、「どのクラスから呼び出しているか」を明確にするため、plus()には呼び出し元のキーワードを付与すること。

   
    	  
    	  public void doTask (int a, int b, int c) {
 		  
    		  
    	  System.out.println("plusメソッドの引数が1つの場合：" + a);
    	  System.out.println("plusメソッドの引数が2つの場合：" + b);
    	  System.out.println("plusメソッドの引数が3つの場合：" + c);
    	 
    	  }
    	
    }
 
