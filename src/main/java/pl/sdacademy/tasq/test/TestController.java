package pl.sdacademy.tasq.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sdacademy.tasq.DocType;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.List;

public class TestController {

    @RestController
    @RequestMapping("/tests")
    public class RegistrationController {
        private TestService testService;

        @Autowired
        public void TestController(TestService testService) {
            this.testService = testService;
        }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public void saveTest(@Valid @RequestBody Test newTest) {
            //ResponseEntity<Test>
            //Test nt =
            testService.saveTest( newTest);
            //return new ResponseEntity<>(nt,HttpStatus.ACCEPTED);
        }

        @DeleteMapping
        @ResponseStatus(HttpStatus.PROCESSING)
        public void deleteTest(@PathVariable String testId )
        {
            testService.deleteById( testId );
        }
        @PutMapping("/update/{testID}")
        @ResponseStatus(HttpStatus.PROCESSING)
        public void updateTest(String testId, String name, DocType type)
        {
            //ResponseEntity<Test> answer =
           testService.updateTitleAndType( testId, name, type );
            //return answer;
        }
        @GetMapping("/search/{query}")
        public Test search(@PathVariable String query )
        {   //ResponseEntity<List
            //List<Test> lst =
            return testService.findByTitle(query);
            //return new ResponseEntity<List<Test>>(lst, HttpStatus.FOUND );
        }

        @GetMapping("search/all")
        public ResponseEntity<List<Test>> findAll(@PathVariable String query) {
            List<Test> lst = testService.findAll();
            return new ResponseEntity<List<Test>>(lst, HttpStatus.FOUND );
        }

    }
}
