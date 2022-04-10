import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Clasa CalendarReader se va ocupa cu citirea datelor din fișierul de input.
 * In timpul citirii datelor de intrare, un obiect de tip CalendarReader va însemna în două obiecte de tip Calendar
 * perioadele de timp în care cele două persoane sunt ocupate.
 * De asemenea, un obiect de tip CalendarReader va seta câmpurile start_global (=prima oră de la care am putea programa o întâlnire),
 * finish_global (=ultima oră la care s-ar putea termina o întâlnire) și meeting_time_minutes(= cât durează o întâlnire)
 * dintr-un obiect de tip TimeLimits.
 */

public class CalendarReader {


    private Calendar calendar1;
    private Calendar calendar2;
    private TimeLimits timeLimits;
    private File myObj;
    private String fileName;



    public CalendarReader(Calendar calendar1, Calendar calendar2, TimeLimits timeLimits, String fileName) {
        this.calendar1 = calendar1;
        this.calendar2 = calendar2;
        this.timeLimits = timeLimits;
        this.fileName=fileName;
        this.myObj= new File(fileName);
    }

    /**
     * Metodă care citește datele din fișierul de intrare și reține datele de care avem nevoie pentru rezolvarea problemei.
     */
    public boolean read_and_init() {
        try {

            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                var res = data.split(" ");

                //Meeting Time Minutes: ... (în fișierul de input)
                //reținem cât durează o întâlnire

                if (res[0].equals("Meeting")) {
                    String mi = res[3];
                    if(Integer.parseInt(mi)<0)
                        throw new InvalidInputException("Wrong meeting time minutes!");
                    timeLimits.setMeeting_time_minutes(Integer.parseInt(mi));


                } else if (res[2].equals("limits:")) {

                    //calendar1 range limits: ...
                    //calendar2 range limits: ... (în fișierul de input)
                    // Din calendar1 range limits și calendar2 range limits vom determina
                    // cea_mai_restrictivă_oră_de_start ca fiind prima oră la care am putea programa o întâlnire și
                    // cea_mai_restrictivă_oră_de_finish ca fiind ultima oră la care s-ar putea termina o întâlnire.

                    // Vom reține aceste valori în câmpurile start_global și finish_global ale obiectului de tip TimeLimits.
                    // Avem nevoie de valorile lui start_global și finish_global ca să nu parcurgem tot vectorul de minute dintr-o
                    // zi atunci când determinăm perioadele de timp libere pentru ambele persoane.
                    // Vom obține un timp mai bun dacă vom parcurge și marca doar minutele
                    // din intervalul [start_global , finish_global], deoarece oricum doar aici putem găsi soluții.

                    var res2 = Arrays.stream(res).skip(3);
                    String interval = res2.collect(Collectors.toList()).get(0);
                    timeLimits.setStart_global(timeLimits.cea_mai_restrictiva_ora_de_start(interval));
                    timeLimits.setFinish_global(timeLimits.cea_mai_restrictiva_ora_de_finish(interval));


                } else if (res[1].equals("calendar1:")) {

                    // booked calendar1: ...
                    // În calendar1 marcăm perioadele de timp în care prima persoană este ocupată.

                    var res2 = Arrays.stream(res).skip(2);
                    calendar1.completare(res2.collect(Collectors.toList()));


                } else if (res[1].equals("calendar2:")) {

                    // booked calendar2: ...
                    // În calendar2 marcăm perioadele de timp în care a doua persoană este ocupată.

                    var res2 = Arrays.stream(res).skip(2);
                    calendar2.completare(res2.collect(Collectors.toList()));


                }


            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return false;
        }
        catch(InvalidInputException e)
        {
            System.out.println(e);
            return false;
        }
        catch (Exception e)
        {

            System.out.println("You have entered wrong input data!");
            return false;
        }

        return true;

    }


}
