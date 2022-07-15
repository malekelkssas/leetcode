class Solution {
    public int reverse(int x) {
        
    	boolean flag = x<0?true:false;
    	x = Math.abs(x);
    	while(x%10==0&&x!=0)
    		x/=10;
    	int tmp = x;
    	String tmp1 = (""+x);
    	int ret = 0;
    	while(x!=0)
    	{
    		ret = (ret*10)+(x%10);
    		x/=10;
    	}
    	String tmp2 = ""+ret;
    	for(int i=0,j=tmp2.length()-1;i!=tmp1.length();i++,j--)
    	{
    		if(tmp1.charAt(i)!=tmp2.charAt(j))
    			return 0;
    	}
    	
    	return flag?-1*ret:ret;
    }
 
}