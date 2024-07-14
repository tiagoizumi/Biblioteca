package biblioteca;

import java.util.List;

public interface SearchCriteria {
    List<Work> search(List<Work> works, String searchTerm);
}
