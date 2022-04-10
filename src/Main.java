


public class Main {


    public static void main(String[] args) {


        ////////////////////////////////////////////////input.txt///////////////////////////////////////////////////////////////////

        TimeLimits timeLimits= new TimeLimits();
        String inputFileName = "src/input.txt";
        String outputFileName = "src/output.txt";
        FreeTimePrinter freeTimePrinter = new FreeTimePrinter(outputFileName);
        Scheduler scheduler = new Scheduler(timeLimits, freeTimePrinter);
        CalendarReader calendarReader = new CalendarReader(timeLimits, scheduler, inputFileName);

        if(calendarReader.read_and_init()) {

            //date valide în fișierul de intrare
            scheduler.compute_available_time();
        }
        else
        {
            //date invalide în fișierul de intrare
            freeTimePrinter.start_printing_result();
            freeTimePrinter.print_end_of_file_wrong_input();
        }

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        /////////////////////////////////////////////input1.txt///////////////////////////////////////////////////////////////
        TimeLimits timeLimits1= new TimeLimits();
        String inputFileName1 = "src/input1.txt";
        String outputFileName1 = "src/output1.txt";
        FreeTimePrinter freeTimePrinter1 = new FreeTimePrinter(outputFileName1);
        Scheduler scheduler1 = new Scheduler(timeLimits1, freeTimePrinter1);
        CalendarReader calendarReader1 = new CalendarReader(timeLimits1, scheduler1, inputFileName1);

        if(calendarReader1.read_and_init()) {

            //date valide în fișierul de intrare
            scheduler1.compute_available_time();
        }
        else
        {
            //date invalide în fișierul de intrare
            freeTimePrinter1.start_printing_result();
            freeTimePrinter1.print_end_of_file_wrong_input();
        }


        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        /////////////////////////////////////////////input2.txt///////////////////////////////////////////////////////////////

        TimeLimits timeLimits2= new TimeLimits();
        String inputFileName2 = "src/input2.txt";
        String outputFileName2 = "src/output2.txt";
        FreeTimePrinter freeTimePrinter2 = new FreeTimePrinter(outputFileName2);
        Scheduler scheduler2 = new Scheduler(timeLimits2, freeTimePrinter2);
        CalendarReader calendarReader2 = new CalendarReader(timeLimits2, scheduler2, inputFileName2);

        if(calendarReader2.read_and_init()) {

            //date valide în fișierul de intrare
            scheduler2.compute_available_time();
        }
        else
        {
            //date invalide în fișierul de intrare
            freeTimePrinter2.start_printing_result();
            freeTimePrinter2.print_end_of_file_wrong_input();
        }


        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        /////////////////////////////////////////////input3.txt///////////////////////////////////////////////////////////////

        TimeLimits timeLimits3= new TimeLimits();
        String inputFileName3 = "src/input3.txt";
        String outputFileName3 = "src/output3.txt";
        FreeTimePrinter freeTimePrinter3 = new FreeTimePrinter(outputFileName3);
        Scheduler scheduler3 = new Scheduler(timeLimits3, freeTimePrinter3);
        CalendarReader calendarReader3 = new CalendarReader(timeLimits3, scheduler3, inputFileName3);

        if(calendarReader3.read_and_init()) {

            //date valide în fișierul de intrare
            scheduler3.compute_available_time();
        }
        else
        {
            //date invalide în fișierul de intrare
            freeTimePrinter3.start_printing_result();
            freeTimePrinter3.print_end_of_file_wrong_input();
        }



        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        /////////////////////////////////////////////input4.txt///////////////////////////////////////////////////////////////

        TimeLimits timeLimits4= new TimeLimits();
        String inputFileName4 = "src/input4.txt";
        String outputFileName4 = "src/output4.txt";
        FreeTimePrinter freeTimePrinter4 = new FreeTimePrinter(outputFileName4);
        Scheduler scheduler4 = new Scheduler(timeLimits4, freeTimePrinter4);
        CalendarReader calendarReader4 = new CalendarReader(timeLimits4, scheduler4, inputFileName4);

        if(calendarReader4.read_and_init()) {

            //date valide în fișierul de intrare
            scheduler4.compute_available_time();
        }
        else
        {
            //date invalide în fișierul de intrare
            freeTimePrinter4.start_printing_result();
            freeTimePrinter4.print_end_of_file_wrong_input();
        }



        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        /////////////////////////////////////////////input5.txt///////////////////////////////////////////////////////////////

        System.out.println("From input 5: ");
        TimeLimits timeLimits5= new TimeLimits();
        String inputFileName5 = "src/input5.txt";
        String outputFileName5 = "src/output5.txt";
        FreeTimePrinter freeTimePrinter5 = new FreeTimePrinter(outputFileName5);
        Scheduler scheduler5 = new Scheduler(timeLimits5, freeTimePrinter5);
        CalendarReader calendarReader5 = new CalendarReader(timeLimits5, scheduler5, inputFileName5);

        if(calendarReader5.read_and_init()) {

            //date valide în fișierul de intrare
            scheduler5.compute_available_time();
        }
        else
        {
            //date invalide în fișierul de intrare
            freeTimePrinter5.start_printing_result();
            freeTimePrinter5.print_end_of_file_wrong_input();
        }


        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        /////////////////////////////////////////////input6.txt///////////////////////////////////////////////////////////////

        System.out.println("From input 6: ");
        TimeLimits timeLimits6= new TimeLimits();
        String inputFileName6 = "src/input6.txt";
        String outputFileName6 = "src/output6.txt";
        FreeTimePrinter freeTimePrinter6 = new FreeTimePrinter(outputFileName6);
        Scheduler scheduler6 = new Scheduler(timeLimits6, freeTimePrinter6);
        CalendarReader calendarReader6 = new CalendarReader(timeLimits6, scheduler6, inputFileName6);

        if(calendarReader6.read_and_init()) {

            //date valide în fișierul de intrare
            scheduler6.compute_available_time();
        }
        else
        {
            //date invalide în fișierul de intrare
            freeTimePrinter6.start_printing_result();
            freeTimePrinter6.print_end_of_file_wrong_input();
        }

    }
}

