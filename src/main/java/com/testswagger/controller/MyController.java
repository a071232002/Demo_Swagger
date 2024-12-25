package com.testswagger.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Hello", description = "只是個測試")
public class MyController {

    @GetMapping("/hello")
//    @Operation(summary = "hello world", description = "no comments",responses = {
//            @ApiResponse(responseCode = "200", description = "成功", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
//            @ApiResponse(responseCode = "400", description = "無效")
//    })
    public String hello(){
        return "hello";
    }
}
