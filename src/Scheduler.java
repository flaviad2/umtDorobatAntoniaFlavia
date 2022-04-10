/**
 * Un obiect de tip Scheduler va determina intervalele orare în care cele două persoane sunt libere.
 * Dacă lungimea unui astfel de interval este mai mare sau egală cu numărul de minute cât ar trebui să dureze o întâlnire
 * și dacă acest interval este inclus sau egal cu intervalul [ora minimă la care poate începe o întâlnire, ora maximă la care se poate termina o întâlnire],
 * atunci intervalul va face parte din soluție.
 *
 */

public class Scheduler {

    private final Calendar calendar1;
    private final Calendar calendar2;
    private TimeLimits timeLimits;
    private FreeTimePrinter freeTimePrinter;
    private final TimeCalculator timeCalculator;

    public Scheduler(Calendar calendar1, Calendar calendar2, TimeLimits timeLimits, FreeTimePrinter freeTimePrinter, TimeCalculator timeCalculator) {
        this.calendar1 = calendar1;
        this.calendar2 = calendar2;
        this.timeLimits = timeLimits;
        this.freeTimePrinter = freeTimePrinter;
        this.timeCalculator = timeCalculator;
    }

    /**
     * Metodă care face produsul între valorile de pe poziții egale din vectorii de minute asociați celor două persoane.
     * Pentru a nu folosi un vector nou de dimensiune egală cu cei doi vectori de minute pe care ii avem deja reținuți
     * în obiectele calendar1 și calendar2, vom reține produsul valorilor din cei doi vectori în vectorul de minute
     * asociat primei persoane și vom lucra mai departe cu acesta.
     *
     */
    public void compute_available_time() {


        freeTimePrinter.start_printing_result();


        // Înmulțim valorile aflate pe poziții mai mari sau egale cu ora minimă la care poate începe o întâlnire și ora
        // maximă la care se poate termina o întâlnire, deoarece doar aici putem găsi soluții.

        for (int i = timeLimits.getStart_global(); i <= timeLimits.getFinish_global(); i = timeCalculator.nextMinute(i)) {

            int pos = timeCalculator.oraTOminute(i);
            calendar1.get_calendar_array()[pos] = calendar1.get_calendar_array()[pos] * calendar2.get_calendar_array()[pos];
        }



        int i = timeCalculator.oraTOminute(timeLimits.getStart_global());
        int crt = i;
        int sum = 0;
        boolean stop = false;


        //Parcurgem vectorul de minute după ce am făcut produsul.

        while (i < timeCalculator.oraTOminute(timeLimits.getFinish_global()) && crt < timeCalculator.oraTOminute(timeLimits.getFinish_global())) {

            // Luăm câte două elemente vecine din vector, reprezentând două minute consecutive.
            // Folosim două elemente alăturate ca să decidem unde ne oprim cu extinderea unui interval în care cele
            // două persoane sunt libere, respectiv unde începem un interval nou în care cele două persoane sunt libere.
            int elem1 = calendar1.get_calendar_array()[crt];
            int elem2 = calendar1.get_calendar_array()[crt + 1];


            // Dacă elementul de pe prima poziție este 1 și cel de pe a doua este -1, înseamnă că primul minut din
            // perechea de minute curentă este sfârșitul unui interval în care cele două persoane sunt libere,
            // deoarece în cel de-al doilea minut, persoana1 începe o activitate.
            if (elem1 == 1 && elem2 == -1) {
                sum += 1; //1 min
                crt += 1;
                stop = true;
            }



            // Dacă elementul de pe prima poziție este 1 și cel de pe a doua este 2, înseamnă că primul minut din
            // perechea de minute curentă este sfârșitul unui interval în care cele două persoane sunt libere,
            // deoarece în cel de-al doilea minut, persoana2 începe o activitate.
            else if (elem1 == 1 && elem2 == 2) {
                sum += 1; //1 min
                crt += 1;
                stop = true;
            }


            // Dacă elementul de pe prima poziție este 1 și cel de pe a doua este -2, înseamnă că primul minut din
            // perechea de minute curentă este sfârșitul unui interval în care cele două persoane sunt libere,
            // deoarece în cel de-al doilea minut, ambele persoane încep să lucreze.
            else if (elem1 == 1 && elem2 == -2) {
                sum += 1; //1 min
                crt += 1;
                stop = true;
            }


            // Dacă elementul de pe prima poziție este 1 și cel de pe a doua este 1, înseamnă că putem merge mai
            // departe cu extinderea intervalului orar curent, deoarece ambele persoane sunt în continuare libere.
            else if (elem1 == 1 && elem2 == 1) {
                sum += 1; //2 min
                crt += 1;
                stop = false;
            }


            //Dacă elementul de pe prima poziție este -1 și cel de pe a doua este 1, înseamnă că de la al
            // doilea minut putem începe un interval nou în care cele două persoane se pot întâlni,
            // deoarece în primul minut, persoana1 era ocupată, dar din al doilea minut ambele persoane sunt libere.
            else if (elem1 == -1 && elem2 == 1) {
                sum += 1; //1 min
                crt += 1;
                stop = false;
            }


            // Dacă elementele de pe cele două poziții sunt -1, înseamnă ca persoana1 este ocupată în aceste minute,
            // deci ele nu vor fi incluse într-un posibil interval orar soluție.
            else if (elem1 == -1 && elem2 == -1) {

                crt += 1;
                stop = true;
            }


            // Dacă elementul de pe prima poziție este -1, iar cel de pe a doua poziție este 2,
            // cele două persoane nu se pot întâlni, deoarece persoana1 este ocupată în primul minut,
            // iar persoana2 este ocupată în al doilea minut.
            else if (elem1 == -1 && elem2 == 2) {

                crt += 1;
                stop = true;
            }

            // Dacă elementul de pe prima poziție este -1, iar cel de pe a doua poziție este -2,
            // cele două persoane nu se pot întâlni, deoarece persoana1 este ocupată în primul minut,
            // apoi ambele sunt ocupate.
            else if (elem1 == -1 && elem2 == -2) {

                crt += 1;
                stop = true;
            }

            // Persoana2 ocupată în primul minut, apoi ambele libere => poate începe o întâlnire din minutul2
            else if (elem1 == 2 && elem2 == 1) {
                sum += 1;
                crt += 1;
                stop = false;
            }

            // Persoana2 ocupată în primul minut, apoi persoana1 ocupată => nu face parte din soluție
            else if (elem1 == 2 && elem2 == -1) {

                crt += 1;
                stop = true;
            }

            // Persoana2 ocupată în ambele minute => nu face parte din soluție
            else if (elem1 == 2 && elem2 == 2) {

                crt += 1;
                stop = true;
            }

            // Persoana2 ocupată în primul minut, apoi ambele ocupate => nu face parte din soluție
            else if (elem1 == 2 && elem2 == -2) {

                crt += 1;
                stop = true;
            }

            // Ambele ocupate, apoi ambele libere => putem începe un interval nou de la minutul al doilea
            else if (elem1 == -2 && elem2 == 1) {
                sum += 1;
                crt += 1;
            }

            // Ambele ocupate, apoi doar prima ocupată => nu face parte din soluție
            else if (elem1 == -2 && elem2 == -1) {

                crt += 1;
                stop = true;
            }

            // Ambele ocupate, apoi doar a doua ocupată => nu face parte din soluție
            else if (elem1 == -2 && elem2 == 2) {

                crt += 1;
                stop = true;
            }

            // Ambele ocupate în ambele minute => nu face parte din soluție
            else if (elem1 == -2 && elem2 == -2) {

                crt += 1;
                stop = true;
            }

            // Dacă unul dintre elemente este mai mic sau egal cu -3, înseamnă că persoana1 termină și începe o activitate
            // în exact același minut. => persoana 1 este ocupată în ambele minute.
            // Dacă valoarea absolută a unuia dintre elemente este divizibilă cu 4, înseamnă că persoana2 termină și începe
            // o activitate în exact același minut. => persoana 2 este ocupată în cele două minute.
            // (Am considerat că o activitate durează cel puțin un minut.)
            // Deci, aceste cazuri nu pot duce la formarea unui posibil interval care să facă parte din soluție.
            else if( (elem1 <= -3 || elem2 <= -3) || (elem1 % 4 == 0 || elem2 % 4 ==0))
            {
                crt += 1;
                stop = true;
            }
            else

            {
                //Niciun alt caz nu face parte din soluție
                crt += 1;
                stop = true;
            }
            if (stop) {

                // Dacă ne-am oprit din a extinde un interval orar, verificăm dacă intervalul obținut este destul de mare
                // pentru a avea loc o întâlnire în acesta.
                // În caz favorabil, intervalul găsit este tipărit.
                if (sum >= timeLimits.getMeeting_time_minutes()) {

                    int o1 = timeCalculator.minuteTOformatOra(i);
                    int o2 = timeCalculator.minuteTOformatOra(crt);
                    freeTimePrinter.print_free_time_interval(o1, o2);


                }
                sum = 0;
                stop = false;
                i = crt;
            }


        }


        //Verificare suplimentară pentru cazul în care ultimul interval extins este destul de mare pentru a organiza o întâlnire în acesta.
        if (sum >= timeLimits.getMeeting_time_minutes()) {

            int o1 = timeCalculator.minuteTOformatOra(i);
            int o2 = timeCalculator.minuteTOformatOra(crt);
            freeTimePrinter.print_free_time_interval(o1, o2);


        }
    freeTimePrinter.print_end_of_file();
    }

}
