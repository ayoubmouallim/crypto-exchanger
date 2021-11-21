import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wallet {

    Map<String,Integer> maskWalet = new HashMap<>();

    public Wallet() {
        this.maskWalet.put("$",0);
    }

    public Map<String, Integer> getMaskWalet() {
        return maskWalet;
    }

    public void setMaskWalet(Map<String, Integer> maskWalet) {
        this.maskWalet = maskWalet;
    }

    @Override
    public String toString() {

        String s="";

        for (Map.Entry<String,Integer> entry:maskWalet.entrySet() )
        {
            s+=entry.getValue()+":"+entry.getKey()+",";
        }

        return  s.substring(0,s.length()-1);
    }
}
