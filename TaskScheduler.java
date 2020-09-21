//TC: O(n)
//SC: O(1)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap();
        int maxFreq = 0; int maxCount = 0;
        for(char task : tasks){
            if(!map.containsKey(task)) map.put(task, 1);
            else map.put(task, map.get(task)+1);
            int count = map.get(task);
            if(count > maxFreq) {
                maxFreq = count;
                maxCount = 0;
            }
            if(count == maxFreq) maxCount++;
        }
        int partition = maxFreq - 1;
        int empty = partition * (n - maxCount + 1);
        int pending = tasks.length - maxFreq*maxCount;
        int idle = Math.max(0, empty - pending);
        return tasks.length + idle;
    }
}
