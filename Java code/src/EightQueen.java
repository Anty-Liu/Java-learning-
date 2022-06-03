public class EightQueen {
    public static void main(String[] args){
        int[] arr = new int[7];
        FindAsr findAsr = new FindAsr();
        findAsr.arrange(arr);

    }
}

class FindAsr{
    public void arrange(int[] arr ){
        int i;
        for (i = 1; i <= arr.length; i++){
            System.out.println(arr[i-1]);
        }

    }
}
