package api;

import java.util.List;

public class Utilities {

    public static String getIndexSafe(String[] _args, int _index) {
        return _args.length > _index ? _args[_index] : "";
    }

    public static void notNull(Object... _o) throws NullPointerException {

        npe(_o);

        for (var e : _o) {
            npe(e);
        }
    }

    public static void npe(Object _o) throws NullPointerException {
        if (_o == null) throw new NullPointerException();
    }

    public static <T extends CharSequence> String flatten(List<T> _list) {

        StringBuilder temp = new StringBuilder();

        for (T str : _list) {
            temp.append(str);
        }
        return temp.toString();
    }
}
