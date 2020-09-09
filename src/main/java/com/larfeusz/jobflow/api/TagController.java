package com.larfeusz.jobflow.api;


import com.larfeusz.jobflow.jpa.TagRepository;
import com.larfeusz.jobflow.model.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/api/tags")
@RestController
public class TagController {

    public TagRepository tagRepository;

    public TagController(TagRepository tagRepository) {this.tagRepository = tagRepository;}


    @GetMapping("")
    public Iterable<Tag> getList(){
        return tagRepository.findAll();
    }

}
