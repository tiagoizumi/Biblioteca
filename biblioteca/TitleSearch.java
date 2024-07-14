package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class TitleSearch implements SearchCriteria {
    @Override
    public List<Work> search(List<Work> works, String title) {
        List<Work> result = new ArrayList<>();
        for (Work work : works) {
            if (work.getTitle().equalsIgnoreCase(title)) {
                result.add(work);
            }
        }
        return result;
    }
}
