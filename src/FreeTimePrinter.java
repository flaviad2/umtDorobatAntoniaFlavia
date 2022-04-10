import java.io.*;

public class FreeTimePrinter {

    /**
     * Numele fișierului în care se tipărește output-ul.
     */
    private String fileName;

    /**
     * Ultimul caracter scris în fișier.
     */
    private String lastCharacter;

    /**
     * Variabilă care ne spune dacă s-a scris măcar un caracter în fișierul de output
     * până la un anumit moment din cadrul rezolvării.
     */
    private  boolean hasPrintedAnything;

    public FreeTimePrinter(String fileName)
    {
        this.fileName=fileName;
        this.lastCharacter="";
        this.hasPrintedAnything=false;

    }

    /**
     *
     * @param time = string care reprezintă o anumită ora sau un anumit minut.
     *             Dacă valoarea numerică este mai mică decât 10, atunci trebuie să tipărim un '0'
     *             în fața acestei valori, pentru a respecta formatul de tipărire al orei.
     * @return
     */
    public String good_format_time(String time)
    {
        if(time.length()==1)
        {
            return "0"+ time;
        }
        return time;
    }

    /**
     * Metoda care începe tipărirea unui rezultat nou, ștergând rezultatul anterior din fișierul de output.
     */
    public void start_printing_result()
    {
        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write("");


        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    /**
     * Metodă care tipărește un interval nou, care face parte din soluție, în fișierul de output.
     * @param start_time ora de start a unui interval orar în care cele două persoane se pot întâlni
     * @param finish_time ora de terminare a unui interval orar în care cele două persoane se pot întâlni
     */
    public void print_free_time_interval(int start_time, int finish_time) {

        try {
            FileWriter myWriter = new FileWriter(fileName, true);
            if(this.lastCharacter.equals(""))
            {
                myWriter.append("[['").append(good_format_time(String.valueOf(start_time / 100)))
                        .append(":").append(good_format_time(String.valueOf(start_time % 100)))
                        .append("','").append(good_format_time(String.valueOf(finish_time / 100)))
                        .append(":").append(good_format_time(String.valueOf(finish_time % 100)))
                        .append("']");
                this.lastCharacter="]";
                this.hasPrintedAnything=true;

            }
            else if(lastCharacter.equals("]"))
            {

                myWriter.append(", ['").append(good_format_time(String.valueOf(start_time / 100)))
                        .append(":").append(good_format_time(String.valueOf(start_time % 100)))
                        .append("',").append(good_format_time(String.valueOf(finish_time / 100)))
                        .append(":").append(good_format_time(String.valueOf(finish_time % 100)))
                        .append("']");
                this.lastCharacter="]";
            }
            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    /**
     * Metodă care printează ultimul lucru din fișierul de output, în cazul în care s-a găsit măcar un interval liber
     * sau în cazul în care nu s-a găsit niciunul.
     */
    public void print_end_of_file()
    {
        try {

            FileWriter myWriter = new FileWriter(fileName,true);
            if(this.hasPrintedAnything)
            {
                myWriter.append("]");

            }
            else
            {
                myWriter.append("There is no available time when they can meet! :( ");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Metodă care printează ultimul lucru din fișierul de output, în cazul în care s-a găsit măcar un interval liber
     * sau în cazul în care nu s-a găsit niciunul.
     */
    public void print_end_of_file_wrong_input()
    {
        try {

            FileWriter myWriter = new FileWriter(fileName,true);
            myWriter.write("You have entered a wrong input!");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

