/**
 * Singleton-ul TimeCalculator ne ajută să facem diferite operații de conversie între diferite formate care reprezintă
 * ora și minutele.
 */

public class TimeCalculator {

    private static TimeCalculator instance = null;


    private TimeCalculator() {
    }


    public static TimeCalculator getInstance() {
        if (instance == null)
            instance = new TimeCalculator();
        return instance;
    }


    /**
     * @param nr = un număr întreg de maxim 4 cifre care reprezintă ora și minutele; ultimele două cifre reprezintă minutele,
     *           iar primele două cifre (sau prima cifră) reprezintă ora.
     * @return un număr întreg care reprezintă câte minute sunt de la ora 00:00 până la ora dată ca parametru de intrare
     * (deci, se returnează ora în minute)
     */
    public int oraTOminute(int nr) {
        return nr / 100 % 100 * 60 + nr % 100;
    }



    /**
     * @param nr = un număr întreg de maxim 4 cifre care reprezintă ora și minutele; ultimele două cifre reprezintă minutele,
     *           iar primele două cifre (sau prima cifră) reprezintă ora.
     * @return un număr întreg care reprezintă următorul minut, după ora dată ca parametru de intrare, în același format ca
     * parametrul de intrare (ultimele două cifre reprezintă minutele, iar prima sau primele două cifre reprezintă ora)
     * Avem nevoie de această funcție pentru cazurile în care numărul de minute ajunge la 59, deci va trebui să creștem ora cu 1
     * și minutele să se modifice în 00.
     */
    public int nextMinute(int nr) {
        if (nr % 100 == 59)
            return nr / 100 * 100 + 100;
        return nr + 1;
    }



    /**
     * @param nr = un număr de minute egal cu minutele care au trecut de la ora 00:00 până la ora curentă
     * @return un număr întreg de maxim 4 cifre ale cărui ultime 2 cifre reprezintă minutele, iar primele 2 cifre
     * sau prima cifră reprezintă ora
     */
    public int minuteTOformatOra(int nr) {
        return nr / 60 * 100 + nr % 60;
    }

}
