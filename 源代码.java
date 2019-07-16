package text;

import java.util.Scanner;

public class text {
	private static int n;//商品
	private static int m;//商品的属性
	private static double[][] alllimit;//限制约束
	private static int[] maxlimit;//最大限制约束
	private static double[] curslimit;//当前限制约束
	private static double[] value_all;//所有价值
	private static double curvalue=0;//当前价值
	private static float bestvalue=0;//满足所有条件的最优解
	private static int[] bestchoice;//商品价值的最优选择
	private static int[] choice;//商品价值的当前选择
	public text() {

	        Scanner in = new Scanner(System.in);
	        //初始化成员
	        n=in.nextInt();  
	    	m=in.nextInt();
	    	//value_all=new double[m];
	    	curslimit=new double[m];
	    	value_all=new double[n];
	    	for(int i=0;i<n;i++) {           //for循坏赋值
	    		value_all[i]=in.nextDouble();
	    	}
	    	alllimit=new double[m][n];//
	    	for(int i=0;i<m;i++) {
	    		for (int j=0;j<n;j++) {    //再次执行for循坏赋值
	    			alllimit[i][j]=in.nextDouble();
//	    			if(j==1) {
//	    				System.out.println(  );
//	    			}
//	    			System.out.print(alllimit[i][j]+" ");
	    		}
	    	}
    		maxlimit=new int[m];
	    	for(int i=0;i<m;i++) {  //for循坏赋值
	    		maxlimit[i]=in.nextInt();
//		    	System.out.print(maxlimit[i]+" ");

	    	


	    }

	    	bestchoice = new int[n]; 
	    	choice=new int[n]; 
		  	  	} 
	private boolean loading(double[] curslimitg,int m,int[] limit,int j,double[][] alllimit){
		//用函数来判断每一个当前限制是否大于最大限制
  		int i; 
	for(i=0;i<m;i++){ 
 			if(curslimit[i]+alllimit[i][j]<limit[i])  //判断属可行性约束条件
 				//判断限界是否每一个都遍历一遍
 				continue; 
 			else break; //如果没有就跳出
 		} 
  		if(i==m) 
 			return true; //可以继续向下执行
  		else  
 			return false; 
  	} 
  	private void backtrack(int a) {  //调用回溯法
  		if (a >= n) { 
  			//采用限界函数-剪枝操作，剪去不是最优解的树枝 
  			//避免无效搜索，提高回溯法效率
  			if ( curvalue > bestvalue) { //如果当前价值大于最优价值，赋值
 				bestvalue= (float) curvalue; 
				// 保存最优的选择值
  				for (int i = 0; i < n; i++) { 
  					bestchoice[i] = choice[i]; 
  					// 把最优的选择序列保存在best_choice中 
  				} 
 			} 
 		} 
  		else { 
 			// 搜索左子树 
  			if (loading(curslimit,m,maxlimit,a,alllimit)) { 
  				//计算限制条件
				for(int i=0;i<m;i++){ 
					curslimit[i] += alllimit[i][a];} 
				 curvalue += value_all[a]; 


  				choice[a] = 1; 
  				backtrack(a + 1); //第a+1的回溯
 

  				// 背包当前限制和所有限制还原，遍历右子树 
 				for(int i=0;i<m;i++){ 
 					curslimit[i] -= alllimit[i][a];}  
  				curvalue -= value_all[a]; 
  			} 
 
  			 
  			choice[a] = 0; 
 			backtrack(a + 1); // 搜索右子树 
 
  			 
 		} 
  	} 
  	public static void main(String args[]) { 
  		//把主类实例化成对象
 		text bag= new text(); //对象调用里面的函数
 		bag.backtrack(0); 
 		//参数执行回溯法一直回溯
 		System.out.println("满足所有条件的最优解最大值为：" + bag.bestvalue); 
 		//回溯找到最优解最大值，就输出答案
 		

 	} 
  



		
	}

