class Solution {
    public String simplifyPath(String path) {
    String[] parts = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                continue;
            } else if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(part);
            }
        }
StringBuilder canonicalPath = new StringBuilder();
        Iterator<String> it = stack.descendingIterator();
        while (it.hasNext()) {
            canonicalPath.append("/").append(it.next());
        }
return canonicalPath.length() > 0 ? canonicalPath.toString() : "/";
    }
}