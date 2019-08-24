package pl.sdacademy.tasq.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        public ResponseEntity<Test> createTest(@Valid @RequestBody Test newTest) {
            ResponseEntity<Test> answer = testService.newTest(newTest);
            return answer;
        }

        @DeleteMapping
        @ResponseStatus(HttpStatus.PROCESSING)
        public ResponseEntity<Test> deleteTest(@PathVariable String testId )
        {
            ResponseEntity<Test> answer = testService.deleteTest( testId );
            return answer;
        }
        @PostMapping("/update/{testID}")
        @ResponseStatus(HttpStatus.PROCESSING)
        public ResponseEntity<Test> updateTest(String testId, String type, String name)
        {
            ResponseEntity<Test> answer = testService.updateTitleAndType( testId, name, type );
            return answer;
        }
        @GetMapping("/search/{query}")
        public ResponseEntity<List<Test>> search(@PathVariable String query )
        {
            List<Test> lst = testService.findByTitle(query);
            return new ResponseEntity<List<Test>>(lst, HttpStatus.FOUND );
        }

        @GetMapping("search/all")
        public ResponseEntity<List<Test>> findAll(@PathVariable String query) {
            List<Test> lst = testService.findAll(query);
            return new ResponseEntity<List<Test>>(lst, HttpStatus.FOUND );
        }

    }
}
