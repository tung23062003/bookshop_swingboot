package com.group7.bookshopwebsite.service.impl;

import com.group7.bookshopwebsite.constant.SortType;
import com.group7.bookshopwebsite.dto.BookSearchDTO;
import com.group7.bookshopwebsite.dto.UserSearchDTO;
import com.group7.bookshopwebsite.entity.Book;
import com.group7.bookshopwebsite.entity.Category;
import com.group7.bookshopwebsite.repository.BookRepository;
import com.group7.bookshopwebsite.repository.CategoryRepository;
import com.group7.bookshopwebsite.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public void addBook(Book book, MultipartFile coverImage) {
        Book savedBook = bookRepository.save(book);
        saveCoverImage(savedBook, coverImage);
    }

    @Override
    public void editBook(Book book, MultipartFile coverImage) {
        Book savedBook = bookRepository.save(book);
        if (!coverImage.isEmpty()) {
            saveCoverImage(savedBook, coverImage);
        }
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book getBookById(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        return bookOptional.orElse(null);
    }

    @Override
    public Book getBookByName(String name) {
        return bookRepository.findByTitle(name);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    private void saveCoverImage(Book book, MultipartFile coverImage) {
        if (coverImage == null || coverImage.isEmpty()) {
            return;
        }

        String originalFileName = coverImage.getOriginalFilename();
        String uniqueFileName = generateUniqueFileName(originalFileName);

        Path coverImagePath = Paths.get("src/main/resources/static/cover_images/" + uniqueFileName);

        try {
            Files.copy(coverImage.getInputStream(), coverImagePath, StandardCopyOption.REPLACE_EXISTING);
            book.setCoverImage(uniqueFileName);
            bookRepository.save(book);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save cover image for book: " + book.getId(), e);
        }
    }

    private String generateUniqueFileName(String originalFileName) {
        String timestamp = String.valueOf(System.currentTimeMillis());
        return timestamp + "_" + originalFileName;
    }


    @Override
    public Page<Book> searchBooks(BookSearchDTO search, Pageable pageable) {
        Long categoryId = search.getCategoryId();
        String keyword = search.getKeyword();

        // Lấy dữ liệu phân trang dựa trên categoryId, keyword và các điều kiện tìm kiếm khác (nếu có)
        if (categoryId != null && keyword != null) {
            return bookRepository.findByCategory_IdAndTitleContaining(categoryId, keyword, pageable);
        } else if (categoryId != null) {
            Optional<Category> category = categoryRepository.findById(categoryId);
            return bookRepository.findByCategory(category, pageable);

        } else if (keyword != null) {
            return bookRepository.findByTitleContaining(keyword, pageable);
        } else {
            return bookRepository.findAll(pageable);
        }
    }

    @Override
    public Page<Book> searchBooksUser(UserSearchDTO search, Pageable pageable) {
        Long categoryId = search.getCategoryId();
        String keyword = search.getKeyword();
        if (keyword == null) keyword = "";
        String sortBy = search.getSortBy();

        Page<Book> booksPage = bookRepository.findAll(pageable);
        if (categoryId != null) {
            if (sortBy.equals(SortType.oldest)) {
                booksPage = bookRepository.findByCategoryIdAndTitleContainingOrderByCreatedAtAsc(categoryId, keyword, pageable);
            } else if (sortBy.equals(SortType.newest)) {
                booksPage = bookRepository.findByCategoryIdAndTitleContainingOrderByCreatedAtDesc(categoryId, keyword, pageable);

            } else if (sortBy.equals(SortType.priceLowToHigh)) {
                booksPage = bookRepository.findByCategoryIdAndTitleContainingOrderBySalePriceAsc(categoryId, keyword, pageable);

            } else {
                booksPage = bookRepository.findByCategoryIdAndTitleContainingOrderBySalePriceDesc(categoryId, keyword, pageable);
            }
        } else {
            if (sortBy.equals(SortType.oldest)) {
                booksPage = bookRepository.findByTitleContainingOrderByCreatedAtAsc(keyword, pageable);
            } else if (sortBy.equals(SortType.newest)) {
                booksPage = bookRepository.findByTitleContainingOrderByCreatedAtDesc(keyword, pageable);

            } else if (sortBy.equals(SortType.priceLowToHigh)) {
                booksPage = bookRepository.findByTitleContainingOrderBySalePriceAsc(keyword, pageable);

            } else {
                booksPage = bookRepository.findByTitleContainingOrderBySalePriceDesc(keyword, pageable);
            }
        }
        if(sortBy == null){
            booksPage = bookRepository.findByCategoryIdAndTitleContainingOrderByCreatedAtDesc(categoryId,keyword,pageable);
        }
        return booksPage;
    }



    @Override
    public Page<Book> getAllBooksForUsers(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }


}
