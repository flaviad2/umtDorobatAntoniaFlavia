import java.time.LocalTime;

public class Main {



    public static void main(String[] args) {


      TimeCalculator timeCalculator= TimeCalculator.getInstance();


      ////////////////////////////////////////////////////////input.txt//////////////////////////////////////////////////////////////////////

      Calendar calendar1= new Calendar(1, timeCalculator);
      Calendar calendar2= new Calendar(2, timeCalculator);

      String inputFileName = "src/input.txt";
      String outputFileName="src/output.txt";

      TimeLimits timeLimits = new TimeLimits();

      FreeTimePrinter freeTimePrinter = new FreeTimePrinter(outputFileName);

      CalendarReader calendarReader= new CalendarReader(calendar1, calendar2, timeLimits, inputFileName);

      //date valide ale fișierului de intrare
      if(calendarReader.read_and_init()) {

        Scheduler scheduler = new Scheduler(calendar1, calendar2, timeLimits, freeTimePrinter, timeCalculator);
        scheduler.compute_available_time();
      }
      else
      {
        //date invalide ale fișierului de intrare
        freeTimePrinter.start_printing_result();
        freeTimePrinter.print_end_of_file_wrong_input();
      }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

      ////////////////////////////////////////////////////////input1.txt//////////////////////////////////////////////////////////////////////

      Calendar calendar1_1= new Calendar(1, timeCalculator);
      Calendar calendar2_1= new Calendar(2, timeCalculator);

      String inputFileName1 = "src/input1.txt";
      String outputFileName1="src/output1.txt";

      TimeLimits timeLimits1 = new TimeLimits();

      FreeTimePrinter freeTimePrinter1 = new FreeTimePrinter(outputFileName1);

      CalendarReader calendarReader1= new CalendarReader(calendar1_1, calendar2_1, timeLimits1, inputFileName1);

      //date valide ale fișierului de intrare
      if(calendarReader1.read_and_init()) {

        Scheduler scheduler1 = new Scheduler(calendar1_1, calendar2_1, timeLimits1, freeTimePrinter1, timeCalculator);
        scheduler1.compute_available_time();
      }
      else
      {
        //date invalide ale fișierului de intrare
        freeTimePrinter1.start_printing_result();
        freeTimePrinter1.print_end_of_file_wrong_input();
      }
      ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

      //////////////////////////////////////////////////input2.txt//////////////////////////////////////////////////////////////////////

      Calendar calendar1_2= new Calendar(1, timeCalculator);
      Calendar calendar2_2= new Calendar(2, timeCalculator);

      String inputFileName2 = "src/input2.txt";
      String outputFileName2="src/output2.txt";

      TimeLimits timeLimits2 = new TimeLimits();

      FreeTimePrinter freeTimePrinter2 = new FreeTimePrinter(outputFileName2);

      CalendarReader calendarReader2= new CalendarReader(calendar1_2, calendar2_2, timeLimits2, inputFileName2);

      //date valide ale fișierului de intrare
      if(calendarReader2.read_and_init()) {

        Scheduler scheduler2 = new Scheduler(calendar1_2, calendar2_2, timeLimits2, freeTimePrinter2, timeCalculator);
        scheduler2.compute_available_time();
      }
      else
      {
        //date invalide ale fișierului de intrare
        freeTimePrinter2.start_printing_result();
        freeTimePrinter2.print_end_of_file_wrong_input();
      }

      ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

      //////////////////////////////////////////////////input3.txt//////////////////////////////////////////////////////////////////////

      Calendar calendar1_3= new Calendar(1, timeCalculator);
      Calendar calendar2_3= new Calendar(2, timeCalculator);

      String inputFileName3 = "src/input3.txt";
      String outputFileName3="src/output3.txt";

      TimeLimits timeLimits3 = new TimeLimits();

      FreeTimePrinter freeTimePrinter3 = new FreeTimePrinter(outputFileName3);

      CalendarReader calendarReader3= new CalendarReader(calendar1_3, calendar2_3, timeLimits3, inputFileName3);

      //date valide ale fișierului de intrare
      if(calendarReader3.read_and_init()) {

        Scheduler scheduler3 = new Scheduler(calendar1_3, calendar2_3, timeLimits3, freeTimePrinter3, timeCalculator);
        scheduler3.compute_available_time();
      }
      else
      {
        //date invalide ale fișierului de intrare
        freeTimePrinter3.start_printing_result();
        freeTimePrinter3.print_end_of_file_wrong_input();
      }


      ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

      //////////////////////////////////////////////////input4.txt//////////////////////////////////////////////////////////////////////


      Calendar calendar1_4= new Calendar(1, timeCalculator);
      Calendar calendar2_4= new Calendar(2, timeCalculator);

      String inputFileName4 = "src/input4.txt";
      String outputFileName4="src/output4.txt";

      TimeLimits timeLimits4 = new TimeLimits();

      FreeTimePrinter freeTimePrinter4 = new FreeTimePrinter(outputFileName4);

      CalendarReader calendarReader4= new CalendarReader(calendar1_4, calendar2_4, timeLimits4, inputFileName4);

      //date valide ale fișierului de intrare
      if(calendarReader4.read_and_init()) {

        Scheduler scheduler4 = new Scheduler(calendar1_4, calendar2_4, timeLimits4, freeTimePrinter4, timeCalculator);
        scheduler4.compute_available_time();
      }
      else
      {
        //date invalide ale fișierului de intrare
        freeTimePrinter4.start_printing_result();
        freeTimePrinter4.print_end_of_file_wrong_input();
      }


      ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

      //////////////////////////////////////////////////input5.txt//////////////////////////////////////////////////////////////////////

      System.out.println("From input 5: ");
      Calendar calendar1_5= new Calendar(1, timeCalculator);
      Calendar calendar2_5= new Calendar(2, timeCalculator);

      String inputFileName5 = "src/input5.txt";
      String outputFileName5="src/output5.txt";

      TimeLimits timeLimits5 = new TimeLimits();

      FreeTimePrinter freeTimePrinter5 = new FreeTimePrinter(outputFileName5);

      CalendarReader calendarReader5= new CalendarReader(calendar1_5, calendar2_5, timeLimits5, inputFileName5);

      //date valide ale fișierului de intrare
      if(calendarReader5.read_and_init()) {

        Scheduler scheduler5 = new Scheduler(calendar1_5, calendar2_5, timeLimits5, freeTimePrinter5, timeCalculator);
        scheduler5.compute_available_time();
      }
      else
      {
        //date invalide ale fișierului de intrare
        freeTimePrinter5.start_printing_result();
        freeTimePrinter5.print_end_of_file_wrong_input();
      }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

      //////////////////////////////////////////////////input6.txt//////////////////////////////////////////////////////////////////////

      System.out.println("From input 6: ");
      Calendar calendar1_6= new Calendar(1, timeCalculator);
      Calendar calendar2_6= new Calendar(2, timeCalculator);

      String inputFileName6 = "src/input6.txt";
      String outputFileName6="src/output6.txt";

      TimeLimits timeLimits6 = new TimeLimits();

      FreeTimePrinter freeTimePrinter6 = new FreeTimePrinter(outputFileName6);

      CalendarReader calendarReader6= new CalendarReader(calendar1_6, calendar2_6, timeLimits6, inputFileName6);

      //date valide ale fișierului de intrare
      if(calendarReader6.read_and_init()) {

        Scheduler scheduler6 = new Scheduler(calendar1_6, calendar2_6, timeLimits6, freeTimePrinter6, timeCalculator);
        scheduler6.compute_available_time();
      }
      else
      {
        //date invalide ale fișierului de intrare
        freeTimePrinter6.start_printing_result();
        freeTimePrinter6.print_end_of_file_wrong_input();
      }





    }
}
