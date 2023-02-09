class Filter {
    // Task 3: Filter
    // Your code here
    public static void main(String[] args) {
        if (args.length <= 1) return;

        int flag;

        if (args[0].equals("even")) {
            flag = 0;
        } else if (args[0].equals("odd")) {
            flag = 1;
        } else {
            throw new IllegalArgumentException("First argument must be 'even' or 'odd'.");
        }

        for (int i = 1; i < args.length; i++) {
            int n = Integer.parseInt(args[i])*(args[i].charAt(0) == '-' ? -1 : 1);;
            if (n%2 == flag) System.out.print(args[i] + " ");
        }
        System.out.println();
    }
}