package boris.enterprice.application;

import java.util.List;

/**
 * Generic interface for use cases that return a list of objects of type T filtered by an object of type D.
 *
 * @param <T> the type of the objects in the list
 * @param <D> the type of the filter object
 */
public interface IListFilterUseCase<T, D> {

    /**
     * Executes the use case with the given filter object.
     *
     * @param filter the filter object
     * @return the list of objects
     */
    List<T> execute(D filter);
}
