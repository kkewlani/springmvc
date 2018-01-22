package kk.springframework.springmvc.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kk.springframework.springmvc.domain.DomainObject;

public abstract class AbstractDomainMapService {

    protected Map<Integer, DomainObject> domainObjectsMap;

    public AbstractDomainMapService() {
        domainObjectsMap = new HashMap<>();
        loadDomainObjectsMap();
    }

    public List<DomainObject> listAll() {
        return new ArrayList<>(domainObjectsMap.values());
    }

    public DomainObject getById(Integer id) {
        return domainObjectsMap.get(id);
    }

    public DomainObject createOrUpdate(DomainObject domainObject) {
        if (domainObject.getId() == null) {
            domainObject.setId(getNextKey());
        }
        domainObjectsMap.put(domainObject.getId(), domainObject);
        return domainObject;
    }

    public void delete(Integer id) {
        domainObjectsMap.remove(id);
    }

    private Integer getNextKey() {
        return Collections.max(domainObjectsMap.keySet()) + 1;
    }

    protected abstract void loadDomainObjectsMap();
}
