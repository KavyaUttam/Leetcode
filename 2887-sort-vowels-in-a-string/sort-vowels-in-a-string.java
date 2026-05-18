class Solution {
    public String sortVowels(String s) {
        List<Character>list=new ArrayList<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
            {
                list.add(ch);
            }
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            {
                list.add(ch);
            }
        }
        Collections.sort(list);
        int j=0;
        StringBuilder t=new StringBuilder();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if((ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') ||
              (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')){
                t.append(list.get(j));
                j++;
              }
              else{
                t.append(s.charAt(i));
              }
        }
              return t.toString();
        
    }
}