package com.biz.book.service;

import com.biz.book.domain.BookVO;
import com.biz.book.persistence.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("bookServiceV1")
public class BookServiceImplV1 implements BookService {

    /*
     @Autowired를 사용하는 방법도 있으나 IntelliJ에서 권장하는 코드
     @Autowired를 사용하면 메모리 누수 현상이 발생할 수 있기 때문
     */
    private final BookRepository bookDao;
    public BookServiceImplV1(BookRepository bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public List<BookVO> selectAll() {
        List<BookVO> bookList = bookDao.findAll();
        return bookList;
    }

    /*
     Optional
      - 데이터가 없음을 null이 아닌, 어떤 명확한 근거를 바탕으로 알기 위한 취지에서 새로 만들어낸 Wrapper Class
      - VO Class를 감싸는 Wrapper Class
      - 일반적으로 DB 핸들링에서 findById(Long id)를 수행한 후 id에 해당하는 데이터가 없을 경우 return값이 null
        if(vo == null) {
            log.debug("데이터가 없음")
        }
      - Optional은 어떤 객체에 저장된 값이 null인가 비교하는 것을 사용하지 않기 위해서 새로 등장한 Class
      - null값을 비교하는 것보다 연상 비용이 많이 들며, 아직은 논란의 여지가 많다.
     */
    @Override
    public BookVO findById(Long id) {
        Optional<BookVO> bookVO = bookDao.findById(id);
        // 만약 findById()를 수행하여 데이터가 존재하지 않으면 새로운 VO를 만들고 id값을 -1로 setting하여 return하라
        return bookVO.orElse(BookVO.builder().id(-1L).build());
        // return bookVO.get() : wrapper class의 wrap만 벗겨낸 간단한 형태
    }

    @Override
    public int insert(BookVO bookVO) {
        bookDao.save(bookVO);
        return 0;
    }

    @Override
    public int update(BookVO bookVO) {
        bookDao.save(bookVO);
        return 0;
    }

    @Override
    public int delete(Long id) {
        bookDao.deleteById(id);
        return 0;
    }

}
