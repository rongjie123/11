package text;

import java.util.Scanner;

public class text {
	private static int n;//��Ʒ
	private static int m;//��Ʒ������
	private static double[][] alllimit;//����Լ��
	private static int[] maxlimit;//�������Լ��
	private static double[] curslimit;//��ǰ����Լ��
	private static double[] value_all;//���м�ֵ
	private static double curvalue=0;//��ǰ��ֵ
	private static float bestvalue=0;//�����������������Ž�
	private static int[] bestchoice;//��Ʒ��ֵ������ѡ��
	private static int[] choice;//��Ʒ��ֵ�ĵ�ǰѡ��
	public text() {

	        Scanner in = new Scanner(System.in);
	        //��ʼ����Ա
	        n=in.nextInt();  
	    	m=in.nextInt();
	    	//value_all=new double[m];
	    	curslimit=new double[m];
	    	value_all=new double[n];
	    	for(int i=0;i<n;i++) {           //forѭ����ֵ
	    		value_all[i]=in.nextDouble();
	    	}
	    	alllimit=new double[m][n];//
	    	for(int i=0;i<m;i++) {
	    		for (int j=0;j<n;j++) {    //�ٴ�ִ��forѭ����ֵ
	    			alllimit[i][j]=in.nextDouble();
//	    			if(j==1) {
//	    				System.out.println(  );
//	    			}
//	    			System.out.print(alllimit[i][j]+" ");
	    		}
	    	}
    		maxlimit=new int[m];
	    	for(int i=0;i<m;i++) {  //forѭ����ֵ
	    		maxlimit[i]=in.nextInt();
//		    	System.out.print(maxlimit[i]+" ");

	    	


	    }

	    	bestchoice = new int[n]; 
	    	choice=new int[n]; 
		  	  	} 
	private boolean loading(double[] curslimitg,int m,int[] limit,int j,double[][] alllimit){
		//�ú������ж�ÿһ����ǰ�����Ƿ�����������
  		int i; 
	for(i=0;i<m;i++){ 
 			if(curslimit[i]+alllimit[i][j]<limit[i])  //�ж���������Լ������
 				//�ж��޽��Ƿ�ÿһ��������һ��
 				continue; 
 			else break; //���û�о�����
 		} 
  		if(i==m) 
 			return true; //���Լ�������ִ��
  		else  
 			return false; 
  	} 
  	private void backtrack(int a) {  //���û��ݷ�
  		if (a >= n) { 
  			//�����޽纯��-��֦��������ȥ�������Ž����֦ 
  			//������Ч��������߻��ݷ�Ч��
  			if ( curvalue > bestvalue) { //�����ǰ��ֵ�������ż�ֵ����ֵ
 				bestvalue= (float) curvalue; 
				// �������ŵ�ѡ��ֵ
  				for (int i = 0; i < n; i++) { 
  					bestchoice[i] = choice[i]; 
  					// �����ŵ�ѡ�����б�����best_choice�� 
  				} 
 			} 
 		} 
  		else { 
 			// ���������� 
  			if (loading(curslimit,m,maxlimit,a,alllimit)) { 
  				//������������
				for(int i=0;i<m;i++){ 
					curslimit[i] += alllimit[i][a];} 
				 curvalue += value_all[a]; 


  				choice[a] = 1; 
  				backtrack(a + 1); //��a+1�Ļ���
 

  				// ������ǰ���ƺ��������ƻ�ԭ������������ 
 				for(int i=0;i<m;i++){ 
 					curslimit[i] -= alllimit[i][a];}  
  				curvalue -= value_all[a]; 
  			} 
 
  			 
  			choice[a] = 0; 
 			backtrack(a + 1); // ���������� 
 
  			 
 		} 
  	} 
  	public static void main(String args[]) { 
  		//������ʵ�����ɶ���
 		text bag= new text(); //�����������ĺ���
 		bag.backtrack(0); 
 		//����ִ�л��ݷ�һֱ����
 		System.out.println("�����������������Ž����ֵΪ��" + bag.bestvalue); 
 		//�����ҵ����Ž����ֵ���������
 		

 	} 
  



		
	}

