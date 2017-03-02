package com.niit.collaboration.controller;


	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	    import org.springframework.http.HttpStatus;
		import org.springframework.http.ResponseEntity;
		import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
		import org.springframework.web.bind.annotation.RequestBody;
		import org.springframework.web.bind.annotation.RestController;

import com.niit.collaboration.dao.EventDAO;
import com.niit.collaboration.model.Event;

	    

		

		@RestController
		public class EventController 
		{
			@Autowired
			Event event;
			
			@Autowired
			EventDAO eventDAO;
			
			@PostMapping("/addEvent/")
			public ResponseEntity<Event> createEvent(@RequestBody Event event)
			{
				eventDAO.add(event);
				event.setErrorCode("200");
				event.setErrorMsg("Success....");
				
				return new ResponseEntity<Event> (event,HttpStatus.OK) ;
			}
			

			@GetMapping("/deleteEvent-{id}")
			public ResponseEntity<Event> deleteEvent(@PathVariable("id") long id)
			{
				event = eventDAO.getEvent(id);
				System.out.println("NAME "+event.getName());
				eventDAO.delete(event);
				event = new Event();
				event.setErrorCode("200");
				event.setErrorMsg("Success....");
				System.out.println(" deleted");
				return new ResponseEntity<Event> (event,HttpStatus.OK);
			}

			@GetMapping("/getAllEvent")
			public ResponseEntity<List<Event>> getAllEvent()
			{
				List<Event> events= eventDAO.Eventlist();
				if(events.isEmpty())
						{
					 event.setErrorCode("100");
						event.setErrorMsg("No blogs are available");
						events.add(event);
						return new ResponseEntity< List<Event>>(events,HttpStatus.OK);
						}
				 event.setErrorCode("200");
					event.setErrorMsg("Successfully fetched the event");

				return new ResponseEntity< List<Event>>(events,HttpStatus.OK);
			}
		/*	@GetMapping("/updateEvent")
			public ResponseEntity<Event> editEvent(@RequestBody Event event)
			{
				eventDAO.update(event);
				event.setErrorCode("200");
				event.setErrorMsg("Success....");
				
				return new ResponseEntity<Event> (event,HttpStatus.OK) ;
			}*/
		}



	

