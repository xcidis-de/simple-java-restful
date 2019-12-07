package com.nexem.serve.utils.http;

import org.springframework.util.MultiValueMap;

import java.util.*;

public final class Headers implements MultiValueMap<String, Object> {
    private static final Map<String, List<Object>> map = new HashMap();

    @Override
    public Object getFirst(String key) {
        if (map.get(key) != null) {
            return map.get(key).get(0);
        } else {
            return null;
        }
    }

    @Override
    public void add(String key, Object value) {
        if (map.get(key) != null) {
            map.get(key).add(value);
        } else {
            List<Object> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }
    }

    @Override
    public void addAll(String key, List values) {
        if (map.get(key) != null) {
            map.get(key).addAll(values);
        } else {
            map.put(key, values);
        }
    }

    @Override
    public void addAll(MultiValueMap<String, Object> values) {
        values.forEach((String key, List<Object> value) -> {
            if (map.get(key) != null) {
                map.get(key).addAll(value);
            } else {
                map.put(key, value);
            }
        });
    }

    @Override
    public void set(String key, Object value) {
        if (value instanceof List) {
            map.put(key, (List) value);
        }
        List list = new ArrayList();
        list.add(value);
        map.put(key, list);
    }

    @Override
    public void setAll(Map<String, Object> values) {
        values.forEach((key, value) -> {
           set(key, value);
        });
    }

    @Override
    public Map<String, Object> toSingleValueMap() {
        return null;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        Collection<List<Object>> values = map.values();
        return values.stream().anyMatch((list) -> list.contains(value));
    }

    @Override
    public List<Object> get(Object key) {
        return map.get(key);
    }

    @Override
    public List<Object> put(String key, List<Object> value) {
        map.put(key, value);
        return value;
    }

    @Override
    public List<Object> remove(Object key) {
        List list = map.get(key);
        map.remove(key);
        return list;
    }

    @Override
    public void putAll(Map<? extends String, ? extends List<Object>> m) {
        clear();
        m.forEach((key, value) -> {
            map.replace(key, value);
        });
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Set<String> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<List<Object>> values() {
        return map.values();
    }

    @Override
    public Set<Entry<String, List<Object>>> entrySet() {
        return map.entrySet();
    }
}
