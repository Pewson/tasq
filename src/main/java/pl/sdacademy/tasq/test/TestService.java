package pl.sdacademy.tasq.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.sdacademy.tasq.DocType;
import pl.sdacademy.tasq.author.Author;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TestService {
    @Autowired
    TestsRepository testsRepository;

    public Test saveTest(Test test){
        return testsRepository.save(test);
    }

    public List<Test> findAll(){
        Iterable<Test> test = testsRepository.findAll();
        List<Test> testList = new ArrayList<>();
        test.forEach(testList::add);
        return testList;
    }

    public Test findById(String id){
        Optional<Test> test = testsRepository.findById(id);
        return test.orElseThrow(()-> new NoSuchElementException("No element with given id"));
    }

    public Test findByTitle(String title){
        Optional<Test> test = testsRepository.findByTitle(title);
        return test.orElseThrow(()->new NoSuchElementException("No element with given title"));
    }

    public List<Test> findByAuthor(Author author){
        Iterable<Test> test = testsRepository.findByAuthor(author);
        List<Test> testList = new ArrayList<>();
        test.forEach(testList::add);
        return testList;
    }

    public List<Test> findByType(DocType type){
        Iterable<Test> test = testsRepository.findByType(type.toString());
        List<Test> testList = new ArrayList<>();
        test.forEach(testList::add);
        return testList;
    }

    public void deleteById(String UUID){
        testsRepository.deleteById(UUID);
    }

    public void updateTitleAndType(String UUID, String title, DocType type){
        Optional<Test> test = testsRepository.findById(UUID);
        if(test.isPresent()) {
            Test test1 = test.get();
            test1.setTitle(title);
            test1.setType(type);
        saveTest(test1);
        }else throw new NoSuchElementException("No element with given UUID");
    }



}
