package datastructures;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    public Trie(char value) {
        this.value = value;
    }

    public void Insert(String str) {
        if (str.length() == 0) {
            boolean containsNull = false;
            for (Trie child : children) {
                if (child.value == '\0') {
                    containsNull = true;
                    break;
                }
            }
            if (!containsNull) {
                children.add(new Trie('\0'));
            }
        }

        boolean foundChar = false;
        for (Trie child : children) {
            if(child.value == str.charAt(0)) {
                foundChar = true;
                child.Insert(str.substring(1));
                break;
            }
        }
        if(!foundChar) {
            Trie child = new Trie(str.charAt(0));
            children.add(child);
            child.Insert(str.substring(1));
        }
    }

    public boolean Contains(String s) {
        char c = s.length() > 0 ? s.charAt(0) : '\0';
        for (Trie child : children) {
            if(child.value == c) {
                if (c == '\0') {
                    return true;
                } else {
                    return child.Contains(s.substring(1));
                }
            }
        }
        return false;
    }

    char value;
    List<Trie> children;
}
