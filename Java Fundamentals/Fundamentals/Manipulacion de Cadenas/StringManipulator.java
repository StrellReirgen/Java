public class StringManipulator {
    public String trimAndConcat(String first, String second) {
    	first = first.trim();
        second = second.trim();
        String result = first.concat(second);
        return result;
    }
    public Integer getIndexOrNull(String word, char letter) {
        Integer result = word.indexOf(letter);
        if (result < 0) {
            return null;
        }
        else {
            return result;
        }
    }
    public Integer getIndexOrNull(String first, String second) {
        Integer result = first.indexOf(second);
        if (result < 0) {
            return null;
        }
        else {
            return result;
        }
    }
    public String concatSubstring(String first, int one, int two, String second) {
        String word = first.substring(one,two);
        return word.concat(second);
    }
}