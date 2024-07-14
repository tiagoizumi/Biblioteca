package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class CategorySearch implements SearchCriteria {
    @Override
    public List<Work> search(List<Work> works, String category) {
        List<Work> result = new ArrayList<>();
        for (Work work : works) {
            if (work.getCategory() != null && work.getCategoryString().equalsIgnoreCase(category)) {
                result.add(work);
            }
        }
        return result;
    }
}
