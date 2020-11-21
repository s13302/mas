package pl.s13302.mas.model;

import pl.s13302.mas.extension.ObjectPlus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Book extends ObjectPlus {

    private static final long serialVersionUID = 1L;

    private String isbn;
    private String title;
    private Library library;
    private List<Author> authors = new ArrayList<>();
    private List<Renting> rentings = new ArrayList<>();
    private List<Chapter> chapters = new ArrayList<>();

    public Book(String isbn, String title, Library library) {
        setIsbn(isbn);
        setTitle(title);
        setLibrary(library);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        if (getLibrary() != null) {
            if (!getLibrary().equals(library)) {
                if (getLibrary() != null) {
                    getLibrary().removeBook(this);
                }
                this.library = library;
                if (library != null) {
                    library.addBook(this);
                }
            }
        } else {
            this.library = library;
            if (library != null) {
                library.addBook(this);
            }
        }
    }

    public List<Author> getAuthors() {
        return Collections.unmodifiableList(authors);
    }

    public void addAuthor(Author author) {
        if (!getAuthors().contains(author)) {
            authors.add(author);
            author.addWrittenBook(this);
        }
    }

    public void addAuthors(Author... authors) {
        for (Author author : authors) {
            this.addAuthor(author);
        }
    }

    public void removeAuthor(Author author) {
        if (getAuthors().contains(author)) {
            authors.remove(author);
            author.removeWrittenBook(this);
        }
    }

    public List<Renting> getRentings() {
        return Collections.unmodifiableList(rentings);
    }

    public void addRenting(Renting renting) {
        if (!getRentings().contains(renting)) {
            rentings.add(renting);
            renting.setBook(this);
        }
    }

    public void removeRenting(Renting renting) {
        if (getRentings().contains(renting)) {
            rentings.remove(renting);
            renting.removeBookAssociation(this);
        }
    }

    public List<Chapter> getChapters() {
        return Collections.unmodifiableList(chapters);
    }

    public Chapter
    addChapter(String chapterNo, String chapterTitle) {
        Chapter chapter = new Chapter(chapterNo, chapterTitle);
        if (!getChapters().contains(chapter)) {
            chapters.add(chapter);
        }
        return chapter;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + getIsbn() + '\'' +
                ", library=" + getLibrary() +
                ", authors=" + getAuthors() +
                '}';
    }

    public class Chapter {

        private String chapterNo;
        private String chapterTitle;

        public Chapter(String chapterNo, String chapterTitle) {
            this.chapterNo = chapterNo;
            this.chapterTitle = chapterTitle;

            if (!getChapters().contains(this)) {
                chapters.add(this);
            }
        }

        public String getChapterNo() {
            return chapterNo;
        }

        public void setChapterNo(String chapterNo) {
            this.chapterNo = chapterNo;
        }

        public String getChapterTitle() {
            return chapterTitle;
        }

        public void setChapterTitle(String chapterTitle) {
            this.chapterTitle = chapterTitle;
        }

        @Override
        public String toString() {
            return "Chapter{" +
                    "chapterNo='" + chapterNo + '\'' +
                    ", chapterTitle='" + chapterTitle + '\'' +
                    '}';
        }
    }

}
