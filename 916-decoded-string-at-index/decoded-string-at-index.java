class Solution {
    public String decodeAtIndex(String s, int k) {
    int n=s.length();
    long decodedsize=0;
    for(int i=0;i<n;i++){
        char curr=s.charAt(i);
        if(Character.isDigit(curr)){
            decodedsize*=(curr-'0');
        }
        else{
            decodedsize++;
        }
    } 
    for(int i=n-1;i>=0;i--){
        char curr=s.charAt(i);
          k%=decodedsize;
          if(k==0 && Character.isLetter(curr)){
            return Character.toString(curr);
          }
          if(Character.isDigit(curr)){
            decodedsize/=(curr-'0');
          }else{
            decodedsize--;
          }
    }  
    return "";
    }
}