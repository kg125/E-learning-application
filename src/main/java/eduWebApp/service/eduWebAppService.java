
package eduWebApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eduWebApp.domain.User;
import eduWebApp.repository.UserRepository;

@Service
public class eduWebAppService {
	
	@Autowired
	private UserRepository userRepo;
	
	public Object findAllPersons(){
		return userRepo.findAll();
	}
	public User findById(Integer id){
		return userRepo.findOne(id);
	}
	
	public void deleteById(Integer id){
		userRepo.delete(id);
	}
	
	
	public void save(User p){
		userRepo.save(p);
	}
}