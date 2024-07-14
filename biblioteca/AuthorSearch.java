package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class AuthorSearch implements SearchCriteria {
    @Override
    public List<Work> search(List<Work> works, String authorName) {
        List<Work> result = new ArrayList<>();
        for (Work work : works) {
            for (Author author : work.getAuthors()) {
                if (author.getName().equalsIgnoreCase(authorName)) {
                    result.add(work);
                    break;
                }
            }
        }
        return result;
    }
}
