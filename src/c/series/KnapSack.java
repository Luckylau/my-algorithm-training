/**
 * ������01��������
 * ��N�������ͼ�ֵ�ֱ�Ϊwi��vi����Ʒ������Ҫ����Щ��Ʒ��ѡ��������������W����Ʒ��
 * ��������ѡ�����еļ�ֵ���ֵ��
 */
package c.series;

public class KnapSack {
	public int solveKnapsack(Stuff[] stuffs , int weight){
		if (stuffs == null || stuffs.length == 0 || weight == 0){
			return 0;
		}
		int m = stuffs.length + 1;
		int n = weight + 1;
		int[][]recoder = new int[m][n];
		for (int i = 0 ; i < m ; i++) {
			recoder[i][0] = 0;
		}
		for (int i = 0 ; i < n ; i++) {
			recoder[0][i] = 0;
		}
		
		for (int i = 1 ; i < m ; i++) {
			for (int j = 1 ; j < n ; j++){
				if(stuffs[i - 1].getWeight() <= j){
					if(recoder[i - 1][j] < stuffs[i - 1].getValue() + recoder[i - 1][j - stuffs[i - 1].getWeight()]){
						recoder[i][j] = stuffs[i - 1].getValue() + recoder[i - 1][j - stuffs[i - 1].getWeight()];
					}else{
						recoder[i][j] = recoder[i - 1][j];
					}
				}else{
					recoder[i][j] = recoder[i - 1][j];
				}
			}
		}
		return recoder[m-1][n-1];		
	}
	public static void main(String[] args) {
		Stuff stuff = new Stuff(2,3);
		Stuff stuff1 = new Stuff(1,2);
		Stuff stuff2 = new Stuff(3,4);
		Stuff stuff3 = new Stuff(2,2);
		Stuff[] stuffs = new Stuff[]{stuff,stuff1,stuff2,stuff3};
		KnapSack knapSack = new KnapSack();
		System.out.println(knapSack.solveKnapsack(stuffs, 4));
	}

}
