import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Result {
    Integer value;
    List<Integer> items;

    public Result(){
        this.value = 0;
        this.items = new ArrayList<>();
    }

    public Integer getValue() {
        return value;
    }

    public List<Integer> getItems() {
        return items;
    }

    public void addItem(Integer item){
        this.items.add(item);
    }

    @Override
    public String toString() {
        String s = "value: "+value+", items: {";
        for (Integer i:items) {
            s += i+", ";
        }
        return s + "}";
    }

    public Result clone(){
        Result ret = new Result();
        ret.value = this.value;
        ret.items = new ArrayList<>(this.items);
        return ret;
    }
}
