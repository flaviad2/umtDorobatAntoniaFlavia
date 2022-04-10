/**
 * Un obiect de tip Pair se va folosi pentru reprezentarea unui interval orar dat prin ora de start și ora de finish.
 * @param <L> ora de start
 * @param <R> ora de finish
 */
public class Pair<L, R> {

    private L left;

    private R right;

    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public L getL() {
        return left;
    }

    public R getR() {
        return right;
    }

    public void setL(L left) {
        this.left = left;
    }

    public void setR(R right) {
        this.right = right;
    }


    @Override
    public String toString() {
        return left + " " + right;
    }
}
