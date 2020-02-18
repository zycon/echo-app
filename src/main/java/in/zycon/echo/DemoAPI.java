package in.zycon.echo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoAPI {
    @ResponseBody
    @GetMapping("/test")
    public String sampleGet() {
        return "Hello World";
    }

    @PostMapping("/test")
    public String samplePost() {
        return "Hello Galaxy";
    }
}
