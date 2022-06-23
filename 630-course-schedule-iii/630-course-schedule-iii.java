class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[1]-b[1];
            }
        });
       
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)-> (b-a));
        int acc = 0;
        for(int i=0;i<courses.length;i++){
            acc = acc + courses[i][0];
            pq.add(courses[i][0]);
            if(acc>courses[i][1]){
                acc = acc - pq.remove();
            }
        }
        return pq.size();
    }
}