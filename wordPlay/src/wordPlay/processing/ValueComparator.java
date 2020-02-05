package wordPlay.processing;

import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;

class ValueComparator implements Comparator<String> {

    Map<String, Integer> wrdFreqMap = new HashMap<String, Integer>();

    public ValueComparator(Map<String, Integer> wrdFreqMap) {
        this.wrdFreqMap.putAll(wrdFreqMap);
    }

    @Override
    public int compare(String strVal1, String strVal2) {

        return wrdFreqMap.get(strVal1) >= wrdFreqMap.get(strVal2) ? -1 : 1;
    }
}