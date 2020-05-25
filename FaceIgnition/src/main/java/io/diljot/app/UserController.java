package io.diljot.app;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.diljot.modals.Admin;
import io.diljot.modals.Owner;
import io.diljot.modals.User;
import io.diljot.repository.AdminRepository;
import io.diljot.repository.OwnerRepository;
import io.diljot.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	AdminRepository adminRepository;
	@Autowired
	OwnerRepository ownerRepository;
	
	@RequestMapping("/")
	String sayHi() {
		return "Hi";
	}
	
@RequestMapping("/userinfo")
String getInfo(@RequestBody Admin u) {
	String id = u.getId();
	Optional<User> opt = userRepository.findById(id);
	if (opt.isPresent()){
		User a = opt.get();
		String ret = a.getId()+":";
		ret+=a.getName()+":";
		if(a instanceof Owner) {
			ret+="Owner";
		}
		else {
			ret+="Admin";
		}
		return ret;
	}
	return "Not found";
}

@RequestMapping(method=RequestMethod.POST,value="/admin")
Admin addAdmin(@RequestBody Admin u) {
	if(!userRepository.findById(u.getId()).isPresent()) {
		return adminRepository.save(u);
	}
	return null;
}

@RequestMapping(method=RequestMethod.DELETE,value="/admin")
String deleteAdmin(@RequestBody Admin u) {
	String id = u.getId();
	Optional<Admin> opt = adminRepository.findById(id);
	if (opt.isPresent()){
		adminRepository.deleteById(id);
		return "Deleted";
	}
	else {
		return "Unknown id";
	}
}

@RequestMapping(method=RequestMethod.POST,value="/owner")
Owner addOwner(@RequestBody Owner u) {
	if(!userRepository.findById(u.getId()).isPresent()) {
		return ownerRepository.save(u);
	}
	return null;
}
@RequestMapping(method=RequestMethod.DELETE,value="/owner")
String deleteOwner(@RequestBody Owner u) {
	String id = u.getId();
	Optional<Owner> opt = ownerRepository.findById(id);
	if (opt.isPresent()){
		ownerRepository.deleteById(id);
		return "Deleted";
	}
	else {
		return "Unknown id";
	}
}
@RequestMapping(method=RequestMethod.POST,value="/update")
Owner updateUser(@RequestBody Owner u) {
	Optional<User> opt = userRepository.findById(u.getId());
	if (opt.isPresent()){
		if(opt.get() instanceof Owner) {
			return ownerRepository.save(u);
		}
		else {
			Admin a = new Admin();
			a.setId(u.getId());
			a.setName(u.getName());
			adminRepository.save(a);
			return u;
		}
	}
	return null;
}
}
