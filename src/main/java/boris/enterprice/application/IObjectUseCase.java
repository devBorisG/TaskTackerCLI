package boris.enterprice.application;

/**
 * Generic interface for use cases that operate on an object of type T and return an object of type D.
 *
 * @param <D> the type of the result object
 * @param <T> the type of the input object
 */
public interface IObjectUseCase<D,T> {

    /**
     * Executes the use case with the given input object.
     *
     * @param object the input object
     * @return the result object
     */
    D execute(T object);
}
