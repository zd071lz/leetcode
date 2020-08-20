package leetcode.solution;

import java.util.Iterator;

/**
 * @author okr
 */
public class Solution284 {


    public Solution284(Iterator<Integer> iterator) {
        this.iterator = iterator;
    }

    Iterator<Integer> iterator;
    Integer cur = null;

    public Integer peek() {
        if (cur == null) {
            if (iterator.hasNext()) {
                 cur = iterator.next();
            }
        }
        return cur;
    }

    public Integer next() {
        if (cur == null) {
            return iterator.next();
        } else {
            Integer ret = cur;
            cur = null;
            return ret;
        }
    }

    public boolean hasNext() {
        if (cur == null) {
            return iterator.hasNext();
        }else {
            return true;
        }
    }
}
