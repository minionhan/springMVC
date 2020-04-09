package service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.springframework.stereotype.Component;

import net.madvirus.spring4.chap07.ac.AccessPerm;

@Component
public class AclService {
	private SortedMap<String, AccessPerm>map = new TreeMap<>();
	public AclService(){
		List<AccessPerm> perms = new ArrayList<>();
		perms.add(createAccessPerm("bkchoi",true, true, true, true, false));
		perms.add(createAccessPerm("madvirus",true, false, true, false, false));
		perms.add(createAccessPerm("spring4",true, true, true, true, false));
		for(AccessPerm p : perms)
			map.put(p.getId(),p);
	}
	private AccessPerm createAccessPerm(String id, boolean canRead, boolean canCreate, boolean canModify,
			boolean canDelete, boolean removed){
		AccessPerm perm = new AccessPerm();
		perm.setId(id);
		perm.setCanRead(canRead);
		perm.setCanCreate(canCreate);
		perm.setCanModify(canModify);
		perm.setCanDelete(canDelete);
		perm.setRemoved(removed);
		return perm;
	}
	public Collection<AccessPerm> getAclList(){
		return map.values();
	}

}
