package pl.sdacademy.tasq.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sdacademy.tasq.DocType;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.List;
@RestController
@RequestMapping("/tests")
public class TestController {
        private TestService testService;

        @Autowired
        public void TestController(TestService testService) {
            this.testService = testService;
        }

        @PostMapping("/saveTest")
        @ResponseStatus(HttpStatus.CREATED)
        public void saveTest(@Valid @RequestBody Test newTest) {
            //ResponseEntity<Test>
            //Test nt =
            testService.saveTest( newTest);
            //return new ResponseEntity<>(nt,HttpStatus.ACCEPTED);
        }

        @DeleteMapping("/delete/{testId}")
        @ResponseStatus(HttpStatus.PROCESSING)
        public void deleteTest(@PathVariable String testId )
        {
            testService.deleteById( testId );
        }
        @PutMapping("/update/{testId}")
        @ResponseStatus(HttpStatus.PROCESSING)
        public void updateTest(String testId, String name, DocType type)
        {
            //ResponseEntity<Test> answer =
           testService.updateTitleAndType( testId, name, type );
            //return answer;
        }
        @GetMapping("/search/byTitle/{title}")
        public Test search(@PathVariable String title )
        {   //ResponseEntity<List
            //List<Test> lst =
            return testService.findByTitle(title);
            //return new ResponseEntity<List<Test>>(lst, HttpStatus.FOUND );
        }

        @GetMapping("/search/all")
        public ResponseEntity<List<Test>> findAll() {
            List<Test> lst = testService.findAll();
            return new ResponseEntity<List<Test>>(lst, HttpStatus.FOUND );
        }

    }
