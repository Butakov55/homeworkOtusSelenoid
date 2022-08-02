package helpers;

import java.util.List;

public interface ISearch<T> {
    T searchFirstElement();
    List<T> searchAllElements();
}
