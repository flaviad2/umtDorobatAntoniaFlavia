import java.util.Arrays;
import java.util.List;

public class Calendar {

    /**
     * Un număr întreg egal cu 1 sau 2 care ne spune cărei persoane îi aparține calendarul.
     * Ne vom folosi de acest index când vom completa intervalul de minute : calendar_array[].
     */
    private int person_index;


    /**
     * Un vector de numere întregi al cărui poziții reprezintă toate minutele dintr-o zi.
     */
    private int[] calendar_array;


    /**
     * O referință către singleton-ul TimeCalculator, care ne va ajuta să facem conversii între diferite formate de
     * reprezentare a orei.
     */
    private final TimeCalculator timeCalculator;



    /**
     * @return vectorul de marcaje corespunzătoare minutelor
     */
    public int[] get_calendar_array() {
        return calendar_array;
    }



    public Calendar(int person_index, TimeCalculator timeCalculator) {

        this.person_index = person_index;
        this.timeCalculator = timeCalculator;
        calendar_array = new int[1441];
        //vector de numere întregi cu atâtea poziții câte minute sunt într-o zi

        Arrays.fill(calendar_array, 1);
        //punem valoarea 1 pe fiecare poziție din acest vector, deoarece 1 este un element neutru la înmulțire


    }


    /**
     *
     * @param line = linie din fișierul de intrare (booked calendar1: ... sau booked calendar2:...)
     *             care reprezintă un șir de intervale orare în care una dintre persoane este ocupată
     *
     *  Completarea celor doi vectori care reprezintă marcajele minutelor dintr-o zi pentru o persoană se face astfel:
     *
     *             - dacă calendarul aparține primei persoane, atunci vom aduna -2 la valoarea curentă
     *               de pe poziția unui minut, dacă în minutul respectiv, persoana 1 este ocupată
     *
     *             - dacă calendarul aparține celei de-a doua persoane, atunci vom înmulți cu 2 valoarea
     *             curentă de pe poziția unui minut, dacă în minutul respectiv, persoana 2 este ocupată
     *
     *  Astfel, în vectorul de minute asociat primei persoane vom avea:
     *
     *          ----> valoarea 1, dacă în acel minut, persoana1 este liberă
     *          ----> număr negativ cu valoare absolută impară, dacă în acel minut persoana 1 este ocupată, astfel:
     *
     *             --> -1, dacă în minutul respectiv persoana1 este în mijlocul unei activități
     *                     sau începe o activitate chiar atunci
     *                     sau termină o activitate chiar atunci
     *
     *             --> -3, dacă în minutul respectiv persoana1 a terminat o activitate și începe imediat altă activitate
     *
     *
     *  În vectorul de minute asociat celei de-a doua persoane vom avea:
     *
     *         ----> valoarea 1, dacă în acel minut persoana2 este liberă
     *         ----> număr pozitiv și par, dacă în acel minut persoana2 este ocupată, astfel:
     *
     *             ---> 2, dacă în minutul respectiv persoana2 este în mijlocul unei activități
     *                      sau începe o activitate chiar atunci
     *                      sau termină o activitate chiar atunci
     *
     *             ---> 4, dacă în minutul respectiv persoana2 a terminat o activitate și începe imediat altă activitate
     */

    public void completare(List<String> line) throws Exception {
        for (int i = 0; i < line.size(); i++) {
            var aux = line.get(i).split("'");
            var ora_obtinuta_start_ora_min = aux[1].split(":");
            int ora_start = Integer.parseInt(ora_obtinuta_start_ora_min[0]);
            ora_start = ora_start * 100;

            if(ora_start<0 || ora_start>2300)
                throw new InvalidInputException("You have entered wrong booked calendars!");
            ora_start = ora_start + Integer.parseInt(ora_obtinuta_start_ora_min[1]);

            if(ora_start<0 || ora_start>2359)
                throw new InvalidInputException("You have entered wrong booked calendars!");

            var ora_obtinuta_finish_ora_min = aux[3].split(":");
            int ora_finish = Integer.parseInt(ora_obtinuta_finish_ora_min[0]);
            ora_finish = ora_finish * 100;

            if(ora_finish<0 || ora_finish>2300)
                throw new InvalidInputException("You have entered wrong booked calendars!");

            ora_finish = ora_finish + Integer.parseInt(ora_obtinuta_finish_ora_min[1]);

            if(ora_finish<0 || ora_finish>2359)
                throw new InvalidInputException("You have entered wrong booked calendars!");

            if(ora_start>ora_finish)
                throw new InvalidInputException("A starting hour can't be bigger than a finishing hour! ");

            int nr= TimeCalculator.getInstance().oraTOminute(ora_start);


            //adăugăm -2 pe pozițiile cu index aparținând unui interval orar în care persoana 1 este ocupată
            if (person_index == 1) {
                while (timeCalculator.minuteTOformatOra(nr) <= ora_finish) {

                    calendar_array[nr] = calendar_array[nr] - 2;
                    nr += 1;

                }
            }

            //înmulțim cu 2 valorile de pe pozițiile cu index aparținând unui interval orar în care persoana 2 este ocupată
            if (person_index == 2) {
                while (timeCalculator.minuteTOformatOra(nr) <= ora_finish) {

                    calendar_array[nr] = calendar_array[nr] * 2;
                    nr += 1;

                }
            }


        }
    }


}
