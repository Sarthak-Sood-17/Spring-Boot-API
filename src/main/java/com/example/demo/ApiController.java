package com.example.demo;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class ApiController {

    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    String dateAndtime;
    boolean flag = true;
    @GetMapping("/")
    public String getDateAndTime()
    {
        if(flag)
            dateAndtime = LocalDateTime.now().format(myFormatObj);

        System.out.println("get Method called");
        return dateAndtime;
    }


    @PutMapping("/{newdata}")
    public String updateDateAndTime(@PathVariable String newdata)
    {
        dateAndtime = newdata;

        flag = false;

        System.out.println(dateAndtime);

        return dateAndtime;
    }

    @DeleteMapping()
    public String deleteDateAndTime()
    {
        flag = true;
        return dateAndtime + " Deleted";
    }
}
