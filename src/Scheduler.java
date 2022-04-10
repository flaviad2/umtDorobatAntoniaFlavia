
import java.util.ArrayList;
import java.util.List;


public class Scheduler {


    private TimeLimits timeLimits;
    private FreeTimePrinter freeTimePrinter;

    /**
     * O listă cu toate intervalele orare în care persoanele sunt ocupate.
     * Aceste intervale orare aparțin sau persoanei1 sau persoanei2.
     */
    private List<Pair<Integer, Integer>> pairList;


    /**
     * Lista de intervale orare în care vom forma rezultatul.
     * Aici vom pune intervalele orare în care cele două persoane se pot întâlni.
     */
    private List<Pair<Integer, Integer>> pairListResult;


    public Scheduler(TimeLimits timeLimits, FreeTimePrinter freeTimePrinter) {

        this.timeLimits = timeLimits;
        this.freeTimePrinter = freeTimePrinter;
        this.pairList = new ArrayList<Pair<Integer, Integer>>();
        this.pairListResult = new ArrayList<Pair<Integer, Integer>>();

    }

    /**
     * Metodă care adaugă in lista pairList toate intervalele orare în care persoanele sunt ocupate, indiferent
     * cărei persoane îi aparține intervalul.
     * @param line linie din fișierul de intrare, care reprezintă intervalele orare în care o persoană e ocupată
     */
    public void add_booked_intervals(List<String> line) throws Exception {

        for (int i = 0; i < line.size(); i++)
        {
            var aux = line.get(i).split("'");
            // pe 1 si pe 3
            var start_activity_hour_minutes = aux[1].split(":");
            int start_hour = Integer.parseInt(start_activity_hour_minutes[0]);
            start_hour = start_hour * 100;

            if(start_hour<0 || start_hour>2300)
                throw new InvalidInputException("Wrong time intervals were added!");

            start_hour = start_hour + Integer.parseInt(start_activity_hour_minutes[1]);

            if(start_hour<0 || start_hour>2359)
                throw new InvalidInputException("Wrong time intervals were added!");

            var finish_activity_hour_minutes = aux[3].split(":");
            int finish_hour = Integer.parseInt(finish_activity_hour_minutes[0]);
            finish_hour = finish_hour * 100;

            if(finish_hour<0 || finish_hour>2300)
                throw new InvalidInputException("Wrong time intervals were added!");

            finish_hour = finish_hour + Integer.parseInt(finish_activity_hour_minutes[1]);

            if(finish_hour<0 || finish_hour>2359)
                throw new InvalidInputException("Wrong time intervals were added!");

            if(start_hour>finish_hour)
                throw new InvalidInputException("A starting hour can't be bigger than a finishing hour!");

            Pair<Integer, Integer> pair = new Pair<>(start_hour, finish_hour);
            pairList.add(pair);


        }
    }

    public int minutes_diff(int a, int b)
    {
        int a_to_minutes = a / 100 % 100 * 60 + a % 100;
        int b_to_minutes = b / 100 % 100 * 60 + b % 100;
        return a_to_minutes-b_to_minutes;

    }

    /**
     * Metodă care sortează intervalele orare din lista pairList după prima oră din interval (= ora de start).
     * În cazul în care două perechi din interval au prima oră egală, atunci sortarea lor de face
     * ținând cont de a doua oră din interval (= ora de finish).
     */
    public void sortPairs() {

        pairList.sort((lhs, rhs) -> {
            if (lhs.getL().equals(rhs.getL())) {
                return Integer.compare(lhs.getR(), rhs.getR());
            } else {
                return lhs.getL().compareTo(rhs.getL());
            }
        });
    }


    /**
     * Metodă care determină toate intervalele orare în care cele două persoane sunt libere și se pot întâlni.
     *
     * Ideea folosită:
     *  Fie două intervale alăturate din lista de intervale orare sortată, [a1, b1] și [a2, b2].
     *  Fie meeting_minutes_time numărul de minute al unei întâlniri.
     *  Fie max_b ora maximă care a fost găsită pe a doua poziție din toate intervalele sortate până la poziția curentă
     *  din lista de intervale sortate.
     *  Avem nevoie de max_b ca să nu considerăm în urma unei scăderi (a2-b1)>=meeting_minutes_time
     *  că cele două persoane se pot întâlni în intervalul [b1, a2],
     *  când de fapt ni s-a arătat anterior că cel puțin una dintre persoane este încă ocupată în acest interval.
     *
     *  Dacă a2-MAX(b1, max_b) >= meeting_minutes_time, atunci în intervalul [b1, a2] poate avea loc o întâlnire.
     *
     *
     */
    public void compute_available_time() {

        freeTimePrinter.start_printing_result();
        sortPairs();

        //Verificăm dacă putem pune o întâlnire înainte ca cele două persoane să își înceapă prima activitate a zilei.
        if (minutes_diff(pairList.get(0).getL() , timeLimits.getStart_global()) >= timeLimits.getMeeting_time_minutes()) {

            Pair<Integer, Integer> pair = new Pair<>(timeLimits.getStart_global(), pairList.get(0).getL());
            pairListResult.add(pair);
        }

        int i = 0;
        int max_time = 0;

        while (i < pairList.size() - 1) {
            int pos1 = i;
            int pos2 = i + 1;


            if (minutes_diff(pairList.get(pos2).getL() , Math.max(pairList.get(pos1).getR(), max_time)) >= timeLimits.getMeeting_time_minutes()) {

                Pair<Integer, Integer> pair = new Pair<>(Math.max(pairList.get(pos1).getR(), max_time), pairList.get(pos2).getL());

                if(pairListResult.size()>0)
                {

                 //Dacă intervalul găsit în care cele două persoane se pot întâlni are ora de start aflată în interiorul
                 // ultimului interval adăugat în lista cu soluții, atunci nu vom adăuga un interval nou în lista cu soluții,
                 // ci vom modifica ultimul interval adăugat, deoarece aceste două intervale se pot alipi, fiind
                 // suprapuse peste o perioadă în care cele două persoane sunt libere.

                  // a2 inclus in [a1,b1]
                if(pairListResult.get(pairListResult.size()-1).getL()<=pair.getL()  && pair.getL() <= pairListResult.get(pairListResult.size()-1).getR())
                {
                    pairListResult.get(pairListResult.size()-1).setR(Math.max(pair.getR(), pairListResult.get(pairListResult.size()-1).getR()));
                }
               else
                {
                    //Altfel, adăugăm un interval nou în soluție.
                    pairListResult.add(pair);
                }
                }
                else
                {
                    pairListResult.add(pair);
                }

            }
            if (max_time < pairList.get(i).getR())
                max_time = pairList.get(i).getR();
            i += 1;
        }
        if (max_time < pairList.get(i).getR())
            max_time = pairList.get(i).getR();


        //Verificăm dacă mai putem pune o întâlnire după ce ambele persoane și-au încheiat ultima activitate a zilei.
        if (minutes_diff(timeLimits.getFinish_global() , max_time )>= timeLimits.getMeeting_time_minutes()) {

            Pair<Integer, Integer> pair = new Pair<>(max_time, timeLimits.getFinish_global());
            pairListResult.add(pair);

        }

        //Intervalele soluții în care se pot întâlni
        for (i = 0; i < pairListResult.size(); i++) {
            freeTimePrinter.print_free_time_interval(pairListResult.get(i).getL(), pairListResult.get(i).getR());
        }

        freeTimePrinter.print_end_of_file();
    }

}
