package boris.enterprice.application;

import java.util.List;

public interface IListUseCase<T> {
    List<T> execute();
}
