package com.microservice.cloud.studentservice.service;

import com.microservice.cloud.studentservice.entity.Student;
import com.microservice.cloud.studentservice.repo.StudentRepository;
import com.microservice.cloud.studentservice.request.CreateStudentRequest;
import com.microservice.cloud.studentservice.response.AddressResponse;
import com.microservice.cloud.studentservice.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	WebClient webClient;


	public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {
		Student student = new Student();
		student.setFirstName(createStudentRequest.getFirstName());
		student.setLastName(createStudentRequest.getLastName());
		student.setEmail(createStudentRequest.getEmail());
		
		student.setAddressId(createStudentRequest.getAddressId());
		student = studentRepository.save(student);

		StudentResponse studentResponse = new StudentResponse(student);
		studentResponse.setAddressResponse(getAddressById(student.getAddressId()));

		return studentResponse;
	}
	
	public StudentResponse getById (long id) {
		Student student = studentRepository.findById(id).get();
		StudentResponse studentResponse = new StudentResponse(student);

		studentResponse.setAddressResponse(getAddressById(student.getAddressId()));

		return studentResponse;
	}

	public AddressResponse getAddressById (long addressId) {
		Mono<AddressResponse> addressResponseMono = webClient.get().uri("/getById/" + addressId)
				.retrieve().bodyToMono(AddressResponse.class);

		return addressResponseMono.block();
	}
}
