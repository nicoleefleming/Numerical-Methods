public class precision {

    public double dmaceps()
    {
        //initialize and declare variables.
        double approx = 2.0;
        //initialize x1 to 1, and seps to 1
        double x1 = 1.0;
        double deps = 1.0;
        //set approx = x1 + seps
        //approx = x1 + seps;
        //declare an iteration variable
        int iters = 0;

        while(approx != 1)
        {
            //update seps, divide it by two each iteration to get closer to seps = 0
            deps = deps/2.0;
            //update the approximation
            approx = x1 + deps;
            //increment the iteration counter
            iters = iters + 1;
            //when approx is equal to 1, or close enough to 1 that the
            // computer can't track the small number, exit loop
        }

        System.out.println("The single precision iterations: " + iters + "\n");
        return deps;
    }

    public float smaceps()
    {
        //initialize and declare variables.
        float approx = 0;
        //initialize x1 to 1, and seps to 1
        float x1 = 1;
        float seps = 1;
        //set approx = x1 + seps
        approx = x1 + seps;
        //declare an iteration variable
        int iters = 0;

        while(approx != 1)
        {
            //update seps, divide it by two each iteration to get closer to seps = 0
            seps = seps/2;
            //update the approximation
            approx = x1 + seps;
            //increment the iteration counter
            iters = iters + 1;
            //when approx is equal to 1, or close enough to 1 that the
            // computer can't track the small number, exit loop
        }

        System.out.println("The single precision iterations: " + iters + "\n");
        return seps;
    }

}

