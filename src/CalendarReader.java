import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;


/**
 * Clasa CalendarReader se va ocupa cu citirea datelor din fișierul de input.
 * In timpul citirii datelor de intrare, un obiect de tip CalendarReader va adăuga perechi de intervale orare în care una
 * dintre persoane este ocupată într-un obiect de tip Scheduler.
 * De asemenea, un obiect de tip CalendarReader va seta câmpurile start_global (=prima oră de la care am putea programa o întâlnire),
 * finish_global (=ultima oră la care s-ar putea termina o întâlnire) și meeting_time_minutes(= cât durează o întâlnire)
 * dintr-un obiect de tip TimeLimits.
 */

public class CalendarReader {

    private TimeLimits timeLimits;
    private Scheduler scheduler;
    private String fileName;

    public CalendarReader(TimeLimits timeLimits, Scheduler scheduler, String fileName) {

        this.timeLimits=timeLimits;
        this.scheduler=scheduler;
        this.fileName=fileName;

    }

    /**
     * Metodă care citește datele din fișierul de intrare și reține datele de care avem nevoie pentru rezolvarea problemei.
     */
    public boolean read_and_init() {
        try {
            File myObj = new File(fileName);
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


                }

                //calendar1 range limits: ...
                //calendar2 range limits: ... (în fișierul de input)
                // Din calendar1 range limits și calendar2 range limits vom determina
                // cea_mai_restrictivă_oră_de_start ca fiind prima oră la care am putea programa o întâlnire și
                // cea_mai_restrictivă_oră_de_finish ca fiind ultima oră la care s-ar putea termina o întâlnire.

                // Vom reține aceste valori în câmpurile start_global și finish_global ale obiectului de tip TimeLimits.
                // Avem nevoie de valorile lui start_global și finish_global ca să putem verifica dacă înainte ca cele două
                // persoane să își înceapă prima activitate a zilei se poate programa o întâlnire între acestea
                // sau după ce cele două persoane își termină ultima activitate a zilei se mai poate programa o întâlnire
                // între acestea.

                else if (res[2].equals("limits:")) {
                    var res2 = Arrays.stream(res).skip(3);
                    String interval = res2.collect(Collectors.toList()).get(0);
                    timeLimits.cea_mai_restrictiva_ora_de_start(interval);
                    timeLimits.cea_mai_restrictiva_ora_de_finish(interval);

                    // booked calendar1: ...
                    // Reținem perioadele de timp în care prima persoană este ocupată.
                } else if (res[1].equals("calendar1:")) {
                    var res2 = Arrays.stream(res).skip(2);

                    scheduler.add_booked_intervals(res2.collect(Collectors.toList()));


                    // booked calendar2: ...
                    // Reținem perioadele de timp în care a doua persoană este ocupată.
                } else if (res[1].equals("calendar2:")) {
                    var res2 = Arrays.stream(res).skip(2);
                    scheduler.add_booked_intervals(res2.collect(Collectors.toList()));

                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found.");
            e.printStackTrace();
            return false;
        } catch (NumberFormatException e)
        {
            System.out.println(e);
            return false;
        } catch(InvalidInputException e)
        {
            System.out.println(e);
            return false;
        }
        catch(Exception e)
        {
            System.out.println("You have entered wrong input data!");
            return false;
        }

        return true;
    }



}
