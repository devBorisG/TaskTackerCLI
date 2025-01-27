package boris.enterprice.application;

public interface IObjectUseCase<D,T> {
    D execute(T object);
}
