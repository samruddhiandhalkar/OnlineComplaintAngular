package Service;


import org.springframework.stereotype.Service;

import Entity.Complaint;
import Repository.ComplaintRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ComplaintService {

    private final ComplaintRepository complaintRepository;

    public ComplaintService(ComplaintRepository complaintRepository) {
        this.complaintRepository = complaintRepository;
    }

    // Add new complaint
    public Complaint saveComplaint(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    // Get all complaints
    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    // Get by id
    public Optional<Complaint> getComplaintById(Long id) {
        return complaintRepository.findById(id);
    }

    // Update complaint
    public Complaint updateComplaint(Long id, Complaint updatedComplaint) {
        return complaintRepository.findById(id)
                .map(existing -> {
                    existing.setName(updatedComplaint.getName());
                    existing.setEmail(updatedComplaint.getEmail());
                    existing.setDescription(updatedComplaint.getDescription());
                    return complaintRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Complaint not found with id " + id));
    }

    // Delete complaint
    public void deleteComplaint(Long id) {
        complaintRepository.deleteById(id);
    }
}
