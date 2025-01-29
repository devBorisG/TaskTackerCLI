package boris.enterprice.application;

import java.util.List;

public interface IListFilterUseCase<T, D> {
    List<T> execute(D filter);
}
