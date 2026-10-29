class Solution {
    public int compress(char[] chars) {
        int i=0;
        int j=0;
      
       while(i<chars.length){
        char ch=chars[i];
          int count=0;

        while(i<chars.length && chars[i]==ch){
            count++;
            i++;
        }
        chars[j++]=ch;
        if(count>1){
            String s=String.valueOf(count);
            for(int k=0;k<s.length();k++){
                chars[j++]=s.charAt(k);
            }
        }
        }
        return j;
    }

}