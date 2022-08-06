package com.nashtech.rookies.java05.AssetManagement.service;

import com.nashtech.rookies.java05.AssetManagement.dto.request.AssignmentRequest;
import com.nashtech.rookies.java05.AssetManagement.dto.response.AssignmentDetailResponse;
import com.nashtech.rookies.java05.AssetManagement.dto.response.AssignmentResponse;
import com.nashtech.rookies.java05.AssetManagement.dto.response.AssignmentStaffResponse;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface AssignmentService {
	List<AssignmentStaffResponse> getListAssignments(String userId);

	AssignmentStaffResponse getAssignmentById(long id);

	AssignmentStaffResponse updateStateAssignment(long id, String status);

	AssignmentResponse createAssignment(AssignmentRequest assignmentRequest, String userName);

	AssignmentResponse editAssignment(AssignmentRequest assignmentRequest, Long id);

	AssignmentResponse getAssignment(Long id);

	ResponseEntity<?> deleteAssignment(Long id);

	public List<AssignmentDetailResponse> getAllAssignmentByLocation(String location);

	public List<AssignmentDetailResponse> searchAssignment(String content, String location);

}