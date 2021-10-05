package GenericScale;

public class Scale <T extends Comparable> {
    private T left;
    private T right;

    public Scale(T left, T right){
        this.left= left;
        this.right = right;
    }

    public T getHeavier(){
        int result = left.compareTo(right);
        if (result > 0){
            return left;
        }
        if (result < 0){
            return right;
        }
        return null;
    }
}
