package org.csco.meat.dailrun;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class ReadingListController {

    private BookRepostitory bookRepostitory;

    @Autowired
    public ReadingListController(BookRepostitory bookRepostitory) {
        this.bookRepostitory = bookRepostitory;
    }

    @RequestMapping(value = "/{raader}", method = RequestMethod.GET)
    public String  readerBooks(@PathVariable("reader") String reader, Model model) {
        List<Book> readingList = bookRepostitory.findByReader(reader);
        if(readingList == null) {
            model.addAttribute("book", readingList);
        }
        return "readingList";
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
    public String addToReaderList(@PathVariable("reader") String reader, Book book) {
        book.setReader(reader);
        bookRepostitory.save(book);
        return "redirect:/{reader}";
    }
}
