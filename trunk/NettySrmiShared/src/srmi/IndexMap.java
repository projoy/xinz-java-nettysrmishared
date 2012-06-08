package srmi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IndexMap<T> {

	Map<T,Integer> map = new HashMap<T,Integer>();
	List<T> list = new ArrayList<T>();
	
	public IndexMap(){
		
	}
	public IndexMap(T... values){
		this();
		put(values);
	}
	
	public int put(T... values){
		for(int n=0;n<values.length;++n){
			put(values[n]);
		}
		return list.size();
	}
	
	public int put(T value){
		map.put(value, list.size());
		list.add(value);
		return list.size();
	}
	
	public T get(int index){
		return list.get(index);
	}
	
	public Integer indexOf(T obj){
		return map.get(obj);
	}
	
	public List<T> getList(){
		return list;
	}
	
	public Map<T,Integer> getMap(){
		return map;
	}
	
	public int size(){
		return list.size();
	}
}
