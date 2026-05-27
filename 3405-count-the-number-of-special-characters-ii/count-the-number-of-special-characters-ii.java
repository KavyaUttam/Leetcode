class Solution {
    public int numberOfSpecialChars(String word) {
      int n=word.length();
      int[] firstcapital=new int[26];
      int[] lastsmall=new int[26]; 
      Arrays.fill(firstcapital,-1);
       Arrays.fill(lastsmall,-1);
       for(int i=0;i<n;i++){
        char ch=word.charAt(i);
        if(Character.isLowerCase(ch)){
            lastsmall[ch-'a']=i;
        }
        else{
            int idx=ch-'A';
            if(firstcapital[idx]==-1){
                firstcapital[idx]=i;
            }
        }
       }
       int count=0;
       for(int i=0;i<26;i++){
        
        if((lastsmall[i]!=-1 && firstcapital[i]!=-1) && (lastsmall[i]<firstcapital[i])){
            count++;
        }
       }
       return count;
    }

}