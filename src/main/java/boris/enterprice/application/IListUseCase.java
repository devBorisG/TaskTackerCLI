package boris.enterprice.application;

import java.util.List;

/**
 * Generic interface for use cases that return a list of objects of type T.
 *
 * @param <T> the type of the objects in the list
 */
public interface IListUseCase<T> {


    /**
     * Executes the use case.
     *
     * @return the list of objects
     */
    List<T> execute();
}
