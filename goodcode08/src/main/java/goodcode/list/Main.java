package goodcode.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@SuppressWarnings("unused")
public class Main {
	public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<Integer>();
        List<Integer> linkedList = new LinkedList<Integer>();
        var random = new Random();
        var t1 = System.currentTimeMillis();

        // ArrayListへの挿入
        for (var i = 0; i < 100000; i++) {
            arrayList.add(0, random.nextInt());
        }
        var t2 = System.currentTimeMillis();

        // LinkedListへの挿入
        for (var i = 0; i < 100000; i++) {
            linkedList.add(0, random.nextInt());
        }

        // ArrayListへの参照
        var t3 = System.currentTimeMillis();
        for (var i = 0; i < 100000; i++) {
            var n = arrayList.get(i);
        }

        // LinkedListへの参照
        var t4 = System.currentTimeMillis();
        for (var i = 0; i < 100000; i++) {
            var n = linkedList.get(i);
        }
        var t5 = System.currentTimeMillis();

        System.out.println("ArrayListへの挿入=" + (t2 - t1));
        System.out.println("LinkedListへの挿入=" + (t3 - t2));
        System.out.println("ArrayListへの参照=" + (t4 - t3));
        System.out.println("LinkedListへの参照=" + (t5 - t4));
    }
}
