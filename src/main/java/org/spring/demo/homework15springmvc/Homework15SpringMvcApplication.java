package org.spring.demo.homework15springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Homework15SpringMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(Homework15SpringMvcApplication.class, args);

//		NoteService noteService = new NoteService();
//
//		Note note = Note.builder()
//				.title("the first note")
//				.content("the content of the first note")
//				.build();
//		System.out.println("a new added note = " + noteService.add(note));
//
////		long id = note.getId();
////		System.out.println("noteService.getById(id) = " + noteService.getById(id));
////
////		note.setTitle("updated title");
////		note.setContent("updated content");
////		noteService.update(note);
//
//		Note note2 = Note.builder()
//				.title("the second note")
//				.content("the content of the second note")
//				.build();
//		Note note3 = Note.builder()
//				.title("the third note")
//				.content("the content of the third note")
//				.build();
//		System.out.println("a new added note = " + noteService.add(note2));
//		System.out.println("a new added note = " + noteService.add(note3));
//		long id3 = note3.getId();
//		noteService.listAll().forEach(System.out::println);

	}

}
