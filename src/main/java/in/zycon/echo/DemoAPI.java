package in.zycon.echo;

import org.springframework.web.bind.annotation.*;

@RestController
public class DemoAPI {
    @GetMapping("/test")
    public String sampleGet() {
        return "Hello World";
    }

    @PostMapping("/test")
    public String samplePost() {
        return "Hello Universe";
    }

    @RequestMapping("/test")
    public String newGlobalApi() {
        return "Hello Galaxy";
    }
}
