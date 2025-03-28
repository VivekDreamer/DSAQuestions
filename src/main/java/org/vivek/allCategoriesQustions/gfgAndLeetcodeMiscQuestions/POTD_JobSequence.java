class POTD_JobSequence {

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        List<int[]> jobs = new ArrayList<>();
        int maxDeadline = 0;

        for (int i = 0; i < n; i++) {
            jobs.add(new int[]{profit[i], deadline[i]});
            maxDeadline = Math.max(maxDeadline, deadline[i]);
        }

        // Sort jobs in descending order based on profit
        jobs.sort((a, b) -> Integer.compare(b[0], a[0]));
        
        // TreeSet to track available slots
        TreeSet<Integer> slots = new TreeSet<>();
        for (int i = 1; i <= maxDeadline; i++) {
            slots.add(i);
        }

        int totalProfit = 0, count = 0;

        for (int[] job : jobs) {
            Integer availableSlot = slots.floor(job[1]);
            if (availableSlot != null) {
                totalProfit += job[0];
                count++;
                slots.remove(availableSlot);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(count);
        result.add(totalProfit);
        return result;
    }
}
