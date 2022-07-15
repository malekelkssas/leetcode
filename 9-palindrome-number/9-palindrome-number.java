class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
    
    else
    {
        String tmp = ""+x;
        boolean flag = true;
        for(int i=0,j=tmp.length()-1;i<(tmp.length()/2);i++,j--)
        {
            if(tmp.charAt(i)!=tmp.charAt(j))
            {
            	flag=false;
            	break;
            }
        }
        
            return flag;
    }
    }

}