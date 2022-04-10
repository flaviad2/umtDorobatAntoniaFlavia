
public class TimeLimits {

    /**
     * prima oră la care ar putea începe o întâlnire între cele două persoane
     */
    private int start_global;


    /**
     * ultima oră la care s-ar putea termina o întâlnire dintre două persoane
     */
    private int finish_global;


    /**
     * cât durează o întâlnire
     */
    private int meeting_time_minutes;



    public TimeLimits() {

        this.start_global = 0;
        // inițializăm start_global ca fiind cea mai mică oră dintr-o zi

        this.finish_global = 2359;
        // inițializăm finish_global ca fiind cea mai mare oră dintr-o zi


        this.meeting_time_minutes = 0;
    }


    public void setStart_global(int start_global) {
        this.start_global = start_global;
    }

    public void setFinish_global(int finish_global) {
        this.finish_global = finish_global;
    }

    public void setMeeting_time_minutes(int meeting_time_minutes) {
        this.meeting_time_minutes = meeting_time_minutes;
    }


    public int getMeeting_time_minutes() {
        return meeting_time_minutes;
    }


    public int getStart_global() {
        return start_global;
    }

    public int getFinish_global() {
        return finish_global;
    }


    /**
     * @param line = linie din fișierul cu date de intrare (calendar1 range limits: ... sau calendar2 range limits:....)
     * @return cea mai restrictivă oră de start, adică ora de la care vom începe parcurgerea vectorului de minute
     *         când vom căuta intervalele orare în care cele două persoane se pot întâlni
     */
    public int cea_mai_restrictiva_ora_de_start(String line) throws Exception {

        var aux = line.split("'");
        var ora_obtinuta_start_ora_min = aux[1].split(":");

            int ora_start = Integer.parseInt(ora_obtinuta_start_ora_min[0]);
            ora_start = ora_start * 100;

            if(ora_start<0 || ora_start>2300) {
                throw new InvalidInputException("You have entered wrong calendar range limits!");

            }

            ora_start = ora_start + Integer.parseInt(ora_obtinuta_start_ora_min[1]);

            if(ora_start<0 || ora_start>2359)
                throw new InvalidInputException("You have entered wrong calendar range limits!");

            if (ora_start > start_global)
                start_global = ora_start;
            return start_global;


    }

    /**
     * @param line = linie din fișierul cu date de intrare (calendar1 range limits: ... sau calendar2 range limits:....)
     * @return cea mai restrictivă oră de finish, adică ora la care ne vom opri cu parcurgerea vectorului de minute
     *         când vom căuta intervalele orare în care cele două persoane se pot întâlni
     */
    public int cea_mai_restrictiva_ora_de_finish(String line) throws Exception {

        var aux = line.split("'");
        var ora_obtinuta_finish_ora_min = aux[3].split(":");

            int ora_finish = Integer.parseInt(ora_obtinuta_finish_ora_min[0]);

            ora_finish = ora_finish * 100;
            if(ora_finish<0 || ora_finish>2300)
                throw new InvalidInputException("You have entered wrong calendar range limits!");

            ora_finish = ora_finish + Integer.parseInt(ora_obtinuta_finish_ora_min[1]);

            if(ora_finish<0 || ora_finish>2359)
                throw new InvalidInputException("You have entered wrong calendar range limits!");

            if (ora_finish < finish_global)
                finish_global = ora_finish;
            return finish_global;




    }
}
