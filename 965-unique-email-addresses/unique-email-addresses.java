class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        
        for(String email : emails){
            String[] parts = email.split("@");
            String local = parts[0];
            String domain = parts[1];

            int plusIdx = local.indexOf('+');
            if(plusIdx != -1) local = local.substring(0, plusIdx);

            local = local.replace(".", "");
            
            String normalized = local + "@" + domain;
            set.add(normalized);
        }
        
        return set.size();
    }
}
