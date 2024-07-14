package biblioteca;

import java.util.ArrayList;
import java.util.List;

// composite
public class BookCategory extends Item{
    private String name;
    private List<Item> items;

    public BookCategory(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        this.items.add(item);
        if (item instanceof WorkItem) {
            WorkItem workItem = (WorkItem) item;
            workItem.getWork().setCategory(this);
        }
    }

    public boolean removeItem(Item item) {
        return this.items.remove(item);
    }

    @Override
    public void display(int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print(" ");
        }
        System.out.println(name);
        for (Item item : items) {
            item.display(indent + 2);
        }
    }

    public Item searchCategory(String categoryName) {
        if (this.name.equals(categoryName)) {
            return this;
        }
        for (Item item : items) {
            if (item instanceof BookCategory) {
                Item found = ((BookCategory) item).searchCategory(categoryName);
                if (found != null) {
                    return found;
                }
            }
        }
        return null;
    }

    public void showItems() {
        for (Item item : this.items) {
            if (item instanceof BookCategory) {
                BookCategory category = (BookCategory) item;
                System.out.println("Categoria: " + category.getName());
            } else if (item instanceof WorkItem) {
                WorkItem work = (WorkItem) item;
                System.out.println("Work: " + work.getTitle());
            }
        }
    }

    public String getName() {
        return name;
    }
}
